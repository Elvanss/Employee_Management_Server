package com.management.employee.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResDTO {
    private String refreshToken;
    private String accessToken;
    private Date expiredIn;
    private List<String> roles;
}
