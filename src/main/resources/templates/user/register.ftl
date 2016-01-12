<#import "../base/htmlBase.ftl" as html>
<@html.htmlBase title="注册" cssFiles=["main.css"] jsFiles=["validate.js","user/register.js","JPlaceholder.js"]>
<body>
    <#include "../base/head.ftl"/>
<form id="regform" action="/register" method="POST" onsubmit="return false;">
    <div id="content">
        <div class="middle">
            <div class="main-text">
                <span>注册成为用户</span>
            </div>
            <div class="checkbox">
                <input id="realname" name="realname" class="name " type="text" placeholder="请输入您的姓名"/>
            </div>
            <div class="checkbox">
                <input id="phone" name="phone" class="name phone" type="text" placeholder="请输入您的11位手机号码"/>
            </div>
            <div class="val-mak">
                <input id="captcha" name="captcha" class="entry" type="text" placeholder="请输入短信验证码"/>
                <input id="captchaBtn" class="obtain" type="button" value="获取验证码" onclick="sendCaptcha();"/>
            </div>
            <div class="checkbox">
                <input id="password" name="password" class="name password" type="password" placeholder="请输入密码"/>
            </div>
            <div class="checkbox">
                <input id="confirm" class="name password" type="password" placeholder="请再一次输入密码"/>
            </div>
            <div class="button" style="margin-top: 20px;">
                <input class="btn" type="submit" value="立即注册"/>
            </div>
            <div class="foot-regis">
                <a href="/login">已有账号立即登录</a>
            </div>
        </div>
    </div>
</form>
<div id="errmsg" class="popup hiden" style=" margin-top:-95px; display:none;"><!--请将报名信息填写完整-->
    <div class="meng" style="margin-top:95px;"></div>
    <div class="font">
        <div class="information">
            <div class="inf-test">
                <span class="wen"><span>请将报名信息填写完整</span></span>
                <ul>
                    <li>1. 您已注册参与本次评选活动</li>
                    <li>2. 可以用“找我吧”账号直接登录参与活动</li>
                </ul>
                <div style="clear: both; height: 1px; overflow: hidden;"></div>
            </div>
            <div class="footer">
                <div class="box">
                    <input id="confirm_btn" class="sure" type="button" value="确定" />
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</@html.htmlBase>