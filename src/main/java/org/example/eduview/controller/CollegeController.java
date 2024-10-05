package org.example.eduview.controller;

import org.example.eduview.dto.CollegeDTO;
import org.example.eduview.dto.CollegeWithCoursesDTO;
import org.example.eduview.dto.CourseDTO;
import org.example.eduview.model.College;
import org.example.eduview.model.Course;
import org.example.eduview.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author vero-git-hub
 **/
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping
    public ResponseEntity<List<CollegeDTO>> getAllColleges() {
        List<CollegeDTO> colleges = collegeService.getAllCollegeDTOs();
        return ResponseEntity.ok(colleges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollegeWithCoursesDTO> getCollegeById(@PathVariable Integer id) {
        return collegeService.getCollegeByIdWithCourses(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College savedCollege = collegeService.saveCollege(college);
        return ResponseEntity.ok(savedCollege);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollegeDTO> updateCollege(@PathVariable Integer id, @RequestBody CollegeDTO collegeDTO) {
        Optional<College> optionalCollege = collegeService.getCollegeById(id);

        if (!optionalCollege.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        College existingCollege = optionalCollege.get();

        existingCollege.setName(collegeDTO.getName());
        existingCollege.setAccommodationType(collegeDTO.getAccommodationType());
        existingCollege.setAccommodationFee(collegeDTO.getAccommodationFee());

        if (collegeDTO.getCourses() != null && !collegeDTO.getCourses().isEmpty()) {
            existingCollege.getCourses().clear();
            for (CourseDTO courseDTO : collegeDTO.getCourses()) {
                Course course = new Course();
                course.setId(courseDTO.getId());
                course.setName(courseDTO.getName());
                course.setDuration(courseDTO.getDuration());
                course.setCollege(existingCollege);
                existingCollege.getCourses().add(course);
            }
        }

        College updatedCollege = collegeService.saveCollege(existingCollege);

        List<CourseDTO> courseDTOs = updatedCollege.getCourses().stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDuration()
                ))
                .collect(Collectors.toList());

        CollegeDTO updatedCollegeDTO = new CollegeDTO(
                updatedCollege.getId(),
                updatedCollege.getName(),
                updatedCollege.getAccommodationType(),
                updatedCollege.getAccommodationFee(),
                courseDTOs
        );

        return ResponseEntity.ok(updatedCollegeDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Integer id) {
        if (!collegeService.getCollegeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        collegeService.deleteCollege(id);
        return ResponseEntity.noContent().build();
    }
}
