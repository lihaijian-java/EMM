package com.oracle.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.MeetingRoom;
import com.oracle.service.MeetingRoomService;
public class RoomdetailsServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
 private MeetingRoomService meetingRoomService=new MeetingRoomService();
 
 public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
     String roomid = request.getParameter("roomid");
     MeetingRoom meetingRoom = meetingRoomService.getMeetingRoomById(Integer.parseInt(roomid));
     request.setAttribute("mr", meetingRoom);
     request.getRequestDispatcher("/roomdetails.jsp").forward(request, response);
 }
}
