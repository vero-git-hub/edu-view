package org.example.eduview.dto;

/**
 * @author vero-git-hub
 **/
public class CollegeDTO {
    private Integer id;
    private String name;
    private String accommodationType;
    private Double accommodationFee;

    public CollegeDTO(Integer id, String name, String accommodationType, Double accommodationFee) {
        this.id = id;
        this.name = name;
        this.accommodationType = accommodationType;
        this.accommodationFee = accommodationFee;
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
}
