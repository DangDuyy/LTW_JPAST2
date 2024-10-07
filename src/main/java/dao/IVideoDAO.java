package dao;

import entity.Video;

import java.util.List;

public interface IVideoDAO {
    void insert(Video video);

    void update(Video video);

    void delete(String videoid) throws Exception;

    Video findById(String videoid);

    List<Video> findAll();

    List<Video> findByVideoname(String title);

    List<Video> findAll(int page, int pagesize);

    int count();
}
