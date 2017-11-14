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
        <button class="abtn red" onclick="javascript:history.back(-1);">返回上一级</button>
        <form action="${ctx }/tech/ajax/save" modelAttribute="tech" id="queryForm" method="post">
            <div class="J_table mt20">
                <div class="t_table">
                    <table >
                        <tr>
                            <td colspan="2">发布状态:
                                <input type="radio" name="postStatus" value="0" checked />草稿
                                <input type="radio" name="postStatus" value="1" />发布
                            </td>
                        </tr>
                    </table>

                    <table class="t_1">
                        <tr>
                            <td colspan="2" bgcolor="#eee"><h3>基本信息</h3></td>
                        </tr>
                        <tr>
                            <td><span>*</span>技术名称:</td>
                            <td><input placeholder="技术名称" type="text" name="name" id="name" value="${tech.name}"/></td>
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
                            <td>商务合作:</td>
                            <td><input placeholder="产品详情" type="text" name="cooperation" id="cooperation" /></td>
                        </tr>
                        <tr>
                            <td>技术领域:</td>
                            <td><input placeholder="技术领域" type="text" name="area" id="area"/></td>
                        </tr>
                        <tr>
                            <td>技术详情:</td>
                            <td><input placeholder="技术详情" type="text" name="introduction" id="introduction"/></td>
                        </tr>
                        <tr>
                            <td>排序:</td>
                            <td><input placeholder="排序" type="text" name="sort" id="sort"/></td>
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

        $(".t_1 td span").css("color","red");
    });
    function mySubmit(id){

        layer.confirm("是否确定保存？", function(index){
            layer.close(index);

            var loadIdx = layer.load();
            $.ajax({
                url : '${ctx}/tech/ajax/save',//换成保存方法的地址
                type : 'post',

                data:$("#queryForm").serialize(),//$("#queryForm").serialize();序列化或者按照下边一个一个写
//                data : {
//                    'id' : id,
//                    // 'name' : name,
//                },
                dataType: "json",
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