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
<title>리뷰 상세 보기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h3>리뷰 상세보기</h3>
		<br><hr><br>
		<fmt:setLocale value="ko_kr" />
		<table class="table">
			<tbody>
				<tr>
					<th>글번호</th>
					<td>	${rev.r_num }</td>
				</tr>
				<tr>
					<th>카테고리 번호</th>
					<td>	${rev.cate }</td>
				</tr>
				<tr>
					<th>장소코드</th>
					<td>	${rev.pcode }</td>
				</tr>
				<tr>
					<th>작성자 아이디</th>
					<td>	${rev.id }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>	${rev.review }</td>
				</tr>				
				<tr>
					<th>작성일</th>
					<td>						
						<fmt:parseDate value="${rev.regdate }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />				
					</td>							
				</tr>			
				<c:if test="${!empty rev.pic }">
				<tr>
					<th>후기 사진</th>
					<td>						
						<c:set var="lh" value="${fn:length(rev.pic) }" />
						<c:set var="download" value="${fn:substring(rev.pic,5,lh) }" />
						<img src ="${path1 }/${filepath1 }/${pic }" >
					</td>
				</tr>
				</c:if>					
			</tbody>
		</table>		
		<div class="btn-group">
			<a href="${path1 }/ReviewList.do" class="btn btn-primary">리뷰 목록</a>
			<a href="${path1 }/AddReview.do" class="btn btn-primary">리뷰 등록</a>
			<%-- 로그인한 사람의 이름이나 작성자이거나 관리자와 같은 경우 편집 및 삭제 가능 --%>
			<a href="${path1 }/UpdateReview.do?r_num=${rev.r_num }" class="btn btn-primary">글 변경</a>
			<a href="${path1 }/DelReview.do?r_num=${rev.r_num }" class="btn btn-primary">글 삭제</a>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>