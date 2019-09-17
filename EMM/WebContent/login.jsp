<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE> 
    <head>
        <meta charset="utf-8">
        <title>
            英杰会议管理系统v1.0
        </title>
       <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no"> 
        <link rel="stylesheet" href="css/x-admin.css">
          <link rel="shortcut icon" href="images/meeting.ico" /> 
    </head>
    
    <body style="background-color: #393D49">
        <div class="x-box">
            <div class="x-top">
                <i class="layui-icon x-login-close">
                    会议管理系统
                </i>
                  <div align="right" class="x-top">   <input type="button"  value="去注册"  class="layui-btn"  onclick="window.location.href='reg' "/></div>              
            </div>
            <div class="x-mid">
                <div class="x-avtar">
                    <img src="./images/logo.png" alt="">
                </div>
                <div class="input">
                    <form class="layui-form" action="${pageContext.request.contextPath }/login" method="post" name="loginForm" >
                        <div class="layui-form-item x-login-box">
                            <label for="username" class="layui-form-label">
                                <i class="layui-icon">&#xe612;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="text" id="username" name="accountname" 
                               class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item x-login-box">
                            <label for="pass" class="layui-form-label">
                                <i class="layui-icon">&#xe628;</i>
                            </label>
                            <div class="layui-input-inline">
                                <input type="password" id="pass" name="password" class="layui-input">                                
                            </div>                            
                        </div>
                       <span style="color:red"> ${error}</span>                       
                        
                        <div class="layui-form-item" id="loginbtn">
                        
                           <button id="btn1" class="layui-btn" onclick="return check(forms);">
                                登 录
                            </button>                        
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="js/jquery.min.js"></script>
        <script>
        function check(form){
            if(document.forms.loginForm.accountname.value==""){
                alert("请输入用户名！")
                document.forms.loginForm.accountname.focus();
                return false;
            }
            if(document.forms.loginForm.password.value==""){
                alert("请输入密码！");
                document.forms.loginForm.password.focus();
                return false;
                }     
        }
            layui.use(['form'],
            function() {
                $ = layui.jquery;
                var form = layui.form(),
                layer = layui.layer;

                $('.x-login-right li').click(function(event) {
                    color = $(this).attr('color');
                    $('body').css('background-color', color);
                });

                //监听提交
                form.on('submit(save)',
                function(data) {
                    console.log(data);
                    layer.alert(JSON.stringify(data.field), {
                      title: '最终的提交信息'
                    },function  () {
                        location.href = "./index.jsp";
                    })
                    return false;                              
                 $("#btn1").click(function(){
                	 $("span").css("color","red");
                	});
                });                           
            });       
        </script>
    </body>
</html>