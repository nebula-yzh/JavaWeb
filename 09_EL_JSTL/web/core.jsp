<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/26
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
<c:set/>标签
    作用：可以往域中保存数据
    格式：域对象.setAttribute(key,value);
--%>
    保存之前：${requestScope.get("key")}<br/>
    <c:set scope="request" var="key" value="key132"/>
    保存之后：${requestScope.key}<br/>

<%--
    <c:if/>标签
    作用：用来做if判断
    test属性表示判断的条件(使用EL表达式输出)
--%>
    <c:if test="${12==12}">
        <h2>12等于12</h2><br/>
    </c:if>

<%--
    <c:choose><c:when test=""><c:otherwise>标签
    作用：多路判断，与switch-case-default类似
    test属性用于条件判断使用EL表达式
--%>
    <%
        request.setAttribute("height",188);
    %>
    <c:choose>
        <c:when test="${requestScope.height>190}">
            <h3>很高</h3>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h3>较高</h3>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h3>一般</h3>
        </c:when>
        <c:otherwise>
            <h3>不太高</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
