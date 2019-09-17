package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.Employee;
import com.oracle.bean.Meeting;
import com.oracle.service.MeetingService;
public class MeetingDetailsServlet  extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String type = req.getParameter("type");
        Meeting meeting = meetingService.getMeetingDetailsByMeetingId(Integer.parseInt(mid));
        List<Employee> emps = meetingService.getEmps();
        req.setAttribute("mt", meeting);
        req.setAttribute("emps", emps);
        req.setAttribute("type", type);
        req.getRequestDispatcher("/meetingdetails.jsp").forward(req, resp);
    }
}
