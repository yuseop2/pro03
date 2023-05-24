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
<title>상품 등록하기</title>
<style>
.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content" style="padding-top:30px; margin-top:30px; border-top:3px solid #333; min-height:500px; ">
	<div class="container-fluid">
		<h2>장소 등록 하기</h2>
		<p>${msg }</p>
		<form action="${path1 }/InsertPlacePro.do" method="post" enctype="multipart/form-data">
			<table class="table">
				<tbody>
					<tr>
						<th>
							<label for="cate1">장소 분류</label><br>
							<span id="pcodetxt"></span>
						</th>
						<td>
							대분류 : 
							<select id="cate1" name="cate1" class="form-control">
								<option value="">선택안함</option>
								<c:forEach items="${cateList }" var="cate1">
								<option value="${cate1.ct }">${cate1.gname }</option>
								</c:forEach>
							</select>
							소분류 : 
							<select id="cate" name="cate" class="form-control">
								<option value="">선택안함</option>
							</select><br>
							<input type="hidden" id="pcode" name="pcode" value="">
							<input type="hidden" id="pcodeck" name="pcodeck" value="no">
							<input type="button" value="카테고리 번호 발급" class="btn btn-primary" onclick="PcodeGenerator()">
						</td>
					</tr>
					<tr>
						<th><label for="pname">장소명 (예: 장소명 - 카테고리명)</label></th>
						<td>
							<input type="text" name="pname" id="pname" maxlength="100" title="규칙에 맞게 작성" placeholder="규칙에 맞게 작성" >
						</td>
					</tr>
					<tr>
						<th><label for="addr">주소 </label></th>
						<td>
							<input type="text" name="weight" id="weight" maxlength="100" title="100글자이내" placeholder="100글자이내" >
						</td>
					</tr>
					<tr>
						<th><label for="phone">전화번호 </label></th>
						<td>
							<input type="number" name="phone" id="phone" maxlength="13" >
						</td>
					</tr>
					<tr>
						<th><label for="comm">장소 설명 </label></th>
						<td>
							<textarea rows="5" cols="100" name="comm" id="comm" maxlength="300" title="300자 내로 작성" ></textarea>
						</td>
					</tr>							
					<tr>
						<th><label for="pic">사진 첨부</label></th>
						<td>
							<input type="file" name="pic" id="pic" class="">
						</td>
					</tr>								
					<tr>
						<td colspan="2">
							<input type="submit" value="장소 등록하기" class="btn btn-primary">
							<a href="${path1 }/PlaceList.do" class="btn btn-primary">장소 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<script>
		$(document).ready(function(){
			$("#content").click(function(){
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
			$("#cate1").change(function(){
				if($("#cate1").val()==""){
					alert("대분류 카테고리를 선택하시기 바랍니다.");
					$("#cate1").focus();
					return;
				}
				var params = { cate1:$("#cate1").val() }
				$.ajax({
					url:"${path1 }/CategoryLoading.do",
					type:"post",
					dataType:"json",
					encType:'UTF-8',
					data:params,
					success:function(result){
						console.log(result);
						var ctList = result.ctList;
						var msg = result.msg;
						$("#cate").empty();
						$("#cate").append("<option value=''>선택안함</option>");
						for(var c in ctList){
							$("#cate").append("<option value='"+ctList[c]["cate"]+"'>"+ctList[c]["catename"]+"</option>");
						}
					}
				});				
			});			
		});
		function PodeGenerator(){
			if($("#cate1").val()=="" || $("#cate").val()==""){
				alert("대분류/소분류 카테고리를 선택하시기 바랍니다.");
				$("#cate1").focus();
				return;
			}
			var params = { cate:$("#cate").val() }
			$.ajax({
				url:"${path1 }/PcodeGenerator.do",
				type:"post",
				dataType:"json",
				data:params,
				encType:"UTF-8",
				success:function(result){
					console.log(result);
					var msg = result.msg;
					var placeCode = result.pcode;
					$("#pcodeck").val("yes");
					$("#pcode").val(placeCode);
					$("#pcodetxt").html("("+placeCode+")");
					$("#msg").html("<strong>상품 코드가 발급되었습니다.</strong>");
					$("#pname").focus();
				}
			});
		}
		function productCheck(f){
			if(f.pcodeck.value!="yes"){
				alert("상품코드를 생성하지 않으셨습니다.");
				return false;
			}
		}
	</script>		
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>