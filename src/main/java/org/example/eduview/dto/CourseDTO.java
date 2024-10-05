package org.example.eduview.dto;

/**
 * @author vero-git-hub
 **/
public class CourseDTO {
    private Integer id;
    private String name;
    private String duration;

    public CourseDTO(Integer id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDuration() { return duration; }
}
