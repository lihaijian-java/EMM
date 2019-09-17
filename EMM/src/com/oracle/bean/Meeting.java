package com.oracle.bean;
import java.sql.Timestamp;
/*
 * 会议信息
 */
public class Meeting {
    private int meetingid;       //id
    private String meetingname;      //会议名称
    private int roomid;            //会议室id
    private int reservationistid;    //预定者id
    private int numberofparticipants;  //最大容纳人数
    private Timestamp starttime;      //开始时间
    private Timestamp endtime;        //结束时间
    private Timestamp reservationtime;  //预定时间
    private Timestamp canceledtime;     //取消日期
    private String description;     //会议描述
    private int status;        //会议室状态
    private String roomname;       //会议室名称
    private String empname;         //预定者姓名
    private String canceledreason;       //取消原因 

    public String getCanceledreason() {
        return canceledreason;
    }

    public void setCanceledreason(String canceledreason) {
        this.canceledreason = canceledreason;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Meeting(String meetingname, int roomid, int reservationistid, int numberofparticipants, Timestamp starttime, Timestamp endtime, Timestamp reservationtime, String description) {
        this.meetingname = meetingname;
        this.roomid = roomid;
        this.reservationistid = reservationistid;
        this.numberofparticipants = numberofparticipants;
        this.starttime = starttime;
        this.endtime = endtime;
        this.reservationtime = reservationtime;
        this.description = description;
    }

    public Meeting() {
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingid=" + meetingid +
                ", meetingname='" + meetingname + '\'' +
                ", roomid=" + roomid +
                ", reservationistid=" + reservationistid +
                ", numberofparticipants=" + numberofparticipants +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", reservationtime=" + reservationtime +
                ", canceledtime=" + canceledtime +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", roomname='" + roomname + '\'' +
                ", empname='" + empname + '\'' +
                '}';
    }

    public Meeting(int meetingid, String meetingname, int roomid, int reservationistid, int numberofparticipants, Timestamp starttime, Timestamp endtime, Timestamp reservationtime, Timestamp canceledtime, String description, int status) {
        this.meetingid = meetingid;
        this.meetingname = meetingname;
        this.roomid = roomid;
        this.reservationistid = reservationistid;
        this.numberofparticipants = numberofparticipants;
        this.starttime = starttime;
        this.endtime = endtime;
        this.reservationtime = reservationtime;
        this.canceledtime = canceledtime;
        this.description = description;
        this.status = status;
    }

    public int getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(int meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getReservationistid() {
        return reservationistid;
    }

    public void setReservationistid(int reservationistid) {
        this.reservationistid = reservationistid;
    }

    public int getNumberofparticipants() {
        return numberofparticipants;
    }

    public void setNumberofparticipants(int numberofparticipants) {
        this.numberofparticipants = numberofparticipants;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Timestamp getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(Timestamp reservationtime) {
        this.reservationtime = reservationtime;
    }

    public Timestamp getCanceledtime() {
        return canceledtime;
    }

    public void setCanceledtime(Timestamp canceledtime) {
        this.canceledtime = canceledtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
