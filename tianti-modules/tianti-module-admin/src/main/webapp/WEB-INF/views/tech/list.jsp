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

		  <form action="${ctx }/tech/list" id="queryForm" method="post">
	        <div class="J_toolsBar clearfix">
				<div class="t_label">技术名称</div>
				<div class="t_text ml10">
                	<input placeholder="" type="text" name="name" id="name" value="${companyQueryDTO.name }"/>
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
                                     <span>发布状态</span>
                                 </td>
                                 <td>
                                     <span>技术名称</span>
                                 </td>
                                 <td>
                                     <span>所属企业</span>
                                 </td>
                                 <td>
                                     <span>商务合作</span>
                                 </td>
                                 <td>
                                 	 <span>技术领域</span>
                                 </td> 
                                 <td>
                                 	 <span>创建时间</span>
                                 </td>

								 <td>
									 <span>审核状态</span>
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
		                                        ${c.postStatus}
		                                     </div>
		                                 </td>
		                                 <td>
		                                     <div class="t_text tc">
												${c.name}
		                                     </div>
		                                 </td>
		                                 <td>
		                                     <div class="t_text tc">
													 ${c.companyId}
		                                     </div>
		                                 </td>
		                                 <td>
		                                     <div class="t_text tc">
													 ${c.cooperation}
		                                     </div>
		                                 </td>
										 <td>
											 <div class="t_text tc">
													 ${c.area}
											 </div>
										 </td>

		                                 <td>
		                                 	<div class="t_text tc">
												<fmt:formatDate value="${c.createDate }" pattern="yyyy-MM-dd"/>
		                                 	</div>
		                                 </td>
										 <td>
											 <div class="t_text tc">
												 <%--这里放状态--%>
													 <c:choose>
														 <c:when test="${c.auditFlag eq '1' }">
															 已通过
														 </c:when>
														 <c:when test="${c.auditFlag eq '2' }">
															 未通过
														 </c:when>
														 <c:otherwise>
															 未审核
														 </c:otherwise>
													 </c:choose>

											 </div>
										 </td>
		                                 <td>
		                                     <div class="t_link">
												 <c:choose>
													 <c:when test="${c.auditFlag eq '2' }">
														 <a href="javascript:myLook('${c.id }');"><i class="icon"></i>查看</a>
													 </c:when>
													 <c:when test="${c.auditFlag eq '1' }">
														 <a href="javascript:myLook('${c.id }');"><i class="icon"></i>查看</a>
													 </c:when>
													 <c:otherwise>
														 <a href="javascript:myAudit('${c.id }');"><i class="icon"></i>审核</a>
													 </c:otherwise>
												 </c:choose>

		                                     </div>
		                                 </td>
		                             </tr>
	                             </c:forEach>
                              </c:when>
                              <c:otherwise>
                                  <tr>
                                    <td colspan="10">
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
        window.location.href="${ctx}/tech/techAdd";
	}
	function myAudit(id){
		var loadIdx = layer.load();
		var title = '技术审核';

		$.post('${ctx}/tech/details?id='+id, {}, function(str){
			
			layer.close(loadIdx);
			
			layer.open({
				title : title,
				type : 1,
				area : ['600px', '400px'],
				content : str,
				btn : ['审核通过', '不通过'],
				yes : function(index, layero){
                    audit(id, "1");
				},
				btn2 : function(index, layero){
                    audit(id, "2");
				}
			});
		});
	}
	//审核 id是企业id,flag代表1通过，2不通过
    function audit(id, flag){
        layer.confirm('确定审核通过吗？', function(index){
            layer.close(index);

            var loadIdx = layer.load();
            $.ajax({
                url : '${ctx}/tech/ajax/audit',
                type : 'post',
                data : {
                    'id' : id,
                    'auditFlag' : flag,
                },
                traditional : true,
                success : function(result){
                    layer.close(loadIdx);
                    if(result.success){
                        layer.alert('审核成功', function(){
                            window.location.reload();
                        });
                    }else{
                        layer.alert('审核失败');
                    }
                }
            });
        });
    }
    function myLook(id){
        var loadIdx = layer.load();
        var title = '查看';

        $.post('${ctx}${ctx}/tech/details?id='+id, {}, function(str){

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