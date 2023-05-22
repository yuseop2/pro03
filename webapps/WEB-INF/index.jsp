<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path1" value="${pageContext.request.contextPath }" />  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<title>메인 페이지</title>
<style>

.container-fluid { width:1280px; }
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="content">
	<h2>메인 페이지 콘텐츠</h2>
</div>
<%@ include file="../footer.jsp" %> 
</body>
</html>