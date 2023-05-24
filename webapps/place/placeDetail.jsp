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
<title>장소 상세 보기</title>
<style>
.container-fluid { width:1280px; }
th { width: 200px;}
td > img { width: 500px; height: 500px;}
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h3>장소 > ${cateMap.cname}> <a href="${path1 }/placeList.do?cate=${place.cate}">${catemap.cname }</a> > ${place.pname }</h3>
		<br><hr><br>
		<fmt:setLocale value="ko_kr" />
		<table class="table">
			<tbody>
				<tr>
					<td colspan="2">
						<img src='${path1 }/place${place.pic }' alt="${place.pname }"/>
					</td>
				</tr>
				<tr>
					<th>장소명(장소코드)</th>
					<td>${place.pname }(${place.pcode })</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${place.addr }</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${place.phone }</td>
				</tr>
				<tr>
					<th>장소 설명</th>
					<td>${place.comm }</td>
				</tr>				
				<tr>
					<td colspan="2">
						<div class="buttons">
							<c:if test="${!sid.equals('admin')}">
								<c:if test="${!empty sid}">
									<a class="button is-info" href="${path1 }/UpdatePlace.do?pcode=${place.pcode }" >리뷰 쓰기</a>
								</c:if>
								<a href="${path1 }/PlaceList.do?cate=${place.cate}" class="btn btn-primary" role="button">목록</a>
							</c:if>
							<c:if test="${sid.equals('admin') }">
								<a class="button is-info" href="${path1 }/UpdatePlace.do?pcode=${place.pcode }" >장소 수정</a>
								<a class="button is-info" href="${path1 }/DeletePlace.do?pcode=${place.pcode }" >장소 삭제</a>
								<a class="button is-info" href="${path1 }/PlaceList.do?cate=${place.cate}" >목록</a>
							</c:if>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<table class="table">
			<tbody>
				<c:forEach var="rev" items="${rList }">
				<tr>
					<td>작성자 : ${rev.id }</td>
					<td>내용 : ${rev.review }</td>
					<td>만족도 : ${rev.rating }</td>
					<td>
						<c:if test="${rev.id==sid }">
						<div class="buttons">
							<a class="button is-info" href="${path1 }/UpdateReview.do?w_num=${rev.w_num }" >이용후기 수정</a>
						</div>
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${sid.equals('admin') }">
		<div class="buttons">
			<a class="button is-info" href="${path1 }/InsertPlace.do" >장소 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>