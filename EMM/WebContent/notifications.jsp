<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>
          通知页面
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
                欢迎使用英杰会议管理系统<span class="f-14">v1.0！</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <div style="display: inline;text-align: right">您是第${vc}位访客!</div>
            </blockquote>
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">未来七天参加的会议</a></legend>
            </fieldset>
            <table class="layui-table">           
                   <tr class="listheader">
                <th style="width:300px">会议名称</th>
                <th>会议室</th>
                <th>起始时间</th>
                <th>结束时间</th>
                <th style="width:100px">操作</th>
            </tr>
            <c:forEach items="${mt7}" var="mt">
                <tr>
                    <td>${mt.meetingname}</td>
                    <td>${mt.roomname}</td>
                    <td><fmt:formatDate value="${mt.starttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${mt.endtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>
                        <a  class="layui-btn"  href="${pageContext.request.contextPath }/meetingdetail?mid=${mt.meetingid}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
         <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">已取消的会议 </a></legend>
            </fieldset>  
            <table class="layui-table">           
            <tr class="listheader">
                <th style="width:300px">会议名称</th>
               <th>会议室</th>
                <th>起始时间</th>
                <th>结束时间</th>
                <th>取消原因</th>
                <th style="width:100px">操作</th>
            </tr>
            <c:forEach items="${cm}" var="m">
                <tr>
                    <td>${m.meetingname}</td>
                    <td>${m.roomname}</td>
                    <td><fmt:formatDate value="${m.starttime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${m.endtime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
                    <td>${m.canceledreason}</td>
                    <td>
                        <a class="layui-btn" href="${pageContext.request.contextPath }/meetingdetail?mid=${m.meetingid}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>  
          <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-layui.js" charset="utf-8"></script>
        <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>            
    </body>
    
</html>