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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=37c7fab50b87f8b86ce1b5998b61cb27&libraries=services,clusterer,drawing"></script>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h3>장소 > ${cateMap.gname} ><a href="${path1 }/PlaceList.do?cate=${cateMap.cate}"> ${cateMap.cname } ></a> ${place.pname }</h3>
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
					<th>지도</th>
					<td>
						<div id="map" style="width:500px;height:400px;"></div>
						<input type="hidden" id="addrlat" value="${place.lat}">
						<input type="hidden" id="addrlng" value="${place.lng}">
						<script>
						var lat = addrlat.val();
						var lng = addrlng.val();
								alert(lat);
								alert(lng);
						var container = document.getElementById('map');	//지도를 표시할 div
						var options = {									
							/* center: new kakao.maps.LatLng(33.450701, 126.570667),	//지도의 중심좌표  */
							 center: new kakao.maps.LatLng(lat ,lng ),	//지도의 중심좌표
							 level: 3	//지도의 확대 레벨	
						};
						var map = new kakao.maps.Map(container, options);						 	
						var marker = new kakao.maps.Marker({ // 마커를 생성합니다
						    map: map,
						    position: new kakao.maps.LatLng(33.450701, 126.570667) // 마커가 표시될 위치입니다 
						});	 						   	 
						marker.setMap(map);		// 마커가 지도 위에 표시되도록 설정합니다
						var infowindow = new kakao.maps.InfoWindow({	// 인포윈도우를 생성합니다
						    map: map,
						    position: new kakao.maps.LatLng(33.450701, 126.570667),//인포윈도우 표시 위치입니다
						    content: 'I am InfoWindow'
						});
						infowindow.open(map, marker);	//마커 위에 인포윈도우를표시합니다.두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
						</script>
						<script type="text/javascript" src="http://m1.daumcdn.net/tiara/js/td.min.js"></script>
						<script type="text/javascript">
						var _tiq = 'undefined' !== typeof _tiq ? _tiq : [];
						    window._tiq = _tiq;
						    _tiq.push(['__trackPageview']);
						</script>
						<script type="text/javascript" src="http://s1.daumcdn.net/svc/attach/U03/cssjs/mapapidoc/1421136453605/service.min.js">
						</script>							
					</td>
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