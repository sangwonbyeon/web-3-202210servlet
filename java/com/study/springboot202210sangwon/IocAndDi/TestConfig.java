package com.study.springboot202210sangwon.IocAndDi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public Test1 t1(){
        return new Test1();
    }  //수동적으로 등록가능
    //일반 컴퍼넌트 클래스는 bean 등록가능하지만 configuration 는 bean 등록이 2개가 가능하다 일반 컴퍼넌트 클래스는 bean 등록을 잘 하지않는다
    // 언제 쓰는건가? 소스 코드가 수정이 안되는 경우 configuration 에서 bean 등록을 2개해서  ioc 에 등록이 가능하다
    @Bean
    public Test2 t2(){
        return new Test2();
    }
}
