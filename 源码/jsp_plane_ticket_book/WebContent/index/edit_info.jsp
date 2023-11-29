
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-----------------------------------
-@data-time	2019?6?11?---??7:32:46
-@author	created by matou
-@IDE		eclipse
-@tomcat	9.0
-@jdk		1.8.0_161	
------------------------------------%>
<%@ include file="verify_login.jsp"%><%--包含验证登陆的代码--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="/plane_ticket_book/index/css/core.css">
<link type="text/css" rel="stylesheet"
	href="/plane_ticket_book/index/css/home.css">
</head>
<body>

	<div class="ydc-content-slide ydc-body">
		<div class="ydc-flex">
			<div class="ydc-column ydc-column-8">
				<div class="ydc-release-content">
					<div class="ydc-tabPanel ydc-tabPanel-release">
						<div class="ydc-release-tab-head">
							<ul>
								<li class="hit">帐号设置</li>
							</ul>
						</div>
						<div class="ydc-panes">
							<form action="../upload_img" enctype="multipart/form-data"
								method="post">
								<div class="ydc-reg-form-class ydc-reg-form-reg"
									style="margin-top: 40px;">
									<div class="ydc-reg-form-group clearfix">
										<label>帐号名称:</label>
										<div class="ydc-reg-form-input"><%=session.getAttribute("user_id")%></div>
									</div>

									<div class="ydc-reg-form-group clearfix">
										<label>帐号图标:</label>
										<div class="ydc-reg-form-input">
											<input type="file" id="" name="username" class=""
												autocomplete="off" placeholder="">
										</div>
									</div>

									<div class="ydc-reg-form-group clearfix">
										<label>身份证号:</label>
										<div class="ydc-reg-form-input clearfix">
											<input type="text" id="user2" name="sfz"
												class="ydc-form-control" autocomplete="off"
												placeholder="<%=session.getAttribute("sfz")%>" value="<%=session.getAttribute("sfz")%>">
										</div>

									</div>
									<div class="ydc-reg-form-group clearfix">
										<label>所在城市:</label>
										<div class="ydc-reg-form-input">
											<input type="text" id="user1" name="city"
												class="ydc-form-control" autocomplete="off"
												placeholder="<%=session.getAttribute("city")%>" value="<%=session.getAttribute("city")%>">
										</div>

									</div>
									<div class="ydc-reg-form-group clearfix">
										<label>联系手机:</label>
										<div class="ydc-reg-form-input">
											<input type="text" id="user1" name="phone"
												class="ydc-form-control" autocomplete="off"
												placeholder="<%=session.getAttribute("phone")%>" value="<%=session.getAttribute("phone")%>">
										</div>
									</div>
									<div class="ydc-reg-form-group clearfix">
										<label>邮箱:</label>
										<div class="ydc-reg-form-input">
											<input type="text" id="user1" name="email"
												class="ydc-form-control" autocomplete="off"
												placeholder="<%=session.getAttribute("email")%>" value="<%=session.getAttribute("email")%>">
										</div>

									</div>
									<div class="ydc-reg-form-group clearfix">
										<label>QQ/微信号:</label>
										<div class="ydc-reg-form-input">
											<input type="text" id="user1" name="qq"
												class="ydc-form-control" autocomplete="off"
												placeholder="<%=session.getAttribute("qq")%>"
												value="<%=session.getAttribute("qq")%>">
										</div>
									</div>
								</div>
								<div class="ydc-reg-form-group">
									<div class="ydc-reg-form-button" style="margin-left: 255px;">
										<input type="submit" value="保存">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>