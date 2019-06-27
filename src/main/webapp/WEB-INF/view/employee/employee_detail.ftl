<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <meta name="description"
          content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="ZbacBBPSZU"/>

    <title>新新妈咪-${employeeDO.name}阿姨简历</title>
    <!-- Chosen CSS -->
    <link href="${base}/css/chosen.min.css" rel="stylesheet">
    <!-- Custom Main StyleSheet CSS -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <!-- Color CSS -->
    <link href="${base}/css/color.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="${base}/css/responsive.css" rel="stylesheet">

    <link href="${base}/css/dashboard.css" rel="stylesheet">
    <!-- Custom Main StyleSheet CSS -->
    <link href="${base}/css/style.css" rel="stylesheet">
    <!-- Color CSS -->
    <link href="${base}/css/color.css" rel="stylesheet">
    <!-- Responsive CSS -->
    <link href="${base}/css/responsive.css" rel="stylesheet">

    <script type="text/javascript">
        function showWx() {
            document.getElementById("wxImg").style.display = 'block';
        }
        function hideWx() {
            document.getElementById("wxImg").style.display = 'none';
        }
    </script>

</head>

<body>
<!--gt Wrapper Start-->
<div class="gt_wrapper">

    <!--Main Content Wrap Start-->
    <div class="gt_content_wrap">
        <!--Classes Wrap Start-->
        <section class="gt_courses_bg">
            <div class="container">

                <!--Classes List Wrap Start-->
                <div class="col-md-8">
                    <div class="gt_d_classes_wrap default_width mb20">
                        <div class="gt_d_profile_wrap default_width">
                            <figure>
                                <img src="/imgs/${employeeDO.photo}" alt="">
                            </figure>
                            <div class="gt_d_profile_detail">
                                <ul>
                                    <li>
                                        <span>姓名:</span>
                                        <p>${employeeDO.name}</p>
                                    </li>
                                    <li>
                                        <span>生日</span>
                                        <p>${employeeDO.birthday?string('yyyy-MM-dd')}</p>
                                    </li>
                                    <li>
                                        <span>入行时间:</span>
                                        <p>${employeeDO.startDate?string('yyyy-MM-dd')}</p>
                                    </li>
                                    <li>
                                        <span>籍贯:</span>
                                        <p>${employeeDO.hometown}</p>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="gt_d_about_author default_width">
                            <h4 class="gt_d_title">个人简介</h4>
                            <p>${employeeDO.introduce?replace('\n', '<br/>')}</p>
                        </div>
                    </div>

                </div>
                <!--Classes List Wrap End-->
            </div>
        </section>
        <!--Classes Wrap End-->
    </div>
    <!--Main Content Wrap End-->

</div>
<!--gt Wrapper End-->

<div id="modal2" class="modal modal--align-top modal__bg" role="dialog" aria-hidden="true">
    <div class="modal__dialog">
        <div class="modal__content">
            <h2 align="center">长按二维码加小助理咨询</h2>
            <p><img src="${base}/extra-images/kefu.jpeg" alt=""/></p>
            <a href="" class="modal__close demo-close">
                <svg class="" viewBox="0 0 24 24">
                    <path d="M19 6.41l-1.41-1.41-5.59 5.59-5.59-5.59-1.41 1.41 5.59 5.59-5.59 5.59 1.41 1.41 5.59-5.59 5.59 5.59 1.41-1.41-5.59-5.59z"/>
                    <path d="M0 0h24v24h-24z" fill="none"/>
                </svg>
            </a>
        </div>
    </div>
</div>

<!--Chosen JavaScript-->
<script src="${base}/js/chosen.jquery.min.js"></script>
<!--Custom JavaScript-->
<script src="${base}/js/custom.js"></script>

</body>
</html>
