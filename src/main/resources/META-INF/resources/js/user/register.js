function check_unique_account_name(value,call) {
    var account = encodeURIComponent(value);
    $.ajax({
        url: ns.caspath + '/api/v1/isValidAccount?account=' + account,
        type: "GET",
        contentType: 'text/plain',
        dataType: 'json',
        //async: false
        cache: false
        //success: function (result) {
        //    ///valid = result;
        //}
    }).done(function(result){
        call(result);
        //valid = result;
    });
    //var xdr;
    //jQuery.support.cors = true;
    //if('XDomainRequest' in window && window.XDomainRequest !== null){
    //    xdr = new XDomainRequest();
    //    if (xdr)
    //    {
    //        xdr.onerror = function(){
    //            valid = false;
    //            syncParamForXDR = true;
    //        };
    //        //xdr.ontimeout = timeo;
    //        //xdr.onprogress = progres;
    //        xdr.onload = function(){
    //            valid = xdr.responseText;
    //            syncParamForXDR = true;
    //        };
    //        xdr.timeout = 10000;
    //        xdr.open("get", ns.caspath + '/api/v1/isValidAccount?account=' + account);
    //        xdr.send();
    //    }
    //    while(!syncParamForXDR){
    //    }
    //}else{
    //    $.ajax({
    //        url: ns.caspath + '/api/v1/isValidAccount?account=' + account,
    //        type: "GET",
    //        crossDomain: true,
    //        dataType: 'json',
    //        async: false,
    //        cache: false,
    //        success: function (result) {
    //            valid = result;
    //        }
    //    });
    //return valid;
}


function sendCaptcha() {
    var phone = $('#phone').val();
    if (phone) {
        check_unique_account_name(phone,function(result){
            if (!result) {
                accountCheckTips('电话号码已存在。>><a href="/login?service=/apply?id=1">去登录</a>');
                return;
            }
            $.ajax({
                url: ns.basepath + '/captcha',
                type: "POST",
                dataType: 'text',
                data: {'tel': $("#phone").val()},
                success: function (repeat) {
                    var captchaIntervl = 60;
                    $('#captchaBtn').addClass('seconds');
                    $('#captchaBtn').attr('disabled', '');
                    $('#captchaBtn').val('重新发送(' + captchaIntervl + ')');
                    var timerId = setInterval(function () {
                        captchaIntervl -= 1;
                        $('#captchaBtn').val('重新发送(' + captchaIntervl + ')');
                        if (captchaIntervl < 0) {
                            clearInterval(timerId);
                            $('#captchaBtn').removeAttr('disabled', '');
                            $('#captchaBtn').removeClass('seconds');
                            $('#captchaBtn').val('发送验证码')
                        }
                    }, 1000);
                }
            });
        });
        //if (!check_unique_account_name(phone)) {
        //    tips('电话号码已注册');
        //    return;
        //}
        //$.ajax({
        //    url: ns.basepath + '/captcha',
        //    type: "POST",
        //    dataType: 'text',
        //    data: {'tel': $("#phone").val()},
        //    success: function (repeat) {
        //        var captchaIntervl = 60;
        //        $('#captchaBtn').addClass('seconds');
        //        $('#captchaBtn').attr('disabled', '');
        //        $('#captchaBtn').val('重新发送(' + captchaIntervl + ')');
        //        var timerId = setInterval(function () {
        //            captchaIntervl -= 1;
        //            $('#captchaBtn').val('重新发送(' + captchaIntervl + ')');
        //            if (captchaIntervl < 0) {
        //                clearInterval(timerId);
        //                $('#captchaBtn').removeAttr('disabled', '');
        //                $('#captchaBtn').removeClass('seconds');
        //                $('#captchaBtn').val('发送验证码')
        //            }
        //        }, 1000);
        //    }
        //});

    } else {
        tips('请输入您的手机号码');
    }

}

var validator;
$(function () {
    validator = new FormValidator('regform', [{
        name: 'realname',
        display: '姓名',
        rules: 'required'
    }, {
        name: 'phone',
        display: '电话',
        rules: 'required|callback_check_phone_format'
    }, {
        name: 'captcha',
        display: '验证码',
        rules: 'required|callback_check_captcha'
    }, {
        name: 'password',
        display: '密码',
        rules: 'required|callback_pwd_regexp'
    }, {
        name: 'confirm',
        display: '确认密码',
        rules: 'required|matches[password]'
    }], function (errors, evt) {
        if (errors.length > 0) {
            var errorString = '';
            errorString = errors[0].message;
            tips(errorString);
        } else {
            $("#errormsg").hide();
            /**
             * ajax注册
             */
            $('.theme-popover-mask').fadeIn(100);
            var data = $('#regform').serializeObject();
            /**************2015年12月8日 添加****************/
            check_unique_account_name($("#phone").val(),function(result){
                if(!result){
                    accountCheckTips('电话号码已存在。</br>>><a href="/login?service=/apply?id=1">去登录</a>"');
                    return;
                }
                $.ajax({
                    url: '/doRegister',
                    type: 'POST',
                    data: data,
                    dataType: 'json',
                    cache: false,
                    success: function (result) {
                        if (result.success) {
                            casLogin(data.phone, data.password, 'login', function (result) {
                                alert('注册成功，点击确定跳转到活动首页');
                                location.href = '/';
                            });
                        } else {
                            tips('注册失败，请联系网站管理员。');
                        }
                    }
                });
            });
            /**************2015年12月8日 添加****************/
            //$.ajax({
            //    url: '/doRegister',
            //    type: 'POST',
            //    data: data,
            //    dataType: 'json',
            //    cache: false,
            //    success: function (result) {
            //        if (result.success) {
            //            casLogin(data.phone, data.password, 'login', function (result) {
            //                alert('注册成功，点击确定跳转到活动首页');
            //                location.href = '/';
            //            });
            //        } else {
            //            tips('注册失败，请联系网站管理员。');
            //        }
            //    }
            //});
        }
    });

    //validator.registerCallback('check_unique_account_name', check_unique_account_name)
    //    .setMessage('check_unique_account_name', '电话号码已注册');
    validator.registerCallback('check_phone_format', function (value) {
        if (!/^1\d{10}$/.test(value)) {
            return false;
        }
        return true;
    })
        .setMessage('check_phone_format', '电话号码格式不正确');
    validator.registerCallback('check_captcha', function (value) {
        var success = false;
        $.ajax({
            url: '/checkCaptcha',
            type: 'POST',
            data: {
                captcha: value,
                phone: $("#phone").val()
            },
            dataType: 'json',
            async: false,
            cache: false,
            success: function (result) {
                success = result.success;
                if (!success) {
                    $("#regform input[name=captcha]").focus().select();
                }
            }
        });
        return success;
    })
        .setMessage('check_captcha', '短信验证码错误');

    validator.registerCallback('pwd_regexp', function (value) {
        var success = /\w{6,}/.test(value);
        return success;
    })
        .setMessage('pwd_regexp', '至少6位数字或字母');
    $('#confirm_btn').click(function () {
        $(this).parents('#errmsg').hide();
    });
});

function tips(tip) {
    $('#errmsg .wen span').html(tip);
    $('#errmsg ul').hide();
    $('#errmsg').show();
}

function accountCheckTips(tip){
    $('#errmsg .wen span').html(tip);
    $('#errmsg ul').show();
    $('#errmsg').show();
}