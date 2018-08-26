<#assign base=request.contextPath />
<!DOCTYPE HTML>
<html>
<head>
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
</head>
<body>


<!--未登陆-->
<div class="login-block" id="putonglogin">
    <a href="${base}/app/to/login.do">
        <img class="bgImg" src="//static.daojia.com/assets/project/user-center-v1.1/images/banner-bg.png"/>
        <div class="wrap">
            <div class="box">
                <img src="//static.daojia.com/assets/project/user-center-v1.1/images/temp-head_c43dfad.png"/>
                <div class="verticalv-box">
                    <span class="bg-icon name">立即登录</span>
                </div>
            </div>
        </div>
    </a>
</div>


<div class="myaddr ico mt0 "><a href="${base}/app/to/course.do">课程培训</a></div>
<div class="jifen ico mt0 "><a href="${base}/app/to/about-us.do">关于我们</a></div>
<div class="myfav ico mt0 "><a href="${base}/app/to/contact-us.do"> 联系我们</a></div>
<#--<div class="myfav ico" id="appdownload"><a>下载APP<p>超快速度，超省流量</p></a></div>-->
<div style="height: 20px"></div>

<#include "/common/foot.ftl" >

</body>
</html>
