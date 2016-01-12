$(function () {
    if ($('#isLogin').text() == "N") {
        checkCAS();
    } else {
        $('body').show();
    }
    var val = new FormValidator('log_form', [{
        name: 'name',
        display: '用户名',
        rules: 'required'
    }, {
        name: 'pwd',
        display: '密码',
        rules: 'required'
    }], function (errors, evt) {
        if (errors.length > 0) {
            var errorString = '';
            errorString = errors[0].message;
            tips(errorString);
        } else {
            login();
        }
    });

    $('#confirm').bind('click', function () {
        $(this).parents('#popup').hide();
    });
});

function checkCAS() {
    loginCheck('getLoginUser', function (result) {
            var redirectUrlAfterLoginSuccess = $('#redirectUrl').text();
            if (redirectUrlAfterLoginSuccess) {
                location.href = redirectUrlAfterLoginSuccess;
            } else {
                location.href = "/";
            }
        },
        function () {
            $('body').show();
        });
}
function login() {
    var username = $('#name').val(), pwd = $('#pwd').val();
    casLogin(username, pwd, 'getLoginUser', function (result) {
        var origin = $('#redirectUrl').text();
        var redirectUrlAfterLoginSuccess = origin ? origin : ns.basepath + '/';
        location.href = redirectUrlAfterLoginSuccess;
    }, function (error) {
        if (error.errcode == '4001') {
            tips(error.errmsg);
        }
    });
}

function tips(tip) {
    $('#popup .wen span').text(tip);
    $('#popup').show();
}