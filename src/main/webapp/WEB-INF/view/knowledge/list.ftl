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
    <script type="text/javascript" src="${base}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${base}/js/miniMobile.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/miniMobile.css"/>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="${base}/plugins/fonticon/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/css/customer.css"/>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="${base}/css/animate.css"/>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <script src="${base}/js/swiper.min.js"></script>

    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/home_f587618.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/main.css">

    <script language="javascript">
        //到指定的分页页面
        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }
    </script>

</head>

<body class="fadeIn animated">
<div class="wx-index__theme__list">

    <form action="${base}/app/to/knowledge/list.do">
        <input type="hidden" name="page" id="page"/>
        <input type="hidden" name="loc" id="loc" value="knowledge"/>
        <input type="hidden" name="parentId" id="parentId" value="${parentId}"/>
    </form>

    <ul class="list_pet">
    <#list pageView.records as knowledge>
        <li class="js-tracker ">
            <a href="${base}/app/${knowledge.id}/knowledge/view.do?loc=knowledge">
                <div class="picbox"
                     style="background-image:url(<#if (knowledge.img != '')>'/imgs/${knowledge.img}'
                     <#else>'${base}/images/blog-pic.jpg'</#if>);">
                </div>
                <div class="list-main">
                    <div class="tit">
                        <p class="title_name">${knowledge.title}</p>
                        <span class="title_tag">精品</span>
                    </div>

                    <div class="price clearfix">
                    </div>

                    <div class="evaluate-info clearfix">
                        <div class="sell-info">
                            <#if knowledge.content?length gt 33>${knowledge.content?substring(0,30)}...
                            <#else>${knowledge.content!}
                            </#if></div>
                    </div>

                    <div class="price clearfix">
                    </div>

                    <div class="store-info clearfix">
                        <div class="info">${knowledge.created?string('yyyy-MM-dd')}</div>
                    </div>
                </div>
            </a>
        </li>
    </#list>
    </ul>
<#include "../../share/paging.ftl" >
</div>
<#include "/common/foot.ftl" >
</body>
</html>