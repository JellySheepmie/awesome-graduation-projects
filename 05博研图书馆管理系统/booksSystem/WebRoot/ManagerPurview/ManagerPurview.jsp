<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>图书馆管理系统</title>
<link href="CSS/style.css" rel="stylesheet">
</head>
<script language="javascript">
function checkForm(form){
	for(i=0;i<form.length;i++){
		if(form.elements[i].value==""){
			alert("请将信息添写完整!");
			form.elements[i].focus();
			return false;
		}
	}
}
</script>
<body onLoad="clockon(bgclock)">
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="118" valign="top" background="Images/top_bg.gif" bgcolor="#EEEEEE"><table width="100%" height="33"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="81%" height="10"></td>
        <td colspan="2"></td>
      </tr>
      <tr>
        <td height="20">&nbsp;</td>
        <td width="10%"><a href="#" onClick="window.location.reload();" class="word_dark">刷新页面</a></td>
        <td width="9%"><a href="#" onClick="myclose()" class="word_dark">关闭系统</a></td>
		<script language="javascript">
			function myclose(){
				if(confirm("真的要关闭当前窗口吗?")){
					window.close();
				}
			}
		</script>
        </tr>
    </table>
      <table width="93%" height="79"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="69" align="right" valign="bottom">当前登录用户：${manager.name }</td>
        </tr>
    </table></td>
  </tr>
</table>





<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="JS/onclock.JS" charset="utf-8"></script>
<script src="JS/menu.JS" charset="utf-8"></script>
<div class=menuskin id=popmenu
      onmouseover="clearhidemenu();highlightmenu(event,'on')"
      onmouseout="highlightmenu(event,'off');dynamichide(event)" style="Z-index:100;position:absolute;"></div>
