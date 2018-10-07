<!DOCTYPE html>
<#assign base=request.contextPath />
<html lang="zh-CN">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>订单验证</title>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <link href="${base}/css/djapp.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/css/app_card.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/css/card.css" rel="stylesheet" type="text/css"/>
    <script>
        $(document).ready(function () {
            $("#btnExchange").click(function () {
                var mobile = $("#phone").val();
                var code = $("#exchange-code-input2").val();
                if (mobile == "") {
                    alert("手机号不能为空!");
                    return;
                }
                if (code == "") {
                    alert("验证码不能为空!");
                    return;
                }
                $.post("${base}/shop/order/verify.do?mobile=" + mobile + "&code=" + code, function (data) {
                    alert(data);
                });
            });
        });
    </script>

</head>

<body class="bg_w">
<ul class="tab clearfix">
    <li class="left line_1pxR_tab-li"><a href="${base}/shop/mobile/activity/list.do?mobile=${customerDO.phone}">订单列表</a>
    </li>
    <li class="right"><a class="active" href="javascript:;">订单兑换</a></li>
    <span style="transform: translateX(100%);"><em></em></span>
</ul>


<div class="spacing"></div>
<div class="card_first-wrap card_first-wrap2">

    <div class="alteration-phone">

        <div class="input-wrap input-wrap-B phone">
            <input type="text" placeholder="请输入手机号" id="phone" maxlength="11"/>
        </div>


        <div class="input-wrap">
            <input class="exchange-code-input" id="exchange-code-input2"
                   type="text" placeholder="请输入验证码"/>
        </div>

    </div>

    <input id="btnExchange" class="big-button-B" type="button" value="验证"/>
</div>


</body>


</html>
