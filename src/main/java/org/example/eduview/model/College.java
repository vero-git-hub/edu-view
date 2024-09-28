package org.example.eduview.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * @author vero-git-hub
 **/
@Entity
@Table(name = "colleges")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "accommodation_type", nullable = false)
    private String accommodationType;

    @Column(name = "accommodation_fee", nullable = false)
    private Double accommodationFee;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

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

    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public Double getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(Double accommodationFee) {
        this.accommodationFee = accommodationFee;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
