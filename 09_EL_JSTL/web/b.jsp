<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/26
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //往四个域中放入相同的数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
<%--取数据时，会从四个域中取，从域的小到大匹配，匹配到就输出--%>
${key}<br/>

${12/2}<br/>
${empty null}<br/>
${empty ""}<br/>

${pageContext.getAttribute("key")}<br/>
${pageScope.get("key")}<br/>
${pageScope}<br/>
${requestScope}<br/>
${applicationScope.get("key")}<br/>
${pageContext.request}<br/>
协议：${pageContext.request.scheme}<br/>
服务器ip：${pageContext.request.serverName}<br/>
服务器端口号：${pageContext.request.serverPort}<br/>
请求方法：${pageContext.request.method}<br/>
客户端ip：${pageContext.request.remoteHost}<br/>

</body>
</html>
