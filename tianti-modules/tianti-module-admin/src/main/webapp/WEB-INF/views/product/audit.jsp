<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<html>
<%@ include file="../common/jstl.jsp"%>
<head>
</head>
<body>
	<div id="addForm" class="mgt40">
		<div class="mt20 plr20">

				<div class="J_table mt20">
					<div class="t_table">
						<table>
							<tr>
								<td>产品名称:</td>
								<td>${product.name}</td>
							</tr>
							<tr>
								<td>所属企业:</td>
								<td>${product.companyId}</td>
							</tr>
							<tr>
								<td>现有产量（年）:</td>
								<td>${product.capacity}</td>
							</tr>
							<tr>
								<td>产能:</td>
								<td>${product.capacity}</td>
							</tr>
							<tr>
								<td>合作:</td>
								<td>${product.cooperation}</td>
							</tr>
							<tr>
								<td>详情:</td>
								<td>${product.introduction}</td>
							</tr>
						</table>

					</div>

				</div>

		</div>

	</div>

</body>
</html>