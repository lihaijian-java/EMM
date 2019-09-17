package com.oracle.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.service.DepartmentService;
public class DeleteDepServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DepartmentService departmentService = new DepartmentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String depid = req.getParameter("depid");
        int i = departmentService.deleteDepById(Integer.parseInt(depid));
        if (i == 1) {
            resp.sendRedirect(req.getContextPath() + "/departments");
        } else {
            req.setAttribute("error", "删除失败");
            req.getRequestDispatcher("/departments").forward(req, resp);
        }
    }
}