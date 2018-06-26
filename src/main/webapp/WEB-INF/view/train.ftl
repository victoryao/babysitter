<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta name="description"
          content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <title>快乐妈咪-联系我们</title>
    <!-- ui css、js -->
    <link rel="stylesheet" type="text/css" href="/css/miniMobile.css"/>
    <script type="text/javascript" src="/js/zepto.min.js"></script>
    <script type="text/javascript" src="/js/miniMobile.js"></script>
    <!-- 字体图标 -->
    <link rel="stylesheet" type="text/css" href="/plugins/fonticon/iconfont.css" />
    <!-- swiper -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.5/css/swiper.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.5/js/swiper.min.js"></script>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css" />
</head>

<body class="fadeIn animated">
<header class="ui-header clearfix w75 h8 f46 pl3 pr3 color8 bg-color-primary t-c o-h">
    <div class="ui-header-l fl w5">
        <b class="icon iconfont icon-sortlight"></b>
    </div>
    <div class="ui-header-c fl f30 w59">
        培训
    </div>
    <div class="ui-header-r fl w5">
        <i class="icon iconfont icon-phone"></i>
    </div>
</header>
<div class="t-c p6 f46 color5">
    <br /><br />
    <span class="btn btn-primary btnLeft f32 p2 w22 radius10">
				月嫂
			</span>
    <span class="btn btn-primary btnRight f32 p2 w22 radius10">
				育儿嫂
			</span>
    <br /><br />
    <span class="btn btn-primary btnTop f32 p2 w22 radius10">
				保姆
			</span>
    <span class="btn btn-primary btnBottom f32 p2 w22 radius10">
				保洁
			</span><br /><br />
</div>
<!-- aside left-->
<aside class="ui-aside asideLift w40 bg-color-primary"></aside>
<!-- aside right -->
<aside class="ui-aside asideRight w40 bg-color-primary"></aside>
<!-- aside top -->
<aside class="ui-aside asideTop h50 w75 bg-color-primary"></aside>
<!-- aside bottom -->
<aside class="ui-aside asideBottom h50 w75 bg-color-primary"></aside>

<script type="text/javascript">
    //左侧
    var asideLift = $(".asideLift").asideUi({
        hasmask: true,
        size: "4rem",
        position: "left",
        sidertime: 300
    });
    $(".ui-header-l,.btnLeft").tap(function(event) {
        asideLift.toggle();
        event.preventDefault();
    });

    //右侧
    var asideRight = $(".asideRight").asideUi({
        size: "4rem",
        position: "right",
    });
    $(".btnRight").tap(function(event) {
        asideRight.toggle();
        event.preventDefault();
    });

    //顶部
    var asideTop = $(".asideTop").asideUi({
        size: "5rem",
        position: "top",
    });
    $(".btnTop").tap(function(event) {
        asideTop.toggle();
        event.preventDefault();
    });

    //底部
    var asideBottom = $(".asideBottom").asideUi({
        size: "5rem",
        position: "bottom",
    });
    $(".btnBottom").tap(function(event) {
        asideBottom.toggle();
        event.preventDefault();
    });
</script>
</body>

</html>