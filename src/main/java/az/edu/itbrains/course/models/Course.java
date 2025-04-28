package az.edu.itbrains.course.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortDescription;
    private String description;
    private Float price;
    private String photoUrl;
    private String requirement;

    @ManyToOne
    private Category category;


    @ManyToOne
    private Instructor instructor;


    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

    @ManyToMany
    private List<User> users;

}
