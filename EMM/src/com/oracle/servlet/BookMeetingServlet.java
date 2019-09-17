package com.oracle.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.MeetingRoom;
import com.oracle.service.MeetingRoomService;
public class BookMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingRoomService meetingRoomService = new MeetingRoomService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MeetingRoom> list = meetingRoomService.getAllMeetingRoom();
        request.setAttribute("mrs", list);
        request.getRequestDispatcher("/bookmeeting.jsp").forward(request, response);
    }
}
