<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />      

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>JSON 객체 테스트1</title>		<%-- json= $( ) //// EL= ${ }	//// 배열 $[ ] --%>
</head>
<style>
</style>
<body>
	<h2>JSON 객체 테스트1</h2>
	<div id="msg">
		<ul id="lst">
		
		</ul>
	</div>		<!-- 서블릿을 통해 실행시<JSONTest1.do> 에서 "자바 웹앱 텍스트 데이터"에 해당하는걸 불러옴 -->
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
	$(document) .ready (function(){
		var obj = {id:"kkt", point:99, resdate:"2023-02-04"};
		$("#lst").append("<li>아이디 : "+obj.id+"</li>");
		$("#lst").append("<li>포인트 : "+obj.point+"</li>");
		$("#lst").append("<li>가입일 : "+obj.resdate+"</li>");			
	});
	</script>
	<script>		/* 그냥 직접 실행시 <JSONTest1.do> 에서 "자바앱 텍스트 데이터"에 해당하는걸 불러옴 */
	$(document).ready(function(){
		$("#reqBtn").click(function () {
			$.ajax({
				url:"${path1 }/JSONTest1.do",
				type:"post",
				dataType:"json",
				success:function(result){
					//consol.log(result.result);
					$("#lst").append("<li>메세지 : "+result.result+"</li>");
				}
			});
		});
	});
	</script>

</body>
</html>