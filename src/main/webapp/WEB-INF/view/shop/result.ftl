<!DOCTYPE html>
<#assign base=request.contextPath />
<html lang="zh">
<head data-gc="">
    <base id="base" href="${base}">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta content="email=no" name="format-detection"/>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <title>新手妈妈支付</title>
    <meta name="description"
          content="北京新手妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新手妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <meta name="applicable-device" content="mobile">

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">


</head>

<body>

<input type="hidden" id="appId" value='${pay.appId}'>
<input type="hidden" id="timeStamp" value='${pay.timeStamp}'>
<input type="hidden" id="nonceStr" value='${pay.nonceStr}'>
<input type="hidden" id="package" value='${pay.packages}'>
<input type="hidden" id="signType" value='${pay.signType}'>
<input type="hidden" id="paySign" value='${pay.paySign}'>

<script>

    function onBridgeReady() {
        var appId = $("#appId").val();
        var ts = $("#timeStamp").val();
        var ns = $("#nonceStr").val();
        var pa = $("#package").val();
        var st = $("#signType").val();
        var ps = $("#paySign").val();

        WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId": appId,     //公众号名称，由商户传入
                    "timeStamp": ts,         //时间戳，自1970年以来的秒数
                    "nonceStr": ns, //随机串
                    "package": pa,
                    "signType": st,         //微信签名方式：
                    "paySign": ps //微信签名
                },
                function (res) {
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        window.location.href = '${base}/shop/order/list.do?openId=${pay.openId}';
                        // 使用以上方式判断前端返回,微信团队郑重提示：
                        //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
                    }
                });
    }
    if (typeof WeixinJSBridge == "undefined") {
        if (document.addEventListener) {
            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
        } else if (document.attachEvent) {
            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
        }
//            onBridgeReady();
    } else {
        onBridgeReady();
    }
</script>

</body>
</html>