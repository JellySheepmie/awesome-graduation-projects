<HEAD>
<%@ page contentType="text/html;charset=gb2312" %>
<%@ include file="../config.jsp"%><TITLE><%=webname%>----我的会员助手!</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!-- Hide

function killErrors() {
return true;
}

window.onerror = killErrors;

// -->
</SCRIPT>
<STYLE type=text/css>
@media All    
{
CC\:clientCaps {
	BEHAVIOR: url(#default#clientCaps)
}
    }
TD {
	FONT-SIZE: 12px; FONT-FAMILY: "宋体"
}
A:link {
	COLOR: #039; TEXT-DECORATION: underline
}
A:visited {
	COLOR: #039; TEXT-DECORATION: underline
}
A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}
.left:link {
	FONT-SIZE: 14px; COLOR: #000000; TEXT-DECORATION: none
}
.left:visited {
	FONT-SIZE: 14px; COLOR: #111111; TEXT-DECORATION: none
}
.left:hover {
	FONT-SIZE: 14px; COLOR: #ff6701; TEXT-DECORATION: underline
}
.left1:link {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: none
}
.left1:visited {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: none
}
.left1:hover {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.top:link {
	FONT-SIZE: 12px; COLOR: #0066cc; TEXT-DECORATION: none
}
.top:visited {
	FONT-SIZE: 12px; COLOR: #0066cc; TEXT-DECORATION: none
}
.top:hover {
	FONT-SIZE: 12px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.top1:link {
	FONT-SIZE: 12px; COLOR: #000000; TEXT-DECORATION: none
}
.top1:visited {
	FONT-SIZE: 12px; COLOR: #000000; TEXT-DECORATION: none
}
.top1:hover {
	FONT-SIZE: 12px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.leftnav {
	PADDING-RIGHT: 10px; PADDING-LEFT: 0px; PADDING-BOTTOM: 6px; CURSOR: hand; PADDING-TOP: 6px; BACKGROUND-COLOR: #e6e6e6; TEXT-ALIGN: right
}
.leftnav1 {
	PADDING-RIGHT: 10px; PADDING-LEFT: 0px; PADDING-BOTTOM: 6px; PADDING-TOP: 6px; BACKGROUND-COLOR: #ffffff; TEXT-ALIGN: right
}
.leftnav2 {
	PADDING-RIGHT: 10px; PADDING-LEFT: 0px; PADDING-BOTTOM: 6px; CURSOR: hand; PADDING-TOP: 6px; BACKGROUND-COLOR: #f2f2f2; TEXT-ALIGN: right
}
.topnav {
	BACKGROUND-COLOR: #ccffff; TEXT-ALIGN: center
}
.topnav1 {
	BACKGROUND-COLOR: #ffffff; TEXT-ALIGN: center
}
.note {
	COLOR: #999999
}
.homebg {
	BACKGROUND-POSITION: right bottom; BACKGROUND-REPEAT: no-repeat
}
.bdr1 {
	BORDER-RIGHT: #ededed 5px solid; PADDING-RIGHT: 0px; BORDER-TOP: #ededed 5px solid; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; BORDER-LEFT: #ededed 5px solid; PADDING-TOP: 0px; BORDER-BOTTOM: #ededed 5px solid
}
.bdr2 {
	BORDER-RIGHT: #cccccc 1px solid; PADDING-RIGHT: 12px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 12px; PADDING-BOTTOM: 12px; BORDER-LEFT: #cccccc 1px solid; PADDING-TOP: 12px; BORDER-BOTTOM: #cccccc 1px solid
}
.bdr3 {
	BORDER-RIGHT: #cc6633 1px solid; PADDING-RIGHT: 12px; BORDER-TOP: #cc6633 1px solid; PADDING-LEFT: 12px; PADDING-BOTTOM: 12px; BORDER-LEFT: #cc6633 1px solid; PADDING-TOP: 12px; BORDER-BOTTOM: #cc6633 1px solid
}
.tbg1 {
	PADDING-RIGHT: 4px; PADDING-LEFT: 4px; FONT-WEIGHT: bold; FONT-SIZE: 14px; PADDING-BOTTOM: 4px; COLOR: #ffffff; PADDING-TOP: 4px; BACKGROUND-COLOR: #cc6633
}
.tbg2 {
	PADDING-RIGHT: 4px; PADDING-LEFT: 4px; FONT-SIZE: 12px; PADDING-BOTTOM: 4px; COLOR: #000000; PADDING-TOP: 4px; BACKGROUND-COLOR: #fff7d8
}
.tbg3 {
	PADDING-RIGHT: 4px; PADDING-LEFT: 4px; FONT-WEIGHT: bold; FONT-SIZE: 16px; PADDING-BOTTOM: 4px; COLOR: #ffffff; PADDING-TOP: 4px; BACKGROUND-COLOR: #cc6633
}
.fbg1 {
	BORDER-RIGHT: #ffcc99 0px solid; PADDING-RIGHT: 4px; BORDER-TOP: #ffcc99 2px solid; PADDING-LEFT: 4px; FONT-WEIGHT: bold; PADDING-BOTTOM: 4px; BORDER-LEFT: #ffcc99 0px solid; COLOR: #cc3300; PADDING-TOP: 4px; BORDER-BOTTOM: #ffcc99 0px solid; BACKGROUND-COLOR: #f1eeee
}
.formtop {
	VERTICAL-ALIGN: top; PADDING-TOP: 6px; TEXT-ALIGN: right
}
.X {
	FONT-WEIGHT: bold; FONT-SIZE: 24px
}
.L {
	FONT-WEIGHT: bold; FONT-SIZE: 16px
}
.M {
	FONT: bold 14px 宋体
}
.C {
	FONT-SIZE: 14px
}
.S {
	FONT-SIZE: 12px
}
.lh13 {
	LINE-HEIGHT: 130%
}
.lh17 {
	LINE-HEIGHT: 170%
}
.padded {
	PADDING-RIGHT: 12px; PADDING-LEFT: 12px; PADDING-BOTTOM: 12px; PADDING-TOP: 12px
}
.temp {
	COLOR: #999999
}
.rd14 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #cc0000
}
.sg {
	COLOR: #666666
}
.pj1x {
	FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #006600
}
.pj2x {
	FONT-WEIGHT: bold; FONT-SIZE: 12px
}
.pj3x {
	FONT-WEIGHT: bold; FONT-SIZE: 12px; COLOR: #ff0000
}
.pj1 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #006600
}
.pj2 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px
}
.pj3 {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff0000
}
.linkstyle1:link {
	FONT-SIZE: 12px; COLOR: #ffffff; TEXT-DECORATION: underline
}
.linkstyle1:visited {
	FONT-SIZE: 12px; COLOR: #ffffff; TEXT-DECORATION: underline
}
.linkstyle1:hover {
	FONT-SIZE: 12px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.linkstyle2:link {
	FONT-SIZE: 14px; COLOR: #000000; TEXT-DECORATION: underline
}
.linkstyle2:visited {
	FONT-SIZE: 14px; COLOR: #000000; TEXT-DECORATION: underline
}
.linkstyle2:hover {
	FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.linkstyle3:link {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.linkstyle3:visited {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.linkstyle3:hover {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #ff6600; TEXT-DECORATION: underline
}
.font_13_white {
	FONT-SIZE: 13px; COLOR: #ffffff; FONT-FAMILY: "宋体"
}
.index_title {
	FONT-WEIGHT: bold; FONT-SIZE: 14px; COLOR: #000000; PADDING-TOP: 2px; FONT-FAMILY: "宋体"
}
.index_content {
	FONT-SIZE: 14px; COLOR: #000000; LINE-HEIGHT: 150%; FONT-FAMILY: "宋体"
}
.leftmenu1 {
	PADDING-LEFT: 6px; FONT-WEIGHT: bold; FONT-SIZE: 14px; BACKGROUND-IMAGE: url(images/leftmanu_bg1.gif); CURSOR: hand; PADDING-TOP: 4px; HEIGHT: 29px
}
.leftmenu2 {
	PADDING-LEFT: 10px; FONT-SIZE: 14px; BACKGROUND-IMAGE: url(images/leftmanu_bg2.gif); HEIGHT: 26px
}
.leftmenu3 {
	BORDER-RIGHT: #4296ce 0px solid; BORDER-TOP: #4296ce 1px solid; PADDING-LEFT: 29px; FONT-SIZE: 14px; BACKGROUND-IMAGE: url(images/leftmanu_bg3.gif); BORDER-LEFT: #4296ce 0px solid; BORDER-BOTTOM: #4296ce 0px solid; HEIGHT: 26px
}
.leftmenu4 {
	BORDER-RIGHT: #4296ce 0px solid; BORDER-TOP: #4296ce 1px solid; PADDING-LEFT: 7px; FONT-SIZE: 14px; BACKGROUND-IMAGE: url(images/leftmanu_bg3.gif); PADDING-BOTTOM: 1px; BORDER-LEFT: #4296ce 0px solid; PADDING-TOP: 1px; BORDER-BOTTOM: #4296ce 0px solid
}
.content_border {
	BORDER-RIGHT: #bdd7f7 1px solid; BORDER-TOP: #000000 0px solid; BORDER-LEFT: #bdd7f7 1px solid; BORDER-BOTTOM: #bdd7f7 1px solid
}
.subbutton {
	FONT-SIZE: 14px; CURSOR: hand; LINE-HEIGHT: 19px
}
.nobianbuttonborder {
	BORDER-TOP: #ffffff 5px solid; FONT-WEIGHT: bold; FONT-SIZE: 12px; BACKGROUND: #f1f1f1; BORDER-BOTTOM: #cccccc 1px solid; HEIGHT: 25px; TEXT-ALIGN: center
}
.outborder {
	BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-BOTTOM: #999999 1px solid
}
.red {
	FONT-WEIGHT: bold; COLOR: #cc3300
}
.red:link {
	COLOR: #cc3300
}
.red:visited {
	COLOR: #cc3300
}
.red:hover {
	COLOR: #f60
}
.lh15 {
	LINE-HEIGHT: 150%
}
.lh13 {
	LINE-HEIGHT: 130%
}
.lh18 {
	FONT-SIZE: 14px; LINE-HEIGHT: 150%
}
</STYLE>

<META content="MSHTML 6.00.2800.1476" name=GENERATOR></HEAD>
<BODY 
style="BACKGROUND-IMAGE: url(images/myalibaba_topbg.gif); BACKGROUND-REPEAT: repeat-x; BACKGROUND-COLOR: #ffffff" 
leftMargin=0 topMargin=0 marginheight="0" marginwidth="0"><CC:clientCaps 
id=clientCaps></CC:clientCaps>
<TABLE cellSpacing=0 cellPadding=0 width=778 border=0>
  <TBODY>
  <TR>
    <TD  bgcolor=4296ce><A href="../"><IMG height=59 
      src="images/myalibaba_logo.gif" width=189 border=0></A><IMG 
      height=59 src="images/myalibaba_logo_1.gif" width=167 
    border=0></TD>
    <TD vAlign=top align=right bgcolor=4296ce>
      <TABLE cellSpacing=0 cellPadding=0 border=0>
        <TBODY>
        <TR>
          <TD><IMG height=31 src="images/top_nav_1.gif" width=9></TD>
          <TD background=images/top_nav_bg.gif valign=middle>&nbsp;<A 
            class=linkstyle1 href="../">首页</A> | 
            <A class=linkstyle1 
            href="../sj/come1.jsp?baar=buy">我要采购</A> | <A 
            class=linkstyle1 
            href="../sj/come2.jsp?baae=sale">我要销售</A> | <A 
            class=linkstyle1 href=../book>商人话题</A> | <A 
            class=linkstyle1 href="#" title="建设中">商人办公</A> | <A 
            class=linkstyle1 href="../union">网站登录</A> | <A 
            class=linkstyle1 
            href="quit.jsp" ><img src=images/off.gif border=0 width=18 height=18 alt="退出"></A>&nbsp;</TD>
          <TD><IMG height=31 src="images/top_nav_2.gif" 
        width=9></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>

<TABLE cellSpacing=0 cellPadding=0 width=778 border=0>
<TBODY>
<TR>
<TD vAlign=top align=middle width=150  background=images/leftmanu_bg.gif>
<%@ include file="left.jsp"%>
</TD>


<TD style="BACKGROUND-POSITION: right 50%; BACKGROUND-IMAGE: url(images/bg1.gif); BACKGROUND-REPEAT: repeat-y; BACKGROUND-COLOR: #ffffff"  vAlign=top align=middle width=628>


      <TABLE cellSpacing=0 cellPadding=0 width=628 border=0>
        <TBODY>
        <TR>
          <TD class=s vAlign=top align=right width=459 
          background=images/leftmanu_top1.gif height=30><FONT 
            color=#ffffff></FONT></TD>
          <TD class=s vAlign=top width=141 
          background=images/top_nav_bg2.gif><FONT 
            color=#ffffff></FONT> </TD>
          <TD width=28><IMG height=30 src="images/top_nav_5.gif" 
            width=28></TD></TR></TBODY></TABLE>
<br><br><br><br>
<TABLE cellSpacing=3 cellPadding=3 width=520 border=0>
        <TBODY>
        <TR>
          <TD align=middle><IMG height=19 src="images/jiangtou.gif" width=27 
            align=absMiddle> <SPAN 
            style="FONT-SIZE: 16px; COLOR: #f96f09">企富助手欢迎您！您现在还没有登录，登录后即可使用各项功能了</SPAN></TD></TR></TBODY></TABLE><BR>
      <FORM name=form1 action=../denglu.jsp method=post><INPUT type=hidden 
      value=/myalibaba/turbine/template/myalibaba,Myalibaba name=Done> <INPUT 
      type=hidden value=1 name=cc> <INPUT type=hidden value=2 name=step> <INPUT 
      type=hidden name=from_where> <INPUT type=hidden name=asker> 
      <TABLE cellSpacing=0 cellPadding=0 width=444 border=0>
        <TBODY>
        <TR>
          <TD><IMG height=20 src="images/hason.gif" 
      width=444></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=354 border=0>
        <TBODY>
        <TR>
          <TD><IMG height=25 src="images/bg2.gif" width=354></TD></TR>
        <TR>
          <TD background=images/bg4.gif>
            <TABLE cellSpacing=3 cellPadding=3 align=center border=0>
              <TBODY>
              <TR>
                <TD colSpan=3>请输入登录名和密码，按“登录”即可。</TD></TR>
              <TR>
                <TD class=M>会员登录名：</TD>
                <TD><INPUT tabIndex=1 maxLength=20 size=17 name=user></TD>
                <TD></TD></TR>
              <TR>
                <TD class=M>密　　　码：</TD>
                <TD><INPUT tabIndex=2 type=password size=17 name=pass></TD>
                <TD><A 
                  href="forget.jsp">忘了密码？</A></TD></TR>
<INPUT tabIndex=2 type=hidden size=17 name=referer value="<%=request.getParameter("referer")%>">
              <TR>
                <TD>&nbsp;</TD>
                <TD><INPUT tabIndex=3 type=submit value="登   录" name=Submit></TD>
                <TD>&nbsp;</TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD><IMG height=16 src="images/bg3.gif" 
      width=354></TD></TR></TBODY></TABLE><BR><BR>
      <TABLE cellSpacing=0 cellPadding=0 width=444 border=0>
        <TBODY>
        <TR>
          <TD><IMG height=20 src="images/hasnot.gif" 
      width=444></TD></TR></TBODY></TABLE><BR>
      <TABLE cellSpacing=3 cellPadding=3 align=center border=0>
        <TBODY>
        <TR>
          <TD><A 
            href="../reg/register.jsp"><IMG 
            height=37 src="images/zhuce.gif" width=107 border=0></A></TD>
          <TD><IMG height=17 src="images/kaishi.gif" 
      width=127></TD></TR></TBODY></TABLE></FORM><BR><BR><BR>

     


</TR></TBODY></TABLE><IMG 
height=10 src="images/bottom.gif" width=778><BR>

<%@ include file="end.jsp"%>
</BODY></HTML>
