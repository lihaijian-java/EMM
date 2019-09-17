<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
        <meta charset="utf-8">
        <title>
          撤销会议预定
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
               会议预定 > 撤销会议预定
            </blockquote>
            <form action="${pageContext.request.contextPath }/docanceled" method="post">
            <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">撤销预定</a></legend>
            </fieldset>
     
            <table class="layui-table">           
            <tr class="listheader">
                <tr>
                        <td><input type="hidden" name="mid" value="${m.meetingid}"/></td>
                        <td>会议名称：     ${m.meetingname}</td>
                   
                    </tr>
                    <tr>
                        <td>撤销理由：</td>
                        <td><textarea id="description" rows="5" name="canceledreason"></textarea></td>
                    </tr>
                    <tr>
                        <td class="command" colspan="2">
                            <input type="submit"   class="layui-btn" value="确认撤销"></input>
                            <input type="button" class="layui-btn"  value="返回" onclick="window.history.back();"/>
                        </td>
                    </tr>
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

