<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div id="menu">
		<ul>
		    <li id="logo">fastcampus</li>
		    <li><a href="<c:url value='/'/>">Home</a></li>
		    <li><a href="<c:url value='/board/list'/>">Board</a></li>
		    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>    
		    <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
		    <li><a href=""><i class="fas fa-search small"></i></a></li>
		</ul> 
	</div>
	<script>
		// let msg = "${param.msg}"; controller에서 model에 담을때
		let msg = "${msg}";
		if(msg=="WRT_ERR") alert("등록에 실패했습니다.");
	</script>
	<div style="text-align:center">
	<h2>게시물 ${mode == "new" ? "쓰기" : "읽기"}</h2>
		<form action="" id="form">
			<input type="hidden" name="bno" value="${boardDto.bno}" >
			<input type="text" name="title" value="${boardDto.title}" ${mode == "new" ? "" : "readonly='readonly'" }>
			<textarea name="content" id="" cols="30" rows="10" ${mode == "new" ? "" : "readonly='readonly'" }>${boardDto.content}</textarea>
			<button type="button" id="writeBtn" class="btn">글쓰기</button>
			<button type="button" id="modifyBtn" class="btn">수정</button>
			<button type="button" id="removeBtn" class="btn">삭제</button>
			<button type="button" id="listBtn" class="btn">목록</button>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$('#listBtn').on("click", function() {
				location.href= "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";
			});
			
			
			$('#modifyBtn').on("click", function() {
				let form = $('#form');
				let isReadOnly = $("input[name=title]").attr("readonly");
				
				if(isReadOnly=='readonly') {
					$("input[name=title]").attr("readonly", false);
					$("textarea").attr("readonly", false);
					$("modifyBtn").html("등록");
					$("h2").html("게시물 수정");
					return;
				}
				
				form.attr("action", "<c:url value='/board/modify'/>?page=${page}&pageSize=${pageSize}");
				form.attr("method", "post");
				form.submit();
			});
			
			$('#writeBtn').on("click", function() {
				let form = $('#form');
				form.attr("action", "<c:url value='/board/write'/>");
				form.attr("method", "post");
				form.submit();
			});
			
			$('#removeBtn').on("click", function() {
				if(!confirm("정말로 삭제하시겠습니까?")) return;
				let form = $('#form');
				form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
				form.attr("method", "post");
				form.submit();
			});
		});
	</script>
</body>
</html>