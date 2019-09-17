package com.oracle.servlet;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.oracle.bean.MeetingFile;
import com.oracle.service.MeetingFileService;
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MeetingFileService meetingFileService=new MeetingFileService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try{
          //获取文件的描述信息
          String desc=request.getParameter("desc");
          //测试
          System.out.println(desc);
          //获取上传文件
          Part part=request.getPart("file");
          //获取上传人姓名
          String uploader=request.getParameter("uploader");
           //获取请求的信息
          String name=part.getHeader("content-disposition");
          //获取上传文件的目录
          String root="D:\\upload";
          //获取文件后缀
          String str=name.substring(name.lastIndexOf("."),name.length()-1);
          //生成一个新的文件名
          String filename=root+"\\"+UUID.randomUUID().toString()+str;
          //上传文件到指定目录
         part.write(filename);
          String fname = filename.substring(filename.lastIndexOf("\\")+1);    
       MeetingFile meetingFile=new MeetingFile(fname,desc,filename,uploader);             
        meetingFileService.insert(meetingFile);  
        request.setAttribute("info", "上传文件成功");
      }catch (Exception e){
          e.printStackTrace();
          request.setAttribute("info", "上传文件失败");
      }
      request.getRequestDispatcher("/upload.jsp").forward(request, response);
	}

}
