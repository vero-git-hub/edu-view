package org.example.eduview.repository;

import org.example.eduview.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vero-git-hub
 **/
@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {
}
