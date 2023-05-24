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
.navbar-item img {max-height:initial;}
.content {width:1280px; margin : 0 auto;}
</style>
<header>

<nav class="navbar" role="navigation" aria-label="main navigation" style="width: 1280px; height: 100px; align-items: center; margin: 0 auto; text-align: center;">
  <div class="navbar-brand">
  	<a class="navbar-item" style= "max-height:100%;" href="${path}/ "><img src="img/main_logo_hover3.png" width="143" height="54"></a>
  </div>    
  <div id="navbarBasic" class="navbar-menu">
    <div class="navbar-start">
      <div class="navbar-item has-dropdown is-hoverable">
      	<a class="navbar-link">
			관광명소
     	</a>
     	<div class="navbar-dropdown">
     		<a class="navbar-item">
          	  여수10경
         	</a>
          	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0101">
          	  섬/해변
         	</a>
        	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0102">
         	  산/사찰
         	</a>
         	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0103">
         	  문화/경승지
         	</a>
         </div>
      </div>
      <div class="navbar-item has-dropdown is-hoverable">
      	<a class="navbar-link">
			문화/축제
	    </a>
	    <div class="navbar-dropdown">
     		<a class="navbar-item" >
          	  	주요축제
         	</a>         	
          	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0201">
          	 	엑스포아트갤러리소식
         	</a>
         	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0202">
          	 	달빛갤러리소식 
         	</a>
         	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0203">
          	 	시민회관소식 
         	</a>       	
         </div>
      </div>
      <div class="navbar-item has-dropdown is-hoverable">
     	 <a class="navbar-link">
			음식점/숙박/쇼핑
     	</a>
     	<div class="navbar-dropdown">
     		<a class="navbar-item">
          		여수10미
         	</a>
     		<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0301">
          		음식점
         	</a>
          	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0302">
          	 	숙박
         	</a>
        	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0303">
         		쇼핑
         	</a>
         </div>
      </div>
      <div class="navbar-item has-dropdown is-hoverable">
    	 <a class="navbar-link">
			여행/체험
      	 </a>
      	 <div class="navbar-dropdown">
     		<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0401">
          		관람
         	</a>
          	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0402">
          		레저
         	</a>
        	<a class="navbar-item" href="${path }/CatePlaceList.do?cate=0403">
          		캠핑
         	</a>
         </div>
      </div>
      <div class="navbar-item has-dropdown is-hoverable">
     	 <a class="navbar-link">
			관광안내
     	 </a>
      	 <div class="navbar-dropdown">
     		<a class="navbar-item">
          		오시는길
         	</a>
          	<a class="navbar-item">
          		관광안내전화
         	</a>
        	<a class="navbar-item">
          		관광안내소
         	</a>
         	<a class="navbar-item">
          		홍보물신청
         	</a>
         </div>	
      </div>
    </div>
  </div>
  <div class="navbar-end">
    <div class="navbar-item">
    	<div class="buttons"> 
			<a class="button is-primary is-light" href="${path1 }/QnaList.do">QnA</a>
			<a class="button is-primary is-light" href="${path1 }/ReviewList.do">Review</a>		 	
	   		<c:if test="${!empty sid && sid!='admin'}">	
				<a class="button is-link" href="${path }/MyPage.do">마이페이지</a>									
				<a class="button is-info" href="${path }/UserLogout.do">로그아웃</a>	
			</c:if>
			<c:if test="${empty sid }">
	     		<a class="button is-link" href="${path }/UserLogin.do">로그인</a>									
				<a class="button is-info" href="${path }/UserTerms.do">회원가입</a>	
		 	</c:if>
			<c:if test="${!empty sid && sid=='admin'}">
			<div class="navbar-item has-dropdown is-hoverable">
      			<a class="navbar-link" >관리자 페이지</a>	
      			<div class="navbar-dropdown">
	     			<a class="navbar-item" href="${path }/AdminPlaceList.do">장소 관리</a>
		          	<a class="navbar-item" href="${path }/NoticeList.do">공지사항 관리</a>		        		         	
         		</div>				
     		</div>									
			<a class="button is-info" href="${path }/UserLogout.do">로그아웃</a>				
		 	</c:if>		 	
		</div>
		
    </div>
  </div> 
</nav>		   
</header>
