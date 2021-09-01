<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/25
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp页面</h1>
<%
    //设置四个值
    pageContext.setAttribute("key1", "pageContext");
    request.setAttribute("key2", "request");
    session.setAttribute("key3", "session");
    application.setAttribute("key4", "application");
%>
<h2>scope1</h2>
    pageContext是否有值:<%=pageContext.getAttribute("key1")%><br/>
    request是否有值:<%=request.getAttribute("key2")%><br/>
    session是否有值:<%=session.getAttribute("key3")%><br/>
    application是否有值:<%=application.getAttribute("key4")%><br/>

<%--
    //还可以进行请求转发
    request.getRequestDispatcher("/scope2.jsp").forward(request, response);
--%>
    <%--
         <jsp:forward page="include"></jsp:forward> 这是jsp中的请求转发标签，功能就是进行请求转发
            page请求转发的路径
    --%>
    <jsp:forward page="/scope2.jsp"></jsp:forward>
</body>
</html>
