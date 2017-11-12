<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ include file="common/common.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - 企业管理系统</title>
</head>

<script type="text/javascript">

function mySubmit(){
	
	var username = $.trim($('#username').val());
	var pwd = $.trim($('#pwd').val());

	
	if(!username){
		layer.alert('请输入用户名/手机号/邮箱');
		return;
	}
	
	if(!pwd){
		layer.aletr('请输入密码');
		return;
	}
	
	$('#mySubmit').submit();
}
function adminSubmit(){
    var adminname = $.trim($('#adminName').val());
    var adminpwd = $.trim($('#adminPwd').val());

    if(!adminname){
        layer.alert('请输入用户名/手机号/邮箱');
        return;
    }

    if(!adminpwd){
        layer.aletr('请输入密码');
        return;
    }

    $('#adminSubmit').submit();
}

$(function(){
	
	document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	mySubmit();
	    }
	}
	
});
//切换js代码
$(function(){
    $(document).ready(function()
    {
        $('.re-ul li').click(function(){
            var $this = $(this);
            var $t = $this.index();
            var $ul = $this.parent().parent().next().children('div');
            $this.siblings().removeClass();
            $this.addClass('active');
            $ul.css('display','none');
            $ul.eq($t).css('display','block');
        })
    })
});
function goRegister(){

    window.location.href = '${ctx}/user/toRegister';
   //window.location.href = '${ctx}/register';

}

</script>

<body>
    <div class="J_loginMain">
        <div class="l_inner">

				<div class="m_title">
					<div class="m_txt">
						<c:choose>
							<c:when test="${not empty msg }">${msg }</c:when>
							<c:otherwise>后台管理系统</c:otherwise>
						</c:choose>
					</div>
				</div>


	            <div class="i_main">
					<div class="re-bar">
						<ul class="re-ul">
							<li class="active">企业用户登录</li>
							<li>管理员登录</li>
						</ul>
					</div>
					<div>

						<div style="display: block">
							<form action="${ctx }/do_login" method="post" id="mySubmit">
							<div class="m_input">
								<input placeholder="用户名/手机号/邮箱" type="text" name="username" id="username"/>
							</div>
							<div class="m_input">
								<input placeholder="请输入密码" type="password" name="pwd" id="pwd"/>
							</div>
							<span class="forget_password"><a href="#">忘记密码？去找回</a></span>
							<div class="m_btn">
								<a href="javascript:mySubmit();">登录</a>
								<a href="javascript:goRegister();">管理员注册</a>
							</div>
							</form>
						</div>



						<div style="display: none">
							<form action="${ctx }/do_login" method="post" id="adminSubmit">
							<div class="m_input">
								<input placeholder="请输入用户名/手机号/邮箱" type="text" name="username" id="adminName"/>
							</div>
							<div class="m_input">
								<input placeholder="请输入密码" type="password" name="pwd" id="adminPwd"/>
							</div>

							<div class="m_btn">
								<a href="javascript:adminSubmit();">登录</a>

							</div>
							</form>
						</div>

					</div>
	            </div>

        </div>
    </div>
	
	<%@ include file="common/footer.jsp" %>
</body>
<style type="text/css">
	.re-bar{
		width:100%;
		height:50px;
		margin-top:5px;
	}
	.re-bar ul li{
		width:50%;
		float: left;
		line-height: 50px;
		text-align: center;
	}
	.re-bar ul li:hover{
		cursor :pointer;
		color:#00b7ee;
	}
	.re-bar .active{
		border-bottom: 2px solid #00a0e9;

	}
	.forget_password{
		wideh:100%;
		height:20px;
		display: block;
		margin-top: 5px;
		text-align: right;

	}
	.forget_password a{
		color: #00aeef;
		font-size: 12px;
		text-align: right;
	}
	.m_title{
		margin:50px auto;
		width: 340px;
	}


</style>
</html>