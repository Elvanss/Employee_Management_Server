package com.management.employee.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountCourseResDTO {
    private UserAccountResDTO accountDTO;
    private CourseDTO courseDTO;
    private Date registrationDate;
    private BigDecimal purchasePrice;
}
