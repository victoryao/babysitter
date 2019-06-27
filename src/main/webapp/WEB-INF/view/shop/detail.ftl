<!DOCTYPE html>
<#assign base=request.contextPath />
<html lang="zh">
<head data-gc="">
    <base id="base" href="${base}">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta content="email=no" name="format-detection"/>

    <title>${shopActivityDO.name}</title>
    <meta name="description"
          content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="ZbacBBPSZU"/>

    <meta name="applicable-device" content="mobile">

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${base}/js/tabulous.js"></script>
    <script type="text/javascript" src="http://res2.wx.qq.com/open/js/jweixin-1.4.0.js"></script>

    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">

    <link rel="stylesheet" href="${base}/css/shop_frame.css">
    <link rel="stylesheet" href="${base}/css/common.css">
    <link rel="stylesheet" href="${base}/css/getTicketPopup.css" data-outlink>
    <link rel="stylesheet" href="//static.daojia.com/assets/project/dj-m/pkg/detail/detail_2595ae0.css">
    <link rel="stylesheet" href="${base}/css/normalize.min.css">
    <link rel="stylesheet" href="${base}/css/promote-style.css">
    <link rel="stylesheet" href="${base}/css/tab-style.css">

    <style>
        .centerdiv {
            display: table-cell;
            vertical-align: middle;
            text-align: center;
            display: table-cell;
        }
    </style>
    <script>

        $(document).ready(function () {

            var token = $("#accessToken").val();
            if (token != '') {
                $.cookie('kl_token', '${token}', {expires: 120, path: '/'});
            }

            token = $.cookie('kl_token');
            if (token != '') {
                $.get("${base}/activity/is/join.do", {
                    activityId: '${shopActivityDO.id}',
                    accessToken: '${token}'
                }, function (data) {
                    if (data) {
                        $("#nextpay").text("已报名");
                        $("#nextpay").on("click", function () {
                            return false;
                        });

                    }
                });
            }

        });

        wx.ready(function () {

            wx.onMenuShareAppMessage({
                title: '${shopActivityDO.name}', // 分享标题
                imgUrl: '${shopActivityDO.img}',
                desc: '${shopActivityDO.desc}',
                success: function () {
                    // 用户确认分享后执行的回调函数
                },
                cancel: function () {
                    // 用户取消分享后执行的回调函数
                }
            });

            wx.onMenuShareTimeline({
                title: '${shopActivityDO.name}', // 分享标题
                imgUrl: '${shopActivityDO.img}',
                desc: '${shopActivityDO.desc}',
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
            $('#tabs').tabulous();
            $("#atabs-1").click();
            var price = $("#price").val();
            var oldPrice = $("#oldPrice").val();
            $("#priceSpan").html(price / 100 + "元");
            $("#oldPriceSpan").html("原价：<s>" + oldPrice / 100 + "元</s>");

            $(".tab").click(function () {
                var aId = $(this).attr("title");
                $("#activityId").val(aId);
                var price = $(this).find(".childRealPrice").val();
                var oldPrice = $(this).find(".childPrice").val();
                $("#priceSpan").html(price / 100 + "元");
                $("#oldPriceSpan").html("原价：<s>" + oldPrice / 100 + "元</s>");
                aId = $("#activityId").val();
                if ($("#transferType").val() == 0) {
                    $("#nextpay").attr("href", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fwww.newmami.cn%2fapp%2fshop%2fpay.do%3fredirectUrl%3d%2fshop%2factivity%2fdetail.do%3fid%3d" + aId + "&response_type=code&scope=snsapi_base&state=" + aId + "#wechat_redirect");
                } else if ($("#transferType").val() == 1) {
                    $("#nextstep").attr("href", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fnewmami.cn%2fapp%2fshop%2fto%2fpay.do%3fredirectUrl%3d%2fshop%2factivity%2fdetail.do%3fid%3d" + aId + "&response_type=code&scope=snsapi_base&state=" + aId + "#wechat_redirect");
                } else if ($("#transferType").val() == 2) {
                    $("#nextpay").attr("href", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fwww.newmami.cn%2fapp%2factivity%2fjoin.do%3fscope%3dsnsapi_userinfo%26id%3d" + aId + "%26redirectUrl%3d%2fshop%2factivity%2fdetail.do%3fid%3d" + aId + "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
                }

            });

        });
    </script>

</head>

<body data-pagetype="serveDetail">

<input type="hidden" id="price" value="${shopActivityDO.realPrice}">
<input type="hidden" id="oldPrice" value="${shopActivityDO.price}">
<input type="hidden" id="activityId" value="${shopActivityDO.id}">
<input type="hidden" id="transferType" value="${transferType}">
<input type="hidden" id="accessToken" value="${token}">

<div class="topbar-holder"></div>


<div class="wrapper-serve-detail" id="wrapper-serve-detail">

    <!-- 服务详情页title-bar-->
    <div class="title-bar">
        在线交易有保障！
    </div>
    <!-- 头部商家信息展示区 -->
    <div class="topinfo-box">
        <div class="topinfo">
            <div class="model-img1">
                <div class="look-img">

                    <img class="picone"
                         src="${shopDO.img}"/>
                </div>
                <div class="tit" style="padding: 5px"><h1 class="tit_custom">${shopActivityDO.name}</h1></div>

                <div class="price-box" style="padding: 5px">

                    <div class="price">
                        <span class="showPrice" id="priceSpan"></span>
                    </div>

                    <div class="tags">
                    <#if shopActivityDO.discount != 10>
                        <span class="tag_hot">${shopActivityDO.discount}折</span>
                        <span class="showPrice" id="oldPriceSpan"></span>
                    </#if>
                    </div>

                </div>

                <div style="padding: 5px"><br/>
                    地址：${shopDO.address}

                </div>

            </div>
            <div class="shop-info">
                <div class="ustar">
                    <div data-star="98.0"></div>
                </div>
                <div class="ustar-num">5</div>
                <div class="si-box-jd">接单率 100.0%</div>
            <#--<div class="si-box-ys">已售 121 </div>				-->
            </div>
        </div>

    </div>

    <!-- 促销保障区域 -->
    <div class="bzcx-box">
        <!--  保障  -->
        <div class="bar-bzcx">
            <div class="lbox">保障</div>
            <div class="rbox">
                <ul class="tags_fw clearfix">
                    <li class="oi_zz">资质认证</li>
                    <!-- 默认展示 -->
                    <li class="oi_sst">未服务随时退</li>
                    <!--添加商品标签根据不同的id进行展示-->
                    <li class="oi_bz">标准服务</li>
                    <li class="oi_wxbp">安全保障</li>
                </ul>
            </div>
        </div>
        <!--  促销  -->
    </div>




<#if shopActivityDO.isParent == 1>
    <div id="tabs">
        <ul>
            <#list children as child>
                <#if child_index == 0>
                    <li><a id="a${child.tab}" href="#${child.tab}" class="tab" title="${child.id}">
                        <input type="hidden" class="childRealPrice" value="${child.realPrice}">
                        <input type="hidden" class="childDiscount" value="${child.discount}">
                        <input type="hidden" class="childPrice" value="${child.price}">
                    ${child.name}</a></li>
                <#else>
                    <li><a id="a${child.tab}" href="#${child.tab}" class="tab" title="${child.id}">
                        <input type="hidden" class="childRealPrice" value="${child.realPrice}">
                        <input type="hidden" class="childDiscount" value="${child.discount}">
                        <input type="hidden" class="childPrice" value="${child.price}">
                    ${child.name}</a></li>
                </#if>
            </#list>
        </ul>
        <div id="tabs_container">

            <#list children as child>
                <div id="${child.tab}"
                     class="make_transist hidescale showscale centerdiv">
                    <#list child.images as img>
                        <img src="${img}">
                    </#list>
                </div>
            </#list>
        </div><!--End tabs container-->
    </div><!--End tabs-->
</#if>

    <!-- 服务详情区域 -->
    <div class="block block_detail mb10">
        <div class="title border-b">
            <h2>服务详情</h2></div>
        <div class="con_u">
            <p>
            ${shopActivityDO.desc}
            </p>
        <#list images as image>
            <p><img src="${image}"/></p>
        </#list>
        </div>
    </div>

    <div class="block block_detail mb10">
        <div class="title border-b"><h2>店铺详情</h2></div>
        <div class="con_u">
            <p>${shopDO.intro}</p>
            <p><img src="${shopDO.descImg}"/></p>

        </div>
    </div>

    <!-- 下单须知区域 -->
    <div class="block block_xzbz" style="padding-bottom: 30px">
        <div class="title title_event mb10 border-b">
            <h2>下单须知</h2>
        </div>
        <div class="con">
            <ol class="box-yyxz">
                <li class="yyxz-dd-xy">使用新新妈咪平台前，请充分了解并同意<a href="${base}/app/to/user/notice.do">《新新妈咪用户协议》</a>。交易前充分沟通，明确包括但不限于服务项、金额、服务时间等具体细节。
                </li>
                <li class="yyxz-dd-wq">新新妈咪平台服务由第三方提供，强烈建议您在到家平台通过在线支付完成所有交易，并保留相应的证据以利于售后维权。</li>
                <li class="yyxz-dd-lx">如遇服务质量问题，可进行<a class="xd_report">举报</a></li>
            </ol>
        </div>
    </div>

    <!-- 我再看看 -->

    <!-- 到底提示 -->
    <div class="foobar-tip-txt">没有更多啦~</div>
    <div class="spacing64"></div>
    <!-- 底部栏 -->
    <div class="footbar">
        <div class="foo_s2">
            <a href="" class="btn_min btn_contact modal__trigger" data-modal="#modal2">联系客服</a>

        <#if (transferType == 1)>
            <a class="btn_order"
               href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fnewmami.cn%2fapp%2fshop%2fto%2fpay.do%3fredirectUrl%3d%2fshop%2factivity%2fdetail.do%3fid%3d${shopActivityDO.id}&response_type=code&scope=snsapi_base&state=${shopActivityDO.id}#wechat_redirect"
               id="nextstep">
                立即预约
            </a>
        </#if>

        <#if (transferType == 0)>
            <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fwww.newmami.cn%2fapp%2fshop%2fpay.do%3fredirectUrl%3d%2fshop%2factivity%2fdetail.do%3fid%3d${shopActivityDO.id}&response_type=code&scope=snsapi_base&state=${shopActivityDO.id}#wechat_redirect"
               class="btn_order" id="nextpay">
                立即支付
            </a>
        </#if>

        <#if (transferType == 2)>
            <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fwww.newmami.cn%2fapp%2factivity%2fjoin.do&response_type=code&scope=snsapi_userinfo&connect_redirect=1&state=${shopActivityDO.id}#wechat_redirect"
               class="btn_order" id="nextpay">
                我要报名
            </a>
        </#if>

        </div>
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