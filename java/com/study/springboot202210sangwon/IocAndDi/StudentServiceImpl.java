package com.study.springboot202210sangwon.IocAndDi;

import org.springframework.stereotype.Component;

@Component  //@Service  서비스 어노테이션도 컴퍼넌트 어노테이션 처럼 IoC 에 등록이 된다
public class StudentServiceImpl implements StudentService {
    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번: " + student.getStudentId());
        System.out.println("이름: " + student.getStudentName());
    }
}
