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
<title>구매후기 작성</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>구매후기</h2>
		<p>${msg }</p>
		<form action="${path1 }/UpdateReviewPro.do" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th><label for="title">만족도</label></th>
						<td>
							<input type="hidden" name="w_num" id="w_num" value="${rev.w_num }">	
							<input type="hidden" name="id" id="id" value="${rev.id }">
							<input type="hidden" name="o_code" id="o_code" value="${rev.o_code }">
							<p>현재 만족도 : ${rev.rpoint }</p>
							<input type="hidden" name="rating" id="rating" value="${rev.rating }">
							<input type="radio" name="new_rating" id="rating5" value="5" checked><label for="rating5">매우 만족</label> &nbsp; &nbsp;
							<input type="radio" name="new_rating" id="rating4" value="4"><label for="rating4">만족</label> &nbsp; &nbsp;
							<input type="radio" name="new_rating" id="rating3" value="3"><label for="rating3">보통</label> &nbsp; &nbsp;
							<input type="radio" name="new_rating" id="rating2" value="2"><label for="rating2">불만족</label> &nbsp; &nbsp;
							<input type="radio" name="new_rating" id="rating1" value="1"><label for="rating1">매우 불만족</label> &nbsp; &nbsp;
						</td>
					</tr>
					<tr>
						<th><label for="content">이용후기 내용</label></th>
						<td>
							<textarea rows="10" cols="100" name="review" id="review" maxlength="990" title="1000자 내로 작성" class="form-control">${rev.review }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="이용후기 수정하기" class="btn btn-primary">
							<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로 가기</a>				
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