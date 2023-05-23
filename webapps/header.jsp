<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />  
<%
	String sid = "";
	if(session!=null) sid = (String) session.getAttribute("sid");  
%>
<style>
.column {text-align: center;}
</style>
<header>
<div class="columns is-gapless " style="width: 1280px; height=100px;">
  <div class="column">
      <a class=""  href="${path}/ "><img src="img/main_logo_hover3.png"></a>
  </div>
  <div class="column">
  	관광명소
  </div>
  <div class="column">
    문화/축제
  </div>
  <div class="column">
    숙박/음식/쇼핑
  </div>
  <div class="column">
    여행/체험
  </div>
  <div class="column">
    관광안내
  </div>
  <div class="column">
	<a href="${path1 }/QnaList.do">QnA - 묻고 답하기</a>	    
  </div>   
  <div class="column">
	<a href="${path1 }/ReviewList.do">Review - 이용후기</a>
  </div>
  	<c:if test="${!empty sid && sid!='admin'}">			
		<div class="column">
			<a href="${path }/MyPage.do">마이페이지</a>									
			<a href="${path }/UserLogout.do">로그아웃</a>	
		 </div>
	</c:if>
	<c:if test="${empty sid }">
		<div class="column">
			<a href="${path }/UserLogin.do">로그인</a>
			<a href="${path }/UserTerms.do">회원가입</a>
		</div>
	</c:if>	
	<c:if test="${sid=='admin' }">
		<div class="column">	
			<a href="${path }/Admin.do">관리자 페이지</a>
			<a href="${path }/UserLogout.do">로그아웃</a>
		</div>
	</c:if>	  
</div>			   
</header>
