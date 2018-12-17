<!DOCTYPE html>
<#assign base=request.contextPath />
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta content="email=no" name="format-detection"/>
    <title>预约下单</title>
    <base id="base" href="${base}">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no"/>
    <meta content="email=no" name="format-detection"/>

    <title>下单支付</title>
    <meta name="description"
          content="北京新手妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新手妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <meta name="applicable-device" content="mobile">

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>


    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">

    <link rel="stylesheet" type="text/css"
          href="${base}/css/orderlocation.css">


    <link rel="stylesheet" type="text/css"
          href="//static.daojia.com/fe/h5/dj_h5/widget/h5-menu/djapp_widget_menu_h5_8419b04.css">


    <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkglayout/frame_18092619.css">


    <!-- <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/layout/frame_a12f5c5.css">-->


    <!-- <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/order/order_8bc50eb.css"> -->
    <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/order/order_18092619.css">

    <script>
        $(document).ready(function () {

            var price = $("#price").val();
            var coupon = $("#coupon").val();
            var realPrice = $("#realPrice").val();
            $("#priceSpan").html(price / 100 + "元");
            $("#couponSpan").html(coupon / 100 + "元");
            $("#realPriceSpan").html("¥" + realPrice / 100 + "元");

            $("#toPay").click(function () {

                var address = $("#address").val();
                var tel = $("#tel").val();
                var name = $("#name").val();
                var idcard = $("#idcard").val();
                var activityType = $("#activityType").val();

                $("#toPay").attr("href", "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx408ebb6c68b9d640&redirect_uri=http%3a%2f%2fwww.newmami.cn%2fapp%2fshop%2fpay.do%3fphone%3d" + tel + "%26address%3d" +
                        address + "%26name%3d" + name + "%26idcard%3d" + idcard + "&response_type=code&scope=snsapi_base&state=${shopActivityDO.id}#wechat_redirect"
                )
                ;

                if (activityType != 8) {
                    if ($.trim(address) == "" || $.trim(tel) == "") {
                        alert("地址和手机号不能为空");
                        return false;
                    }
                } else {
                    if ($.trim(name) == "" || $.trim(idcard) == "") {
                        alert("姓名和身份证不能为空");
                        return false;
                    }
                }

                return true;

            });
        });
    </script>
</head>

<body data-pagetype="order">


<div class="wrapper-order" id="wrapper-order">
    <div class="title-bar">
        线上支付金额将作为唯一的售后保障凭据，请勿线下支付。
    </div>
    <!--表单信息 - 上门-->
    <div class="order-form">

        <div data-v-7f1fb524="" class="save-address-wrap">

        <#if shopActivityDO.type != 8>
            <div data-v-7f1fb524="" class="contacts user-info">
                <span data-v-7f1fb524="">服务地址</span>
                <input data-v-7f1fb524="" placeholder="上门服务地址" id="address" type="text">
            </div>
        </#if>

            <div data-v-7f1fb524="" class="contacts user-info">
                <span data-v-7f1fb524="">手机号</span>
                <input
                        data-v-7f1fb524="" placeholder="手机号码" maxlength="11" type="tel" id="tel" value="${phone}"></div>

        <#if shopActivityDO.type == 8>

            <div data-v-7f1fb524="" class="contacts user-info">
                <span data-v-7f1fb524="">姓名</span>
                <input data-v-7f1fb524="" placeholder="身份证姓名" id="name" type="text" maxlength="8" >
            </div>

            <div data-v-7f1fb524="" class="contacts user-info">
                <span data-v-7f1fb524="">身份证号</span>
                <input data-v-7f1fb524="" placeholder="身份证号" id="idcard" maxlength="18" type="tel">
            </div>

        </#if>

        </div>

        <div class="mail-border"></div>
    </div>


    <!--店铺信息-->
    <div class="shop-block">
        <div class="sp-info">
            <div class="sp-info-inner">
                <div class="sp-logo">
                    <img src="${shopActivityDO.img}"/>
                </div>
                <div class="sp-tit">${shopActivityDO.name}</div>
                <!-- 无规格项，把这块隐藏调 -->
                <div class="spec-info" style="display:none;"></div>
                <div class="sp-tag">
                    <span class="tag-s2">上门服务</span>
                    <span class="tag-s2 tag-s2-limit">限购1件</span>
                    <span class="tag-s2 active-tag">特惠</span>

                </div>
                <div class="sp-price">
                    <div class="item-price">
                        <span class="price-num"></span>
                        <em class="ori-price"></em>
                    </div>
                    <div class="sp-tag item-tag"><span>一口价</span></div>
                </div>

            </div>
        </div>


        <!-- 总价，优惠劵，留言栏 -->
        <div class="coupons-block">
            <!-- 总价 -->
            <div class="total-price">
                <div class="total-price-inner">
                    <div class="total-price-title medium">订单总价</div>
                    <div class="total-price-txt">¥<span id="priceSpan"></span></div>
                </div>
            </div>
            <!-- 活动价已优惠 -->
            <div class="active-price">
                <div class="active-price-inner">
                    <div class="active-price-title medium">优惠券</div>
                    <div class="active-price-txt">-¥<span id="couponSpan">${coupon}</span></div>
                </div>
            </div>
            <input type="hidden" id="price" value="${price}">
            <input type="hidden" id="coupon" value="${coupon}">
            <input type="hidden" id="realPrice" value="${realPrice}">
            <input type="hidden" id="activityType" value="${shopActivityDO.type}">

        </div>

    </div>

    <!--温馨提示-->
    <div class="block-tips">
        <div class="tit">温馨提示</div>
        <div class="con">
            <ol>
                <li><span class="c-red">请仔细核对您填写的手机号，</span>并保持电话畅通，商家会在服务开始前与此号码沟通服务具体事宜</li>
                <li>您的退款，赔偿处理均以线上交易的订单金额作为唯一有效凭证</li>
                <li>支付时可使用代金券（仅限使用一张）、会员卡</li>
                <li>发票由商家提供</li>
            </ol>
        </div>
    </div>

    <div class="bar-pay">
        <div class="box">

            <div class="pay"><span class="pay-txt">待支付</span>
                <span class="pay-unit" id="realPriceSpan">¥${realPrice}</span>
            </div>

            <div class="btn btn-pay btn-pay-order">
                <a id="toPay">去支付</a>
            </div>

        </div>
    </div>

</div>


</body>
</html>