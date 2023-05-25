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
<title>장소 정보 수정 하기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>장소 정보 수정</h2>
		<p>${msg }</p>
		<form action="${path1 }/UpdatePlacePro.do" method="POST" enctype="multipart/form-data">
			<table class="table">
				<tbody>
					<tr>
						<th>
							장소 분류(장소분류코드)
						</th>
						<td>
							<span id="pcodetxt">${cateMap.catename } (${place.cate })</span>
							<input type="hidden" name="cate1" id="cate1"  value="${place.cate }">
						</td>						
					</tr>
					<tr>
						<th><label for="pname">장소명</label></th>
						<td>
							<input type="text" name="pname" id="pname" value="${place.pname }" title="40자 내로 작성" placeholder="40자 내로 작성" class="form-control" required>
							<input type="hidden" name="pcode" id="pcode" value="${place.pcode }">
						</td>
					</tr>
					<tr>
						<th><label for="addr">주소</label></th>
						<td>
							<input type="text" name="addr" id="addr" value="${place.addr }" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control">
						</td>
					</tr>
					<tr>
						<th><label for="phone">전화번호</label></th>
						<td>
							<input type="text" name="phone" id="phone" value="${place.phone }" min="0" max="5000000" step="100" title="0~5000000" class="form-control">
						</td>
					</tr>
					<tr>
						<th><label for="lat">위도</label></th>
						<td>
							<input type="text" name="lat" id="lat" value="${place.lat }"  step="100" title="0~5000000" class="form-control">
						</td>
					</tr>
					<tr>
						<th><label for="lng">경도</label></th>
						<td>
							<input type="text" name="lng" id="lng" value="${place.lng }"  step="100" title="0~5000000" class="form-control">
						</td>
					</tr>									
					<tr>
						<th><label for="comm">장소 설명</label></th>
						<td>
							<textarea rows="5" cols="100" name="comm" id="comm" maxlength="300" title="300자 내로 작성" class="form-control">${place.comm }</textarea>
						</td>
					</tr>						
					<tr>
						<th><label for="pic">상품 이미지 변경</label></th>
						<td>
							<label for="pic">이미지 </label>
							<p id="picAttac"><img src='${path1 }/place/${place.pic }' alt="${place.pname }"/></p>							
							<input type="file" accept="image/*" name="pic" id="pic" ><br>
							<input type="hidden" name="ori_pic" id="ori_pic" value="${place.pic }">
							<br>							
						</td>
					</tr>					
					<tr>
						<td colspan="2">
							<input type="submit" value="상품 정보 수정" class="btn btn-danger">
							<a href="${path1 }/AdminPlaceList.do" class="btn btn-primary">장소 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		$(document).ready(function(){
			$("#comm").click(function(){
				if($(this).text()=="500자 이내"){
					$(this).text("");
				}
			});
			$(".file").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
				}
			});
		});
	</script>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>