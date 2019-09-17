package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.oracle.bean.Department;
import com.oracle.service.DepartmentService;
public class GetAllDepJsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 
    DepartmentService departmentService=new DepartmentService();
    public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        List<Department> list = departmentService.getAllDepartment();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new Gson().toJson(list));
    }
}
