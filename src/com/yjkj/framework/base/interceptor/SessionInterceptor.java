package com.yjkj.framework.base.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 监听用户登录情况
 * @author Jaylan
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("User")==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

            out.write("<script type='text/javascript'>");
            out.write("alert('登录已超时,请重新登录!');");
            out.write("window.top.location.href='"+request.getContextPath()+"/request/login';");
            out.write("</script>");
			out.flush();
			out.close();
			return false;
		}else{
		return true;
		}
	}
	
}
