package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.Department;
import com.oracle.service.DepartmentService;
public class DePartmentsServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private DepartmentService departmentService = new DepartmentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> list = departmentService.getAllDepartment();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/departments.jsp").forward(req, resp);
    }
}
