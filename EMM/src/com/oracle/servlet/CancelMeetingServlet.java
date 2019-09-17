package com.oracle.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.Meeting;
import com.oracle.service.MeetingService;
public class CancelMeetingServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        Meeting meeting = meetingService.getMeetingDetailsByMeetingId(Integer.parseInt(mid));
        req.setAttribute("m", meeting);
        req.getRequestDispatcher("/cancelmeeting.jsp").forward(req, resp);
    }
}
