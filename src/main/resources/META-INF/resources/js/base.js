/**
 * 登录检测
 * 
 * @param sucessCallback
 *            已登录状态时回调函数
 * @param failCallback
 *            未登录状态时回调函数
 * @param checkUrl
 *            登录检测url
 */
function loginCheck(validationUrl, successCallback, failCallback, data) {
	data || (data = {});
	AtmeSSO.loginCheck({
		casServerUrl : ns.caspath + '/',
		service : ns.basepath + '/' + validationUrl,
		success : function(st) {
			var url = ns.basepath + '/' + validationUrl + '?ticket=' + st;
			$.ajax({
				url : url,
				type : "GET",
				dataType : 'json',
				cache : false,
				success : function(result) {
					if(typeof successCallback == 'function') {
						successCallback(result);
					}
				},
				error : function(err, b) {
					if(typeof failCallback == 'function') {
						failCallback();
					}
				}
			});
		},
		error : function(error) {
			if (error.errcode == '4003') {
				if(typeof failCallback == 'function') {
					failCallback();
				}
			}
		}
	});
}

/**
 * 登录cas
 * 
 * @param name
 *            用户名
 * @param pwd
 *            密码
 * @param validationUrl
 *            cas登录成功后，cas客户端进行校验的url
 * @param successCallback
 *            登录成功并校验成功的回调函数
 * @param errorCallback
 *            登录失败回调函数
 * @returns
 */
function casLogin(name, pwd, validationUrl, successCallback, errorCallback) {
	var option = {
		casServerUrl : ns.caspath + "/",
		service : ns.basepath + '/' + validationUrl,
		username : name,
		password : pwd,
		success : function(st) {
			$.ajax({
				url : ns.basepath + '/' + validationUrl + '?ticket=' + st,
				type : "POST",
				dataType : 'text',
				success : function(data, status, xhr) {
					successCallback && successCallback(data, status, xhr);
				}
			});
		},
		error : errorCallback
	};
	AtmeSSO.login(option);
}

function isWeChat(){
	var ua = navigator.userAgent.toLowerCase();
	if(ua.match(/MicroMessenger/i) == "micromessenger") {
		return true;
	} else {
		return false;
	}
}

/**
 * 序列表格内容为json对象
 * 
 */
jQuery.prototype.serializeObject = function() {
	var obj = {};
	$.each(this.serializeArray(), function(index, param) {
		if (!(param.name in obj)) {
			obj[param.name] = param.value;
		} else {
			var existsValue = obj[param.name];
			if ($.isArray(existsValue)) {
				existsValue.push(param.value);
			} else {
				var ary = [ existsValue ];
				ary.push(param.value);
				obj[param.name] = ary;
			}
		}
	});
	return obj;
};

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, '');
};

String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, '');
};

String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, '');
};