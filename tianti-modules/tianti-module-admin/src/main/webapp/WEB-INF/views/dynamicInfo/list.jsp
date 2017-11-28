<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../common/common.jsp" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${menu_name } - ${title }</title>
</head>
<link href="${ctx }/static/plugins/chosen_v1.6.2/chosen.css" rel="stylesheet" />
<body <%@ include file="../common/skin.jsp" %>>
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/menu.jsp" %>
<div class="J_content">
	<div class="mt20 plr20">
		<form action="${ctx }/user/list" id="queryForm" method="post">
			<div class="J_toolsBar clearfix">
				<div class="t_label">动态信息名称</div>
				<div class="t_text ml10">
					<input placeholder="" type="text" name="name" id="name" value="${specialist.name }"/>
				</div>
				<div class="t_button mgl30">
					<a class="abtn red" href="javascript:myQuery();">
						<i class="icon"></i>查询
					</a>
				</div>
				<div class="t_button ml10">
					<a class="abtn blue" href="javascript:myAdd();">
						<i class="icon"></i>新增
					</a>
				</div>
				<div class="t_label ml10">
					动态信息数：<label style="color: red;" id="total">${page.totalCount }</label>
				</div>
			</div>

			<div class="J_table mt20">
				<div class="t_table">
					<table>
						<thead>
						<tr>
							<td>
								<span>序号</span>
							</td>
							<td>
								<span>动态名称</span>
							</td>

							<td>
								<span>所属企业</span>
							</td>
							<td>
								<span>动态信息简介</span>
							</td>

							<td>
								<span>创建时间</span>
							</td>
							<td>
								<span>状态</span>
							</td>
							<td>
								<span>操作</span>
							</td>
						</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${page.list != null && page.totalCount > 0 }">
								<c:forEach items="${page.list }" var="c" varStatus="status">
									<tr>
										<td>
											<div class="t_text tc">
													${status.index+1 }
											</div>
										</td>

										<td>
											<div class="t_text tc">
													${c.name}
											</div>
										</td>
										<td>
											<div class="t_text tc">
													${c.company.name}
											</div>
										</td>
										<td>
											<div class="t_text tc">
													${c.brief}
											</div>
										</td>


										<td>
											<div class="t_text tc">
												<fmt:formatDate value="${c.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
											</div>
										</td>
										<td>
											<div class="t_text tc">
												草稿还是发布
											</div>
										</td>


										<td>
											<div class="t_link">

												<a href="javascript:myLook('${c.id }');"><i class="icon"></i>查看</a>

												<a href="javascript:toEdit('${c.id }');"><i class="icon"></i>编辑</a>


											</div>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="8">
										<div class="J_null mt40">
											<img src="${ctx }/static/images/null.png">
											<p>暂无相关数据</p>
										</div>
									</td>
								</tr>
							</c:otherwise>
						</c:choose>
						</tbody>
					</table>
				</div>
				<%@ include file="../common/pager.jsp"%>
			</div>
		</form>
	</div>
</div>
<script src="${ctx }/static/plugins/chosen_v1.6.2/chosen.jquery.js"></script>
<script type="text/javascript">
    function myAdd(){
        //跳转到新增
        window.location.href="${ctx}/dynamicInfo/toEdit";
    }
    function myLook(id){
        var loadIdx = layer.load();
        var title = '查看动态信息';

        $.post('${ctx}/dynamicInfo/details?id='+id, {}, function(str){

            layer.close(loadIdx);

            layer.open({
                title : title,
                type : 1,
                area : ['600px', '400px'],
                content : str,
                btn : ['关闭'],
                yes : function(index, layero){
                    layer.close(index);
                }
            });
        });
    }
    function toEdit(id){
        var loadIdx = layer.load();
        var title = '编辑动态信息';

        $.post('${ctx}/dynamicInfo/toEdit?id='+id, {}, function(str){

            layer.close(loadIdx);

            layer.open({
                title : title,
                type : 1,
                area : ['600px', '400px'],
                content : str,
                btn : ['关闭'],
                yes : function(index, layero){
                    layer.close(index);
                }
            });
        });

    }

</script>
</body>
</html>