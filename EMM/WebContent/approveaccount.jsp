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
           人员管理 > 注册审批
            </blockquote>
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">所有待审批注册信息</a></legend>
            </fieldset>
            <table class="layui-table">           
                   <tr class="listheader">
                  <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <th>操作</th>
            </tr>
                 <c:forEach items="${list}" var="emp">
                <tr>
                    <td>${emp.employeename}</td>
                    <td>${emp.username}</td>
                    <td>${emp.phone}</td>
                    <td>${emp.email}</td>
                    <td>
                        <a class="layui-btn" href="${pageContext.request.contextPath }/updateEmpStatus?status=1&empid=${emp.employeeid}">通过</a>
                        <a class="layui-btn" href="${pageContext.request.contextPath }/updateEmpStatus?status=2&empid=${emp.employeeid}">不通过</a>
                    </td>
                </tr>
            </c:forEach>
        </table>    
        </div>                   
    </body>    
</html>


