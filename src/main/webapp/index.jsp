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
			<table class="table table-hover" id="emps_table">
			<thead>
				<tr>
				 <th>#</th>
				 <th>empName</th>
				 <th>gender</th>
				 <th>email</th>
				 <th>deptName</th>
				 <th>操作</th>
				</tr>
			</thead>
			<tbody></tbody>
				
				
			</table>
		</div>
	
	</div>
	<div class="row">
		<!-- 分页文字信息 -->
		<div class="col-md-6">
		    当前页，总页
		</div>
		<div class="col-md-6">
			
		</div>
		
		
		<!-- 分页条信息 -->
	</div>		
	</div>
	<script type="text/javascript">
		//1.页面加载完成后，直接发送一个ajax请求，要到分页数据
		$(function(){
			$.ajax({
				url:"${APP_PATH}/ssm-crud/emps",
				data:"pn=1",
				type:"GET",
				success:function(result){
					console.log(result);
					//这个时候请求信息已经拿到了
					//下一步解析并显示员工数据
					build_emps_table(result);
					//下一步解析并显示分页信息
				}
			});		
		});
		function build_emps_table(result){
			var emps=result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				//alert(item.empName);
				var empIdTd=$("<td></td>").append(item.empId);
				var empNameTd=$("<td></td>").append(item.empName);
				var genderTd=$("<td></td>").append(item.gender=="M"?"男":"女");
				var emailTd=$("<td></td>").append(item.email);
				var deptNameTd=$("<td></td>").append(item.department.deptName);
				var editBtn=$("<button></button>").addClass("btn btn-primary btn-sm")
				.append("编辑")
				
				var delBtn=$("<button></button>").addClass("btn btn-danger btn-sm")
				.append("删除")
				var btnTd=$("<td></td>").append(editBtn).append("  ").append(delBtn);
				$("<tr></tr>").append(empIdTd)
							.append(empNameTd)
							.append(genderTd)
							.append(emailTd)
							.append(deptNameTd)
							.append(btnTd)
							.appendTo("#emps_table tbody")
							
				
			});
		}
	 
	</script>

</body>
</html>