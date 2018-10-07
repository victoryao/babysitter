<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="format-detection" content="telephone=no" />
    <meta content="email=no" name="format-detection" />
    <title>预约下单</title>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <base target="_blank">
    <link rel="dns-prefetch" href="//static.daojia.com" >
    <link rel="dns-prefetch" href="//images.daojia.com" >
    <link rel="dns-prefetch" href="//track.daojia.com" >

    <link rel="shortcut icon" type="image/x-icon" href="//static.daojia.com/assets/project/pc/resource/favicon.ico" >
    <link rel="stylesheet" type="text/css" href="//static.daojia.com/fe/h5/dj_h5/widget/h5-menu/djapp_widget_menu_h5_8419b04.css">


    <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkglayout/frame_18092619.css">


    <!-- <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/layout/frame_a12f5c5.css">-->



    <!-- <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/order/order_8bc50eb.css"> -->
    <link rel="stylesheet" href="//static.daojia.com/pt/project/h5-user/pkg/order/order_18092619.css">



</head>

<body data-pagetype="order">




<div class="wrapper-order" id="wrapper-order">
    <div class="title-bar">
        线上支付金额将作为唯一的售后保障凭据，请勿线下支付。
    </div>
    <!--表单信息 - 上门-->
    <div class="order-form">

        <!--未选地址-->
        <div class="of-enter of-enter-addr" >
            <i class="icon iconfont icon-Add"></i>
            <div class="addr-box">
                <div class="txt">选择服务地址</div>

            </div>
            <i class="icon iconfont icon-arrow"></i>

        </div>

        <div class="of-enter of-enter-time">
            <i class="icon iconfont icon-time"></i>
            <div class="txt-l">服务时间</div>
            <div class="txt-r">
                <div class="time">

                    <span>请选择上门时间</span>
                </div>
                <div class="time-tip" style="display:none">订单高峰日期只保证当天送达</div>
            </div>
            <i class="icon iconfont icon-arrow"></i>
        </div>
        <div class="mail-border"></div>
    </div>

    <dl class="remark-cell remark-top" data-type="top">
        <dt>留言</dt>
        <dd class="normal empty">文字留言或上传图片留言</dd>
    </dl>
    <!--店铺信息-->
    <div class="shop-block">
        <div class="sp-1px">
            <div class="sp-name">点到</div>
        </div>
        <div class="sp-info">
            <div class="sp-info-inner">
                <div class="sp-logo">
                    <img src="https://images.daojia.com/dop/custom/b88572d28c3f4fa9abbdea1116888bcc.png@246w_246h_1e_1c" />
                </div>
                <div class="sp-tit">深度全身理疗/90分钟</div>
                <!-- 无规格项，把这块隐藏调 -->
                <div class="spec-info" style="display:none;"></div>
                <div class="sp-tag">
							<span class="tag-s2">
																	上门服务
															</span>
                    <span class="tag-s2 tag-s2-limit">限购5件</span>
                    <span class="tag-s2 active-tag">特惠</span>

                </div>
                <div class="sp-price">
                    <div class="item-price">
                        <span class="price-num"></span>
                        <em class="ori-price"></em>
                    </div>
                    <div class="sp-tag item-tag"><span>一口价</span></div>
                    <!--这个是通用功能的组件-->
                    <div class="num-ctrl">
                        <div class="btn btn-sub"></div>
                        <div class="num">1</div>
                        <div class="btn btn-add"></div>
                    </div>
                </div>
                <!--价格超出提示-->
                <div class="sp-tip">
                    <div class="sp-tip-inner"></div>
                </div>


            </div>
        </div>

        <!-- 限制价格300元提示 -->
        <div class="limit-price-tip">每洞疏通总费用不高于300元，高于300元请勿支付。</div>

        <div class="custom-block guarantee-service" style="display:none">
            <div class="custom-block-item guarantee border-top">
                <div class="main">
                    <div class="title">保障</div>
                    <div class="content">
                        <ul class="guarantee-service-list clearfix">
                            <li class="guarantee-service-item bzfw" style="display: none;">标准服务</li>
                            <li class="guarantee-service-item cdp" style="display: none;">迟到赔</li>
                            <li class="guarantee-service-item nomore" style="display: none;">明码标价</li>
                        </ul>
                    </div>
                    <span class="more-icon"></span>
                </div>

            </div>
        </div>

        <!-- 到家宝等 -->
        <div class="custom-block wxb-item" style="display:none">
            <div class="custom-block-item border-top">
                <div class="main">
                    <div class="title">安全保障</div>
                    <div class="content">服务中发生意外可理赔（商家送）</div>
                    <span class="more-icon"></span>
                </div>
            </div>
        </div>

        <!-- 爽约费 -->
        <!-- -->

    </div>

    <!-- 总价，优惠劵，留言栏 -->
    <div class="coupons-block">
        <!-- 总价 -->
        <div class="total-price">
            <div class="total-price-inner">
                <div class="total-price-title medium">订单总价</div>
                <div class="total-price-txt">¥<span></span></div>
            </div>
        </div>
        <!-- 活动价已优惠 -->
        <div class="active-price" style="display:none">
            <div class="active-price-inner">
                <div class="active-price-title medium">活动优惠</div>
                <div class="active-price-txt">-¥<span></span></div>
            </div>
        </div>
        <!-- 商家券 -->
        <div class="shop-coupons-tiem">
            <div class="coupons-tiem-title medium">商家优惠</div>


            <!-- 暂无可用 -->

            <!-- (不可与会员卡折扣共用)  -->
            <div class="coupons-tiem-txt">
                <span class="special-sty"></span>

                <span class="medium"></span>


            </div>
            <!-- 显示优惠劵 张数-->
            <div class='coupons-tiem-icon'></div>
        </div>
        <!-- 平台优惠劵入口 -->
        <div class="coupons-tiem">
            <div class="coupons-tiem-title medium">平台优惠</div>


            <!-- 暂无可用 -->

            <!-- (不可与会员卡折扣共用)  -->
            <div class="coupons-tiem-txt">
                <span class="special-sty"></span>

                <span class="medium"></span>


            </div>
            <!-- 显示优惠劵 张数-->
            <div class='coupons-tiem-icon'></div>
        </div>
        <!-- 留言 -->
        <dl class="remark-cell remark-normal" data-type="normal">
            <dt>留言</dt>
            <dd class="normal empty">文字留言或上传图片留言</dd>
        </dl>
    </div>

    <!--阅读协议-->
    <div class="agreement" style="display:none">
        <i class="icon"></i>
        <!--<i class="icon iconfont icon-agree"></i>-->
        <p>已阅读并同意
            <a href="javascript:;">《58到家用户协议》</a>
        </p>
    </div>

    <!--温馨提示-->
    <div class="block-tips">
        <div class="tit">温馨提示</div>
        <div class="con">
            <ol>
                <li><span class="c-red">请仔细核对您填写的手机号，</span>并保持电话畅通，商家会在服务开始前与此号码沟通服务具体事宜</li>
                <li>您的退款，赔偿处理均以线上交易的订单金额作为唯一有效凭证<span class="c-rule">《58到家平台争议处理规则》</span></li>
                <li>支付时可使用代金券（仅限使用一张）、会员卡</li>
                <li>发票由商家提供</li>

                <li class="banjia-tip" style="display:none"><span class="c-red " >在线完成搬家订单即送清洁券</span></li>

            </ol>
        </div>
    </div>

    <!--底部预付须知提示-->



    <div class="bar-pay">
        <div class="box">

            <div class="pay">
								<span class="pay-txt">
																			待支付
																	</span>
                <span class="pay-unit">¥</span>
                <span class="pay-price"></span>
                <span class="pay-tip">(已优惠¥99)</span>
                <p class="use-info">支付时使用卡/券，最多可节省80元</p>
            </div>
            <!--<div class="tips">支付时使用卡/券，最多可节省80元</div>-->
            <div class="btn btn-pay btn-pay-order">去支付</div>


        </div>
    </div>

