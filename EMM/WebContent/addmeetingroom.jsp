<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
        <meta charset="utf-8">
        <title>
       添加会议室
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
             会议管理 > 添加会议室
            </blockquote>
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">会议室信息</a></legend>
            </fieldset>
             <form action="${pageContext.request.contextPath}/addmeetingroom" method="post"> 
              <input id="roomid"  name="roomid"  type="hidden" maxlength="10"/>
            <table class="layui-table">        
                    <tr>
                        <td>门牌号:</td>
                        <td>
                            <input id="roomnumber"  name="roomnum"  type="text" placeholder="例如：201" maxlength="10"/>
                        </td>
                    </tr>
                    <tr>
                        <td>会议室名称:</td>
                        <td>
                            <input id="capacity"  name="roomname" type="text" placeholder="例如：第一会议室" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>最多容纳人数：</td>
                        <td>
                            <input id="roomcapacity" name="capacity" type="text" placeholder="填写一个正整数"/>
                        </td>
                    </tr>
                    <tr>
                        <td>当前状态：</td>
                        <td>
                            <input type="radio" id="status" name="status" checked="checked" value="0"/>启用
                            <input type="radio" id="status" name="status" value="1"/>停用
                        </td>
                    </tr>
                    <tr>
                        <td>备注：</td>
                        <td>
                            <textarea id="description" name="description" maxlength="200" rows="5" cols="60"
                                      placeholder="200字以内的文字描述"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="添加" class="layui-btn"/>
                            <input type="reset" value="重置" class="layui-btn"/>
                        </td>
                    </tr>          
        </table>   
         </form> 
        </div>                   
    </body>    
</html>



