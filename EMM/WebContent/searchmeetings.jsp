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
        <script src="./My97DatePicker/WdatePicker.js"></script>
    </head>
       <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
                         人员管理 >搜索会议
            </blockquote>
        <form action="${pageContext.request.contextPath }/searchmeeting" method="post">
          <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">会议搜索</a></legend>
            </fieldset>
                    <table class="layui-table">
                   <tr>
                        <td>会议名称：</td>
                        <td>
                            <input type="text" id="meetingname"  name="meetingname" value="${meetingname}" maxlength="20"/>
                        </td>
                        <td>会议室名称：</td>
                        <td>
                            <input type="text" id="roomname"  value="${roomname}" name="roomname" maxlength="20"/>
                        </td>
                        <td>预定者姓名：</td>
                        <td>
                            <input type="text" id="reservername"  value="${reservername}" name="reservername" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>预定日期：</td>
                        <td colspan="5">
                            从&nbsp;
                            <input class="Wdate" type="text" id="starttime"  name="reservefromdate"
                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                            到&nbsp;
                            <input class="Wdate" type="text" id="endtime"  name="reservetodate"
                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                        </td>
                    </tr>
                    <tr>
                        <td>会议日期：</td>
                        <td colspan="5">
                            从&nbsp;
                            <input class="Wdate" type="text" name="meetingfromdate" 
                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                            到&nbsp;
                            <input class="Wdate" type="text" name="meetingtodate"
                                   onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
                        </td>
                    </tr>
                    <tr>
                        <td align="center" colspan="6" class="command">
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
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议室名称</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议预定时间</th>
                <th>预定者</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="m">
                <tr>
                    <td>${m.meetingname}</td>
                    <td>${m.roomname}</td>
                    <td>${m.starttime}</td>
                    <td>${m.endtime}</td>
                    <td>${m.reservationtime}</td>
                    <td>${m.empname}</td>
                    <td>
                        <a class="layui-btn" href="${pageContext.request.contextPath}/meetingdetail?mid=${m.meetingid}">查看详情</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
               
          
              <div align="center">               
                  共<span class="info-number">${totalCount}</span>条结果，
                    分成<span class="info-number">${totalPage}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
            
                    <a type="button" class="clickbutton"
                       href="${pageContext.request.contextPath}/searchmeeting?page=1&meetingname=${meetingname}&roomname=${roomname}&reservername=${reservername}&reservefromdate=${reservefromdate}&reservetodate=${reservetodate}&meetingfromdate=${meetingfromdate}&meetingtodate=${meetingtodate}">首页</a>
                    <c:choose>
                        <c:when test="${page>1}">
                            <a type="button" class="clickbutton"
                               href="${pageContext.request.contextPath}/searchmeeting?page=${page-1}&meetingname=${meetingname}&roomname=${roomname}&reservername=${reservername}&reservefromdate=${reservefromdate}&reservetodate=${reservetodate}&meetingfromdate=${meetingfromdate}&meetingtodate=${meetingtodate}">上页</a>
                        </c:when>
                        <c:otherwise>上页</c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${page<totalPage}">
                            <a type="button" class="clickbutton"
                               href="${pageContext.request.contextPath}/searchmeeting?page=${page+1}&meetingname=${meetingname}&roomname=${roomname}&reservername=${reservername}&reservefromdate=${reservefromdate}&reservetodate=${reservetodate}&meetingfromdate=${meetingfromdate}&meetingtodate=${meetingtodate}">下页</a>
                        </c:when>
                        <c:otherwise>
                            下页
                        </c:otherwise>
                    </c:choose>
                    <a type="button" class="clickbutton"
                       href="${pageContext.request.contextPath}/searchmeeting?page=${totalPage}&meetingname=${meetingname}&roomname=${roomname}&reservername=${reservername}&reservefromdate=${reservefromdate}&reservetodate=${reservetodate}&meetingfromdate=${meetingfromdate}&meetingtodate=${meetingtodate}">末页</a>
                    <form action="${pageContext.request.contextPath}/searchmeeting" style="display: inline" method="post">
                        <input type="hidden" value="${meetingname}" name="meetingname" maxlength="20"/>
                        <input type="hidden" value="${roomname}" name="roomname" maxlength="20"/>
                        <input type="hidden" value="${reservername}" name="reservername" maxlength="20"/>
                        <input type="hidden" value="${reservefromdate}" name="reservefromdate" maxlength="20"/>
                        <input type="hidden" value="${reservetodate}" name="reservetodate" maxlength="20"/>
                        <input type="hidden" value="${meetingfromdate}" name="meetingfromdate" maxlength="20"/>
                        <input type="hidden" value="${meetingtodate}" name="meetingtodate" maxlength="20"/>
                        跳到第<input type="text" id="pagenum" name="page" class="nav-number"/>页
                        <input type="submit" class="layui-btn" value="跳转"/>
                    </form>
                </div>
            </div>
      
       
</body>
</html>




          