package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CategoryId")


    private int categoryId;

    @Column(name="Categoryname", columnDefinition = "nvarchar(50) NOT NULL")


    private String categoryname;

    @Column(name="Images", columnDefinition = "nvarchar(500) NULL")
    private String images;

    @Column(name="Status")

    private int status;

    //bi-directional many-to-one association to Video

    @OneToMany(mappedBy="category")


    private List<Video> videos;

    public Video addVideo(Video video) {
        getVideos().add(video);
        video.setCategory(this);
        return video;
    }
    public Video removeVideo(Video video) {
        getVideos().remove(video);
        video.setCategory(null);
        return video;
    }

}


