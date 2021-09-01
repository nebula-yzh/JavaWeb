<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/28
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
1.遍历 1 到 10，输出
 begin属性设置开始的索引
 end属性设置结束的索引
 var属性表示循环的变量(也是当前正在遍历到的数据)
 for(int i = 1; i < 10; i++)
 --%>
<c:forEach begin="1" end="10" var="i">
    i=${i}<br/>
</c:forEach>

<%--
2.遍历 Object 数组
        for (Object item: arr)
    items 表示遍历的数据源（遍历的集合）
    var 表示当前遍历到的数据
3.遍历map集合
4.遍历list集合
 --%>
<%
    ArrayList<String> al = new ArrayList<>();
    al.add("nebula");
    al.add("yzh");
    al.add("bupt");
    Object obj[] = new Object[]{"nebula", 123, al};
    request.setAttribute("obj", obj);
    request.setAttribute("al", al);
    HashMap<String, Object> map = new HashMap<>();
    map.put("al", al);
    map.put("obj", obj);
    request.setAttribute("map", map);
%>
<c:forEach items="${requestScope.obj}" var="object">
    object=${object}<br/>
</c:forEach>
<c:forEach items="${requestScope.map}" var="map">
    ${map.key}=${map.value}<br/>
</c:forEach>

</body>
</html>
