<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta name="description"
          content="北京新新妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,新新妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="ZbacBBPSZU"/>

    <title>新新妈咪</title>
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="${base}/css/animate.css"/>

    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/v-user.css">
    <link rel="stylesheet" href="${base}/css/global.css">
    <link rel="stylesheet" href="${base}/css/search-rs.css">

    <script>
        $(document).ready(function () {
            $("#search").click(function () {
                var name = $("#searchTextBox").val();
                if ($.trim(name) == '') {
                    alert("百科名字不能为空");
                    return;
                }
                var form = document.forms[0];
                form.submit();
            });
        });
    </script>

</head>

<body class="fadeIn animated">

<div class="head-wrap">
    <div class="serach-wrap">
        <div class="input-wrap">
            <div class="input-box">
                <i class="search__icon__search"></i>
                <form action="${base}/knowledge/query.do">
                    <input type="hidden" name="page" id="page"/>
                    <input id="searchTextBox" placeholder="搜索百科" autocomplete="off" type="search" name="name"
                           value="${name}">
                </form>
            </div>
        </div>
        <div class="button" id="search">搜索</div>
    </div>
</div>

<#list topics as topic>
<div class="feedback ico border-b"><a
        href="${base}/app/topic/list.do?parentId=${topic.id}&loc=knowledge">${topic.name}</a></div>
</#list>

<#--<#include "/common/foot.ftl" >-->
</body>
</html>