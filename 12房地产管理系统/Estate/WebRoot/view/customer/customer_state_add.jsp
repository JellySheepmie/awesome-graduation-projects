<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <base href="<%=basePath%>">
		<title>My JSP 'customerCondition_add.jsp' starting page</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" >  
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="resource/css/admin.css" type=text/css  rel=stylesheet>
		<script type="text/javascript" src="resource/js/CheckForm.js"></script>
	</head>

	<body>
		<form action="servlet/CustomerConditionServlet?method=add"  name="form2" onsubmit="return checkForm('form2');" method="post" >
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入顾客状态的详细信息
					</td>
				</tr>
				<tr>
					<td width="19%" bgcolor="#FFFDF0">
						<div align="center">
							顾客状态名称：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  maxlength="20" name="conditionName"  check_str="顾客状态名称" >
						&nbsp;
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							顾客状态描述：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  name="conditionExplain">
						&nbsp;
					</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="10%"></td>
					<td width="10%"><input type="submit" name="submit"  value="提交"></td>
					<td width="5%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="75%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
