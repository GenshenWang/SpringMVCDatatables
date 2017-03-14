<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>男孩的天职datatables+bootstrap Demo</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/equipment.css">
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>

<!--  表格会出现黑线，底部翻页变成大图标，很不好看还有阴影，不建议使用
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dataTables.min.css" />
-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.bootstrap.css" />
<!-- 导出数据按钮样式 -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.tableTools.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/dataTables.bootstrap.js"></script>
<!-- 导出数据按钮引用的js-->
<script type="text/javascript"  charset="utf-8" src="${pageContext.request.contextPath}/js/dataTables.tableTools.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/js/sucaijiayuan.js"></script>
<!-- 日期控件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<script>
	var contextPath = "${pageContext.request.contextPath}";
</script>
<%
	if(session.getAttribute("currentUser") == null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}

	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="/WEB-INF/common/default.jsp";
	}
%>
</head>
<body>
<!-- 
<div class="container">
 -->
  <div class="row">
	  <div class="col-md-12">
		  <%@ include file="/WEB-INF/common/head.jsp" %>
	  </div>
  </div>
  <div class="row" style="padding-top: 45px">
	  <div class="col-md-1">
		  <%@ include file="/WEB-INF/common/menu.jsp" %>
	  </div>
	  <div class="col-md-10">
	  	<div>
			<ol class="breadcrumb">
			  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
			
			  <li class="active">${modeName }</li>
			 
			</ol>
		</div>
		<jsp:include page="<%=mainPage %>"/>
	  </div>
  </div>
  <div class="row">
	  <div class="col-md-12">
		  <%@ include file="/WEB-INF/common/foot.jsp" %>
	  </div>
  </div>
  
  <div style="display: none;" id="rocket-to-top">
<div style="opacity:0;display: block;" class="level-2"></div>
<div class="level-3"></div>
</div>
<!--
</div>
 -->
</body>
</html>