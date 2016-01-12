<#global contextPath= ((requestContext.getContextPath()??)?string(requestContext.getContextPath(),"")) />
<#global basepath= "http://" + getRequest().getServerName() + contextPath/>
<#global caspath= SystemSetting.casServerUrl/>


<#function isEmpty value>
	<#return !(value?? && (value?length>0)) >
</#function>
