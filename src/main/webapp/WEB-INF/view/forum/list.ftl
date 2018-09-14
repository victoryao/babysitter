<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <base id="base" href="${base}">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <meta name="description"
          content="北京快乐妈咪科技有限公司是由一群有爱心有激情的奶爸与月嫂创始建设，着力搭建一个孕妈和月嫂的深度交流平台。目前的核心服务包括培训、月嫂、育儿嫂、催乳师、产后护理、小儿推拿、月子餐等母婴服务的预定与咨询，用户可结合自身实际情况，分价格、分地域、分年限进行快速搜索，可以周为单位进行服务评价、付款，是专业且具有保障的孕妈社区。"/>
    <meta name="aplus-xplug" content="NONE">
    <meta name="keyword" content="月嫂,培训,月嫂培训,育儿嫂,催乳师,小儿推拿师,产后恢复,月子膳食,营养师,快乐妈咪,推荐工作,高薪,家政"/>
    <meta name="baidu-site-verification" content="71R86N1GBt"/>

    <title>快乐妈咪</title>

    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/main.im.css"/>
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
<#--<link href="${base}/css/bootstrap.min.css" rel="stylesheet">-->
    <script language="javascript">
        //到指定的分页页面
        function topage(page) {
            var form = document.forms[0];
            form.page.value = page;
            form.submit();
        }

        $(document).ready(function () {
            var token = $.cookie('kl_token');
            $("#accessToken").val(token);
            $("#fireForum").attr("href", "${base}/app/to/0/forum/add.do?accessToken=" + token);
        });

    </script>
</head>

<body class="fadeIn animated">

<div class="w-topbar no-invest m-widget">
    <div class="topbar-wrap">

        <a class="forumTitle">
            <span>快乐社区</span>
        </a>

        <a id="fireForum" class="fireForum">
            <span>发帖子</span>
        </a>
    </div>
</div>

<form action="${base}/forum/0/list.do">
    <input type="hidden" name="page" id="page"/>
</form>

<input id="accessToken" name="accessToken" type="hidden"/>

<div style="padding-bottom: 30px">
    <div>
        <div>
            <div class="im-list">
            <#list pageView.records as forum>
                <div data-v-753d272c="">
                    <div data-v-753d272c="" class="media">
                        <div data-v-753d272c="" class="media-left">
                            <a href="${base}/forum/${forum.id}/detail.do?loc=forum">
                                <div data-v-753d272c="" class="media-body">
                                    <p data-v-753d272c="" class="media-heading">
                                        <span data-v-753d272c="" class="nickname">${forum.title}</span>
                                        <span class="timeDiv">${forum.created?string('yyyy-MM-dd HH:mm:ss')}</span>
                                    </p>

                                    <p data-v-753d272c="" class="media-text">
                                        <#if forum.content?length gt 33>${forum.content?substring(0,30)}...
                                        <#else>${forum.content!}
                                        </#if>
                                    </p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            <#--<hr style="height:1px;border:none;border-top:1px dashed #0066CC;"/>-->
            </#list>
            <#include "../../share/paging.ftl" >
            </div>
        </div>
    </div>
</div>
<#include "/common/foot.ftl" >
</body>
</html>