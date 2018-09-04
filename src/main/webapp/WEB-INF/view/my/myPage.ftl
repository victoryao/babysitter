<#assign base=request.contextPath />
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${base}/js/miniMobile.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/miniMobile.css"/>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="${base}/plugins/fonticon/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/css/customer.css"/>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="${base}/css/animate.css"/>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <script src="${base}/js/swiper.min.js"></script>

    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/home_f587618.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/mypage.css">
    <link rel="stylesheet" href="${base}/css/v-user.css">
    <link rel="stylesheet" href="${base}/css/global.css">
    <link rel="stylesheet" href="${base}/css/login.css">
    <script>
        $(document).ready(function () {
            $.cookie('kl_token', '${token}', {expires: 120, path: '/'});
            var redirectUrl = $("#redirectURL").val();
            var openId = $("#openId").val();
            if (openId != "") {
                window.location.href = redirectUrl;
            }

        });
    </script>
</head>
<body>
<input type="hidden" value="${redirectURL}" id="redirectURL">
<input type="hidden" value="${openId}" id="openId">
<input type="hidden" value="${token}" id="token">
<!--已登陆-->
<div class="login-block" id="loginuserdiv">
    <img class="bgImg" src="//static.daojia.com/assets/project/user-center-v1.1/images/banner-bg.png">
    <div class="wrap" id="personaldata">
        <div class="box">
            <img src="${base}/imgs/user.jpg">
            <div class="verticalv-box">
                <span class="bg-icon common name">${customerDO.name} </span>
                <p>
                    <em class="usermark">普通用户</em>
                    <em class="score">${customerDO.phone}</em>
                </p>
            </div>
        </div>
    </div>
</div>

<div class="myorder">
    <div class="hd ico border-b" id="myorder"><a href="${base}/shop/order/list.do?accessToken=${token}">我的订单 <p>
        查看全部订单</p></a></div>
</div>

<div class="myaddr ico mt0 "><a href="${base}/app/to/course.do">课程培训</a></div>
<div class="jifen ico mt0 "><a href="${base}/app/to/about-us.do">关于我们</a></div>
<div class="myfav ico mt0 "><a href="${base}/app/to/contact-us.do"> 联系我们</a></div>
<#if userLevel = "shop">
<div class="imsshop mt0 ico" id="shop"><a
        href="${base}/shop/mobile/activity/list.do?mobile=${customerDO.phone}">商家验证</a></div>
</#if>
<div style="height: 20px"></div>

<#include "/common/foot.ftl" >

</body>
</html>
