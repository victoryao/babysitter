<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>支付收银台</title>


<#--<link rel="stylesheet" href="${base}/pay.css">-->

    <link rel="stylesheet" href="${base}/css/velvet.css">

    <link rel="stylesheet"
          href="//static.daojia.com/assets/project/universal_pay/styles/pay.e6d0250731944b2a599f889655c3d93a.css">

</head>


<body>
<div id="app"><!--v-start-->
    <div class="pay"> <!--fragment-start-->
        <div class="alert" role="alert"> 支付剩余时间 <span class="especial">12:09</span>
            <div class="inline icon-prompt">?</div><!--v-if--> </div><!--v-component--><!--fragment-end--><!--v-if-->
        <!--v-if--> <!--fragment-start-->
        <div> <!--v-if--> <!--fragment-start-->
            <div class="list-group-item">
                <div class="item">
                    <div class="item-main"><span class="order-name">订单总价</span> <!--v-if--> <!--v-if--> </div>
                    <div class="item-extend"><span class="order-price"> <!--fragment-start--> 179元 <!--fragment-end-->
                        <!--v-if-->  </span><!--v-if-->  </div>
                </div>
            </div><!--v-component--><!--fragment-end--><!--v-if-->  <!--v-if--> <!--v-if--> <!--fragment-start-->
            <!--fragment-start-->
            <div class="list-group-item">
                <div class="item">
                    <div class="item-main"><span class="order-name">预付金额</span> <!--v-if--> <!--v-if--> </div>
                    <div class="item-extend"><span class="order-price"> <!--fragment-start--> 179元 <!--fragment-end-->
                        <!--v-if-->  </span><!--v-if-->  </div>
                </div>
            </div><!--v-component--><!--fragment-end--><!--v-if--><!--fragment-end--><!--v-if--> <!--v-if--> <!--v-if-->
            <!--v-if--> <!--v-if--> <!--v-if--> <!--v-if--> <!--v-if--> <!--fragment-start--><!--v-if-->
            <!--fragment-end--><!--v-if--> <!--v-if--> </div><!--v-component--><!--fragment-end--><!--v-if-->
        <!--v-if--> <!--v-if--> <!--fragment-start-->
        <div class="channel-panel"> <!--v-for-start--><!--fragment-start--><!--fragment-start--><!--fragment-start-->
            <!--fragment-start-->
            <div class="list-group-item">
                <div class="item">
                    <div class="item-thumb">
                        <div class="ico-hollow"><img title="title"
                                                     src="//static.daojia.com/assets/project/universal_pay/images/alipay.png">
                            <!--v-if--> </div><!--v-if-->  </div>
                    <div class="item-main ">
                        <div class="item-hd"><h3>支付宝</h3> <span class="notes">活动期间首单随机立减，最高188元</span><!--v-if--> </div>
                        <div class="item-bd"><p>支付宝支付</p></div><!--v-if--> </div>
                    <div class="item-extend">
                        <div class="order-select">
                            <div class="ico-select active"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="dashboard">
            <div class="text-con">
                <div class="inline price-con"> <!--v-if-->
                    <div class="">还需支付: <strong class="order-focus"><span class="price">179</span>元</strong></div>
                </div><!--v-if-->  <!--v-if--> </div>
            <button type="button" class="btn btn-primary">确认支付</button>
        </div><!--v-component--> <!--v-if--> <!--v-if--> <!--v-if--> </div><!--v-if--> <!--v-end--><!--v-component-->
</div>


</body>
</html>
