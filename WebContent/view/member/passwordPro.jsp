<%@page import="model.Member"%>
<%@page import="service.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = "";
String url = "";
String login = (String) session.getAttribute("memberId");
if (login == null || login.trim().equals("")){
%>
<script>
alert("로그인이 필요 합니다.");
location.href="<%=request.getContextPath()%>/view/member/loginForm.jsp";
</script>
<% }else {
	
	MemberDao md = new MemberDao();
	//id 없으면 mem:null, 있으면 mem return
	Member mem = md.selectOne(login);
	String pass = request.getParameter("pass");
	String newpass = request.getParameter("newpass");
	
	if(pass.equals(mem.getPass())){
		if(md.changePass(login, newpass) > 0)  { 
			msg="비밀번호가 수정되었습니다.";
			url= "main.jsp";
		}else{
			msg="비밀번호 변경 오류.";
			url= "main.jsp";
		}
	}else{
		msg="비밀번호가 틀렸습니다.";
		url= "member/passwordForm.jsp";
	}
}%>
<script>
alert("<%=msg%>");
location.href="<%=request.getContextPath()%>/view/<%=url%>";
</script>

</body>
</html>