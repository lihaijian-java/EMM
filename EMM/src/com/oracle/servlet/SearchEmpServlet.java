package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.Employee;
import com.oracle.service.EmployeeService;
public class SearchEmpServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String updateStatus = req.getParameter("updateStatus");
        if (updateStatus != null && "-1".equals(updateStatus)) {
            String empid = req.getParameter("empid");
            employeeService.updateEmpStatusById(Integer.parseInt(empid), Integer.parseInt(updateStatus));
        }
        String employeename = req.getParameter("employeename");
        String username = req.getParameter("username");
        String status = req.getParameter("status");
        String page = req.getParameter("page");
        String count = req.getParameter("count");
        if (status == null || "".equals(status)) {
            status = "1";
        }
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (count == null || "".equals(count)) {
            count = "5";
        }
        List<Employee> list = employeeService.searchEmp(employeename, username, Integer.parseInt(status), Integer.parseInt(page), Integer.parseInt(count));
        int totalCount = employeeService.getCount(employeename, username, Integer.parseInt(status));
      
           int totalPage = (totalCount-1) / Integer.parseInt(count) + 1;       
        req.setAttribute("list", list);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("page", page);
        req.setAttribute("employeename", employeename);
        req.setAttribute("username", username);
        req.setAttribute("status", status);
        req.getRequestDispatcher("/searchemployees.jsp").forward(req, resp);
    }
}
