package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name ="Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="VideoId")
    private String videoId;

    @Column(name="Active")
    private int active;

    @Column(name="Description",columnDefinition = "nvarchar(50) NOT NULL")
    private String description;

    @Column(name="Poster",columnDefinition = "nvarchar(50) NOT NULL")
    private String poster;

    @Column(name="Title")
    private String title;

    @Column(name="Views")
    private int views;

    @ManyToOne
    @JoinColumn(name="CategoryId")
    private Category category;

}
