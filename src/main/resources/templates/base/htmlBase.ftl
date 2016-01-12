<#macro htmlBase title="" jsFiles=[] cssFiles=[] staticJsFiles=[] staticCssFiles=[]>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="description" content="${SystemSetting.htmlDesc!""}">
    <meta name="keywords" content="${SystemSetting.htmlKeywords!""}">
    <title>${(title?length!=0)?string(title,SystemSetting.htmlTitle!"")}</title>
<#--<link rel="shortcut icon" type="image/x-icon" href="/img/favo.png">-->
    <#include "../base/commonCss.ftl">
    <#list staticCssFiles as file>
        <link rel="stylesheet" href="${basepath}/${file}"/>
    </#list>
    <#list cssFiles as cssFile>
        <link rel="stylesheet" href="${basepath}/css/${cssFile}"/>
    </#list>

    <#include "../base/commonJs.ftl">
    <#list staticJsFiles as file>
        <script src="${basepath}/${file}"></script>
    </#list>
    <#list jsFiles as jsFile>
        <script src="${basepath}/js/${jsFile}"></script>
    </#list>
</head>
    <#nested/>
</html>
</#macro>
