<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8"/>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="ZbacBBPSZU"/>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <script type="text/javascript" src="${base}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${base}/js/miniMobile.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/miniMobile.css"/>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="${base}/plugins/fonticon/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/css/customer.css"/>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="${base}/css/animate.css" />
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <script src="${base}/js/swiper.min.js"></script>


</head>

<body class="fadeIn animated">
<!-- swiper -->
<section class="swiper-container h40">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src='${base}/imgs/banner1.jpeg' class="w75 h40"/></div>
        <div class="swiper-slide"><img src='${base}/imgs/banner2.jpeg' class="w75 h40"/></div>
        <div class="swiper-slide"><img src='${base}/imgs/banner3.jpeg' class="w75 h40"/></div>
    </div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
</section>

<!-- 导航 -->
<section class="demo-nav t-c f28 clearfix">

    <div class="col-3 h19">
        <a href="${base}/app/to/babysitter.do" class="pt4 pb4">
            <i class="f44 color-info icon iconfont icon-biaoge"></i>
            <p>月嫂</p>
        </a>
    </div>

    <div class="col-3 h19">
        <a href="${base}/app/to/babysitter.do" class="pt4 pb4"><i
                class="f44 color-warning icon iconfont icon-iconfontliebiao1copy"></i>
            <p>育儿嫂</p>
        </a>
    </div>

    <div class="col-3 h19">
        <a href="${base}/app/to/babysitter.do" class="pt4 pb4">
            <i class="f46 color-success icon iconfont icon-dialog"></i>
            <p>催乳师</p>
        </a>
    </div>

    <div class="col-3 h19">
        <a href="${base}/app/to/train.do" class="pt4 pb4">
            <i class="f46 color-success icon iconfont icon-dialog"></i>
            <p>月嫂培训</p>
        </a>
    </div>


</section>

<#include "/common/foot.ftl" >

</body>

</html>