</div>
<!-- 预付须知弹窗 -->
<div id="pre_info" style="display: none">
    <div class="content">
        <div class="title">预付须知</div>
        <ul class="desc">
            <li>本订单的全部费用需在实际服务时确认，请仔细阅读服务详情内的收费标准</li>
            <li>若产生额外费用请在订单页面进行支付</li>
            <li>为保障您的权益请通过58到家完成交易</li>
        </ul>
        <div class="know">我知道了</div>
    </div>
</div>
<!-- 温馨提示 -->
<div class="pop_alert" id="errmsgbox">
    <div class="popbox">
        <div class="popcon">
            <div class="tit" id="tips">温馨提示</div>
            <div class="con">
                <p id="errmsg"></p>
            </div>
        </div>
        <a href="javascript:void(0);" id="ok" class="onebtn" id="iknow">我知道了</a>
    </div>
</div>

<div class="pop_alert" id="errmsgbox_stock">
    <div class="popbox">
        <div class="popcon">
            <div class="tit">温馨提示</div>
            <div class="con">
                <p id="tipsText"></p>
            </div>
        </div>
        <a href="javascript:void(0);" id="haode" class="onebtn">我知道了</a>
    </div>
</div>

<!-- alert弹窗 验证-->
<div class="pop-alert" id="pop-alert-ver" style="display:none">
    <div class="box">
        <div class="title pop-alert-ver-title"></div>
        <div class="pa-form">
            <div class="bar-input bar-ver-pic">
                <div class="input-box">
                    <input id="imgCodeInput" type="tel" placeholder="图片验证码" maxlength="4" value=""/>

                    <!--建议不做这个清除图标注，比较麻烦-->
                    <!--<div class="btn-close"><i class="icon"></i></div>-->
                </div>
                <img id="imgCode" src="" alt="图片验证码" />
            </div>
            <div class="tips-error tip-bar tip-err" style="display: none">图片验证码错误</div>

            <div class="bar-input bar-ver-voice">
                <div class="input-box">
                    <input id="input-box-voice-val" class="input-box-voice-val" type="tel" placeholder="验证码" maxlength="4" value=""/>
                </div>
                <div class="voice-code-get ver-txt ver-tip">获取语音验证码</div>
                <div class="voice-code-timer ver-txt ver-time left-time" style="display: none"></div>
                <div class="voice-code-reget ver-txt ver-tip" style="display: none">重新获取</div>
            </div>
            <div class="tip-bar tip-err tip-err-voice" style="display: none;">语音验证码错误</div>
            <div class="tip-bar tip-bar-text"></div>

            <div class="btn-one btn-one-submit btn-disabled">提交</div>
        </div>
        <div id="btn-close-win" class="btn-close"><i class="icon"></i></div>
    </div>
