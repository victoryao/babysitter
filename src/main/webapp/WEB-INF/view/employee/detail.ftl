<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description"
          content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <title>快乐妈咪-${employeeDO.name}阿姨简历</title>
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/rem.js"></script>
    <script type="text/javascript" src="${base}/js/swiper.min.js"></script>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <link rel="stylesheet" href="${base}/css/resume.css">
    <link rel="stylesheet" href="${base}/css/ucenter.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/main.im.css"/>
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/detail.css">
    <link rel="stylesheet" href="${base}/css/app.css">

    <script>
        $(document).ready(function () {
            var token = $.cookie('kl_token');
            $("#accessToken").val(token);
            $("#addComment").attr("href", "${base}/employee/${employeeDO.id}/to/comment/add.do?accessToken=" + token);
        });

        $(function () {
            var element = $("div[class='new-comment-content']");
            var temp = element.text().replace(/\n/g, '<br/>');
            element.html(temp);
        });
    </script>

</head>
<body>
<div class="resume">
    <div align="center"><img src="/imgs/${employeeDO.photo}" alt="" width="250px" height="250px"></div>
    <div class="field">
        <h1 class="title title_phone stonefont">${employeeDO.name}（女）
        </h1>
    </div>
    <div class="field">
        <h2 class="field-title">基本资料</h2>
        <dl>
            <dt>姓名：</dt>
            <dd class="stonefont">${employeeDO.name}</dd>
        </dl>
        <dl>
            <dt>生日：</dt>
            <dd>${employeeDO.birthday?string('yyyy-MM-dd')}</dd>
        </dl>
        <dl>
            <dt>入行时间:</dt>
            <dd>${employeeDO.startDate?string('yyyy-MM-dd')}</dd>
        </dl>
        <dl>
            <dt>籍贯:</dt>
            <dd>
            <#if employeeDO.hometown?length gt 6>${employeeDO.hometown?substring(0,6)}...
            <#else>${employeeDO.hometown!}
            </#if></dd>
        </dl>
    </div>
    <!--我的亮点-->
    <div class='field'><h2 class='field-title'>个人技能</h2>
        <ul class='tags-list'>
        <#if (employeeDO.skill?contains("1"))!>
            <li>辅食添加</li></#if>
        <#if (employeeDO.skill?contains("2"))!>
            <li>月子餐</li></#if>
        <#if (employeeDO.skill?contains("3"))!>
            <li>手指操</li></#if>
        <#if (employeeDO.skill?contains("4"))!>
            <li>早教</li></#if>
        <#if (employeeDO.skill?contains("5"))!>
            <li>产后修复</li></#if>
        </ul>
        <p></p></div>

    <!--我的亮点-->
    <div class='field'><h2 class='field-title'>个人证件</h2>
        <ul class='tags-list'>

        <#list courseOrders as courseOrder>
            <li>${courseOrder.courseName}</li>
        </#list>

        </ul>
        <p></p>
    </div>
    <!--求职意向-->
    <div class="field">
        <h2 class="field-title">求职意向</h2>
        <dl>
            <dt>期望薪资：</dt>
            <dd class="stonefont">${employeeDO.salary}</dd>
        </dl>
        <dl>
            <dt>期望职位：</dt>
            <dd>
            <#if (employeeDO.types?contains("1"))!>月嫂</#if>
            <#if (employeeDO.types?contains("3"))!> 育儿嫂</#if>
            </dd>
        </dl>
    </div>
    <!--工作经验-->
    <div class="field">
        <h2 class="field-title">个人简介</h2>
        <div class="new-comment-content">
        ${employeeDO.introduce}
        </div>
    </div>


    <!-- 评价区域 -->
    <div class="block block_com mb10">
        <div class="title">
            <h2>用户评价
                <em> (共${commentCount}条评论 评分：${employeeDO.score}分) </em>
            </h2>
            <em><span><a id="addComment" class="c_red">我要评论</a></span></em>
        </div>
        <div class="commentinfo">
        <div class="comcon">

        <#list employeeComments.resultlist as employeeComment>
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
                                <img class="list-img" src="${image}">
                            </#list>
                        </p>
                    </div>
                </div>
            </div>
            <hr style="height:1px;border:none;border-top:1px dashed #0066CC;"/>
        </#list>

        <#if commentCount gt 3>
            <!-- 查看更多按钮 -->
            <a href="${base}/employee/comment/list.do?employeeId=${employeeDO.id}">
                <div id="showMore" class="btn-all-com">
                    查看全部评价
                </div>
            </a>
        </div>
        </#if>
        </div>
    </div>

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