<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>男孩的天职datatables+bootstrap Demo</title>
<!-- CSS -->
<link rel="shortcut icon" href="favicon.ico" /> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/supersized.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
  <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tooltips.js"></script>
</head>
<body>
<div class="container">  
	<div class="main_box">
		<div class="login_box">
			
			<div class="login_form">
				<form  id="login_form" action="${pageContext.request.contextPath}/login.do"  method="post"  >
					<div class="form-group">
						<label for="j_username" >用户名</label> 
						<input id="username"  name="username" type="text" class="form-control x319 in "   />
					</div>
					<div class="form-group">
						<label for="j_password" >密　码</label> 
						<input id="username"  name="password" type="text" class="form-control x319 in "   />
					</div>
					<div class="form-group space">		
						<button type="submit"  id="loginbtn" 	class="btn btn-primary btn-lg"  >登  录</button>
					</div>
				</form>
			</div>
		</div>
	
	</div>
</div>
 
<script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/js/supersized-init.js"></script>
<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>