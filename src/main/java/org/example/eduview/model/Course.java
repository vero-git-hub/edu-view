package org.example.eduview.model;

import jakarta.persistence.*;

/**
 * @author vero-git-hub
 **/
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String duration;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private CourseFee courseFee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public CourseFee getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(CourseFee courseFee) {
        this.courseFee = courseFee;
    }
}
