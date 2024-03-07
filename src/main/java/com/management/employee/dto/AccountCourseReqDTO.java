package com.management.employee.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class AccountCourseReqDTO {
    private Long accountId;
    private Long courseId;
    private Date registrationDate;
    private BigDecimal purchasePrice;
}
