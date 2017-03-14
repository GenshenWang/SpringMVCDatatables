<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function departmentDelete(id){
		if(confirm("确定要删除这条记录吗?")){
			$.post("${pageContext.request.contextPath}/department/delete.do",{id:id},
				function(res){
					var result=eval('('+res+')');
					if(1==result.code){
			        	alert("删除成功");
						window.location.href="${pageContext.request.contextPath}/department/list.do";
					}else{
						alert(result.errorInfo);
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/department/list.do" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="deptname"   placeholder="请输入要查询的部门...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
  	<button type="button" class="btn btn-primary" style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/department/addjsp.do'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
	  <tr>
	  	<th>序号</th>
	  	<th>部门名称</th>
	  	<th>部门备注</th>
	  	<th>最后更新时间</th>
	  	<th>最后操作ip</th>
	  	<th>操作</th>
	  </tr>
	  <c:forEach var="department" items="${list }" varStatus="status">
	  	<tr>
	  		<td>${status.index+1 }</td>
	  		<td>${department.deptname }</td>
	  		<td><button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#${status.index+1 }" >查 看</button></td>
	  		<td><fmt:formatDate value="${department.createtime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	  			<td>${department.createip}</td>
	  		<td>
	  			<button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/department/editdep.do?id=${department.id}'">修改</button>
	  			<button type="button" class="btn btn-danger btn-xs" onclick="departmentDelete('${department.id}')">删除</button>
	  		</td>
	  	</tr>
	  	<div class="modal fade" id="${status.index+1 }" tabindex="-1" role="dialog" aria-labelledby="modal-label"  aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modal-label">这是&nbsp;<span class="text text-success" >${department.deptname}</span>&nbsp;部门的备注</h4>
                </div>
                <div class="modal-body">
                 
                    <textarea class="form-control" rows="5" id="${a.id}"  maxlength="620">${department.remark }</textarea>
                </div>
                <div class="modal-footer">
                   <button type="button" class="btn btn-success" data-dismiss="modal">关 闭</button>
                </div>
            </div>
        </div>
    </div>
	  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
		总共&nbsp;${total}&nbsp;条记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	${pageCode }
		</ul>
	</nav>
</div>



