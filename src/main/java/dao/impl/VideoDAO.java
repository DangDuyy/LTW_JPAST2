package dao.impl;

import configs.JPAConfig;
import dao.IVideoDAO;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class VideoDAO implements IVideoDAO {
    @Override
    public void insert(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(String videoid) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Video video = enma.find(Video.class, videoid);
            if (video != null) {
                enma.remove(video);
            } else {
                throw new Exception("Not found");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public Video findById(String videoid) {
        EntityManager enma = JPAConfig.getEntityManager();
        return enma.find(Video.class, videoid);    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList();    }

    @Override
    public List<Video> findByVideoname(String title) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title LIKE :title";
        TypedQuery<Video> query = enma.createQuery(jpql, Video.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
        query.setFirstResult(page * pagesize);
        query.setMaxResults(pagesize);
        return query.getResultList();
    }

    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT count(v) FROM Video v";
        Query query = enma.createQuery(jpql);
        return ((Long) query.getSingleResult()).intValue();

    }
}
