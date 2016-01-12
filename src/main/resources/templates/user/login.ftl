<#import "../base/htmlBase.ftl" as html>
<@html.htmlBase title="登录" cssFiles=["main.css"] jsFiles=["user/login.js","JPlaceholder.js"]>

<body style="display: none;">
    <#include "../base/head.ftl"/>
<form id="log_form" method="POST" onsubmit="return false;">
    <div id="reg-funch">
        <div class="middle">
            <div class="reg-test">
                <span>登录</span>
                <div style="display:none">
                    <span id="redirectUrl" >${service!""}</span>
                    <span id="isLogin">${LoginUser()???string("Y","N")}</span>
                </div>
                <script>
                    if(isWeChat()){
                        if(confirm('使用微信授权登录？')){
                            var url = $('#redirectUrl').text();
                            var href = ns.caspath + '/login?service=' + window.location.origin +  (url ? url : '/');
                            window.location = href;
                        }
                    }
                </script>
                <div class="checkbox">
                    <input id="name" name="name" class="name " type="text" placeholder="手机号码/邮箱地址"/>
                </div>
                <div class="checkbox">
                    <input id="pwd" name="pwd" class="password" type="password" placeholder="请输入密码"/>
                </div>
                <div class="button" style="margin-top: 20px;">
                    <input class="btn" type="submit" value="登录"/>
                </div>
                <div class="foot-regis">
                    <a href="/register" style="width: 50%;float: left;">还没有账号吗？</a>
                    <a href="http://${SystemSetting.casServerUrl}/user/forgetpassword"
                            style="width: 50%;float: left;text-align: right">忘记密码？</a>
                </div>
            </div>
        </div>
    </div>
</form>
<div id="popup" class="hiden popup" style=" margin-top:-75px; display: none; "><!--请将报名信息填写完整-->
    <div class="meng" style="margin-top:75px;"></div>
    <div class="font">
        <div class="information">
            <div class="inf-test">
                <span class="wen"><span>请将报名信息填写完整</span></span>
            </div>
            <div class="footer">
                <div class="box">
                    <input id="confirm" class="sure" type="button" value="确定"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</@html.htmlBase>
