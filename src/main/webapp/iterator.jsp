<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.10.2018
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iterator</title>
</head>
<body>
    <%
        List<Integer> list = (ArrayList<Integer>)request.getAttribute("list");
        for (int i = 0; i < list.size(); i++) { %>
            <%=i%>
        <%}
    %>
</body>
</html>
