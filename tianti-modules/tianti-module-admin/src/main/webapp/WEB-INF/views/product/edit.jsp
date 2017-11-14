<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../common/common.jsp" %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>${menu_name } - ${title }</title>
</head>
<link href="${ctx }/static/plugins/chosen_v1.6.2/chosen.css" rel="stylesheet" />
<!-- 配置文件 -->
<script type="text/javascript" src="${ctx }/ueditor/editor_config.js"></script>
<!-- 编辑器源码文件 -->

<script type="text/javascript" charset="utf-8" src="${ctx }/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${ctx }/ueditor/lang/zh-cn/zh-cn.js"></script>
<!-- 实例化编辑器 -->

<body <%@ include file="../common/skin.jsp" %>>
<%@ include file="../common/head.jsp" %>
<%@ include file="../common/menu.jsp" %>
<div class="J_content">

	<div class="mt20 plr20">
		<button class="abtn red" onclick="javascript:history.back(-1);">返回上一级</button>
		<form action="${ctx }/product/ajax/save" modelAttribute="product" id="queryForm" method="post">
			<div class="J_table mt20">
				<div class="t_table">
					<table>
						<tr>
							<td colspan="2">发布状态:
								<input type="radio" name="postStatus" value="0" checked />草稿
								<input type="radio" name="postStatus" value="1" />发布
							</td>
						</tr>
					</table>

					<table class="t_1">
						<tr bgcolor="#eee">
							<td colspan="2">
								<h3>基本信息</h3>
							</td>
						</tr>
						<tr>
							<td><span>*</span>产品名称:</td>
							<td><input placeholder="产品名称" type="text" name="name" id="name" value="${product.name}"/></td>
						</tr>
						<tr>
							<td><span>*</span>所属企业:</td>
							<td>
								<select name="companyId" id="companyId">
									<option value="">---请选择---</option>
									<option value="001">中国石油化工集团</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>现有产量（年）:</td>
							<td><input placeholder="现有产量（年）" type="text" name="capacity" id="capacity"/></td>
						</tr>
						<tr>
							<td>产能:</td>
							<td><input placeholder="产能" type="text" name="" id=""/></td>
						</tr>
						<tr>
							<td>单位:</td>
							<td><input placeholder="单位" type="text" name="measurement" id="measurement"/></td>
						</tr>
					</table>

					<%--副文本编辑框--%>
					<table class="t_2">
						<tr bgcolor="#eee">
							<td colspan="2">
								<h3>详情信息</h3>
							</td>
						</tr>
						<tr>
							<td>产品详情:</td>
							<td><input placeholder="产品详情" type="text" name="introduction" id="introduction"/></td>
						</tr>
						<tr>
							<td>排序:</td>
							<td><input placeholder="排序" type="text" name="sort" id="sort" value="0"/></td>
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
        $(".t_1 tr td:odd").css({"text-align":"right","width":"40%"});
        $(".t_1 tr td:even").css({"text-align":"left","width":"60%"});
        $(".t_2 tr td:odd").css({"text-align":"right","width":"40%"});
        $(".t_2 tr td:even").css({"text-align":"left","width":"60%"});
        $(".t_1 td span").css("color","red");
    });
    function mySubmit(){

        var productName = $.trim($('#name').val());
        var sort = $.trim($('#sort').val());


        if(!productName){
            layer.alert('请输入产品名！');
            return;
        }



        layer.confirm("是否确定保存？", function(index){
            layer.close(index);
            var loadIdx = layer.load();
//            var json = $("#queryForm").serialize()
//
//            json= eval(json);

//			var name = $('#name').val();
//			alert(name);
            $.ajax({
                url : '${ctx}/product/ajax/save',//换成保存方法的地址
                type : 'post',
               data:$("#queryForm").serialize(), //序列化或者按照下边一个一个写JSON.stringify()
//                data : {
//                    'id' : "113314",
//                },
//                contentType:'application/json;charset=UTF-8',
                dataType: "json",
                traditional : true,
                success : function(result){
                    layer.close(loadIdx);
                    if(result.success){
//                        layer.alert('保存成功');
                        layer.alert('保存成功', function(){
                            //window.location.reload();//保存成功之后往哪跳？跳到列表吧
                            window.location.href="${ctx}/product/list";
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
   $(function(){
       var ue = UE.getEditor( 'container', {



           initialFrameWidth: 690,

           initialFrameHeight:483

       });
   });



</script>
</body>
</html>