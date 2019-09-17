package com.oracle.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.bean.MeetingRoom;
import com.oracle.service.MeetingRoomService;
public class AddMeetingRoomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  private   MeetingRoomService meetingRoomService=new MeetingRoomService();
  public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      String roomid = request.getParameter("roomid");
      String roomnum = request.getParameter("roomnum");
      String roomname = request.getParameter("roomname");
      String capacity = request.getParameter("capacity");
      String status = request.getParameter("status");
      String description = request.getParameter("description");
      MeetingRoom meetingRoom = new MeetingRoom(Integer.parseInt(roomnum), roomname, Integer.parseInt(capacity), Integer.parseInt(status), description);
      if (roomid == null || "".equals(roomid)) {
          //添加会议室
          int result = meetingRoomService.insert(meetingRoom);
          if (result == 1) {
              //去查看会议室页面
              response.sendRedirect(request.getContextPath() + "/getallmr");
          } else {
              request.setAttribute("error", "添加失败");
              request.getRequestDispatcher("/addmeetingroom.jsp").forward(request, response);
          }
      } else {
          //修改会议室
          meetingRoom.setRoomid(Integer.parseInt(roomid));
          int update = meetingRoomService.update(meetingRoom);
          if (update == 1) {
              response.sendRedirect(request.getContextPath() + "/getallmr");
          }else{
              //更新失败
          }
      }
  }
}  
