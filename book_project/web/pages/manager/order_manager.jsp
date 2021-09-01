<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%--静态包含，头信息，base标签、css样式、jQuery--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">订单管理系统</span>
    <%--静态包含 管理页面--%>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>

        </tr>
        <tr>
            <td>2015.04.23</td>
            <td>90.00</td>
            <td><a href="#">查看详情</a></td>
            <td><a href="#">点击发货</a></td>
        </tr>

        <tr>
            <td>2015.04.20</td>
            <td>20.00</td>
            <td><a href="#">查看详情</a></td>
            <td>已发货</td>
        </tr>

        <tr>
            <td>2014.01.23</td>
            <td>190.00</td>
            <td><a href="#">查看详情</a></td>
            <td>等待收货</td>
        </tr>
    </table>
</div>

<%-- 静态包含 页脚 --%>
<%@include file="/pages/common/foot.jsp"%>
</body>
</html>