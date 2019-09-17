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
    </head>
       <body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
                      会议预定 > 会议详情
            </blockquote>
         
                 <table class="layui-table">
                <thead>
                    <tr>
                        <th colspan="2" scope="col">会议信息</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th width="30%">会议名称：</th>
                        <td><span id="lbServerName">${mt.meetingname}</span></td>
                    </tr>
                    <tr>
                        <td>预计参加人数：</td>
                        <td>${mt.numberofparticipants}</td>
                    </tr>
                    <tr>
                        <td>预计开始时间：</td>
                        <td>${mt.starttime}</td>
                    </tr>
                    <tr>
                        <td>预计结束时间：</td>
                        <td>${mt.endtime}</td>
                    </tr>
                    <tr>
                        <td>会议说明： </td>
                        <td><textarea id="description" rows="5" readonly>${mt.description}</textarea></td>
                    </tr>
                    <tr>
                        <td>参会人员： </td>
                        <td> 
                        <table class="listtable">
                                <tr class="listheader">
                                    <th>姓名</th>
                                    <th>联系电话</th>
                                    <td>电子邮件</td>
                                </tr>
                                <c:forEach items="${emps}" var="emp">
                                    <tr>
                                        <td>${emp.employeename}</td>
                                        <td>${emp.phone}</td>
                                        <td>${emp.email}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                            </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <c:if test="${type=='cancel'}">
                                <input type="button" class="layui-btn" value="撤销会议"
                                       onclick="window.location.href='cancelmeeting?mid=${mt.meetingid}';"/>
                            </c:if>
                            <input type="button"  class="layui-btn" value="返回" onclick="window.history.back();"/> </td>                       
                    </tr>
                </tbody>
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