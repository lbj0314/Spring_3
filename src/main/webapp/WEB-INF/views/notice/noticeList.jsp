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

					<li><span id="${pager.startNum-1 }" class="list">이전</span></li>
				</c:if>
				<c:forEach begin="${ pager.startNum }" end="${ pager.lastNum }" var="i">
					<li><span id="${i}" class="list">${i}</span></li>
				</c:forEach>
				<c:if test="${ pager.curBlock lt pager.totalBlock }">
				<li><span id="${pager.lastNum + 1 }" class="list">다음</span></li>
				</c:if>
			</ul>
		</div>
		<!-- search -->
		<div>
			<form id="frm" action="./noticeList" method="get">
			<input type="hidden" id="curPage" value="1" name="curPage">
			<select name="kind">
				<option id="kt" value="kt">title</option>
				<option id="kc" value="kc">contents</option>
				<option id="kw" value="kw">writer</option>
			</select>
			<input type="text" id="search" name="search" value="${pager.search }">
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
			location.href = "noticeWrite";
		});	
		var kind = '${pager.kind}';
		if(kind == ''){
			kind = "kt";
		}
		$("#"+kind).prop("selected", true);
		$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
			
		var search = '${pager.search}';
		if ("#"+search == null) {
			alert("Data Not Found");
		}	
		
		});
	</script>
</body>
</html>