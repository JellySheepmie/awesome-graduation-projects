<%@ page contentType="text/html;charset=gb2312" %>
<%@ include file="checkfinaler.jsp"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.lynews.news.*"%>
<%@ include file="../conn/conn.jsp"%>
<%
int id = Integer.parseInt((String)request.getParameter("id"));
stmt = con.createStatement() ;
String sql3="delete from message where id="+id;
stmt.executeUpdate(sql3);


response.sendRedirect("allmessage.jsp");
%>