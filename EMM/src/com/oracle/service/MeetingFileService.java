package com.oracle.service;
import java.util.List;
import com.oracle.bean.MeetingFile;
import com.oracle.dao.MeetingFileDao;
public class MeetingFileService {
    MeetingFileDao file=new MeetingFileDao();
  
    public int insert(MeetingFile meetingFile) {
        return file.insert(meetingFile);       
    }
    public List<MeetingFile> getAllMeetingFile(){
      return file.getAllMeetingFile();
    }
}
