package com.study.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")  //톰캣에서 모든 요청을 다 거치게 만들어짐   톰캣 -> HSR(HttpSerlvetRequest) 생성 -> filter
public class EncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  //ServletRequest request 업캐스팅 됨
			throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest) request;

		if (hsr.getMethod().equalsIgnoreCase("POST")) {//equalsIgnoreCase("POST") post 요청인지 확인해라 
			request.setCharacterEncoding(StandardCharsets.UTF_8.name());
		}
		// 전처리
		chain.doFilter(request, response); // chain => servlet 체인 이전과 이후로 나뉜다
	}   // 후처리

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
