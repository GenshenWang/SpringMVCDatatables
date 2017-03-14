<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	
	function checkForm(){
		var equipmentnameid=$("#equipmentnameid").val();
		var ppxh=$("#ppxh").val();
		var ccbh=$("#ccbh").val();
		var checktime=$("#checktime").val();
		var jdjg=$("#jdjg").val();
			var jdzsh=$("#jdzsh").val();
		var state=$("#state").val();	
		if(equipmentnameid==null || equipmentnameid==""){
			$("#error").html("请选择设备名称!");
			return false;
		}
		if(ppxh==null || ppxh==""){
			$("#error").html("品牌型号不能为空！");
			return false;
		}
		if(ccbh==null || ccbh==""){
			$("#error").html("出厂编号不能为空！");
			return false;
		}
		if(checktime==null || checktime==""){
			$("#error").html("请选择检定日期！");
			return false;
		}
		if(jdjg==null || jdjg==""){
			$("#error").html("检定机构不能为空!");
			return false;
		}
		if(jdzsh==null || jdzsh==""){
			$("#error").html("检定证书号不能为空!");
			return false;
		}
		if(state==null || state==""){
			$("#error").html("请选择设备状态!");
			return false;
		}
		return true;
	}
	
	
	function resetValue(){
		$("#username").val("");
		$("#password").val("");
		$("#truename").val("");
		$("#rolename").val("");
		$("#deptid").val("");
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
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/equipment/save.do" enctype="multipart/form-data"  onsubmit="return checkForm()"
    >
	  <div class="form-group">
	    <label class="col-sm-2 control-label">设备名称：</label>
	    <div class="col-sm-4">
	    	<select class="form-control" style="width: 250px" id="equipmentnameid" name="equipmentnameid">
	    		<option value="">请选择...</option>
	    		<c:forEach var="Equipmentname" items="${list}">
	    			<option value="${Equipmentname.id }">${Equipmentname.name}</option>
	    		</c:forEach>
	    	</select>
	    </div>
	     <label class="col-sm-2 control-label">品牌型号：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="ppxh" name="ppxh" style="width: 250px">
	    </div>
	  </div>
	
	  <div class="form-group">
	    <label class="col-sm-2 control-label">出厂编号：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="ccbh" name="ccbh"  style="width: 250px">
	    </div>
	    
	    <label class="col-sm-2 control-label">检定日期：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="checktime" name="checktime" style="width: 250px" onclick="laydate()">
	    </div>
	  </div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label">检定有效日期至：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="checkavltime" name="checkavltime" style="width: 250px" onclick="laydate()">
	    </div>
	       <label class="col-sm-2 control-label">检定机构：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="jdjg" name="jdjg" style="width: 250px">
	    </div>
	  </div>
	   <div class="form-group">
	    <label class="col-sm-2 control-label">检定证书号：</label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" id="jdzsh" name="jdzsh" style="width: 250px">
	    </div>
	    
	    <label class="col-sm-2 control-label">设备状态：</label>
	    <div class="col-sm-4">
	    	<select class="form-control" style="width: 250px" id="state" name="state">
	    		<option value="">请选择...</option>
	    		<option value="1">报 废</option>
	    		<option value="2">闲 置</option>
	    		<option value="3">使用中</option>
	    	</select>
	    </div>
	  </div>
	    <div class="form-group">
	    <label class="col-sm-2 control-label">所有权证明：</label>
	    <div class="col-sm-4">
	      <input type="file" name="syqzmfile1" >
	    </div>

	      <label class="col-sm-2 control-label">鉴定证书：</label>
	    <div class="col-sm-4">
	      <input type="file"  name="jdzsfile2" >
	    </div>
	 
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">保 存</button>&nbsp;&nbsp;
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