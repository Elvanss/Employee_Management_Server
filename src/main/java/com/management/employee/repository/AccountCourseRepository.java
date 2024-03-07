package com.management.employee.repository;

import com.management.employee.entity.AccountCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountCourseRepository extends JpaRepository<AccountCourse, Long> {
    Optional<AccountCourse> findByAccount_IdAndCourse_Id(Long account_id, Long course_id);
    Optional<AccountCourse> findByAccount_Id(Long account_id);
    boolean existsAccountCourseByAccount_Id(Long account_id);
}
