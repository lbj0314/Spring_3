<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Qna</title>\
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	<h1>Qna Select Page</h1>
	<div class="container">
	<table class="table">
			
			<tr>
			<th>NUM</th>
			<th width="60%">TITLE</th>
			<th>WRITER</th>
			<th>DATE</th>
			<th>HIT</th>
			</tr>
		
			<tr>
					<td>${ vo.num } </td>
					<td>${ vo.title }</td>
					<td>${ vo.writer}</td>
					<td>${ vo.reg_date }</td>
					<td>${ vo.hit } </td>
				</tr>
			
	</table>
	<div>
		<textarea rows="30" cols="154" readonly="readonly">${ vo.contents } </textarea>
	</div>
		<div>
<%-- 	<%if(memberDTO !=null && memberDTO.getId().equals(noticeDTO.getWriter()) ){ %> --%>
			<a href="./qnaUpdate?num=${vo.num }" class="btn btn-success">Update</a>
			<a href="./qnaDelete?num=${vo.num }" class="btn btn-danger">Delete</a>
			<a href="./qnaReply?num=${vo.num }" class="btn btn-info">Ref</a>
		<%-- <% }%>  --%>
			<a href="./qnaList" class="btn btn-primary">List</a>
		</div>
	</div>
</body>
</html>