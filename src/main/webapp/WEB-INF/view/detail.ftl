<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8" />
    <title>商品详情页面</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1,minimum-scale=1,maximum-scale=1" />
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <link href="${base}/css/ratchet.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${base}/css/page.css" />
    <link rel="stylesheet" type="text/css" href="${base}/css/product.css" />
    <link rel="stylesheet" type="text/css" href="${base}/css/pro2.css" />
    <script src="${base}/js/flex.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="${base}/js/ratchet.min.js"></script>
</head>
<body>
<header class="bar bar-nav"> <a class="icon icon-left-nav pull-left"></a> <a class="icon icon-more-vertical pull-right"></a>
    <h1 class="title">商品详情</h1>
</header>
<div id="content">
    <div class="scroller">
        <div id="p-summary" class="page">
            <div class="container">
                <section id="s-showcase">
                    <div class="scroller">
                        <div class="itbox main"> <a class="item"> <img src="${base}/imgs/banner3.png" alt="" /> </a> </div>
                    </div>
                </section>
                <section id="s-from" class="mui-flex"> </section>
                <section id="s-title">
                    <div class="main">
                        <h1>森松尼T-M30有线电脑游戏鼠标USB台式笔记本发光大鼠标电竞家用</h1>
                    </div>
                    <div class="sub">
                        <div class="slogon"></div>
                    </div>
                </section>
                <section id="s-price"> <span class="mui-price big"> <i class="mui-price-rmb">&yen;</i> <span class="mui-price-integer">33.00 - 39.00</span> <span class="mui-price-decimal"></span> </span> </section>
                <section id="s-adds"> </section>
                <section id="s-hkDeliver"></section>
                <section class="itemExtraInfo"> </section>
                <section id="s-advantage" data-spm=""> </section>
                <div id="s-action-container">
                    <section id="s-action"> </section>
                </div>
                <section id="s-rate" data-spm=""> </section>
                <ul class="table-view">
                    <li class="table-view-cell" style="padding: 11px 6px 11px 15px;font-size: 18px;font-style:bold;color:#333;">规格选择 <span style="float: right;margin-right:10px;" class="icon icon icon-more clickwn"></span></li>
                </ul>
                <ul class="table-view" style="margin-top: 10px;">
                    <li class="table-view-cell media"> <a class=""> <img class="media-object pull-left" src="http://placehold.it/42x42" />
                        <div class="media-body"> 店铺名字
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore. Lorem ipsum dolor sit amet.</p>
                        </div>
                    </a> </li>
                </ul>
                <ul class="table-view" style="margin-top:10px;">
                    <li class="table-view-cell"> <a class="navigate-right" style="font-size: 18px;font-style:bold;color:#666;"> <span class="badge">共1485条</span> 用户评价 </a> </li>
                </ul>
                <div class="ipo">
                    <ul class="table-view">
                        <li class="table-view-cell media"> <a class="">
                            <div class="media-body"> 图文详情 </div>
                        </a> </li>
                    </ul>
                    <div class="leftc"> <img src="${base}/imgs/fengge.png" /> </div>
                    <div class="rightc">
                        <p style="margin-bottom: 0;"> <img src="${base}/imgs/51.png" /> </p>
                        <p> <img src="${base}/imgs/58.png" /> </p>
                    </div>
                </div>
                <!-- 弹出 -->
                <div class="flick-menu-mask" style=""></div>
                <div class="spec-menu">
                    <div class="spec-menu-content spec-menu-show" style="display: block;">
                        <div class="spec-menu-top bdr-b">
                            <div class="spec-first-pic"> <img id="spec_image" src="" /> </div>
                            <a class="rt-close-btn-wrap spec-menu-close">
                                <p class="flick-menu-close tclck"> <img src="${base}/imgs/close.png" width="24" height="24" /> </p>
                            </a>
                            <div id="specPlus" class="plus-price-wrap spec-plus-price-mtl" style="display: none">
                                <div class="plus-price-row">
                                    <div class="spec-jd-price"> <span class="plus-jd-price-title">京东价：</span> <span class="price-icon grey"></span> <span class="plus-jd-price-text" id="specJdPrice"> 36.80 </span> </div>
                                </div>
                                <div class="plus-price-row">
                                    <div class="spec-plus-price"> <span class="plus-member-price-title">会员价：</span> <span class="price-icon black"></span> <span class="plus-member-price-text" id="specPlusPrice"></span> <img class="plus-pri-icon" src="" /> </div>
                                </div>
                            </div>
                            <div class="spec-price" id="specJdPri" style="display: block"> <span class="yang-pic spec-yang-pic"> <img src="${base}/imgs/rmb.png" /> </span> <span id="spec_price"> 36.80 </span> </div>
                            <div id="specWeightDiv" class="spec-weight"> <span>重量:</span> <span id="spec_weight">3.26kg</span> </div>
                        </div>
                        <div class="spec-menu-middle">
                            <div class="prod-spec" id="prodSpecArea">
                                <!-- 已选 -->
                                <div class="prod-spec" id="prodSpecArea">
                                    <!-- 已选 -->
                                    <div class="spec-desc"> <span class="part-note-msg">已选</span>
                                        <div id="specDetailInfo_spec" class="base-txt"> 白色 直袖款 &nbsp;&nbsp; <span class="amount">1</span>件 </div>
                                    </div>
                                    <div class="nature-container" id="natureCotainer">
                                        <!--颜色 5.5版本之前的规格属性-->
                                        <div class="pro-color"> <span class="part-note-msg"> 颜色 </span>
                                            <p id="color"> <a title="白色 直袖款" class="a-item selected J_ping"   report-eventparam="白色 直袖款" >白色 直袖款</a> <a title="蓝色 直袖款" class="a-item J_ping"   report-eventparam="蓝色 直袖款" >蓝色 直袖款</a> <a title="黑色 直袖款" class="a-item J_ping"   report-eventparam="黑色 直袖款" >黑色 直袖款</a> <a title="灰色 直袖款" class="a-item J_ping"   report-eventparam="灰色 直袖款" >灰色 直袖款</a> <a title="粉色 直袖款" class="a-item J_ping"   report-eventparam="粉色 直袖款" >粉色 直袖款</a> <a title="紫色 直袖款" class="a-item J_ping"   report-eventparam="紫色 直袖款" >紫色 直袖款</a> </p>
                                        </div>
                                        <!--尺寸-->
                                        <!--容量-->
                                        <!--数量-->
                                    </div>
                                    <!--尺寸-->
                                    <!--容量-->
                                    <!--数量-->
                                    <div id="addCartNum" class="pro-count"> <span class="part-note-msg" style="margin-right: 10px;">数量</span>
                                        <div style="width: 100%;margin-left: 10px;" class="num">
                                            <p class="jian" style="float: left;margin-top: 5px;"><img src="${base}/imgs/jian.png" width="16" height="16"></p>
                                            <input id="cool" class="inputBorder"  value="1" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" onafterpaste="this.value=this.value.replace(/[^0-9]/g,'')" type="text" maxlength="5" placeholder="数量" style="font-size: 12px;width: 60px;height: 20px;float: left;padding: 0 5px;margin-top:3px;margin-left: 5px;" />
                                            <p class="jia" style="float: left;margin-top: 5px;margin-left:4px;"><img src="${base}/imgs/jia.png" width="16" height="16"></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--延保start-->
                            <div class="warranty-wrap bdr-t" style="display: none;">
                                <div id="spec_yanbaoInfo" class="warranty-title"> 保障服务 </div>
                                <div id="spec_yanbaoItems"> </div>
                            </div>
                            <!--延保end-->
                        </div>
                        <div class="flick-menu-btn spec-menu-btn"> <a class="yellow-color add_cart" id="add_cart_spec" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">加入购物车</a> <a class="red-color directorder" id="directorder_spec" style="transform-origin: 0px 0px 0px; opacity: 1; transform: scale(1, 1);">立即购买</a> <a class="yellow-color J_ping looksimilar looksimilara looksimilar_spec" id="looksimilar_speca" href=" " style="display: none;" report-eventid="MProductdetail_Similar" report-eventparam="W" report-eventlevel="5">查看相似</a>
                            <!--大家电-查看同款-->
                            <a class="yellow-color J_ping looksimilar looksimilarb looksimilar_spec" id="looksimilar_specb" href="" style="display: none;" report-eventid="MProductdetail_SameProduct" report-pageparam="" report-eventlevel="4">查看同款</a> <a class="red-color J_ping arrivalInform" id="arrivalInform_spec" style="display: none;" report-eventid="MProductdetail_ArrivalNotice" report-eventparam="2015246_W" report-eventlevel="5">到货通知</a> <a class="red-color disabled waitingForAppointments" style="display: none;" id="waitingForAppointments_spec">等待预约</a> <a class="red-color makeAppointments" style="display: none;" id="makeAppointments_spec">立即预约</a> <a class="red-color disabled waitingForBuying" style="display: none;" id="waitingForBuying_spec">等待抢购</a> <a class="red-color buyImmediately" style="display: none;" id="buyImmediately_spec">立即抢购</a> <a class="red-color disabled appointmentsEnd" style="display: none;" id="appointmentsEnd_spec">预约结束</a> <a class="red-color" style="display: none;" id="yushou_add_cart_spec">立即预定</a> </div>
                    </div>
                </div>
                <!-- 弹出 -->
                <section id="s-actionBar-container">
                    <div id="s-actionbar" class="action-bar mui-flex align-center">
                        <div class="web"> <img src="${base}/imgs/atm.png" width="20" height="20" />
                            <p>客服</p>
                        </div>
                        <div class="web"> <img src="${base}/imgs/trade-assurance.png" width="20" height="20" />
                            <p>进店</p>
                        </div>
                        <div class="web"> <img src="${base}/imgs/favorite.png" width="20" height="20" />
                            <p>客服</p>
                        </div>
                        <button class="cart cell">加入购物车</button>
                        <button class="buy cell">立即购买</button>
                        <div class="activity-box cell"></div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $(".clickwn").click(function () {
            $(".flick-menu-mask").show();
            $(".spec-menu").show();
        })

        $(".tclck").click(function () {
            $(".flick-menu-mask").hide();
            $(".spec-menu").hide();
        })

        /* $("#cool").focus(function(){
             var oi = $('#cool').val();

             $('.amount').html(oi)
         });*/

        $('#cool').bind('input propertychange', function () {
            /* alert(this.value);*/
            $('.amount').html(this.value)

        }).bind('input input', function () {

        });


        $('#color a').click(function () {
            var cook = $(this).index();
            $('#color a').eq(cook).addClass('selected').siblings().removeClass('selected');
        })


        //加减面板
        $(function(){
            //加号
            $(".jia").click(function(){

                var $parent=$(this).parent(".num");
                var $num=window.Number($(".inputBorder",$parent).val());
                $(".inputBorder",$parent).val($num+1);

                $('.amount').html($num+1)

            });

            //减号
            $(".jian").click(function(){
                var $parent=$(this).parent(".num");
                var $num=window.Number($(".inputBorder",$parent).val());
                if($num>2){
                    $(".inputBorder",$parent).val($num-1);
                    $('.amount').html($num-1)

                }else{
                    $(".inputBorder",$parent).val(1);
                    $('.amount').html($num)


                }
            });

        })


    })
</script>
</html>