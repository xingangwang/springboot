    <script src="/js/json2.js" ></script>
    <script src="/js/jquery.min.js" ></script>
    <script src="//cdn.bootcss.com/jquery-ajaxtransport-xdomainrequest/1.0.3/jquery.xdomainrequest.min.js"></script>
    <#--<script src="http://libs.baidu.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>-->
	<script src="http://${SystemSetting.casServerUrl}/js/api/atme.sso.js"></script>
	<script src="/js/validate.js"></script>
	<script src="/jstemplate/jsevalcontext.js"></script>
	<script src="/jstemplate/jstemplate.js"></script>
	<script src="/jstemplate/util.js"></script>
	<script src="/js/base.js"></script>
	<script type="text/javascript">
	    window.ns || (ns = {});
	    ns.basepath = '${basepath}';
	    ns.caspath = 'http://' + '${caspath}';
		ns.qiniu = '${SystemSetting.qiniuDomain}';
		ns.polyvWriteToken = '${SystemSetting.polyv_wtoken}';
		ns.polyvReadToken = '${SystemSetting.polyv_rtoken}';
		ns.polyvCoverUrl = '${SystemSetting.polyv_cover_url}';
	</script>
