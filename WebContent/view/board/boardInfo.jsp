<%@page import="model.Board"%>
<%@page import="service.BoardDao"%>
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
int num = Integer.parseInt(request.getParameter("num"));
BoardDao bd= new BoardDao();
Board b = bd.boardOne(num);  
bd.readCountUp(num); 
%>

<hr>
	<div class="container">

		<h2 id="center">게시판 상세보기</h2>
			<table class = "table talbe-hover">
				<tr><th>작성자 : </th><td><%=b.getWriter()%></td></tr>
				<tr><th>제목 : </th><td><%=b.getSubject()%></td></tr>
				<tr height="250px"><td>내용 : </td><td><%=b.getContent()%></td></tr>
				<tr><th>파일 : </th><td><img src="<%=request.getContextPath()  %>/boardupload/<%=b.getFile1() %>" width="50%"></td></tr>
			</table>
	
			<div id="center" style="padding:3px;">
				<button class="btn btn-dark" onclick="location.href='boardReplyForm.jsp?num=<%=b.getNum()%>'">답변</button>
				<button class="btn btn-dark" onclick="location.href='boardUpdateForm.jsp?num=<%=b.getNum()%>'">수정</button>
				<button class="btn btn-dark" onclick="location.href='boardDeleteForm.jsp?num=<%=b.getNum()%>'">삭제</button>
				<button class="btn btn-dark" onclick="location.href='list.jsp'">목록</button>
			</div>

	</div>	
</body>
</html>