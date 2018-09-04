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
          content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <meta name="applicable-device" content="mobile">

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">

    <link rel="stylesheet" href="${base}/css/shop_frame.css">
    <link rel="stylesheet" href="${base}/css/common.css">
    <link rel="stylesheet" href="${base}/css/getTicketPopup.css" data-outlink>
    <link rel="stylesheet" href="//static.daojia.com/assets/project/dj-m/pkg/detail/detail_2595ae0.css">
    <script>
        $(document).ready(function () {
            var price = $("#price").val();
            $("#priceSpan").html(price / 100 + "元");
        });
    </script>

</head>

<body data-pagetype="serveDetail">


<input type="hidden" id="price" value="${shopActivityDO.realPrice}">

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
                        <span class="showPricek" id="priceSpan"></span>
                    </div>
                    <div class="tags">
                        <span class="tag_hot">${shopActivityDO.discount}折</span>
                    </div>
                </div>

                <div style="padding: 5px">
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

<#--<div class="get-coupon  mb10 enterbar">-->
<#--<div class="lbox">领券</div>-->
<#--<div class="coupon">-->
<#--<span><i class="circle_left"></i>10元通用券<i class="circle_right"></i></span>-->
<#--<i></i>-->
<#--</div>-->
<#--<i class="coupon_count">共1张</i>-->
<#--<i class="more"></i>-->
<#--</div>-->

    <!-- 评价区域 -->
<#--<div class="block block_com mb10">-->
<#--<div class="title">-->
<#--<h2>用户评价-->
<#--<em> (120) </em>-->
<#--</h2>-->
<#--<em><span class="c_red">98.33%</span>好评</em>-->
<#--</div>-->
<#--<div class="commentinfo">-->
<#--<div class="comcon">-->
<#--<!-- 评价标 &ndash;&gt;-->
<#--<div class="saytags">-->
<#--<span data-tagId="135">上门快<em>10</em></span>-->
<#--<span data-tagId="137">态度好<em>7</em></span>-->
<#--<span data-tagId="136">帮忙清理垃圾<em>5</em></span>-->
<#--<span data-tagId="133">非常专业<em>5</em></span>-->
<#--<span data-tagId="134">价格合理<em>4</em></span>-->
<#--<span data-tagId="139">有收据<em>3</em></span>-->
<#--</div>-->
<#--<!-- 用户评价内容 &ndash;&gt;-->

<#--<div class="com-bar-top clearfix">-->
<#--<div class="utel">151****7134</div>-->
<#--<div class="ustar">-->
<#--<div data-star="98.0"></div>-->
<#--</div>-->
<#--</div>-->
<#--<div class="pjcon">态度太差了，我坚持线上付款，工作人员就不高兴了，说什么一般不走线上，没有确认的权限，打了商家电话，最后线上付款，工作人员很生气地说“没见过我这样的人”，我还一肚子火呢-->
<#--</div>-->
<#--<!-- 订单创建相关内容 &ndash;&gt;-->
<#--<div class="utime"><span>2018.08.11 19:26</span><span>服务方式：上门服务</span></div>-->
<#--<!-- 查看更多按钮 &ndash;&gt;-->
<#--<div id="showMore" class="btn-all-com">查看全部评价</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->


    <!-- 服务报价区 报价单 -->

    <!-- 服务详情区域 -->
    <div class="block block_detail mb10">
        <div class="title border-b"><h2>服务详情</h2></div>
        <div class="con_u">
            <p>
                <img src="${shopActivityDO.img}"/>
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
                <li class="yyxz-dd-xy">使用快乐妈咪平台前，请充分了解并同意《快乐妈咪用户协议》。交易前充分沟通，明确包括但不限于服务项、金额、服务时间等具体细节。</li>
                <li class="yyxz-dd-wq">快乐妈咪平台服务由第三方提供，强烈建议您在到家平台通过在线支付完成所有交易，并保留相应的证据以利于售后维权。</li>
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
            <a href="javascript:;" class="btn_min btn_contact">联系客服</a>
            <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx679b7a7176d86d5b&redirect_uri=http%3a%2f%2fwww.klmami.cn%2fapp%2fshop%2fpay.do&response_type=code&scope=snsapi_base&state=${shopActivityDO.id}#wechat_redirect"

            <#--"${base}/shop/pay.do" -->

               class="btn_order" id="nextstep">
                立即支付
            </a>
        </div>
    </div>

</body>
</html>