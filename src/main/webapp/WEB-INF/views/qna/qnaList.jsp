<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qnaList</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Qna List Page</h1>
	<div class="container">
		<table class="table ">
			<tr>
				<th>NUM</th>
				<th width="60%">TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
				<th>REF</th>
				<th>STEP</th>
				<th>DEPTH</th>
			</tr>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${ vo.num }</td>
					<td><a href="./qnaSelect?num=${ vo.num }">${ vo.title }</a></td>
					<td>${ vo.writer }</td>
					<td>${ vo.reg_date }</td>
					<td>${ vo.hit }</td>
					<td>${ vo.ref }</td>
					<td>${ vo.step }</td>
					<td>${ vo.depth }</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<ul class="pagination">
				<c:if test="${ pager.curBlock gt 1 }">
					<li><span id="${pager.startNum-1 }" class="list">이전</span></li>
				</c:if>
				<c:forEach begin="${ pager.startNum }" end="${ pager.lastNum }"
					var="i">
					<li><a href="./qnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<c:if test="${ pager.curBlock lt pager.totalBlock }">
					<li><span id="${pager.lastNum + 1 }">다음</span></li>
				</c:if>
			</ul>
		</div>
		<!-- Search -->
		<div>
			<form action="./qnaList" method="get">
			<input type="hidden" value="1" name="curPage">
				<select name="kind">
					<option id="kt" value="kt">Title</option>
					<option id="kc" value="kc">Contents</option>
					<option id="kw" value="kw">Writer</option>
				</select> 
				<input type="text" name="search" value="${ pager.search }">
				<button class="btn btn-info">SEARCH</button>
			</form>
		</div>
		<!-- session member, memberDTO -->
		<c:if test="${ empty member  }">
			<button type="button" class="btn btn-info" id="btn_write">WRITE</button>
		</c:if>
	</div>
	<script type="text/javascript">
		$("#btn_write").click(function() {
			location.href = "qnaWrite";
		});
		$("#${pager.kind}").prop("selected", true);
	</script>
</body>
</html>