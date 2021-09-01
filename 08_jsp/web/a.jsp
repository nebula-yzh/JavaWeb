<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 应志豪
  Date: 2021/2/25
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp中常用脚本
    一、声明脚本(极少使用)
    声明脚本的格式是： <%! 声明 java 代码 %>
    作用：可以给 jsp 翻译出来的 java 类定义属性和方法甚至是静态代码块。内部类等。
   --%>
<%--1、声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%--2、声明 static 静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
    }
%>
<%--3、声明类方法--%>
<%!
    public int abc() {
        return 12;
    }
%>
<%--4、声明内部类--%>
<%!
    public static class A {
        private Integer id;
        private String name;
    }
%>

<%--
二、表达式脚本（常用）
    表达式脚本的格式是：<%=表达式%>
    表达式脚本的作用是：的 jsp 页面上输出数据。
    表达式脚本的特点：
        1、所有的表达式脚本都会被翻译到_jspService() 方法中
        2、表达式脚本都会被翻译成为 out.print()输出到页面上
        3、由于表达式脚本翻译的内容都在_jspService() 方法中,所以_jspService()方法中的对象都可以直接使用。
        4、表达式脚本中的表达式不能以分号结束。
    练习：
    1. 输出整型
    2. 输出浮点型
    3. 输出字符串
    4. 输出对象
--%>
<%=12%><br/>
<%=12.13%><br/>
<%="i lsn 中文"%><br/>
<%=map%><br/>
<%=request.getParameter("username")%><br/>
<%--
三、代码脚本
    代码脚本的格式是： <% java 语句 %>
    代码脚本的作用是：可以在 jsp 页面中，编写我们自己需要的功能（写的是 java 语句）。
    代码脚本的特点是：
    1、代码脚本翻译之后都在_jspService 方法中
    2、代码脚本由于翻译到_jspService()方法中，所以在_jspService()方法中的现有对象都可以直接使用。
    3、还可以由多个代码脚本块组合完成一个完整的 java 语句。
    4、代码脚本还可以和表达式脚本一起组合使用，在 jsp 页面上输出数据
--%>
<%-- 1. 代码脚本----if 语句--%>
<%
    int a = 4;
    if (a > 2) {
        System.out.println("x");
    } else {
        System.out.println("y");
    }
%>
<%-- 2. 代码脚本----for 循环语句--%>
<%
    for (int i = 0; i < 10; i++) {
%>
<%=i%><br/>
<%
        System.out.println(i);
    }
%>
<%--与html标签结合 输出10行--%>
<table border="1" cellspacing="0">
    <%
        for (int i = 0; i < 10; i++) {
    %>
    <tr>
        <td>第<%=i + 1%>行</td>
    </tr>
    <%
        }
    %>
</table>
<%-- 3. 翻译后 java 文件中_jspService 方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println("username:" + username);
%>

</body>
</html>
