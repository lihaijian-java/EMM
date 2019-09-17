package com.oracle.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.bean.MeetingFile;
import com.oracle.utils.DBUtils;
public class MeetingFileDao {
    /*
     * 添加文件
     */
public int insert(MeetingFile meetingFile) {
    Connection con = null;
    PreparedStatement ps = null;
    try {
        con = DBUtils.getConnection();
        ps = con.prepareStatement("insert into meetingfile(filename,filedesc,filepath,uploader) VALUES (?,?,?,?)");
        ps.setString(1, meetingFile.getFilename());
        ps.setString(2, meetingFile.getFiledesc());
        ps.setString(3, meetingFile.getFilepath());
        ps.setString(4, meetingFile.getUploader());
        return ps.executeUpdate();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtils.close(ps);
        DBUtils.close(con);
    }
    return -1;
}
/*
 * 获取文件名
 */
public List<MeetingFile> getAllMeetingFile(){
    List<MeetingFile> list = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        con = DBUtils.getConnection();
        ps = con.prepareStatement("select filename from meetingfile");
        rs = ps.executeQuery();
        while (rs.next()) {
            MeetingFile meetingfile = new MeetingFile(rs.getString("filename") );
            list.add(meetingfile);
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtils.close(rs);
        DBUtils.close(ps);
        DBUtils.close(con);
    }
    return list;
}
}
