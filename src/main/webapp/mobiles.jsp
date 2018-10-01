<%@ page import="pojo.Manufacturer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Mobile" %><%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 01.10.2018
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mobiles</title>
</head>
<body>
<table>
<tr>

    <th>Manufacturer</th>
    <th>Model</th>
    <th>Price</th>
</tr>

<%
    List<Mobile> mobiles =
            (ArrayList<Mobile>) request.getAttribute("mobiles");
    for (int i = 0; i < mobiles.size(); i++) {
%>
<tr>
    <td><%=mobiles.get(i).getManufacturer().getName()%></td>
    <td><%=mobiles.get(i).getModel()%></td>
    <td><%=mobiles.get(i).getPrice()%></td>
</tr>
<%
    }
%>
    </table>

</body>
</html>
