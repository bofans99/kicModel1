<%@page import="model.Board"%>
<%@page import="java.util.List"%>
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

int pageInt = 1;
int limit = 3;

try{
	pageInt = Integer.parseInt(request.getParameter("pageNum"));
}catch(Exception e){
	pageInt=1;
}

String boardid ="1";
BoardDao bd= new BoardDao();
int boardcount = bd.boardCount(boardid);




List<Board> list = bd.boardList(pageInt, limit, boardcount, boardid);

int boardnum = boardcount - (pageInt-1) *limit;

int bottomLine = 3;
int startPage = (pageInt -1)/bottomLine*bottomLine +1;
int endPage = startPage + bottomLine -1;
int maxPage = (boardcount/limit) + (boardcount % limit ==0? 0:1);
if (endPage>maxPage) endPage=maxPage;


%>





<hr>
	<!-- table list start -->
	<div class="container">
		<h2  id="center">게시판 리스트<%=pageInt %></h2>
		<p align="right">
		<% if (boardcount > 0){ %> 글개수 <%=boardcount%> <% } else { %> 
		등록된 게시물이 없습니다. 
		<% }%>
		</p>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>파일</th>
					<th>조회수</th>

				</tr>
			</thead>
			<tbody>
			<%
			for(Board b : list){
			%>
				<tr>
					<td><%=(boardnum--)%></td>
					<td><a href="boardInfo.jsp?num<%=b.getNum()%> "><%=b.getSubject() %></a></td>
					<td><%=b.getWriter() %></td>
					<td><%=b.getRegdate() %></td>
					<td><%=b.getFile1() %></td>
					<td><%=b.getReadcnt() %></td>
				</tr>
			<% }%>
			</tbody>
		</table>
		<p align="right"><a href="<%=request.getContextPath()%>/view/board/writeForm.jsp">글 입력</a></p>
		<div class="container"  >
		<ul class="pagination justify-content-center"  >
		
  <li class="page-item <% if(startPage <= bottomLine){ %> disabled <% }%> "><a class="page-link" href="list.jsp?pageNum=<%=startPage-bottomLine%>">Previous</a></li>
   
  <% for (int i=startPage; i<=endPage;i++){ %>
  <li class="page-item <% if(i==pageInt){ %> active<% }%>"><a class="page-link" href="list.jsp?pageNum=<%=i%>"> <%=i%></a></li>
  <%}%>
  
  <li class="page-item <% if(endPage >= maxPage){ %> disabled <% }%>"> <a class="page-link" href="list.jsp?pageNum=<%=startPage+bottomLine%>">Next</a></li>
 
</ul> </div>
	</div>
</body>
</html>