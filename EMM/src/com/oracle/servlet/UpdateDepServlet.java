package com.oracle.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.service.DepartmentService;
public class UpdateDepServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private DepartmentService departmentService = new DepartmentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String depName = req.getParameter("depName");
        int i = departmentService.updateDepById(depName, Integer.parseInt(id));
        PrintWriter out = resp.getWriter();
        if (i == 1) {
            out.write("修改成功");
        } else {
            out.write("修改失败");
        }
    }
}
