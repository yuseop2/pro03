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
<title>이용후기 작성</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>이용후기</h2>
		<p>${msg }</p>
		<form action="${path1 }/AddReviewPro.do" method="post" enctype="multipart/form-data">
			<table class="table">			
				<tbody>
					<tr>
						<th>
							장소명
						</th>
						<td>
							<span id="pname">${place.pname }</span>													
							<input type="hidden" name="id" id="id" value="${sid }">													
						</td>						
					</tr>					
					<tr>
						<th><label for="review">글 내용</label></th>
						<td>
							<textarea rows="10" cols="100" name="review" id="review" maxlength="990" title="1000자 내로 작성" class="form-control"></textarea>
						</td>
					</tr>
					<tr>
						<th><label for="pic">후기 사진</label></th>
						<td>
							<input type="file" name="pic" id="pic" class="button is-info">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="글쓰기" class="button is-info">
							<a class="button is-info" href="${path1 }/GetReview.do" >리뷰 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>		
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>