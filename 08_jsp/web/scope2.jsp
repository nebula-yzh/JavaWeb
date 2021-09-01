<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/25
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>scope2</h2>
pageContext是否有值:<%=pageContext.getAttribute("key1")%><br/>
request是否有值:<%=request.getAttribute("key2")%><br/>
session是否有值:<%=session.getAttribute("key3")%><br/>
application是否有值:<%=application.getAttribute("key4")%><br/>
</body>
</html>