</div>		<div class="pop-alert" id="pop-standard-servive" style="display:none">
    <div class="standard-servive-box">
        <div class="servive-title">特别提醒</div>
        <p class="servive-text">
            您预约的服务为58到家标准服务。商家承诺，检测维修前告知您方案及费用，并与您协商确认是否继续服务。若您不同意，可要求商家停止服务，并免费恢复原貌，服务停止后，商家与您协商收取的费用并达成一致。商家未按以上承诺服务时，您可立即反馈至58到家核实解决。58到家客服专线 4008909358 转 0。
        </p>
        <div class="servive-btn">我知道了</div>
    </div>
</div>
<!-- alert弹窗 验证-->
<div class="pop-alert" id="pop-alert-tip" style="display:none">
    <div class="box">
        <div class="con">
            您下单过于频繁，请稍候再试
        </div>
        <div class="btn-bar btn-bar-two">
            <div class="btn">确定</div>
            <div class="btn">联系客服</div>
        </div>
    </div>
</div>





<!-- js -->



<script  src="//static.daojia.com/pt/project/h5-user/pkg/layout/frame_18092619.js"></script>


<!-- <script  src="//static.daojia.com/pt/project/h5-user/pkg/layout/frame_ae2cb75.js"></script> -->

<script>
    /* 加载 frame js */
    require(['page/layout/frame']);
</script>
<script src="//static-fe.daojia.com/assets/project/dj-location-js/djLocation.js" data-outlink type="text/javascript"></script>
<script src="//user.daojia.com/js/djpassport.js?v=201805142131" data-outlink type="text/javascript"></script>

<script  src="//static.daojia.com/pt/project/h5-user/pkg/layout/common_18092619.js"></script>


<script  src="//static.daojia.com/pt/project/h5-user/pkg/layout/common_2b3d7a1.js"></script>
<script>
    require(['page/layout/front']);
</script>

<script src="//static.daojia.com/isdfe/coupon2.0/src/ordercoupon/common.js?v=20180926200913" type="text/javascript"></script>
<!-- <script  src="//static.daojia.com/pt/project/h5-user/pkg/order/order_6bb79ee.js"></script> -->

<script  src="//static.daojia.com/pt/project/h5-user/pkg/order/order_18092619.js"></script>

<script>
    require(['page/order/order']);
</script>

</body>
</html>