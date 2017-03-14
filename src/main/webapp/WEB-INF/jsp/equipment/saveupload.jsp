<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxfileupload2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	
	function go(){
	history.go(-1);
	}
</script>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipment/saveupload.do?id=${equipment.id}" enctype="multipart/form-data" >
	
	    <div class="form-group">
	    <label class="col-sm-2 control-label">所有权证明：</label>
	    <div class="col-sm-4">
	    <c:if test="${empty   equipment.file1}">
	    <input type="file" name="syqzmfile1" id="syqzmfile1" ><br>&nbsp;&nbsp;&nbsp;该记录没有上传所有权证明
	    </c:if>
	       <c:if test="${not empty   equipment.file1}">
	   <input type="file" name="syqzmfile1" id="syqzmfile1" ><br>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/download.do?fileid=${equipment.file1}" target="_blank" >查 看</a>
	    </c:if>
	     
	    </div>

	      <label class="col-sm-2 control-label">鉴定证书：</label>
	    <div class="col-sm-4">
	    <c:if test="${empty   equipment.file2}">
	      <input type="file"  name="jdzsfile2" id="jdzsfile2" ><br>&nbsp;&nbsp;&nbsp;该记录没有上传鉴定证书
	    </c:if>
	       <c:if test="${not empty   equipment.file2}">
	 <input type="file"  name="jdzsfile2" id="jdzsfile2" ><br>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/download.do?fileid=${equipment.file2}" target="_blank" >查 看</a>
	    </c:if>
	    </div>
	 
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">上 传</button>&nbsp;&nbsp;
	      <%-- 
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>
	         --%>
	      <button type="button" class="btn btn-primary" onclick="go()">返 回</button>
	      &nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
	  </form>
  </div>
</div>
</body>
</html>