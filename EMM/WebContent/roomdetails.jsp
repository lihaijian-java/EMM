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
                             会议管理> 修改会议室信息
            </blockquote>
           <form action="${pageContext.request.contextPath }/addmeetingroom" method="post">
                 <table class="layui-table">
                <thead>
                    <tr>
                        <th colspan="2" scope="col">会议室信息</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>门牌号:</td>
                        <td>
                            <input name="roomid" value="${mr.roomid}" type="hidden">
                            <input id="roomnumber"  name="roomnum" type="text" value="${mr.roomnum}" maxlength="10"/>
                        </td>
                    </tr>
                    <tr>
                        <td>会议室名称:</td>
                        <td>
                            <input id="capacity" type="text"  name="roomname" value="${mr.roomname}" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>最多容纳人数：</td>
                        <td>
                            <input id="roomcapacity" type="text" name="capacity" value="${mr.capacity}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>当前状态：</td>
                        <td>
                            <c:choose>
                                <c:when test="${mr.status==0}">
                                    <input type="radio" id="status" name="status" checked="checked" value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" value="1"/> <label for="status">停用</label>                                                                                   
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" id="status" name="status" value="0"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" checked="checked" value="1"/> <label for="status">停用</label> 
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>
                    <tr>
                        <td>备注：</td>
                        <td>
                            <textarea id="description" maxlength="200" rows="5" name="description" cols="60">${mr.description}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="确认修改" class="layui-btn"/>
                            <input type="button" class="layui-btn" value="返回" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </tbody>
            </table>
              </form>
         
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
 
 