package com.oracle.bean;
public class Department {
    private int departmentid;       //部门id
    private String departmentname;   //部门名称
    public Department() {
    }
    public Department(int departmentid, String departmentname) {
        this.departmentid = departmentid;
        this.departmentname = departmentname;
    }
    public int getDepartmentid() {
        return departmentid;
    }
    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    public String getDepartmentname() {
        return departmentname;
    }
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
