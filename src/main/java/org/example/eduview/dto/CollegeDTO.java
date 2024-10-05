package org.example.eduview.dto;

import java.util.List;

/**
 * @author vero-git-hub
 **/
public class CollegeDTO {
    private Integer id;
    private String name;
    private String accommodationType;
    private Double accommodationFee;
    private List<CourseDTO> courses;

    public CollegeDTO(Integer id, String name, String accommodationType, Double accommodationFee, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.accommodationType = accommodationType;
        this.accommodationFee = accommodationFee;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public Double getAccommodationFee() {
        return accommodationFee;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