<table width="778"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr bgcolor="#DFA40C">
        <td width="3%" height="27">&nbsp;</td>
        <td width="29%"><div id="bgclock" class="word_white"></div></td>
		<script language="javascript">
			function quit(){
				if(confirm("真的要退出系统吗?")){
					window.location.href="login.html";
				}
			}
		</script>
        <td width="66%" align="right" bgcolor="#B0690B" class="word_white"><a href="BookServlet" class="word_white">首页</a> |
        <a  onmouseover=showmenu(event,sysmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >系统设置</a> | <a  onmouseover=showmenu(event,readermenu) onmouseout=delayhidemenu() style="CURSOR:hand"  class="word_white">读者管理</a> | <a  onmouseover=showmenu(event,bookmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand" >图书管理</a> | <a  onmouseover=showmenu(event,borrowmenu) onmouseout=delayhidemenu() class="word_white" style="CURSOR:hand">图书借还</a> | <a  onmouseover=showmenu(event,querymenu) onmouseout=delayhidemenu()  class="word_white" style="CURSOR:hand" >系统查询</a> | <a  href="pwd_Modify.jsp" class="word_white">更改口令</a> | <a href="AdminServlet2?operation=logout" onClick="quit()" class="word_white">退出系统</a></td>
        <td width="2%" bgcolor="#B0690B">&nbsp;</td>
  </tr>
      <tr bgcolor="#DFA40C">
        <td height="9" colspan="4" background="Images/navigation_bg_bottom.gif"></td>
      </tr>
</table>

<table width="778"  border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="top" bgcolor="#FFFFFF"><table width="99%" height="510"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tableBorder_gray">
  <tr>
    <td height="510" valign="top" style="padding:5px;"><table width="98%" height="487"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="22" valign="top" class="word_orange">当前位置：系统设置 &gt; 图书馆信息 &gt;&gt;&gt;</td>
      </tr>
      <tr>
        <td align="center" valign="top">
 <table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="84%">&nbsp;      </td>
</tr>
</table>  
<form  method="post" action="ManagerServlet">
<input type="hidden" name="operation" value="updectManagerpurview">
<input type="hidden" name="pid" value="${m.pid }">
<table>
 <tr align="center" bgcolor="#e3F4F7">
    <td width="26%" bgcolor="#F9D16B">管理员名称</td>
    <td>
    <input type="text" name="name" value="${m.name }" disabled="disabled" />
    </td>
  </tr>   
  <tr align="center" bgcolor="#e3F4F7">
    <td width="12%" bgcolor="#F9D16B">系统设置权限</td>
       <c:if test="${m.purview.sysset==1 }" >
    	<td align="center">
    	<input name="sysset" type="radio" class="noborder" value="1"  checked>赋予
    	<input name="sysset" type="radio" class="noborder" value="0" >取消
    	</td>
		
		</c:if>
		<c:if test="${m.purview.sysset==0 }" >
    		<td align="center">
    			<input name="sysset" type="radio" class="noborder" value="1" >赋予
    			<input name="sysset" type="radio" class="noborder" value="0"  checked>取消
    		</td>
		</c:if>
   </tr> 
   <tr>
   		<td width="12%" bgcolor="#F9D16B">读者管理权限</td>
   		
   	<c:if test="${m.purview.readerset==1 }" >
    <td align="center">
    <input name="readerset" type="radio" class="noborder" value="1"  checked>赋予
    <input name="readerset" type="radio" class="noborder" value="0" >取消
    </td>
	</c:if>
<c:if test="${m.purview.readerset==0 }" >
    <td align="center">
    	<input name="readerset" type="radio" class="noborder" value="1" >赋予
    	<input name="readerset" type="radio" class="noborder" value="0" checked>取消
    </td>
</c:if>
   </tr>
   <tr>
   		<td width="12%" bgcolor="#F9D16B">图书管理权限</td>
   		  <c:if test="${m.purview.bookset==1 }" >
    <td align="center">
        <input name="bookset" type="radio" class="noborder" value="1" >赋予
    <input name="bookset" type="radio" class="noborder" value="0"  checked>取消
    
    </td>
	</c:if>
	<c:if test="${m.purview.bookset==0 }" >
    <td align="center">
    <input name="bookset" type="radio" class="noborder" value="1" >赋予
        <input name="bookset" type="radio" class="noborder" value="0" checked >取消
    
    </td>
</c:if>
   </tr>
   <tr>
   		 <td width="11%" bgcolor="#F9D16B">图书借还权限</td>
   		 <c:if test="${m.purview.borrowback==1 }" >
    <td align="center">
  	  <input name="borrowback" type="radio" class="noborder" value="1" checked>赋予
    <input name="borrowback" type="radio" class="noborder" value="0" >取消
  	
    </td>
</c:if>
<c:if test="${m.purview.borrowback==0 }" >
    <td align="center">
    <input name="borrowback" type="radio" class="noborder" value="1"  >赋予
        <input name="borrowback" type="radio" class="noborder" value="0" checked >取消
    </td>
</c:if>
   </tr>
   <tr>
   		<td width="10%" bgcolor="#F9D16B">系统查询权限</td>
   		 <c:if test="${m.purview.sysquery==1 }" >
		    <td align="center">
			    <input name="sysquery" type="radio" class="noborder" value="1"  checked>赋予
			    <input name="sysquery" type="radio" class="noborder" value="0">取消
		    
		    </td>
		</c:if>
		<c:if test="${m.purview.sysquery==0 }" >
		    <td align="center">
		     	<input name="sysquery" type="radio" class="noborder" value="1" >赋予
		    	<input name="sysquery" type="radio" class="noborder" value="0" checked>取消
		    </td>
		</c:if>
   </tr>
   <tr>
   	<td colspan="2" align="center">
   		<input type="submit" value="提交"/>
   		<input type="reset" value="重置"/>
   	</td>
   </tr>
   
   </table>

</form>

<table width="778" height="66"  border="0" align="center" cellpadding="-2" cellspacing="-2" bgcolor="#FFFFFF">
      <tr>
        <td height="11" colspan="4" background="Images/copyright_t.gif"></td>
  </tr>
      <tr>
        <td width="124" height="23">&nbsp;</td>
        <td valign="bottom" align="center"> CopyRight &copy; 2008 www.**********.com 长春市*****有限公司</td>
        <td width="141">&nbsp;</td>
      </tr>
      <tr>
        <td height="23">&nbsp;</td>
        <td align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="8"></td>
        <td height="8"></td>
        <td height="8"></td>
      </tr>
</table>
</td>
  </tr>
</table>
</body>
</html>
    
  