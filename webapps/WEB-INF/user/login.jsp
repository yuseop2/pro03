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
<title>회원 로그인 하기</title>
<style>

#fileSel1:checked ~ #file1 { display:none; }
#fileSel2:checked ~ #file1 { display:block; }
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>

<div class="content" style="padding-top:30px; margin-top:30px; width:600px; min-height:500px; ">
	<h2>로그인</h2>
	<p>${msg }</p>
	<form class="box" action="${path1 }/UserLoginPro.do" method="post">
		<div class="field">
			<label class="label">ID</label>
		  	<div class="control">
		    	<input class="input" type="text" name="id" id="id" maxlength="15" title="15자 내로 작성" placeholder="15자 내로 작성" class="form-control" required autofocus>
		  	</div>
		</div>	
		<div class="field">
			<label class="label">Password</label>
		  	<div class="control">
		    	<input class="input" type="text" name="pw" id="pw" maxlength="15" title="15자 내로 작성" placeholder="15자 내로 작성" class="form-control" required >
		  	</div>
		</div>
		<div class="field is-grouped">
			<div class="control" style="margin:0 auto;">
				<input class="button is-info" type="submit" value="Login">
				<a href="javascript:history.go(-1)" class="button is-info is-light">Cancel</a>		    	
		  	</div>		  	  	
		</div>	
	</form>
	<div class="control" >		
		<a href = "${path1 }/UserTerms.do" class="button is-link is-light" style="margin:0 auto;" >SignUp</a>
  	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>