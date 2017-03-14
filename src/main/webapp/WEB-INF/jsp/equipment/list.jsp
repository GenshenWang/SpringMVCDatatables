<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function departmentDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/equipment/delete.do",{id:id},
				function(res){
					var result=eval('('+res+')');
					if(1==result.code){
			        	alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/equipment/list.do";
					}else{
						alert(result.errorInfo);
					}
				}
			);
		}
	}
</script>
<div class="panel panel-default">
  <div class="panel-body">
  <div class="col-md-12">
	<form class="form-horizontal" action="${pageContext.request.contextPath}/equipment/list.do" method="post">
	   <!-- 
	   
	    <div class="input-group" style="width: 300px">
		     
		      <input type="text" class="form-control" name="ppxh"   placeholder="请输入要查询的部门...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
	     -->
	     
	     <div class="form-group">
	    <label class="col-sm-2 control-label">设备名称：</label>
	    <div class="col-sm-3">
	    	<select class="form-control" style="width: 250px" id="equipmentnameid" name="equipmentnameid">
	    		<option value="">请选择...</option>
	    		<c:forEach var="Equipmentname" items="${equipmentnamelist}">
	    			<option value="${Equipmentname.id }">${Equipmentname.name}</option>
	    		</c:forEach>
	    	</select>
	    </div>
	    
	      <label class="col-sm-2 control-label">品牌型号：</label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="ppxh" name="ppxh" style="width: 250px">
	    </div>
	 <div class="col-sm-2">
	    <button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/addjsp.do'">添 加</button>
	  </div>
	  </div>
	  <div class="form-group">
	    <label class="col-sm-2 control-label">设备状态：</label>
	    <div class="col-sm-3">
	    	<select class="form-control" style="width: 250px" id="state" name="state">
	    		<option value="">请选择...</option>
	    		
	    			<option value="1">报 废</option>
	    			<option value="2">闲 置</option>
	    			<option value="3">使用中</option>
	    		
	    	</select>
	    </div>
	    
	      <label class="col-sm-2 control-label">出厂编号：</label>
	    <div class="col-sm-3">
	      <input type="text" class="form-control" id="ccbh" name="ccbh" style="width: 250px">
	    </div>
	    <div class="col-sm-2">
	      <button type="submit" class="btn btn-success" style="float: right;" >查 询</button>
	      </div>
	    </div>
	    
	    
    </form>
  </div>
  <!--  
  <div class="col-md-2" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/addjsp.do'">添加</button>
  </div>
 -->
</div>
</div>


<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
	  <tr>
	  	<th>序号</th>
	  	<th>设备名称</th>
	  	<th>品牌型号</th>
	  	<th>出厂编号</th>
	  	<th>检定日期</th>
	  	<th>检定有效日期至</th>
	  	<th>设备状态</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="equipment" items="${list }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${equipment.equipmentname.name }</td>
	  			<td>${equipment.ppxh}</td>
	  		<td>${equipment.ccbh}</td>
	  		<td><fmt:formatDate value="${equipment.checktime}" type="date" pattern="yyyy-MM-dd "/></td>
	  		<td><fmt:formatDate value="${equipment.checkavltime}" type="date" pattern="yyyy-MM-dd "/></td>
	  		<td>
	  		<c:if test="${equipment.state==1}">
	  		报废
	  		</c:if>
	  		<c:if test="${equipment.state==2}">
	  		闲置
	  		</c:if>
	  		<c:if test="${equipment.state==3}">
	  		使用中
	  		</c:if>
	  		</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/edit.do?id=${equipment.id}'">修改</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="departmentDelete('${equipment.id}')">删除</button>
	  				  			<button type="button" class="btn btn-success btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/equipment/edituploadjsp.do?id=${equipment.id}'" >重新上传</button>
	  		</td>
	  	</tr>
	  
	  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			 总共&nbsp;${total}&nbsp;条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${pageCode }
		</ul>
	</nav>
</div>



