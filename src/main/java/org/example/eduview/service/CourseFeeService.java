package org.example.eduview.service;

import org.example.eduview.model.CourseFee;
import org.example.eduview.repository.CourseFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vero-git-hub
 **/
@Service
public class CourseFeeService {

    private final CourseFeeRepository courseFeeRepository;

    @Autowired
    public CourseFeeService(CourseFeeRepository courseFeeRepository) {
        this.courseFeeRepository = courseFeeRepository;
    }

    public List<CourseFee> getAllCourseFees() {
        return courseFeeRepository.findAll();
    }

    public Optional<CourseFee> getCourseFeeById(Integer id) {
        return courseFeeRepository.findById(id);
    }

    public CourseFee saveCourseFee(CourseFee courseFee) {
        return courseFeeRepository.save(courseFee);
    }

    public void deleteCourseFee(Integer id) {
        courseFeeRepository.deleteById(id);
    }
}
