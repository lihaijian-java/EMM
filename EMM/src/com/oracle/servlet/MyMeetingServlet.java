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
public class MyMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private MeetingService meetingService = new MeetingService();
public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    int loginEmpId = ((Employee) request.getSession().getAttribute("loginUser")).getEmployeeid();
    List<Meeting> list = meetingService.getMyMeeting(loginEmpId);
    request.setAttribute("mrs", list);
    request.getRequestDispatcher("/mymeetings.jsp").forward(request, response);
}
} 