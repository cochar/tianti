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
						<td>分组:</td>
						<td>${dynamicInfo.groupId}</td>
					</tr>
					<tr>
						<td>企业分类名称:</td>
						<td>${dynamicInfo.name}</td>
					</tr>
					<tr>
						<td>企业分类简介:</td>
						<td>${dynamicInfo.brief}</td>
					</tr>

				</table>

			</div>

		</div>

	</div>

</div>

</body>
</html>