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
					<li><a href="${path1 }/MyBasket.do?id=${sid }">장바구니</a></li>
					<li><a href="${path }/MySalesList.do?id=${sid }">구매내역</a></li>
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
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand"  href="${path}/ ">MYSHOP</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">		       		        
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">사료 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${path1 }/ProductList.do?cate=0101">어덜트</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0102">퍼피</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0103">시니어</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0104">소프트사료</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0105">습식</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0106">샘플</a></li>		           
		          </ul>
	          	</li>		          		       
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">간식 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		          	<li><a href="${path1 }/ProductList.do?cate=0201">수제간식</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0202">덴탈껌</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0203">뼈간식</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0204">개껌</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0205">영양제</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0206">육포/저키</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0207">캔/파우치</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0208">우유/음료</a></li>		
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">건강관리 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		          	<li><a href="${path1 }/ProductList.do?cate=0301">위생용품</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0302">칫솔/치약</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0303">미용/관리</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0304">목용용품</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0305">산책용품</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0306">사료통/급식기</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0307">넥카라/수술</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0308">스텝/매트</a></li>		
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">기타용품 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${path1 }/ProductList.do?cate=0401">배변용품</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0402">장난감</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0403">훈련용품</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0404">하우스/방석</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0405">이동장/유모차</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0406">가방/카시트</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0407">의류/악세사리</a></li>
		            <li><a href="${path1 }/ProductList.do?cate=0408">파티</a></li>		
		          </ul>
		        </li>	
		        <li class="dropdown">
     		    	<a href="${path }/NoticeList.do"class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티 <span class="caret"></span></a>
			        <ul class="dropdown-menu" role="menu">
			            <li><a href="${path1 }/NoticeList.do">Notice - 공지사항</a></li>
			            <li><a href="${path1 }/FaqList.do">FAQ - 자주하는 질문</a></li>
			            <li><a href="${path1 }/QnaList.do">QnA - 묻고 답하기</a></li>
			            <li class="divider"></li>
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
