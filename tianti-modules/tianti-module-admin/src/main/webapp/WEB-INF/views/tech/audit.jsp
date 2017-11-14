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
								<td>技术名称:</td>
								<td>${tech.name}</td>
							</tr>
							<tr>
								<td>所属企业:</td>
								<td>${tech.companyId}</td>
							</tr>
							<tr>
								<td>商务合作:</td>
								<td>${tech.cooperation}</td>
							</tr>
							<tr>
								<td>技术领域:</td>
								<td>${product.area}</td>
							</tr>
							<tr>
								<td>技术详情:</td>
								<td>${product.introduction}</td>
							</tr>

						</table>

					</div>

				</div>

		</div>

	</div>

</body>
</html>