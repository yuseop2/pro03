<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSONTest4 Test</title>
<link href="${path1 }/source/bulma.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.js"></script>
<style>
#sidebar { width:200px; float:left; }
#dataform { width:900px; float:right; }
</style>
</head>
<body>
<header class="header" style="padding:24px; width:100%; text-align:center;">
	<h1 class="title">헤더</h1>
</header>
<div class="container">
	<aside class="menu" id="sidebar">
	  <p class="menu-label">
	    General
	  </p>
	  <ul class="menu-list">
	    <li><a>Dashboard</a></li>
	    <li><a>Customers</a></li>
	  </ul>
	  <p class="menu-label">
	    Administration
	  </p>
	  <ul class="menu-list">
	    <li><a>Team Settings</a></li>
	    <li>
	      <a class="is-active">Manage Your Team</a>
	      <ul>
	        <li><a>Members</a></li>
	        <li><a>Plugins</a></li>
	        <li><a>Add a member</a></li>
	      </ul>
	    </li>
	    <li><a>Invitations</a></li>
	    <li><a>Cloud Storage Environment Settings</a></li>
	    <li><a>Authentication</a></li>
	  </ul>
	  <p class="menu-label">
	    Transactions
	  </p>
	  <ul class="menu-list">
	    <li><a>Payments</a></li>
	    <li><a>Transfers</a></li>
	    <li><a>Balance</a></li>
	  </ul>
	</aside>
	<div id="dataform">
		<h2>JSON 형태로 검색하여 일반 객체 불러오기</h2>
		<br><hr><br>
		<input type="text" class="input" id="item1" name="item1" placeholder="검색할 아이디 입력"/>
		<div id="msg">
			<ul id="lst">
				
			</ul>
		</div>
		<br><hr>
		<button class="button is-danger" type="button" id="reqBtn">데이터 가져오기</button>
		<br><hr>
		<script>
		$(document).ready(function(){
			$("#reqBtn").click(function(){
				//var item1 = $("#item1").val();
				if($("#item1").val()==""){
					alert("검색할 아이디를 입력하세요");
					$("#item1").focus();
					return;
				}
				var params = { item1:$("#item1").val() };
				$.ajax({
					url:"${path1 }/JSONTest2.do",
					type:"post",
					enctype:"UTF-8",
					dataType:"json",
					data:params,
					success:function(obj){
						$("#lst").empty();
						var sam = obj;
						if(typeof sam.name!="undefined"){
							$("#lst").append("<li>아이디 : "+sam.name+"</li>");
							$("#lst").append("<li>포인트 : "+sam.point+"</li>");
							$("#lst").append("<li>가입일 : "+sam.resdate+"</li>");
						} else {
							$("#lst").append("<li>해당 데이터가 존재하지 않습니다.</li>");
						}
					}
				});
			});
		});
		</script>
	</div>
</div>
</body>
</html>