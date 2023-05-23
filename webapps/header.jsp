<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />  
<%
	String sid = "";
	if(session!=null) sid = (String) session.getAttribute("sid");  
%>
<header id="hd" class="container">
	<div class="container-fluid">
		<nav id="tnb" class="navbar navbar-default">
			<ul class="nav navbar-nav navbar-right" style="padding-right:40px">
				<c:if test="${!empty sid && sid!='admin'}">			
					<li><a href="${path }/MyPage.do">마이페이지</a></li>									
					<li><a href="${path }/UserLogout.do">로그아웃</a></li>	
				</c:if>
				<c:if test="${empty sid }">
					<li><a href="${path }/UserLogin.do">로그인</a></li>
					<li><a href="${path }/UserTerms.do">회원가입</a></li>
				</c:if>	
				<c:if test="${sid=='admin' }">
					<li><a href="${path }/Admin.do">관리자 페이지</a></li>
					<li><a href="${path }/UserLogout.do">로그아웃</a></li>	
				</c:if>			
			</ul>
		</nav>
	</div>
	<div class="container-fluid" >	
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">		    
		      <a class="navbar-brand"  href="${path}/ ">여수 문화관광</a>
		    </div>	
		    
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">		       		        
		         <li>     		    	
			        <ul>
			            <li><a href="${path1 }/NoticeList.do">Notice - 공지사항</a></li>
			            <li><a href="${path1 }/FaqList.do">FAQ - 자주하는 질문</a></li>
			            <li><a href="${path1 }/QnaList.do">QnA - 묻고 답하기</a></li>			       
			            <li><a href="${path1 }/ReviewList.do">Review - 이용후기</a></li>
			            <li><a href="${path1 }/DataList.do">자료실</a></li>
			        </ul>
     		    </li>	   
		      </ul>		      
		      <c:if test="${sid=='admin' }">
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="${path1 }/MemberList.do">회원 관리</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">상품/판매 관리 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${path1 }/AdminCateList.do">카테고리 관리</a></li>
		            <li><a href="${path1 }/AdminProductList.do">상품 관리</a></li>
		            <li><a href="${path1 }/AdminSalesList.do">판매 관리</a></li>
		            <li><a href="${path1 }/AdminInventoryList.do">재고 관리</a></li>
		            <li class="divider"></li>
		            <li><a href="${path1 }/AdminBasketList.do">장바구니 관리</a></li>
		           	<li><a href="${path1 }/Survey.do">배송 관리</a></li>
		            <li><a href="${path1 }/AdminPayList.do">결제 관리</a></li>
		          </ul>
		        </li>
		        <li class="dropdown" style="padding-right:30px; margin-right:30px;">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">글 관리 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${path1 }/NoticeList.do">Notice - 공지사항 관리</a></li>
		            <li><a href="${path1 }/FaqList.do">FAQ - 자주하는 질문 관리</a></li>
		            <li><a href="${path1 }/QnaList.do">QnA - 묻고 답하기 관리</a></li>		            
		            <li><a href="${path1 }/AdminReviewList.do">Review - 이용후기 관리</a></li>		          
		            <li><a href="${path1 }/AdminDataList.do">자료실 관리</a></li>
		          </ul>
		        </li>
		      </ul>
		      </c:if>		    
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
</header>
