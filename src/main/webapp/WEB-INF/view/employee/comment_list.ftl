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
    <title>新手妈咪-${employeeDO.name}阿姨评价</title>
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.raty.js"></script>
    <script type="text/javascript" src="${base}/js/labs.js"></script>
    <script type="text/javascript" src="${base}/js/rem.js"></script>
    <script type="text/javascript" src="${base}/js/swiper.min.js"></script>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/jquery.raty.css">
    <link rel="stylesheet" href="${base}/css/labs.css">
    <link rel="stylesheet" href="${base}/css/commentlist.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/main.im.css"/>
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/app.css">
    <script>

        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }

        $(document).ready(function () {
            var token = $.cookie('kl_token');
            $("#accessToken").val(token);
            $("#addComment").attr("href", "${base}/employee/${employeeDO.id}/to/comment/add.do?accessToken=" + token);

            $("#score").raty({readOnly: true, score: ${employeeDO.score}});
            $("#scoreSpan").text("评价" + $("input[name='score']").val() + "分");

        });
    </script>

</head>
<body>
<div>

    <div align="center">
        <div id="score" style="height: 50px; padding-top: 20px; margin: auto"><span id="scoreSpan"></span>
        </div>
    </div>

    <form action="${base}/employee/comment/list.do">
        <input type="hidden" name="employeeId" id="employeeId" value="${employeeDO.id}"/>
        <input type="hidden" name="page" id="page"/>
    </form>

    <!-- 评价区域 -->
    <div class="block block_com mb10" style="padding-top: 30px">
        <div class="title">
            <h2>用户评价
                <em> (${pageView.totalrecord}) </em>
            </h2>
            <em><span><a id="addComment" class="c_red">我要评论</a></span></em>
        </div>

        <div class="commentinfo">
            <div class="comcon">

            <#list pageView.records as employeeComment>
                <!-- 用户评价内容 -->
                <div class="com-bar-top clearfix">
                    <div class="utel">${employeeComment.userName}</div>
                    <div class="ustar">
                        <div data-star="98.0"></div>
                    </div>
                </div>

                <div class="pjcon">${employeeComment.comment}</div>
                <!-- 订单创建相关内容 -->
                <div class="utime"><span>${employeeComment.created?string('yyyy-MM-dd HH:mm:ss')}</span><span></span>
                </div>
                <div>

                    <div class="po-cmt">
                        <div class="po-hd">
                            <p class="post">
                                <#list employeeComment.images as image>
                                    <img class="list-img" src="${image}"/>
                                </#list>
                            </p>
                        </div>
                    </div>

                </div>
                <hr style="height:1px;border:none;border-top:1px dashed #0066CC;"/>
            </#list>
            </div>
        </div>
    </div>
<#include "../../share/paging.ftl" >
</div>
<#include "/common/foot.ftl" >
<script>
    $(document).ready(function () {
        /*调起大图 S*/
        var mySwiper = new Swiper('.swiper-container2', {
            loop: false,
            pagination: '.swiper-pagination2',
        })
        $("#list").on("click", ".post img",
                function () {
                    var imgBox = $(this).parents(".post").find("img");
                    var i = $(imgBox).index(this);
                    $(".big_img .swiper-wrapper").html("")

                    for (var j = 0, c = imgBox.length; j < c; j++) {
                        $(".big_img .swiper-wrapper").append('<div class="swiper-slide"><div class="cell"><img src="' + imgBox.eq(j).attr("src") + '" / ></div></div>');
                    }
                    mySwiper.updateSlidesSize();
                    mySwiper.updatePagination();
                    $(".big_img").css({
                        "z-index": 1001,
                        "opacity": "1"
                    });
                    mySwiper.slideTo(i, 0, false);
                    return false;
                });

        $(".big_img").on("click",
                function () {
                    $(this).css({
                        "z-index": "-1",
                        "opacity": "0"
                    });

                });
    });
    /*调起大图 E*/


</script>
</body>
</html>