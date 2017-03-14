<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function logout(){
		if(confirm('您确定要退出系统吗?')){
			window.location.href="${pageContext.request.contextPath}/user/logout.do";
		}
	}
</script>
<div class="list-group">
  <a href="#" class="list-group-item active">
    系统菜单
  </a>
  <c:if test="${currentUser.rolename=='管理员' }">
  	  <a href="${pageContext.request.contextPath}/user/listjson1.do" class="list-group-item">部门管理</a>
      <a href="javascript:logout()" class="list-group-item">安全退出</a>
  </c:if>
  <c:if test="${currentUser.rolename=='使用者' }">
	  <a href="${pageContext.request.contextPath}/equipmentname/list.do" class="list-group-item">使用设备管理</a>
	  <a href="javascript:logout()" class="list-group-item">安全退出</a>
  </c:if>
  <c:if test="${currentUser.rolename=='维修者' }">
	  <a href="${pageContext.request.contextPath}/equipment/repairList.do" class="list-group-item">维修设备管理</a>
	  <a href="${pageContext.request.contextPath}/equipment/repairHistory.do" class="list-group-item">维修历史</a>
	  <a href="javascript:logout()" class="list-group-item">安全退出</a>
  </c:if>
</div>