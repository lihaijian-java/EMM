package com.oracle.utils;
import java.util.Properties;
public class JdbcProperties {
    private static Properties properties=new Properties();
    static {
        try {
            properties.load(JdbcProperties.class.getClassLoader().getResourceAsStream("db.properties"));
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * 获得驱动
     */
    public static String getDirver(){
        
        return properties.getProperty("driver");
    } 
 public static String getUrl(){
        
        return properties.getProperty("url");
    }
 public static String getUname(){
     
     return properties.getProperty("username");
 }
 public static String getPwd(){
     
     return properties.getProperty("password");
 }
}
