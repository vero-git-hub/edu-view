package org.example.eduview.repository;

import org.example.eduview.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vero-git-hub
 **/
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
