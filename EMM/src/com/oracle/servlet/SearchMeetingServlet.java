package com.oracle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.bean.Meeting;
import com.oracle.service.MeetingService;

public class SearchMeetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String meetingname = request.getParameter("meetingname");
        String roomname = request.getParameter("roomname");
        String reservername = request.getParameter("reservername");
        String reservefromdate = request.getParameter("reservefromdate");
        String reservetodate = request.getParameter("reservetodate");
        String meetingfromdate = request.getParameter("meetingfromdate");
        String meetingtodate = request.getParameter("meetingtodate");
        String page = request.getParameter("page");
        String count = request.getParameter("count");
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (count == null || "".equals(count)) {
            count = "5";
        }
        List<Meeting> list = meetingService.searchMeeting(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate, Integer.parseInt(page), Integer.parseInt(count));
        int totalCount = meetingService.getCount(meetingname, roomname, reservername, reservefromdate, reservetodate, meetingfromdate, meetingtodate);
        int totalPage = (totalCount-1) / Integer.parseInt(count) + 1;
        request.setAttribute("list", list);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("page", page);
        request.setAttribute("meetingname", meetingname);
        request.setAttribute("roomname", roomname);
        request.setAttribute("reservername", reservername);
        request.setAttribute("reservefromdate", reservefromdate);
        request.setAttribute("reservetodate", reservetodate);
        request.setAttribute("meetingfromdate", meetingfromdate);
        request.setAttribute("meetingtodate", meetingtodate);
        request.setAttribute("count", count);
        request.getRequestDispatcher("/searchmeetings.jsp").forward(request, response);
    }
}
