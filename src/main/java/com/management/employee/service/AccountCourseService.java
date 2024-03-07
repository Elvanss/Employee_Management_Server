package com.management.employee.service;

import com.management.employee.dto.AccountCourseResDTO;
import com.management.employee.dto.ResponseDTO;
import com.management.employee.entity.AccountCourse;
import com.management.employee.mapper.Mapper;
import com.management.employee.repository.AccountCourseRepository;
import com.management.employee.repository.AccountRepository;
import com.management.employee.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCourseService {
    private final AccountCourseRepository accountCourseRepository;
    private final AccountRepository accountRepository;
    private final CourseRepository courseRepository;
    private final Mapper mapper;

    public AccountCourseService(AccountCourseRepository accountCourseRepository, AccountRepository accountRepository, CourseRepository courseRepository, Mapper mapper) {
        this.accountCourseRepository = accountCourseRepository;
        this.accountRepository = accountRepository;
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    public ResponseDTO<AccountCourseResDTO> create(AccountCourse accountCourse){
        AccountCourseResDTO res = mapper.mapToAccCourseDTO(accountCourseRepository.save(accountCourse));
        return ResponseDTO.<AccountCourseResDTO>builder()
                .status(HttpStatus.OK)
                .message("Assign course to user successfully.")
                .data(res)
                .build();
    }
    public ResponseDTO<Void> delete(Long account_id, Long course_id){
        Optional<AccountCourse> foundAccCourse = accountCourseRepository.findByAccount_IdAndCourse_Id(account_id,course_id);
        if (foundAccCourse.isEmpty()){
            return ResponseDTO.<Void>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Not found Account assign in Course")
                    .build();
        }

        AccountCourse accountCourse = foundAccCourse.get();
        accountCourseRepository.deleteById(accountCourse.getId());
        return ResponseDTO.<Void>builder()
                .status(HttpStatus.OK)
                .message("Unassign the course success.")
                .build();
    }
}
