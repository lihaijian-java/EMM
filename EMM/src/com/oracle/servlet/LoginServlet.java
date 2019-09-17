package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.CountDao;
import com.oracle.service.EmployeeService;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private EmployeeService employeeService = new EmployeeService();
	  CountDao countdao=new CountDao();
    /*
     * 处理请求
     */
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    String accountname = request.getParameter("accountname");
        String password = request.getParameter("password");
        int login = employeeService.login(accountname, password);
        ServletContext sc = request.getSession().getServletContext();
        Object visitcount = sc.getAttribute("vc");
        if (visitcount == null) {
            visitcount = "0";
        }
        int vc = Integer.parseInt(visitcount.toString()) + 1;
        countdao.updateCount(vc);
        sc.setAttribute("vc", vc);
        if (login == 0) {
            request.setAttribute("error", "用户待审批，请稍候");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else if (login == 1) {
            request.getSession().setAttribute("loginUser", employeeService.getLoginUser());
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else if (login == 2) {
            request.setAttribute("error", "用户审批未通过，请重新注册");
            request.getRequestDispatcher("/login.jsp").forward(request, response);        
        } else if (login == -1) {
            request.setAttribute("error", "账号已关闭，登陆失败，请联系管理员");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } else  {
            request.setAttribute("error", "用户名或者密码输入错误，请重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
	    
	}

