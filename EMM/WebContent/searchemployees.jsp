<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>
          会议详情
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="./css/x-admin.css" media="all">
        
        <script src="js/jquery.min.js"></script>
    </head>
       <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
                         人员管理 > 搜索员工
            </blockquote>
         <form method="post" action="${pageContext.request.contextPath }/serachemp">
          <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">信息搜索</a></legend>
            </fieldset>
                    <table class="layui-table">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" id="employeename" name="employeename" value="${employeename}"
                                   maxlength="20"/>
                        </td>
                        <td>账号名：</td>
                        <td>
                            <input type="text" id="accountname" name="username" value="${username}" maxlength="20"/>
                        </td>
                        <td>状态：</td>
                        <td>
                            <c:choose>
                                <c:when test="${status==0}">
                                    <input type="radio" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input checked="checked" type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                                <c:when test="${status==1}">
                                    <input type="radio" checked="checked" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                                <c:when test="${status==-1}">
                                    <input type="radio" id="status" name="status" value="1"
                                    /><label>已批准</label>
                                    <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                    <input type="radio" checked="checked" id="status" name="status" value="-1"/><label>已关闭</label>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command" align="center">
                            <input type="submit" class="layui-btn" value="查询"/>
                            <input type="reset" class="layui-btn" value="重置"/>
                        </td>
                    </tr>
                </table>                      
             </form>
           
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">查询结果</a></legend>
            </fieldset>       
                 <table class="layui-table">             
                <tbody>
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
                        <form method="post" action="${pageContext.request.contextPath }/serachemp">
                            <input type="hidden" name="employeename" value="${employeename}">
                            <input type="hidden" name="username" value="${username}">
                            <input type="hidden" name="status" value="${status}">
                            <input type="hidden" name="updateStatus" value="-1">
                            <input type="hidden" name="empid" value="${emp.employeeid}">
                            <input class="layui-btn" value="关闭账号" type="submit"></input>
                        </form>
                    </td>
                </tr>
            </c:forEach>               
                </tbody>
            </table>
          
              <div align="center">               
                  共<span class="info-number">${totalCount}</span>条结果，
                    分成<span class="info-number">${totalPage}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
                
               
                    <a type="button" class="clickbutton"
                       href="${pageContext.request.contextPath}/serachemp?page=1&status=${status}&employeename=${employeename}&username=${username}">首页</a>
                    <c:choose>
                        <c:when test="${page>1}">
                            <a type="button" class="clickbutton"
                               href="${pageContext.request.contextPath}/serachemp?page=${page-1}&status=${status}&employeename=${employeename}&username=${username}">上页</a>
                        </c:when>
                        <c:otherwise>
                            上页
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page<totalPage}">
                            <a type="button" class="clickbutton"
                               href="${pageContext.request.contextPath}/serachemp?page=${page+1}&status=${status}&employeename=${employeename}&username=${username}">下页</a>
                        </c:when>
                        <c:otherwise>
                            下页
                        </c:otherwise>
                    </c:choose>
                    <a type="button" class="clickbutton"
                       href="${pageContext.request.contextPath}/serachemp?page=${totalPage}&status=${status}&employeename=${employeename}&username=${username}">末页</a>
                    <form action="${pageContext.request.contextPath}/serachemp" method="post" style="display: inline">
                        <input type="hidden" name="employeename" value="${employeename}">
                        <input type="hidden" name="username" value="${username}">
                        <input type="hidden" name="status" value="${status}">
                        跳到第<input type="text" style="width: 40px" id="pagenum" name="page" class="nav-number"/>页
                        <input type="submit" class="layui-btn" value="跳转"/>
                    </form>
                
                </h6>
            </div>
             
    </body>
 </html>

