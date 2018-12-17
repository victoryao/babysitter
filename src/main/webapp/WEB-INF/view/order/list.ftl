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

    <title>新手妈妈团购</title>
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

    <link href="${base}/css/dj_h5_665df9c.css" rel="stylesheet" type="text/css"/>
    <link href="${base}/css/myorder.css" rel="stylesheet"/>

</head>
<body>
<div class="tab tab5" id="mytab">
    <ul>
        <li class="tab_qbdd  cur "><a href="javascript:">全部</a></li>
    </ul>
</div>
<div class="fixh_tab"></div>
<div id="mydd">
    <ul class="mydd" id="orderList">
        <li>
        <#list shopOrderDOs as shopOrderDO>
            <div class="orderidDiv">

                <div class="titbar">
                    <div class="uhead">
                        <img src="${shopOrderDO.shopActivityDO.shopDO.img}"/>
                    </div>
                    <div class="tittxt">${shopOrderDO.shopActivityDO.name}(预约电话：${shopOrderDO.shopActivityDO.phone})
                    </div>
                    <div class="titzt">
                        <#if shopOrderDO.status='0'>待支付</#if>
                        <#if shopOrderDO.status='1'>已支付</#if>
                        <#if shopOrderDO.status='2'>已完成</#if>
                    </div>
                </div>

                <div class="pricebar">
                    <div class="txt slh">
                        <span>验证码：<b><font color="red">${shopOrderDO.code}</font></b>(消费时请出示)</span>
                    </div>
                </div>

                <div class="ddtime">
                    <i class="ico_time"></i>
                    <div class="txt_time">
                    ${shopOrderDO.created?string('yyyy-MM-dd HH:mm:ss')}
                    </div>
                </div>

                <div class="ddaddr">
                    <i class="icon_addr"></i>
                    <div class="txt_addr slh">
                    ${shopOrderDO.shopActivityDO.shopDO.address}
                    </div>
                </div>

            </div>

        </#list>

        </li>
    </ul>

    <!--end_load用来判断到到底，加载更多订单-->
    <div class="end_load" id="load_dd"></div>
</div>
</body>

</html>
