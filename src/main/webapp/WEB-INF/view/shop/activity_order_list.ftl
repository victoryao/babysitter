<!DOCTYPE html>
<#assign base=request.contextPath />
<html>
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>商家订单列表</title>
    <link href="${base}/css/djapp.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/css/app_card.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/css/card.css" rel="stylesheet" type="text/css"/>
</head>
<body class="bg_c">

<ul class="tab clearfix">
    <li class="left line_1pxR_tab-li"><a class="active" href="javascript:;">订单列表</a></li>
    <li class="right"><a href="${base}/shop/to/exchange.do?id=${customerDO.id}">订单兑换</a>
    </li>
    <span><em></em></span>
</ul>

<div class="spacing"></div>

<div class="card_first-wrap">
    <ul class="fbar_btn_choice templine">
    <#list shopOrderDOs as shopOrderDO>
        <li class="templine">
            <span class="span1"></span>
            <div class="middle">
                <h1>用户手机号：${shopOrderDO.mobile}</h1>
                <p>验证码：${shopOrderDO.code}</p>
            </div>
            <em class="triangleR triangleR-hs"></em>
        </li>
    </#list>
    </ul>
<#--<p class="text-B">-->
<#--企业级购买请联系<a href="tel:4008905758">400-890-5758</a>-->
<#--</p>-->

</div>
</body>
</html>
