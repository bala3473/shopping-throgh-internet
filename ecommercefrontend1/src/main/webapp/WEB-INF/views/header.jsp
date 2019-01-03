<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,intial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/navbarcolor.css'></c:url>">
<link rel="stylesheet" href="<c:url value='/resources/css/precolor.css'></c:url>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-default" id="navcolor">
<div  class="navbar-header">
<a href="" class="navbar-brand"><img src="<c:url value='/resources/images/niit.jpg'></c:url>" height="30px" width="70px"></a>
<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
</div>
<div class="collapse navbar-collapse" id="collapse-example">

<ul class="nav navbar-nav" id="links">
<li><a href="<c:url value='/home'></c:url>">Home</a></li>
<li><a href="<c:url value='/aboutus'></c:url>">About Us</a></li>
<li><a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<c:url value='/admin/getproductform'></c:url>">Add Product</a></li>
</security:authorize>
<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Select By Cateogory
			<span class="caret"></span></a>
			<ul class="dropdown-menu">
			<li><a href="">Furniture</a></li>
			<li><a href="">Kitchen and Dining</a></li>
			<li><a href="">Educational Books</a></li>
			</ul>
			</li>
<c:if test="${pageContext.request.userPrincipal.name==null }">			
<li><a href="<c:url value='/all/getregistrationform'></c:url>">Sign Up</a></li>
<li><a href="<c:url value='/login'></c:url>"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name!=null }">
<li><a href=""><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><span class="glyphicon glyphicon-log-out"></span>Sign Out</a></li>
<li><a href="">Welcome ${pageContext.request.userPrincipal.name }</a></li>
</c:if>
</ul>
</div>
<nav>
</div>
</body>
</html>

