package com.oracle.servlet;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.Employee;
import com.oracle.bean.Meeting;
import com.oracle.service.MeetingService;
public class DoBookMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meetingname = request.getParameter("meetingname");
        String numberofparticipants = request.getParameter("numberofparticipants");
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        String roomid = request.getParameter("roomid");
        String description = request.getParameter("description");
        String[] selSelectedEmployees = request.getParameterValues("selSelectedEmployees");
        //获取当前登录的用户对象
        Employee loginUser = (Employee) request.getSession().getAttribute("loginUser");
        Meeting meeting = new Meeting(meetingname, Integer.parseInt(roomid), loginUser.getEmployeeid(), Integer.parseInt(numberofparticipants), Timestamp.valueOf(starttime), Timestamp.valueOf(endtime), new Timestamp(System.currentTimeMillis()), description);
        meetingService.insert(meeting, selSelectedEmployees);
        response.sendRedirect(request.getContextPath() + "/searchmeetings.jsp");
    }  
}
