package com.google.ScoreManagementSystem;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = "/*")
public class UserLoginCheckFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String currentURL = request.getRequestURI();
        String contextPath = request.getContextPath();
        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(contextPath.length());
        System.out.println("targetURL = " + targetURL);
        HttpSession session = request.getSession();

        if (!(("/index.jsp".equals(targetURL)) ||
                ("/teacher_login.jsp".equals(targetURL)) ||
                ("/student_login.jsp".equals(targetURL)) ||
                ("/admin_login.jsp".equals(targetURL))
        )) {
            if ("/teacher_control.jsp".equals(targetURL) || "/student_control.jsp".equals(targetURL) || "/admin_control.jsp".equals(targetURL)) {
                filterChain.doFilter(request, response);

            } else if (
                    ((session.getAttribute("isTeacher") != null) && (session.getAttribute("isTeacher").equals(true)))
                            || (session.getAttribute("isStudent") != null
                            && session.getAttribute("isStudent").equals(true))
                            || ((session.getAttribute("isAdmin") != null)
                            && (session.getAttribute("isAdmin").equals(true)))
            ) {
                filterChain.doFilter(request, response);
//FIXME 如果老师先成功登录了，那么学生再登录，则能成功。但是老师如果没有登录的话，学生登录就会失败

            } else {
                response.sendRedirect("index.jsp");
            }

        } else {
            filterChain.doFilter(request, response);
        }


    }


}