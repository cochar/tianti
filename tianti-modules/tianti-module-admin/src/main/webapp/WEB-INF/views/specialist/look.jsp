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
						<td>专家姓名:</td>
						<td>${specialist.name}</td>
					</tr>
					<tr>
						<td>所属企业:</td>
						<td>${specialist.company.name}</td>
					</tr>
					<tr>
						<td>专家简介:</td>
						<td>${specialist.brief}</td>
					</tr>
					<tr>
						<td>商务合作:</td>
						<td>${specialist.brief}</td>
					</tr>
					<tr>
						<td>专家详情:</td>
						<td>${specialist.introduction}</td>
					</tr>

				</table>

			</div>

		</div>

	</div>

</div>

</body>
</html>