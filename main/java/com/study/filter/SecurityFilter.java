package com.study.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;


@WebFilter("/*")
public class SecurityFilter extends HttpFilter implements Filter {
	
	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String requestURI = req.getRequestURI();
		String antMatchers = "/mypage, /mypage/password";
		String antMatchers1 = "/login, /register";
		String logoutURI = "/logout";
		String adminPage = "/admin";
		
		if(antMatchers.contains(requestURI) && !authorization(req.getSession())) {  //!authorization(req.getSession()) 인증이 되지 않을때 
			resp.sendRedirect("/login");
			return;
		}
		
		if(antMatchers1.contains(requestURI) && authorization(req.getSession())) {
			resp.sendRedirect("/mypage");
			return;
		}
		
		if(logoutURI.equalsIgnoreCase(requestURI)) {
			req.getSession().invalidate();  //invalidate() : session 을 강제로 종료시킨다 
			resp.sendRedirect("/login");
			return;
		}
		
		if(requestURI.contains(adminPage) && !hasRole(req.getSession(), "ADMIN")) {
			resp.sendError(403, "Forbidden");
			return;
		}
		chain.doFilter(request, response);
	}
	
	private boolean authorization(HttpSession session) {
		User principalUser = (User)session.getAttribute("principal");
		return principalUser != null;
	}
	
	private boolean hasRole(HttpSession session, String role) {
		AtomicBoolean result = new AtomicBoolean(false);
		if(authorization(session)) {
			User principalUser = (User) session.getAttribute("principal");
			String [] roleArray = principalUser.getRoles().replaceAll(" ", "").split(",");
			List<String> roleList = Arrays.asList(roleArray);
			
			roleList.forEach(r -> {
				if(r.startsWith("ROLE_") && r.contains(role)) {
					result.set(true);
				}
			});
			
		}
		
		return result.get();
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
