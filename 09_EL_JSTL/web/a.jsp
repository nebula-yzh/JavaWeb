<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/26
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","值");
    %>
    表达式脚本输出：<%=request.getAttribute("key")%><br/>
    EL表达式输出：${key}<br/>
</body>
</html>
