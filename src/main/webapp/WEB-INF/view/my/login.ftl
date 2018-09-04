<#assign base=request.contextPath />
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <script type="text/javascript" src="${base}/js/zepto.min.js"></script>
    <script type="text/javascript" src="${base}/js/miniMobile.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/miniMobile.css"/>
    <!-- fonticon -->
    <link rel="stylesheet" type="text/css" href="${base}/plugins/fonticon/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${base}/css/customer.css"/>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="${base}/css/animate.css"/>
    <link rel="stylesheet" href="${base}/css/swiper.min.css">
    <script src="${base}/js/swiper.min.js"></script>

    <link rel="stylesheet" href="${base}/css/frame_338829c.css">
    <link rel="stylesheet" href="${base}/css/common_16f528f.css">
    <link rel="stylesheet" href="${base}/css/home_f587618.css">
    <link rel="stylesheet" href="${base}/css/footer.css">
    <link rel="stylesheet" href="${base}/css/mypage.css">
    <link rel="stylesheet" href="${base}/css/v-user.css">
    <link rel="stylesheet" href="${base}/css/global.css">
    <link rel="stylesheet" href="${base}/css/login.css">
    <link rel="stylesheet" href="${base}/css/h5-login.css">
    <script src="${base}/js/jquery.js"></script>
    <script>
        $(document).ready(function () {
            $(".submit-button").click(function () {

                if ($(this).html() == "下一步") {
                    var mobile = $("#mobile-input").val();
                    if (!isPoneAvailable(mobile)) {
                        alert("手机号不合法，请重新输入。");
                        return;
                    }
                    $("#verifyCodeDiv").fadeIn();

                    $.get("${base}/user/verifyCode.do?mobile=" + mobile);

                    $(this).html("登陆");
                    return;
                }

                if ($(this).html() == "登陆") {
                    if ($("#sms-input").val().length != 4) {
                        alert("验证码不合法，请重新输入。");
                        return;
                    }
                    var form = document.forms[0];
                    form.submit();
                }


            });
        });

        function isPoneAvailable(str) {
            var myreg = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            return myreg.test(str);
        }
    </script>
</head>

<body>
<div data-v-c2da3850="">
    <form action="${base}/user/sso.do" method="post">
        <div data-v-c2da3850="" class="main-wrap">
            <div data-v-c2da3850="" class="input-wrap"><i data-v-c2da3850="" class="icon_mobile"></i>
                <div data-v-c2da3850="" class="input-box">
                    <input data-v-c2da3850="" id="mobile-input" maxlength="11" placeholder="手机号" type="tel"
                           name="mobile">
                </div>
            </div>
            <input type="hidden" value="${openId}" name="openId">

            <div data-v-c2da3850="" class="input-wrap" style="display: none;" id="verifyCodeDiv">
                <i data-v-c2da3850="" class="icon_protect"></i>
                <div data-v-c2da3850="" class="input-box">
                    <input data-v-c2da3850="" id="sms-input" maxlength="4" name="capt"
                           placeholder="验证码" type="tel">
                    <i data-v-c2da3850="" class="icon_clear"
                       style="display: none;"></i>
                </div>
                <div data-v-c2da3850="" class="msg-button">验证码已发送</div>
            </div>

            <div data-v-c2da3850="" class="submit-button">下一步</div>
            <div data-v-c2da3850="" class="agreement-wrap">
                点击“下一步”,即同意<a data-v-c2da3850="" href="${base}/app/to/user/notice.do">《快乐妈咪用户协议》</a>
            </div>
        </div>
    </form>
</div>

<#include "/common/foot.ftl" >
</body>
</html>