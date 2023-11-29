
<%@page import="java.sql.ResultSet"%>
<%@page import="javabean.db_conn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-----------------------------------
-@data-time	2019?6?9?---??7:05:15
-@author	created by matou
-@IDE		eclipse
-@tomcat	9.0
-@jdk		1.8.0_161	
------------------------------------%>
<%@ include file="verify_login.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="asset/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="asset/css/plugins/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="asset/css/plugins/animate.min.css" />
<link href="asset/css/style.css" rel="stylesheet">
</head>
<body>

	<div class="panel">
		<div class="panel-body">
			<div class="col-md-12">
				<h3 class="animated fadeInLeft">订单列表</h3>
				<p class="animated fadeInDown">
					订单管理<span class="fa-angle-right fa"></span>订单列表
				</p>
			</div>
		</div>
	</div>


	<div class="col-md-12 padding-0 form-element">

		<div class="panel">
			<div class="panel-heading">
				<h3>列表内容</h3>
			</div>

			<div class="panel-body">
				<div class="responsive-table">
					<div id="datatables-example_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap no-footer">
						<div class="row">
							<div class="col-sm-12">
								<table
									class="table table-striped table-bordered dataTable no-footer"
									width="100%" cellspacing="0" style="width: 100%;">
									<thead>
										<tr role="row">
											<th class="sorting_asc" style="width: 15%;">用户名</th>
											<th class="sorting" style="width: 5%;">航班号</th>
											<th class="sorting" style="width: 5%;">乘机人</th>
											<th class="sorting" style="width: 5;">乘机日期</th>
											<th class="sorting" style="width: 5%;">舱位</th>
											<th class="sorting" style="width: 5%;">证件号码</th>
											<th class="sorting" style="width: 5%;">联系人</th>
											<th class="sorting" style="width: 5%;">联系电话</th>
											<th class="sorting" style="width: 5%;">状态</th>
											<th class="sorting" style="width: 25%;">操作</th>

										</tr>
									</thead>

									<tbody>
										<%
											db_conn conn = new db_conn();
											String sql = "select * from t_order";
											ResultSet res = conn.executeQuery(sql);
											String row = null;
											while (res.next()) {
												if (res.getRow() % 2 == 0) {
													row = "even";
												} else {
													row = "odd";
												}
										%>

										<tr role="row" class="<%=row%>">
											<td class="sorting_1"><%=res.getString(2)%></td>
											<td><%=res.getString(3)%></td>
											<td><%=res.getString(4)%></td>
											<td><%=res.getString(5)%></td>
											<td><%=res.getString(6)%></td>
											<td><%=res.getString(7)%></td>
											<td><%=res.getString(8)%></td>
											<td><%=res.getString(9)%></td>
											<td>
												<%
													if (res.getInt(10) == 0) {
															out.println("已预订");
														} else if (res.getInt(10) == 1) {
															out.println("退票中");
														} else if (res.getInt(10) == 2) {
															out.println("退票成功");
														} else if (res.getInt(10) == 3) {
															out.println("退票失败");
														}
												%>
											</td>
											<td>
											<%
											if(res.getInt(10) == 1){
												
											 
											%>
											<a
												href="/add_order?id=<%=res.getInt(1)%>&status=2&flag=1">同意退票</a>
												<a
												href="/add_order?id=<%=res.getInt(1)%>&status=3&flag=1">拒绝退票</a>
												<%
											 
												
											}
											%></td>
										</tr>
										<%
											}
										%>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>