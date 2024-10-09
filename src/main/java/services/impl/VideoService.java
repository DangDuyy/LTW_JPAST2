package services.impl;

import dao.IVideoDAO;
import dao.impl.VideoDAO;
import entity.Video;
import services.IVideoService;

import java.util.List;
public class VideoService implements IVideoService{

    IVideoDAO videoDao = new VideoDAO();

    @Override
    public void delete(String videoid) throws Exception {
        videoDao.delete(videoid);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public Video findById(String videoid) {
        return videoDao.findById(videoid);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public void insert(Video video) {
        videoDao.insert(video);
    }

    @Override
    public int count() {
        return videoDao.count();
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        return videoDao.findAll(page, pagesize);
    }

    @Override
    public List<Video> findByVideoTitle(String vidtitle) {
        return videoDao.findByVideoTitle(vidtitle);
    }

    @Override
    public List<Video> findByCategoryId(int cateid) {
        return videoDao.findByCategoryId(cateid);
    }



}