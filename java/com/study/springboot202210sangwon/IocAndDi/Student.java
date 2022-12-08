package com.study.springboot202210sangwon.IocAndDi;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String studentName;
    private int studentId;
}
