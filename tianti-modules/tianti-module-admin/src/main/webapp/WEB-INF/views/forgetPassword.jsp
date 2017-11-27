<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="common/common.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录 - 后台管理系统</title>
</head>

<script type="text/javascript">

    function mySubmit(){

        var mobile = $.trim($('#mobile').val());
        var email = $.trim($('#email').val());
        var username = $.trim($('#username').val());
        var pwd = $.trim($('#pwd').val());
        var repwd = $.trim($('#repwd').val());


        if(!mobile){
            layer.alert('请输入手机号');
            return;
        }
        if(!email){
            layer.alert('请输入邮箱');
            return;
        }
        if(!username){
            layer.alert('请输入用户名');
            return;
        }

        if(!pwd){
            layer.alert('请输入密码');
            return;
        }
        if(!repwd){
            layer.alert('请确认密码');
            return;
        }
        if(pwd!=repwd){
            layer.alert('两次密码不一致');
            return;
        }

        isEmail(email);
        isMobile(mobile);
        register();
    }

    function register(){
        //选表单信息
        var mobile = $.trim($('#mobile').val());
        var email = $.trim($('#email').val());
        var username = $.trim($('#username').val());
        var pwd = $.trim($('#pwd').val());

        $.ajax({
            url : '${ctx}/user/ajax/register',//换成保存方法的地址
            type : 'post',
            //data:$("#queryForm").serialize(),//$("#queryForm").serialize();序列化或者按照下边一个一个写
            data : {//自己修改字段名
                'mobile' : mobile,
                'email' : email,
                'username':username,
                'password':pwd
            },
            traditional : true,
            success : function(result){
//                alert(result);
                if(result.success){
//                    layer.alert('注册成功，请登录完善企业信息');
                        layer.alert('注册成功', function(){
                            window.location.href = '${ctx}/login';//保存成功之后往哪跳？
                        });
                }else{
                    layer.alert(result.msg);
                }
            }
        });

    }

    $(function(){

        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                mySubmit();
            }
        }

    });

    function isEmail(str){
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if(!(reg).test(str)){
            layer.alert('不是正确的邮箱格式');
            return false;
        }
    }


    function isMobile(str){
        if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(str))) {
            layer.alert('不是完整的11位手机号或者正确的手机号前七位');
            return false;
        }
    }
    $(function(){
        $("#getpassword lable").click(function(){
            var $this=$(this);
            var $t=$this.index();
            var $div=$this.parent().siblings().children("div");
            $div.css('display','none');
            $div.eq($t).css("display","block");
        })
    });
</script>

<body>
<div class="J_loginMain">
    <div class="l_inner">
        <form action="${ctx }/user/register" modelAttribute="user" method="post" id="mySubmit">
            <%--<div class="m_title">--%>
                <%--<div class="m_txt">--%>
                    <%--<c:choose>--%>
                        <%--<c:when test="${not empty msg }">${msg }</c:when>--%>
                        <%--<c:otherwise>管理员注册</c:otherwise>--%>
                    <%--</c:choose>--%>
                <%--</div>--%>
            <%--</div>--%>


            <div class="i_main" style="margin-top: -270px;">
                <div id="getpassword">
                    请选择找回方式：
                    <lable><input type="radio" name="getType" checked/> 邮箱地址 </lable>
                    <lable><input type="radio" name="getType" />电话号码 </lable>
                </div>
                <div>
                    <div style="display:block">

                        <div class="m_input">
                            <input placeholder="邮箱" type="text" name="email" id="email"/>
                        </div>


                        <div class="m_btn">
                            <a href="javascript:getBack();">注册</a>

                        </div>
                    </div>
                    <div style="display:none">
                        <div class="m_input">
                            <input placeholder="手机号" type="text" name="mobile" id="mobile"/>
                        </div>
                        <div class="m_input">
                            <input placeholder="验证码" type="text" name="mobile" id="authode"/>
                        </div>


                        <div class="m_btn">
                            <a href="javascript:getBack();">注册</a>

                        </div>
                    </div>
                </div>

            </div>
        </form>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
</body>
<style type="text/css">

    .m_title{
        margin:50px auto;
        width: 340px;
    }



</style>
</html>