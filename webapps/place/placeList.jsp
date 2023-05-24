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
<title>장소 목록</title>
<style>
.container-fluid { width:1280px; }
.thumbnail { height:500px; }
.comment { width:auto; height:60px; overflow: hidden;  text-overflow: ellipsis; 
 display: -webkit-box;  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical; }
.thumb_box { width:200px; hegiht:200px; margin:24px auto; margin-bottom:10px; height:auto; overflow:hidden;
padding-top:5px; padding-bottom:5px; 
border:1px solid #e0e0f0; text-align:center; }
.thumb_box::after { content:""; display:block; clear:both; }
.thumb_box img { width:auto; height:193px;  }  
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>장소 > 
		<c:if test="${empty cateMap.group }">
		전체
		</c:if>
		<c:if test="${!empty cateMap.group }">
		${cateMap.group } > ${cateMap.cname }
		</c:if>
		</h2>
		<hr>
		<c:if test="${sid.equals('admin') }">
			<div class="buttons">
				<a class="button is-info" href="${path1 }/CatePlaceList.do?cate=01" >명소주제별 </a>
				<a class="button is-info" href="${path1 }/CatePlaceList.do?cate=02" >전시회장소별 </a>
				<a class="button is-info" href="${path1 }/CatePlaceList.do?cate=03" >업체주제별 </a>
				<a class="button is-info" href="${path1 }/CatePlaceList.do?cate=04" >체험주제별 </a>						
			</div>
		<hr>
		</c:if>		
		<fmt:setLocale value="ko_kr" />
		<article class="row">
			<c:forEach var="place" items="${placeList }" varStatus="status">
			<div class="col-sm-6 col-md-4 col-lg-3">
				<div class="thumbnail">
					<div class="thumb_box">
						<a href="${path1 }/PlaceDetail.do?pcode=${place.pcode}" title="장소 상세 보기">
							<img src="${path1 }/place${place.pic }" alt="${place.pname }"/>
						</a>
					</div>
					<div class="caption">								
						<h4><strong>${place.pname }</strong></h4>
							<p><strong>주소</strong> : ${place.addr }</p>
							<p><strong>전화번호</strong> : ${place.phone }</p>
							<p class="comment"><strong>장소 설명</strong> :<br>${place.comm }</p>
						<div class="buttons">							
							<c:if test="${sid.equals('admin') }">								
								<a class="button is-info" href="${path1 }/UpdatePlace.do?pcode=${place.pcode }" >장소 수정</a>
								<a class="button is-info" href="${path1 }/DeletePlace.do?pcode=${place.pcode }" >장소 삭제</a>
							</c:if>
						</div>		
					</div>
				</div>
			</div>
			</c:forEach>
		</article>
		<c:if test="${empty placeList }">
		<div class="container">
			<h3>해당 장소 존재하지 않습니다.</h3>
		</div>
		</c:if>	
		<c:if test="${sid.equals('admin') }">
		<div class="btn-group">
			<a class="button is-info" href="${path1 }/InsertPlace.do?pcode=${place.pcode }">장소 등록</a>
		</div>
		</c:if>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>