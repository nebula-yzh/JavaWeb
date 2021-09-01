<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/28
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //动态获取相对路径
    String basePath = request.getScheme()
                    +"://"
                    +request.getServerName()
                    +":"
                    +request.getServerPort()
                    +request.getContextPath()
                    +"/";
    pageContext.setAttribute("basePath",basePath);
%>
<!--写base标签，固定相对路径跳转的结果 -->
<base href="${basePath}"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</body>
</html>
