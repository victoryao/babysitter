<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN" style="font-size: 19px;">
<head>
    <base id="base" href="${base}">
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description"
          content="北京新手妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新手妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>
    <title>新手妈咪-${employeeDO.name}阿姨简历</title>
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <#--<script type="text/javascript" src="${base}/js/rem.js"></script>-->
    <script type="text/javascript" src="${base}/js/swiper.min.js"></script>
    <script type="text/javascript" src="http://res2.wx.qq.com/open/js/jweixin-1.4.0.js"></script>

    <link rel="stylesheet" href="${base}/css/normalize.min.css">
    <link rel="stylesheet" href="${base}/css/promote-style.css">
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <link rel="stylesheet" href="${base}/css/resume.css">
    <link rel="stylesheet" href="${base}/css/ucenter.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/main.im.css"/>
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/next-footer.css">
    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/detail.css">
    <link rel="stylesheet" href="${base}/css/app.css">


    <script>

        wx.ready(function () {

            wx.onMenuShareAppMessage({
                title: '${employeeDO.name}', // 分享标题
                imgUrl: '${employeeDO.photo}',
                desc: '新手妈咪-${employeeDO.name}阿姨简历',
                success: function () {
                    // 用户确认分享后执行的回调函数
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareTimeline({
                title: '${employeeDO.name}', // 分享标题
                imgUrl: '${employeeDO.photo}',
                desc: '新手妈咪-${employeeDO.name}阿姨简历',
                success: function () {
                    // 用户确认分享后执行的回调函数
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

        });

        wx.config({
            debug: false,
            appId: '${pay.appId}',
            timestamp: '${pay.timeStamp}',
            nonceStr: '${pay.nonceStr}',
            signature: '${pay.paySign}',
            jsApiList: [
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo',
                'onMenuShareQZone'
            ]
        });

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
    <div align="center"><img src="${employeeDO.photo}" alt="" width="250px" height="250px"></div>
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

<!-- 底部栏 -->
<div class="footbar">
    <div class="foo_s2">
        <a href="" class="btn_min btn_contact modal__trigger" data-modal="#modal2">联系客服</a>

        <a href="${base}/app/to/babysitter.do?eId=${employeeDO.id}&loc=home"
           class="btn_order" id="nextstep">
            立即预约
        </a>
    </div>
</div>

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
<script type="text/javascript" src="${base}/js/index.js"></script>
</body>
</html>