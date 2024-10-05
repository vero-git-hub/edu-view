package org.example.eduview.service;

import org.example.eduview.dto.CollegeDTO;
import org.example.eduview.model.College;
import org.example.eduview.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author vero-git-hub
 **/
@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public List<CollegeDTO> getAllCollegeDTOs() {
        List<College> colleges = collegeRepository.findAll();
        return colleges.stream()
                .map(college -> new CollegeDTO(
                        college.getId(),
                        college.getName(),
                        college.getAccommodationType(),
                        college.getAccommodationFee()
                ))
                .collect(Collectors.toList());
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public Optional<College> getCollegeById(Integer id) {
        return collegeRepository.findById(id);
    }

    public College saveCollege(College college) {
        return collegeRepository.save(college);
    }

    public void deleteCollege(Integer id) {
        collegeRepository.deleteById(id);
    }
}
