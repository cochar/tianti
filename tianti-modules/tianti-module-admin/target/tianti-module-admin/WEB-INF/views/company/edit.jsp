<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
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
		  <form action="${ctx }/com/ajax/save" modelAttribute="company" id="queryForm" method="post">
			<div class="J_table mt20">
                 <div class="t_table">
                     <table>
						<%-- <tr>
							 <td>手机号:</td>
							 <td>13878890989</td>
						 </tr>
						 <tr>
							 <td>邮箱:</td>
							 <td>13878890989@163.com</td>
						 </tr>--%>
						 <tr>
							 <td>企业名称:</td>
							 <td><input placeholder="请输入企业名称" type="text" name="name" id="name" value="${company.name}"/></td>
						 </tr>
						 <tr>
							 <td>社会信用代码:</td>
							 <td><input placeholder="社会信用代码" type="text" name="code" id="code"/></td>
						 </tr>
						 <tr>
							 <td>联系电话:</td>
							 <td><input placeholder="联系电话" type="text" name="mobile" id="tel"/></td>
						 </tr>
						 <tr>
							 <td>单位地址:</td>
							 <td><input placeholder="单位地址" type="text" name="address" id="address"/></td>
						 </tr>
                     </table>
					 <div class="l_p_btn">
						 <div class="J_toolsBar">
							 <div class="t_buttonGroup">
								 <a class="abtn red" href="javascript:mySubmit();">保存</a>
								 <a class="abtn red" href="javascript:myReset();">重置</a>
							 </div>
						 </div>
					 </div>
                 </div>

             </div>
            </form>
		</div>
    </div>
<script src="${ctx }/static/plugins/chosen_v1.6.2/chosen.jquery.js"></script>    
<script type="text/javascript">
	$(function(){
        $("table tr td:even").css("text-align","right");
        $("table tr td:odd").css("text-align","left");
	});
    function mySubmit(id){
        layer.confirm("是否确定保存？", function(index){
            layer.close(index);

            var loadIdx = layer.load();
            $.ajax({
                url : '${ctx}/com/ajax/save',//换成保存方法的地址
                type : 'post',
                data:$("#queryForm").serialize(),//$("#queryForm").serialize();序列化或者按照下边一个一个写
//                data : {
//                    'id' : id,
//                    'name' : name,
//                },
                traditional : true,
                success : function(result){
                    layer.close(loadIdx);
                    if(result.success){
//                        layer.alert('保存成功');
                        layer.alert('保存成功', function(){
                            window.location.reload();//保存成功之后往哪跳？
                        });
                    }else{
                        layer.alert('保存失败');
                    }
                }
            });
        });
    }
    function myReset(){
        $('#queryForm').reset();
    }



</script>
</body>
</html>