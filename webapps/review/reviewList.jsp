<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<title>리뷰 목록 보기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h3>리뷰(이용후기) 목록</h3>
		<br><hr><br>
		<fmt:setLocale value="ko_kr" />
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th><th>작성자</th><th>리뷰</th><th>작업</th>
				</tr>
			</thead>
			<tbody>	
				<c:forEach var="rev" items="${rList }" >
				<tr>												
					<td>글 번호 : ${rev.r_num }</td>
					<td>작성자  : ${rev.id }</td>
					<td><a href="${path1 }/GetReview.do?r_num=${rev.r_num }" >리뷰 : ${rev.review }</a></td>					
					<td>						
						<a href="${path1 }/DelReview.do?r_num=${rev.r_num }" class="button is-info">삭제</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>