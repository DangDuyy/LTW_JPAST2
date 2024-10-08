package services;

import entity.Video;

import java.util.List;

public interface IVideoService {

    void delete(String videoid) throws Exception;

    List<Video> findAll();

    Video findById(String videoid);

    void update(Video video);

    void insert(Video video);

    int count();

    List<Video> findAll(int page, int pagesize);

    List<Video> findByVideoTitle(String vidname);

    List<Video> findByCategoryId(int cateid);
}