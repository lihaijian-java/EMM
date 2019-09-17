package com.oracle.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.oracle.utils.DBUtils;
/*
 * 多对多关联      一个员工可以参加多个会议、一个会议多名员工参加
 */
public class MeetingParticipantsDao {
    public void insert(int meetingid, String[] empids) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement("insert into meetingparticipants (meetingid,employeeid) values (?,?);");
            for (String empid : empids) {
                ps.setInt(1, meetingid);
                ps.setInt(2, Integer.parseInt(empid));
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(ps);
            DBUtils.close(con);
        }
    }
}
