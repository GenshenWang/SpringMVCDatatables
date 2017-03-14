<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkForm(){
		var deptName=$("#name").val();
		if(deptName==null || deptName==""){
			$("#error").html("部门名称不能为空！");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#deptname").val("");
		$("#remark").val("");
	}
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
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipmentname/updatedep.do?id=${equipmentname.id}" onsubmit="return checkForm()">
	  <div class="form-group">
	    <label class="col-sm-2 control-label">部门名称：</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control"  value="${equipmentname.name}"  id="name" name="name"  style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label  class="col-sm-2 control-label">部门备注：</label>
	    <div class="col-sm-10">
	      <textarea class="form-control" rows="4" id="remark"  name="remark">${equipmentname.remark}</textarea>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	    <%-- 
	      <input type="hidden" id="id" name="id" value="${department.id }"/>
	      
	      --%>
	      <button type="submit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
	     <!--  
	      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>
	      -->
	       <button type="button" class="btn btn-primary" onclick="go()">返 回</button>&nbsp;&nbsp;
	      <font color="red" id="error"></font>
	    </div>
	  </div>
  </div>
</div>
</body>
</html>