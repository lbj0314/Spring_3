<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Notice List Page</h1>
	<div class="container">
		<table class="table ">

			<tr>
				<th>NUM</th>
				<th width="60%">TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${ vo.num }</td>
					<td><a href="noticeSelect?num=${ vo.num }">${ vo.title }</a></td>
					<td>${ vo.writer }</td>
					<td>${ vo.reg_date }</td>
					<td>${ vo.hit }</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<ul class="pagination">
				<c:if test="${ pager.curBlock gt 1 }">
					<li><a href="./noticeList?curPage=${pager.startNum-1 }">이전</a></li>
				</c:if>
				<c:forEach begin="${ pager.startNum }" end="${ pager.lastNum }"
					var="i">
					<li><a href="./noticeList?curPage=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${ pager.curBlock lt pager.totalBlock }">
				<li><a href="./noticeList?curPage=${pager.lastNum + 1 }">다음</a></li>
				</c:if>
			</ul>
		</div>
		<!-- session member, memberDTO -->
		<c:if test="${ empty member  }">
			<button type="button" class="btn btn-info" id="btn_write">WRITE</button>
		</c:if>
	</div>
	<script type="text/javascript">
		$("#btn_write").click(function() {
			location.href = "noticeWrite";
		});
	</script>
</body>
</html>