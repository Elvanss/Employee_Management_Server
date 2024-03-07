package com.management.employee.repository;

import com.management.employee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    @Transactional // add this Annotation to delete multi
    void deleteByIdIn(List<Long> longs);
}
