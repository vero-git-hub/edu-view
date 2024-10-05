package org.example.eduview.dto;

import java.util.List;

/**
 * @author vero-git-hub
 **/
public class CollegeWithCoursesDTO {

    private Integer id;
    private String name;
    private String accommodationType;
    private Double accommodationFee;
    private List<CourseDTO> courses;

    public CollegeWithCoursesDTO(Integer id, String name, String accommodationType, Double accommodationFee, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.accommodationType = accommodationType;
        this.accommodationFee = accommodationFee;
        this.courses = courses;
    }

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

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
