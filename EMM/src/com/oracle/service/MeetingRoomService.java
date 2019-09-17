package com.oracle.service;
import java.util.List;
import com.oracle.bean.MeetingRoom;
import com.oracle.dao.MeetingRoomDao;
public class MeetingRoomService {
    private MeetingRoomDao meetingRoomDao = new MeetingRoomDao();
    public int insert(MeetingRoom meetingRoom) {
        return meetingRoomDao.insert(meetingRoom);
    }
    public List<MeetingRoom> getAllMeetingRoom(){
        return meetingRoomDao.getAllMeetingRoom();
    }
    public MeetingRoom getMeetingRoomById(int id) {
        return meetingRoomDao.getMeetingRoomById(id);
    }
    public int update(MeetingRoom meetingRoom) {
        return meetingRoomDao.update(meetingRoom);
    }
}
