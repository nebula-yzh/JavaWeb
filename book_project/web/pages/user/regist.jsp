<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%--静态包含，头信息，base标签、css样式、jQuery--%>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        //页面加载完成后
        $(function () {
            //给验证码图片绑定单击事件
            $("#code_img").click(function () {
                //this对象是当前正在响应事件的dom对象
                //src表示当前标签的属性，可读可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });

            //给注册按钮绑定单击事件
            $("#sub_btn").click(function () {
                // 一、验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取用户名输入框的内容
                var usernameVal = $("#username").val();
                //2.创建正则表达式对象,使用双斜杠区分
                var usernamePatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!usernamePatt.test(usernameVal)) {
                    //4.提示用户结果(不匹配)
                    $(".errorMsg").text("用户名不合法!");
                    return false;
                }
                // 二、验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                //1.获取密码输入框的内容
                var passwordVal = $("#password").val();
                //2.创建正则表达式对象,使用双斜杠区分
                var passwordPatt = /^\w{5,12}$/;
                //3.使用test方法验证
                if (!passwordPatt.test(passwordVal)) {
                    //4.提示用户结果(不匹配)
                    $(".errorMsg").text("密码不合法!");
                    return false;
                }
                // 验证确认密码：和密码相同
                var passwordCon = $("#repwd").val();
                if (passwordCon != passwordVal) {
                    $(".errorMsg").text("确认密码与密码不一致!");
                    return false;
                }
                // 邮箱验证：xxxxx@xxx.com
                var emailVal = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailVal)) {
                    $(".errorMsg").text("邮箱格式不合法!");
                    return false;
                }
                // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                var codeVal = $("#code").val();
                //去掉验证码前后空格
                var codeVal = $.trim(codeVal);
                if (codeVal == null || codeVal == "") {
                    $(".errorMsg").text("验证码不能为空");
                    return false;
                }
                //当表单信息合法，则将提示处信息删除，无不合法提示信息
                $(".errorMsg").text("");
            });
        });
    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 120px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg"
                             style="float: right; margin-right: 40px; width: 100px;height: 35px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%-- 静态包含 页脚 --%>
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>