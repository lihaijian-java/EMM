package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.oracle.bean.Employee;
import com.oracle.service.EmployeeService;
public class GetEmpByDepIdServlet  extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService=new EmployeeService();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depid = request.getParameter("depid");
        List<Employee> list = employeeService.getEmpByDepId(Integer.parseInt(depid));
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new Gson().toJson(list));
    }
}
