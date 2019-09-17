package com.oracle.service;
import java.util.List;
import com.oracle.bean.Department;
import com.oracle.dao.DepartmentDao;
public class DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    public int updateDepById(String name, int id) {
        return departmentDao.updateDepById(name, id);
    }
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }
    public int deleteDepById(int id) {
        return departmentDao.deleteDepById(id);
    }
    public int insert(String name) {
        return departmentDao.insert(name);
    }
}
