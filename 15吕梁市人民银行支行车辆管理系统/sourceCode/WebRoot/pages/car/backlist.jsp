<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd html 4.0 transitional//EN">
<html>
	<head>
		<link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
	<c:if test="${!empty message}">
	<script type="text/javascript">
		var msg="${message}";
		alert(msg);
	</script>
	<c:remove var="message"/>
</c:if>
	
	<body >
			<table width="760" border="0" style="margin:20px 0;" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="3">
						<table cellpadding="0" cellspacing="0" width="100%" height="62">
							<tr>
								<td background="../../images/tab01.gif" width="309" valign="top">
									<div class="tabhead">
										返车登记
									</div>
								</td>
								<td valign="bottom">
									<table cellpadding="0" cellspacing="0" width="100%">
										<tr>
											<td background="../../images/topcenter.gif" width="100%"></td>
											<td><img src="../../images/topright.gif"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td background="../../images/centerleft.gif"></td>
					<td width="100%">
						<table width="100%" border="0" cellspacing="1" cellpadding="3"
							align="center">
							<tr>
								<td bgcolor="#cccccc"  height="3" colspan="5"></td>
							</tr><tr bgcolor="#e6ffd6" height="25">
							<th>出车单号</th><th>调度员</th><th>车牌号码</th><th>发车时间</th><th>操作</th>
							</tr>
							<c:forEach var="record" items="${outrecord}">
							<tr>
								<td bgcolor="#cccccc"  height="3" colspan="5"></td>
							</tr>
								<tr bgcolor="92bff2" height="25">
									<td width="20%" align="center">${record.id}</td>
										<td width="20%" align="center">
										${record.user.name }
									</td>
									<td width="20%" align="center">${record.motorcar.carnumber}</td>
									<td width="20%" align="center">
									${record.outdate }
									</td>
									<td width="20%" align="center">
										<a href="../../backRecordInfo.do?backid=${record.id}">返车登记</a>
									</td>
								</tr></c:forEach>
								<c:remove var="outrecord" scope="session"/>
								<tr>
								<td bgcolor="#cccccc"  height="3" colspan="5"></td>
							</tr>
							
						</table>
					</td>
					<td background="../../images/centeright.gif"></td>
				</tr>
				<tr>
					<td>
						<img src="../../images/bottomleft.gif" />
					</td>
					<td background="../../images/bottomcenter.gif"></td>
					<td>
						<img src="../../images/bottomright.gif" />
					</td>
				</tr>
			</table>
	</body>
</html>
