package com.study.servlet.account;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;
import com.study.service.Accountservice;
import com.study.util.DTO;

@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//로그인은 추가가 아닌 R GET 요청인데 POST 요청을 하는 이유? 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//톰캣에서 request 정보를 날리면 HttpServletRequest객체를 만든다 
		Map<String, String> loginUser = DTO.getParams(request);
		Accountservice accountservice = Accountservice.getInstance();
		
		User user = accountservice.loadUserByUsername(loginUser.get("username"));
		
		if(user == null) {
			System.out.println("아이디 틀림!");
			//error_login.html ->script:  사용자 정보를 확인해 주세요. history.back();
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			return;
		}
		
		if(!accountservice.checkPassword(user, loginUser.get("password"))) {
			System.out.println("비밀번호 틀림!");
			//error_login.html -> script : 사용자 정보를 확인해 주세요. history.back();
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			return;
		}
		 //로그인 성공!
		HttpSession session = request.getSession();
		session.setAttribute("principal", user);
		
		response.sendRedirect("/mypage");
		
		
	}

}
