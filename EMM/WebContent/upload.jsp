<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>
          会议文件
        </title>
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
          <script src="js/jquery-3.2.1.js"></script>
   <script type="text/javascript"> 	   
   alert("${info}");
	       </script>
    </head>
       <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
                         个人中心 > 文件上传与下载
            </blockquote>  
             <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">会议文件上传</a></legend>
            </fieldset>
            <form action="${pageContext.request.contextPath}/upload" id="form1" method="post" enctype="multipart/form-data"> 
            <table class="layui-table">           
           <tr>
           <td></td>
           <td><h1>文件上传</h1></td>
           </tr>
           <tr>
           <td>文件描述</td>
            <td><input type="text" name="desc"/></td>
           </tr>
           <tr>
           <td>上传文件</td>
            <td><input type="file" name="file"/></td>
           </tr>
            <tr>
           <td><input type="hidden" name="uploader"  readonly="readonly"  value="${loginUser.employeename}"/></td>
            <td><input  class="layui-btn"  type="submit" value="上传文件" /> </td>
           </tr>
        </table>
        </form>             
    </div>        
    </body>
 </html>
 
