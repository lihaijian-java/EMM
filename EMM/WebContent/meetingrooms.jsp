<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
        <meta charset="utf-8">
        <title>
        注册审批
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
    </head>
    <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
           会议预定 > 查看会议室
            </blockquote>
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">所有会议室信息</a></legend>
            </fieldset>
            <table class="layui-table">           
                   <tr class="listheader">
                   <th>门牌编号</th>
                <th>会议室名称</th>
                <th>容纳人数</th>
                <th>当前状态</th>
           <c:if test="${loginUser.role==1}">        <th>操作</th></c:if>
            </tr>
             
                 <c:forEach items="${list}" var="mr">
                <tr>
                    <td>${mr.roomnum}</td>
                    <td>${mr.roomname}</td>
                    <td>${mr.capacity}</td>
                    <td>
                        <c:choose>
                            <c:when test="${mr.status==0}">启用</c:when>
                            <c:when test="${mr.status==1}">停用</c:when>
                        </c:choose>
                    </td>
                     <c:if test="${loginUser.role==1}"> 
                    <td>
                        <a class="layui-btn" href="${pageContext.request.contextPath }/roomdetails?roomid=${mr.roomid}">查看详情</a>
                    </td>
                     </c:if>
                </tr>
            </c:forEach>
           
        </table>    
        </div>                   
    </body>    
</html>

