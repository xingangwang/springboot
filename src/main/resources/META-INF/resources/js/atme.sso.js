var AtmeSSO = window.AtmeSSO || (AtmeSSO = {});

AtmeSSO.support = {
    default_options : {
        casServerUrl : 'http://cas.dev.taxhoo.com/',
        service : null,
        casUserUrl : function(ticket) {
            return this.casServerUrl + 'serviceValidate'  + '?service=' + this.service + '&ticket=' + ticket;
        },
        casRestUrl : function() {
            return this.casServerUrl + 'v1/tickets';
        },
        casloginCheckUrl : function() {
            return this.casServerUrl + 'user/loginCheck'  + '?service=' + this.service;
        },
        casRedirectionUrl : function() {
            return this.casServerUrl + 'user/redirectionUrl?service=' + this.service;
        }
    }
}

AtmeSSO.login = function(opts) {
    var options = $.extend($.extend({}, this.support.default_options), opts	|| {});

    $.post(options.casRestUrl(), {
        username : options.username,
        password : options.password

    }).success(function(data, status, xhr) {

        var tgt = data.substring(data.indexOf('/v1/tickets/') + 12, data.indexOf('method="POST"') - 2);

        $.post(options.casRestUrl() + "/" + tgt, {
            service : options.service

        }).success(function(data, status, xhr) {
            var iframe = $('<iframe style="display:none;"/>');
            iframe.attr("src", options.casServerUrl + 'CoookieSet?tgt=' + tgt);
            iframe.load(function() {
                iframe && iframe.remove();
                options.success && options.success(data);
            });
            $("body").append(iframe);

        }).error(function(data, status, xhr) {
            options.error && options.error({"errcode":4002,"errmsg":"获取ST失败"}, data, status, xhr);
        });

    }).error(function(data, status, xhr) {
        options.error && options.error({"errcode":4001,"errmsg":"账号不存在或密码错误"}, data, status, xhr);
    });
}

AtmeSSO.loginCheck = function(opts) {
    var options = $.extend($.extend({}, this.support.default_options), opts	|| {}), tgt, iframe;

    var onmessage = function(e) {

        var jsonMessage = JSON.parse((e || event).data);
        if (jsonMessage.action == 'AtmeSSO.loginCheck') {

            if (typeof window.addEventListener != 'undefined') {
                window.removeEventListener('message', onmessage, false);

            } else if (typeof window.attachEvent != 'undefined') {
                window.detachEvent('onmessage', onmessage);
            }

            iframe && iframe.remove();
            if (jsonMessage.error) {

                options.error && options.error({"errcode":4003,"errmsg": jsonMessage.error});

            } else {
                options.success && options.success (jsonMessage.data);
            }
        }
    };

    if (typeof window.addEventListener != 'undefined') {
        window.addEventListener('message', onmessage, false);

    } else if (typeof window.attachEvent != 'undefined') {
        window.attachEvent('onmessage', onmessage);
    }

    iframe = $('<iframe style="display:none;"/>');
    $("body").append(iframe.attr("src", options.casloginCheckUrl()));
}

AtmeSSO.getRedirectionUrl = function(opts) {
    var options = $.extend($.extend({}, this.support.default_options), opts	|| {}), tgt, iframe;

    var onmessage = function(e) {

        var jsonMessage = JSON.parse((e || event).data);
        if (jsonMessage.action == 'AtmeSSO.redirectionUrl') {

            if (typeof window.addEventListener != 'undefined') {
                window.removeEventListener('message', onmessage, false);

            } else if (typeof window.attachEvent != 'undefined') {
                window.detachEvent('onmessage', onmessage);
            }

            iframe && iframe.remove();

            if (jsonMessage.error) {
                options.error && options.error({"errcode":4006,"errmsg": jsonMessage.error});

            } else {
                options.success && options.success (jsonMessage.data);
            }
        }

    };

    if (typeof window.addEventListener != 'undefined') {
        window.addEventListener('message', onmessage, false);

    } else if (typeof window.attachEvent != 'undefined') {
        window.attachEvent('onmessage', onmessage);
    }

    iframe = $('<iframe style="display:none;"/>');
    $("body").append(iframe.attr("src", options.casRedirectionUrl()));
}

AtmeSSO.casLogin = function(args) {
    $.post(args.service + "?ticket=" + args.serviceTicket).success(function(data, status, xhr) {
        args.success && args.success(data, status, xhr);

    }).error(function(data, status, xhr) {
        args.error && args.error({"errcode":4004, "errmsg":"Error on cas client login process"}, data, status, xhr);
    });
}

AtmeSSO.getUser = function(args) {
    $.post(args.casUserUrl, 'text').success(function(data, status, xhr) {
        var user = {};

        $(data).find('cas\\:attributes > *').each(function(index, e) {
            user[$(e).prop("tagName").toLowerCase().replace('cas:', '')] = $(e).text();
        });
        args.success && args.success(user);

    }).error(function(data, status, xhr) {
        args.error && args.error({"errcode":4005,"errmsg":"Can not get user by ST"}, data, status, xhr);
    });
}