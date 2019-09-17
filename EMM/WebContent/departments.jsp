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
                         人员管理 > 部门管理 
            </blockquote>
         <form method="post" action="${pageContext.request.contextPath }/adddep">
                       部门名称:
                <input type="text" style="height:30px" id="departmentname" name="departmentname"  maxlength="30"/>
                      <span id="lbServerName">  <input type="submit"  class="layui-btn" value="添加"/></span>
             </form>
                 <table class="layui-table">
               
                <tbody>
                 <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
            <c:if test="${error!=null}">
                <tr>
                    <td colspan="3">${error}</td>
                </tr>
            </c:if>
            <c:forEach items="${list}" var="dep">
                <tr>
                    <td>${dep.departmentid}</td>
                    <td id="depname${dep.departmentid}">${dep.departmentname}</td>
                    <td>
                        <a class="layui-btn" id="edit${dep.departmentid}"
                           onclick="editDep(${dep.departmentid})">编辑</a>
                        <a   class="layui-btn"  style="display: none;height: 80px;"  id="cancel${dep.departmentid}"
                           onclick="cancelEdit(${dep.departmentid},'${dep.departmentname}')">取消</a>
                        <a  class="layui-btn" href="${pageContext.request.contextPath }/deletedep?depid=${dep.departmentid}">删除</a>
                    </td>
                </tr>
            </c:forEach>
                </tbody>
            </table>

        </div>  
          <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script src="./js/x-layui.js" charset="utf-8"></script>
        <script>
        function cancelEdit(depid, depName) {
            var cancelBtn = $("#cancel" + depid);
            var editBtn = $("#edit" + depid);
            var ele = $("#depname" + depid);
            cancelBtn.css("display", "none");
            editBtn.html("编辑");
            ele.html(depName);
        }
        function editDep(depid) {
            var cancelBtn = $("#cancel" + depid);
            var editBtn = $("#edit" + depid);
            var ele = $("#depname" + depid);
            if (cancelBtn.css("display") == 'none') {
                cancelBtn.css("display", "inline")
                editBtn.html("确定");
                var depName = ele.text();
                ele.html("<input  type='text' value='" + depName + "'/>");
            } else {
                //提交修改
                var children = ele.children("input");
                var val = children.val();
                $.post("${pageContext.request.contextPath}/updateDep", {id: depid, depName: val}, function (msg) {          
                    cancelBtn.css("display", "none")
                    editBtn.html("编辑");
                    ele.html(val);
                });
            }
        }
</script>    
    </body>
 </html>

