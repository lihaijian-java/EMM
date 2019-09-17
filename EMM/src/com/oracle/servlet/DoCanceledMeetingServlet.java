package com.oracle.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.service.MeetingService;
public class DoCanceledMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String canceledreason = req.getParameter("canceledreason");
        int i = meetingService.cancelMeeting(Integer.parseInt(mid), canceledreason);
        if (i == 1) {
            //取消成功
            resp.sendRedirect(req.getContextPath()+"/mybooking");
        }
    }
}
