<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
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

    <title>快乐妈咪</title>

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
    <link rel="stylesheet" href="${base}/css/search-rs.css">
    <link rel="stylesheet" href="${base}/css/footer.css">

    <script>
        //到指定的分页页面
        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }

        $(document).ready(function () {
            $("#search").click(function () {
                var name = $("#searchTextBox").val();
                if ($.trim(name) == '') {
                    alert("月嫂名字不能为空");
                    return;
                }
                var form = document.forms[0];
                form.submit();
            });
        });
    </script>

</head>

<body class="fadeIn animated">

<div class="head-wrap">
    <div class="serach-wrap">
        <div class="input-wrap">
            <div class="input-box">
                <i class="search__icon__search"></i>
                <form action="${base}/employee/list.do">
                    <input type="hidden" name="page" id="page"/>
                    <input id="searchTextBox" placeholder="搜索月嫂名字" autocomplete="off" type="search" name="name" value="${name}">
                </form>
            </div>
        </div>
        <div class="button" id="search">搜索</div>
    </div>
</div>


<div class="main-con">
    <div class="wx-index__theme__list">
        <div class="head__title">
            <span>快乐月嫂</span>
        </div>


        <ul class="list_pet">
        <#list pageView.records as employee>
            <li class="js-tracker ">
                <a href="${base}/employee/${employee.id}/detail.do">
                    <div class="picbox">
                        <#if (employee.photo == "")>
                            <img src="${base}/imgs/default.jpg"
                                 height="80" width="80"/> </#if>
                        <#if (employee.photo != "")>
                            <img
                                    src="${employee.photo}" height="80"
                                    width="80"/> </#if>
                    </div>
                    <div class="list-main">
                        <div class="tit">
                            <p class="title_name">${employee.name}</p>
                            <span class="title_tag">金牌月嫂</span>
                        </div>

                        <div class="evaluate-info clearfix">
                            <#list employee.courseOrderDOs as courseOrderDO>
                                <div class="sell-info">${courseOrderDO.courseName}</div>
                            </#list>
                        </div>

                        <div class="evaluate-info clearfix">
                            <div class="score">
                                <span>评分</span><span>${employee.score}星</span>
                            </div>
                            <div class="sell-info commentTags">
                            </div>
                        </div>

                        <div class="evaluate-info clearfix">
                            <div class="sell-info guarantee" style="">
                                <span><i></i></span>
                            </div>
                        </div>

                        <div class="price-wrap">
                            <div class="price clearfix">
                                <div class="price-num clearfix">
                          <span class="pri_now">
                            <span class="rmb">¥</span>
                                                          <span> ${employee.salary}</span>
                                                      </span>
                                </div>
                                <span class="price-icon pri_deposit">可优惠</span>
                            </div>
                        </div>
                        <div class="store-info clearfix">
                            <div class="info">
                            ${employee.introduce}
                            </div>
                        </div>
                    </div>
                </a>
            </li>
        </#list>
        </ul>
    <#include "../../share/paging.ftl" >
    </div>

</body>
</html>