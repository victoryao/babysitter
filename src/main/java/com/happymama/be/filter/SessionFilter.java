package com.happymama.be.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happymama.be.constant.Constant;

public class SessionFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;
		 String requestURI = request.getRequestURI();
		if(requestURI.contains("api") || requestURI.contains("client") || requestURI.equals("/admin.do")){
			chain.doFilter(req, res);
        }
		HttpSession session = request.getSession();
        // 如果Session为空，则跳转到指定页面
        if (session == null || session.getAttribute(Constant.sessionCheckKey) == null) {
            requestURI = request.getRequestURI();
            if(!requestURI.equals("/user/login.do")){
            	response.sendRedirect("/admin.do");
            }else{
            	chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
		
	}

}
