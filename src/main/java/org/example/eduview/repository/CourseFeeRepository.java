package org.example.eduview.repository;

import org.example.eduview.model.CourseFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vero-git-hub
 **/
@Repository
public interface CourseFeeRepository extends JpaRepository<CourseFee, Integer> {
}
