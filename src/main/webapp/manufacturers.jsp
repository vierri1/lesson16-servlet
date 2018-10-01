<%@ page import="pojo.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.10.2018
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturers List</title>
</head>
<body>
<table>
    <tr>
        <th>Manufacturer</th>
        <th>Country</th>
    </tr>

    <%
        List<Manufacturer> manufacturers =
                (ArrayList<Manufacturer>) request.getAttribute("manufacturers");
        for (int i = 0; i < manufacturers.size(); i++) {
    %>
    <tr>
        <td><a href="/mobiles?id=<%=manufacturers.get(i).getId()%>"><%=manufacturers.get(i).getName()%></a></td>
        <td><%=manufacturers.get(i).getCountry()%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
