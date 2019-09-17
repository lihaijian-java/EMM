package com.oracle.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.oracle.dao.CountDao;
/*
 * 监听器
 */
public class VisitCountListener implements ServletContextListener{
      CountDao countDao=new CountDao();
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Object visitcount = sce.getServletContext().getAttribute("vc");
        countDao.updateCount(Integer.parseInt(visitcount.toString()));      
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        int count = countDao.getCount();
        sce.getServletContext().setAttribute("vc", count);
    }
}
