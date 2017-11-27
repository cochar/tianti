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
						<td>动态信息名称:</td>
						<td>${dynamicInfo.name}</td>
					</tr>
					<tr>
						<td>所属企业:</td>
						<td>${dynamicInfo.company.name}</td>
					</tr>
					<tr>
						<td>动态信息简介:</td>
						<td>${dynamicInfo.brief}</td>
					</tr>

					<tr>
						<td>动态信息详情:</td>
						<td>${dynamicInfo.introduction}</td>
					</tr>

				</table>

			</div>

		</div>

	</div>

</div>

</body>
</html>