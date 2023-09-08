<%@page import="comp.connect.server.*" %>
<%@page import="comp.remainder.app.User" %>
<%@page import="java.sql.*" %>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
</style>
</head>
<body>

<h2>View Your Remainder</h2>



<table>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
  </tr>
  <%
  String uemail = User.getUsername();
  Connection con = ConnectDB.connect();
  PreparedStatement ps1 = con.prepareStatement("select * from rem_tbl where uemail=?");
  ps1.setString(1, uemail);
  ResultSet rs = ps1.executeQuery();
  while(rs.next())
  {
  
  %>
  <tr>
    <td><%=rs.getString("remid") %></td>
    <td><%=rs.getString("remtitle") %></td>
    <td><%=rs.getString("remdesc") %></td>
  </tr>
  <% } %>
  
</table>

</body>
</html>