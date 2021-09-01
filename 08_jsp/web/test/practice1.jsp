<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/25
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 630px;
            margin-left: auto;
            margin-right: auto;
            font-size: large;
        }
    </style>
</head>
<body>
<%--练习输出九九乘法表--%>
<h1 align="center">九九乘法口诀表</h1>
<table>
    <%for (int i = 1; i < 10; i++) {%>
    <tr>
        <% for (int j = 1; j <= i; j++) { %>
        <td><%=j + "*" + i + "=" + (i * j) + " "%></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
