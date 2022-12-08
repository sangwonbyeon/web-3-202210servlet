package com.study.springboot202210sangwon.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {


    @Autowired //(required = false) ioc 에서 주입은 필수가 아니다 () 없는 경우 기본값이 true 로 생략이됨
    @Qualifier("usi3")
    private UserService userService;
    // UserServiceImpl2 클래스를 Ioc Container 를 담아두고 스캔을 한다 UserService 객체를 자동으로 Di를 해준다

    //UserServiceImpl2 를 new UserServiceImpl2 로 만들어주지 않아도 되는 이유가 IoC 때문
    //Springboot application 이 Component scan 을 해서  객체를 생성한다 UserServiceImpl2에  @Component
    //IoC Container Component 를 가진 객체를 생성시켜 담는 역활을 한다 (싱글톤과 같은 역활을 한다)
    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
