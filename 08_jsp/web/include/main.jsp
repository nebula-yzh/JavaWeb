<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/25
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br/>
    主题信息<br/>
    <%--
        <%@include file="footer.jsp"%> 这就是静态包含
        file属性指定要包含的jsp页面的路径

        静态包含的特点：
        1、静态包含不会翻译被包含的 jsp 页面。
        2、静态包含其实是把被包含的 jsp 页面的代码拷贝到包含的位置执行输出。
    --%>
<%--    <%@include file="/include/footer.jsp"%>--%>
    <%--
        <jsp:include page="footer.jsp"></jsp:include> 这是动态包含
        page属性指定要包含的jsp页面的路径
        动态包含也可以像静态包含页面一样，把被包含的页面执行输出到包含位置

    动态包含的特点：
     1、动态包含会把包含的 jsp 页面也翻译成为 java 代码
     2、动态包含底层代码使用如下代码去调用被包含的 jsp 页面执行输出。
        JspRuntimeLibrary.include(request, response, "/include/footer.jsp", out, false);
     3、动态包含，还可以传递参数

     --%>
    <jsp:include page="footer.jsp">
        <jsp:param name="username" value="root"/>
        <jsp:param name="password" value="root"/>
    </jsp:include>
</body>
</html>
