package org.example.eduview.controller;

import org.example.eduview.dto.CollegeDTO;
import org.example.eduview.model.College;
import org.example.eduview.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<College> getCollegeById(@PathVariable Integer id) {
        return collegeService.getCollegeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College savedCollege = collegeService.saveCollege(college);
        return ResponseEntity.ok(savedCollege);
    }

    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Integer id, @RequestBody College college) {
        if (!collegeService.getCollegeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        college.setId(id);
        College updatedCollege = collegeService.saveCollege(college);
        return ResponseEntity.ok(updatedCollege);
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
