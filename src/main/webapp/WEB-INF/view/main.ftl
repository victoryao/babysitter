<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=0,uc-fitscreen=yes" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="keywords" content="miniMobile的demo" />
    <meta name="description" content="miniMobile是一个简单易用的移动框架！" />
    <!-- miniMObile.css、js -->
    <link rel="stylesheet" type="text/css" href="/css/miniMobile.css"/>
    <script type="text/javascript" src="/js/zepto.min.js"></script>
    <script type="text/javascript" src="/js/miniMobile.js"></script>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="/plugins/fonticon/iconfont.css" />
    <!-- swiper -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.5/css/swiper.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.5/js/swiper.min.js"></script>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
</head>

<body class="fadeIn animated">
<header class="ui-header clearfix w75 h8 f46 pl3 pr3 color8 bg-color-success t-c o-h">
    <div class="ui-header-c fl f30 w59">
        首页
    </div>
    <div class="ui-header-r fl w5">
        <i class="icon iconfont icon-phone"></i>
    </div>
</header>
<!-- aside -->
<style>
    /*只针对侧栏内容部分做简单的样式*/

    .ui-aside {
        line-height: 1.5em;
    }

    .ui-aside ul {
        border-top: 0.02rem solid #017da7;
    }

    .ui-aside li {
        line-height: 0.8rem;
        border-bottom: 0.02rem solid #017da7;
    }

    .ui-aside a {
        display: block;
    }
</style>
<script type="text/javascript">
    var aside = $(".ui-aside").asideUi({
        hasmask: true,
        size: "4rem",
        position: "left",
        sidertime: 300
    });
    $(".ui-header-l").on('touchend', function() {
        aside.toggle();
    })
</script>
<!-- swiper -->
<section class="swiper-container h40">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src='/imgs/banner1.jpg' class="w75 h40" /></div>
        <div class="swiper-slide"><img src='/imgs/banner2.jpg' class="w75 h40" /></div>
        <div class="swiper-slide"><img src='/imgs/banner3.jpg' class="w75 h40" /></div>
    </div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
</section>
<script>
    var swiper = new Swiper('.swiper-container', {
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination',
        }
    });
</script>
<style>
    .swiper-button-next,
    .swiper-button-prev {
        /*swiper 默认图标适应性较差，使用rem单位规定左右按钮大小，图标大小*/
        width: 0.3rem !important;
        height: 0.5rem !important;
        background-size: cover !important;
        margin-top: -0.23rem !important;
    }
</style>
<!--  -->
<div class="t-c f28 p6 color4 bg-color6">
    <h2 class="color-danger f46">
        最专业的月嫂服务
    </h2>
    <p>用心服务 让爱到家</p>
</div>
<!-- 导航 -->
<section class="demo-nav t-c f28 clearfix">
    <div class="col-3 h19">
        <a href="button.html" class="pt4 pb4"><i class="f42 color-primary icon iconfont icon-anniu"></i>
            <p>保洁</p>
        </a>
    </div>
    <div class="col-3 h19">
        <a href="layer.html" class="pt4 pb4">
            <i class="f46 color-success icon iconfont icon-dialog"></i>
            <p>保姆</p>
        </a>
    </div>
    <div class="col-3 h19">
        <a href="/app/to/babysitter.do" class="pt4 pb4"><i class="f44 color-info icon iconfont icon-biaoge"></i>
            <p>月嫂</p>
        </a>
    </div>
    <div class="col-3 h19">
        <a href="babysitter_form.ftl" class="pt4 pb4"><i class="f44 color-warning icon iconfont icon-iconfontliebiao1copy"></i>
            <p>育儿嫂</p>
        </a>
    </div>
    <div class="col-3 h19">
        <a href="icon.html" class="pt4 pb4"><i class="f46 color-danger icon iconfont icon-tupian"></i>
            <p>搬家货运</p>
        </a>
    </div>
    <div class="col-3 h19">
        <a href="aside.html" class="pt4 pb4"><i class="f46 color-warning icon iconfont icon-menu"></i>
            <p>上门安装</p>
        </a>
    </div>
</section>
<style>
    .demo-nav {
        line-height: 1.8em;
    }

    .demo-nav div {
        border-left: 1px solid #f1f1f1;
        border-bottom: 1px solid #f1f1f1;
    }

    .demo-nav a {
        display: block;
        width: 100%;
        height: 100%;
    }

    .demo-nav div:nth-child(4n+1) {
        border-left: none;
    }
</style>
<!-- 底部导航 -->
<nav class="demo-bottomNav mt6 w75 h12 pt1 t-c f28 bg-color8 o-h clearfix">
    <div class="w15 fl">
        <a href="index.html">
            <i class="f46 icon iconfont icon-home_light"></i>
            <p>首页</p>
        </a>
    </div>
    <div class="w15 fl">
        <a href="list-button.html">
            <i class="f46 icon iconfont icon-comment"></i>
            <p>培训</p>
        </a>
    </div>
    <div class="w15 fl">
        <a href="list.html">
            <i class="f46 icon iconfont icon-rank"></i>
            <p>列表</p>
        </a>
    </div>
    <div class="w15 fl">
        <a href="comment.html">
            <i class="f46 icon iconfont icon-list"></i>
            <p>评论</p>
        </a>
    </div>
    <div class="w15 fl">
        <a href="my.html">
            <i class="f46 icon iconfont icon-servicefill"></i>
            <p>我的</p>
        </a>
    </div>
</nav>
<style type="text/css">
    .demo-bottomNav {
        line-height: 1.8em;
        border-top:1px solid #F1F1F1;
    }

    .demo-bottomNav a {
        display: block;
        width: 100%;
        height: 100%;
    }
</style>
</body>

</html>