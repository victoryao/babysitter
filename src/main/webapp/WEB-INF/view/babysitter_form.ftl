<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="北京新手妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新手妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <title>新手妈咪</title>
    <script type="text/javascript" src="${base}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${base}/js/miniMobile.js"></script>
    <script src="${base}/js/swiper.min.js"></script>
    <!-- Animation CSS -->
    <link href="${base}/css/animate.css" rel="stylesheet">
    <!-- Chosen CSS -->
    <link href="${base}/css/chosen.min.css" rel="stylesheet">
    <!-- Chosen CSS -->
    <link href="${base}/css/login-register.css" rel="stylesheet">
    <!-- Swiper Slider CSS -->
    <link href="${base}/css/flexslider.css" rel="stylesheet">
    <!-- Pretty Photo CSS -->
    <link href="${base}/css/prettyPhoto.css" rel="stylesheet">
    <!-- Swiper Slider CSS -->
    <link href="${base}/css/swiper.css" rel="stylesheet">
    <!-- Custom Main StyleSheet CSS -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <!-- Color CSS -->
    <link href="${base}/css/color.css" rel="stylesheet">
    <!-- Typography StyleSheet CSS -->
    <link href="${base}/css/typography.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="${base}/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${base}/css/customer.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/css/miniMobile.css"/>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="${base}/plugins/fonticon/iconfont.css"/>
    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/home_f587618.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
</head>

<body>
<!--gt Wrapper Start-->
<div class="gt_wrapper">

    <!--Header Wrap Start-->
    <header>
    <!--Main Content Wrap Start-->
    <div class="gt_content_wrap">
        <section>
            <div class="container">
                <!--Conatct Form Wrap Start-->
                <div class="gt_contact_form_wrap default_width">

                    <!--Heading Wrap Start-->
                    <div class="gt_hdg_1 default_width">
                        <h3>已为<b><span style="color:red">${count}</span></b>位妈妈进行匹配最佳月嫂/育儿嫂</h3>
                        <p>推荐人将得到巨额奖励</p>
                        <span class="gt_hdg_left"></span>
                        <i class="icon-school"></i>
                        <span class="gt_hdg_right"></span>
                    </div>

                    <!--Heading Wrap End-->
                    <form class="gt_contact_form" id="contact-form" action="${base}/user/reserve.do" method="post"
                          enctype="multipart/form-data"
                          accept-charset="utf-8">

                        <input type="hidden" id="eId" name="eId" value="${eId}" />

                        <div class="col-md-4">
                            <div class="gt_contact_us_field">
                                <input class="c_ph" type="text" placeholder="姓名" id="name" name="name"
                                       required>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="gt_contact_us_field">
                                <input class="c_ph" type="text" placeholder="联系方式" id="phone"
                                       name="phone" required>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="gt_contact_us_field">
                                <input class="c_ph" type="text" placeholder="您的地址（可不填）" id="address"
                                       name="address">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="gt_contact_us_field">
                                <input class="c_ph" type="text" placeholder="推荐人手机号（可不填）" id="recommendMobile"
                                       name="recommendMobile">
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="gt_contact_us_field">
                                <textarea class="gt_c_bg" name="memo" id="memo" placeholder="特殊要求（可不填）"
                                ></textarea>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="gt_contact_us_field">
                                <input id="submit-message" type="submit" value="为我匹配月嫂" name="submit_msg">
                            </div>
                            <!--Alert Message-->
                            <div id="contact-result">
                            </div>
                        </div>
                    </form>
                </div>
                <!--Conatct Form Wrap End-->
            </div>
        </section>
    </div>
    <!--Main Content Wrap End-->


    <!--Main Content Wrap End-->

    <!--Footer Wrap End-->
</div>
<!--gt Wrapper End-->

<!-- 底部导航 -->
<#include "/common/foot.ftl" >
<!--Jquery Library-->
<script src="${base}/js/jquery.js"></script>
<!--Bootstrap core JavaScript-->
<script src="${base}/js/bootstrap.min.js"></script>
<!--Flex Slider JavaScript-->
<script src="${base}/js/jquery.flexslider-min.js"></script>
<!--Swiper Slider JavaScript-->
<script src="${base}/js/swiper.jquery.min.js"></script>
<!--Owl Carousel JavaScript-->
<script src="${base}/js/owl.carousel.js"></script>
<!--Chosen JavaScript-->
<script src="${base}/js/chosen.jquery.min.js"></script>
<!--Chosen JavaScript-->
<script src="${base}/js/waypoints-min.js"></script>
<!--Pretty Photo Javascript-->
<script src="${base}/js/jquery.prettyPhoto.js"></script>
<!--Custom JavaScript-->
<script src="${base}/js/custom.js"></script>

</body>
</html>
