<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh" style="font-size: 154.533px;">
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
    <link rel="shortcut icon" type="image/x-icon"
          href="https://happymama.oss-cn-beijing.aliyuncs.com/bitbug_favicon.ico">
    <script type="text/javascript" src="${base}/js/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/jquery.cookie.js"></script>
    <link rel="stylesheet" href="${base}/css/main.bundle.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/webuploader.css">
    <link rel="stylesheet" type="text/css" href="${base}/css/upload_style.css">
    <script type="text/javascript" src="${base}/js/webuploader.js"></script>
    <script type="text/javascript" src="${base}/js/upload.js"></script>
    <script>
        $(document).ready(function () {
            var token = $.cookie('kl_token');
            $("#accessToken").val(token);

            $(".uploadBtn").hide();


            $("#submit-message").click(function () {
                var content = $.trim($('textarea[name="content"]').val());
                var title = $.trim($('input[name="title"]').val());
                if (title.length == 0) {
                    alert("标题不能为空哦！");
                    return;
                }
                if (content.length == 0) {
                    alert("评论内容不能为空哦！");
                    return;
                }
                $(".uploadBtn").click();
            });

        });
    </script>

</head>

<body>
<form action="${base}/forum/add.do" method="post"
      enctype="multipart/form-data"
      accept-charset="utf-8">
    <section style="overflow: hidden; position: relative; width: 100%; height: 100%;">
        <section class="scroller"
                 style="box-sizing: border-box; padding-bottom: 0.18rem; background: rgb(241, 242, 246) none repeat scroll 0% 0%;">
            <section class="publish-box">
                <section class="line-viewer iosBorder"
                         style="margin-left: 0.3rem; padding-left: 0px; padding-top: 0.32rem; padding-bottom: 0.32rem;">
                    <input placeholder="写一个清晰明确的标题吧" maxlength="15" class="custom-input title" type="text" name="title"
                           required>
                </section>
                <input id="accessToken" name="accessToken" type="hidden"/>

                <section class="line-viewer"
                         style="margin-left: 0.3rem; padding-left: 0px; padding-top: 0.15rem; padding-bottom: 0.15rem;">
                    <section class="custom-textarea">
                    <textarea maxlength="500" placeholder="请输入帖子内容吧。"
                              class="has-margin-left" name="content"
                              style="color: rgb(178, 184, 194); height: 200px;" required></textarea>
                    </section>
                </section>


                <input type="hidden" id="commentId" name="commentId" value="${forumId}">
                <input type="hidden" id="fileType" name="fileType" value="forumType">
                <input type="hidden" id="contextBase"  value="${contextPath}">


                <div id="wrapper">
                    <div id="container">
                        <div id="uploader">
                            <div class="queueList">
                                <div id="dndArea" class="placeholder">
                                    <div id="filePicker"></div>
                                    <p>或将照片拖到这里，单次最多可选9张</p>
                                </div>
                            </div>
                            <div class="statusBar" style="display:none;">
                                <div class="progress">
                                    <span class="text">0%</span>
                                    <span class="percentage"></span>
                                </div>
                                <div class="info"></div>
                                <div class="btns">
                                    <div id="filePicker2"></div>
                                    <div class="uploadBtn">开始上传</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </section>
        </section>

        <input id="submit-message" type="button" value="确认发布" name="submit_msg"
               class="publish-button publish-button-item">

    </section>
</form>

<!--Bootstrap core JavaScript-->
<script src="${base}/js/bootstrap.min.js"></script>
<!--Flex Slider JavaScript-->
<script src="${base}/js/jquery.flexslider-min.js"></script>
<!--Swiper Slider JavaScript-->
<script src="${base}/js/swiper.jquery.min.js"></script>
<!--Owl Carousel JavaScript-->
<script src="${base}/js/owl.carousel.js"></script>
<!--Chosen JavaScript-->
<script src="${base}/js/chosen.jquery.min.js"></script>
<!--Chosen JavaScript-->
<script src="${base}/js/waypoints-min.js"></script>
<!--Pretty Photo Javascript-->
<script src="${base}/js/jquery.prettyPhoto.js"></script>
<!--Custom JavaScript-->
<script src="${base}/js/custom.js"></script>

</body>
</html>