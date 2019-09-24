<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>
 <!-- 通过cdn引用jQuery -->
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
  <!-- 引入css样式表 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- 引入js -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建页面 -->
	<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>SSM-CRUD</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-md-offest-4">
			<button class="btn btn-primary">新增</button>
			<button class="btn btn-danger">删除</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover">
				<tr>
				 <th>#</th>
				 <th>empName</th>
				 <th>gender</th>
				 <th>email</th>
				 <th>deptName</th>
				 <th>操作</th>
				</tr>
				<c:forEach items="${pageInfo.list}" var="emp">
				<tr>
				 <th>${emp.empId}</th>
				 <th>${emp.empName}</th>
				 <th>${emp.gender=="M"?"男":"女"}</th>
				 <th>${emp.email}</th>
				 <th>${emp.department.deptName}</th>
				 <th>
				 	<button class="btn btn-primary btn-sm">编辑</button>
				 	<button class="btn btn-danger btn-sm">删除</button>
				 
				 </th>
				
				</tr>
				</c:forEach>
				
			</table>
		</div>
	
	</div>
	<div class="row">
		<!-- 分页文字信息 -->
		<div class="col-md-6">
		    当前${pageInfo.pageNum}页，总${pageInfo.pages}页
		</div>
		<div class="col-md-6">
			<nav aria-label="Page navigation">
				  <ul class="pagination">
				   <li><a href="#">首页</a></li>
				    <li>
				      +   <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
				    	<c:if test="${page_Num==pageInfo.pageNum}">
				    		<li class="active">
				    			<a href="#">${page_Num}</a>
				    		</li>	
				    	</c:if>
				    	<c:if test="${page_Num!=pageInfo.pageNum}">
				    		<li>
				    			<a href="${APP_PATH }/ssm-crud/emps?pn=${page_Num}">${page_Num}</a>
				    		</li>	
				    	</c:if>
				    </c:forEach>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				     <li><a href="#">末页</a></li>
				  </ul>
	</nav>
		</div>
		
		
		<!-- 分页条信息 -->
	</div>		
	</div>

</body>
</html>