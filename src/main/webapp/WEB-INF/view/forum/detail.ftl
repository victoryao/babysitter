<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta name="description"
          content="北京新手妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新手妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <title>新手妈咪</title>

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/rem.js"></script>
    <script type="text/javascript" src="${base}/js/swiper.min.js"></script>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/main.im.css"/>
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/detail.css">
    <link rel="stylesheet" href="${base}/css/swiper-3.4.0.min.css">
    <link rel="stylesheet" href="${base}/css/evaluateList.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/app.css">
    <link href="${base}/css/bootstrap.min.css" rel="stylesheet">
    <script language="javascript">
        //到指定的分页页面
        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }

        $(document).ready(function () {
            var token = $.cookie('kl_token');
            $("#accessToken").val(token);
            $("#fireForum").attr("href", "${base}/app/to/forum/${forumDO.id}/comment/add.do?accessToken=" + token);
        });

        $(function(){
            var element = $("div[class='new-comment-content']");
            var temp =  element.text().replace(/\n/g,'<br/>');
            element.html(temp);
        });

    </script>
</head>

<body class="fadeIn animated">
<div class="w-topbar no-invest m-widget">
    <div class="topbar-wrap">

        <a class="forumTitle">
            <span>新手社区</span>
        </a>

        <a id="fireForum" class="fireForum">
            <span>发评论</span>
        </a>
    </div>
</div>
<form action="${base}/forum/${forumDO.id}/detail.do?loc=forum">
    <input type="hidden" name="page" id="page"/>
</form>

<div class="topinfo-box">
    <div class="topinfo">
        <div>
            <div class="tit">
                <h1 class="tit_custom">${forumDO.title}</h1>

            </div>
            <div>
                <div>
                    <span>${customerDO.name}</span>
                    <span class="timeDiv">${forumDO.created?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
            </div>
        </div>
    </div>

    <div class="bzcx-box mb10">
        <div class="swiper-wrapper">
        </div>
    </div>

</div>


<div id="chooseSpecItem" class="bar_servertype mb10">

    <div class="new-comment-content">${forumDO.content}</div>

</div>

<div class="po-cmt">
    <div class="po-hd">
        <p class="post">
        <#list images as image>
            <img class="list-img" src="${image}">
        </#list>
        </p>
    </div>
</div>

<!-- 评价区域 -->
<div class="block block_com mb10">
    <div class="title">
        <h2>用户评价
        <#--<em> (292) </em>-->
        </h2>
    </div>

<#if hasComment >
    <div id="evaluate_list">
        <div class="commentinfo">
            <div class="comcon">

                <#list pageView.records as forumComment>
                    <div class="com-bar-top clearfix">
                        <div class="utel">${forumComment.userName}</div>
                        <div class="ustar">
                            <div data-star="98.0"></div>
                        </div>
                    </div>
                    <div class="pjcon">${forumComment.content}</div>
                    <!-- 订单创建相关内容 -->
                    <div class="utime"><span>${forumComment.created?string('yyyy-MM-dd HH:mm:ss')}</span></div>
                     
                    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;"/>

                </#list>
                <!-- 查看更多按钮 -->
            <#--<div id="showMore" class="btn-all-com">查看全部评价</div>-->
                <#include "../../share/paging.ftl" >
            </div>
        </div>
    </div>
<#else>
    <div id="evaluate_list">
        <div class="commentinfo">
            <div class="comcon">
                <div id="showMore" class="btn-all-com">暂无评价</div>
            </div>
        </div>
    </div>
</#if>
<#include "/common/foot.ftl" >
    <script>
        $(document).ready(function(){
            /*调起大图 S*/
            var mySwiper = new Swiper('.swiper-container2', {
                loop: false,
                pagination: '.swiper-pagination2',
            })
            $("#list").on("click", ".post img",
                    function() {
                        var imgBox = $(this).parents(".post").find("img");
                        var i = $(imgBox).index(this);
                        $(".big_img .swiper-wrapper").html("")

                        for(var j = 0 ,c = imgBox.length; j < c ;j++){
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
                    function() {
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