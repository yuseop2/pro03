<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<%@ page import="kr.go.yeosu.test.*" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONTest3 Test</title>
<link href="${path1 }/source/bulma.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>

</style>
</head>
<body>
<div class="container">
	<h2>JSONArray 형태의 ArrayList 객체 출력</h2>
	<br><hr><br>
	<div id="msg">
		<ul id="lst">
			
		</ul>
	</div>
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
	$(document).ready(function(){
		$("#reqBtn").click(function(){
			$.ajax({
				url:"${path1 }/JSONTest3.do",
				type:"post",
				enctype:"UTF-8",
				dataType:"json",
	 			processData:false,
				contentType:false, 
				cache:false,
				success:function(data){
					$("#lst").empty();
					var trans = data;
					console.log(trans.data);
					var tg = "";
					$.each(trans, function(key, value){
						if(key=="data"){
							for(var i=0;i<value.length;i++){
								tg = "";
							console.log(value[i].item1);
								tg = tg + "<div>아이디 : "+value[i].item1+"</div>";
								tg = tg + "<div>포인트 : "+value[i].item2+"</div>";
								tg = tg + "<div>가입일 : "+value[i].item3+"</div>";
								tg = tg + "<hr>"
								$("#lst").append("<li>"+tg+"</li>");
							}
						}
					});
				}
			});
		});
	});
	</script>
</div>
</body>
<footer class="footer">
  <div class="content has-text-centered">
    <p>
      <strong>Bulma</strong> by <a href="https://jgthms.com">Jeremy Thomas</a>. The source code is licensed
      <a href="http://opensource.org/licenses/mit-license.php">MIT</a>. The website content
      is licensed <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">CC BY NC SA 4.0</a>.
    </p>
  </div>
</footer>
</html>