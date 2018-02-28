<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=0,uc-fitscreen=yes"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="format-detection" content="telephone=no"/>
    <title>miniMobile</title>
    <meta name="keywords" content="miniMobile的demo"/>
    <meta name="description" content="miniMobile是一个简单易用的移动框架！"/>
    <!-- miniMObile.css、js -->
    <link rel="stylesheet" type="text/css" href="/css/miniMobile.css"/>
    <script type="text/javascript" src="/js/zepto.min.js"></script>
    <script type="text/javascript" src="/js/miniMobile.js"></script>
    <!-- mobileSelect -->
    <link rel="stylesheet" type="text/css" href="/plugins/mobileSelect/mobileSelect.css">
    <script src="/plugins/mobileSelect/mobileSelect.js" type="text/javascript"></script>
    <!-- icheck -->
    <script src="/plugins/icheck/icheck.js" type="text/javascript" charset="utf-8"></script>
    <!-- noUiSlider -->
    <link rel="stylesheet" type="text/css" href="/plugins/noUiSlider.10.0.0/nouislider.css"/>
    <script src="/plugins/noUiSlider.10.0.0/nouislider.js" type="text/javascript" charset="utf-8"></script>
    <!-- switchery -->
    <link rel="stylesheet" type="text/css" href="/plugins/switchery/switchery.css"/>
    <script src="/plugins/switchery/switchery.js" type="text/javascript" charset="utf-8"></script>
    <!-- iconfont -->
    <link rel="stylesheet" type="text/css" href="/plugins/fonticon/iconfont.css"/>
    <!-- animate.css -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.css"/>
</head>

<body class="pb12 fadeIn animated">
<header class="ui-header clearfix w75 h8 f46 pl3 pr3 color8 bg-color-success t-c o-h">
    <div class="ui-header-l fl w5">
        <b class="icon iconfont icon-sortlight"></b>
    </div>
    <div class="ui-header-c fl f30 w59">
        个人信息
    </div>
    <div class="ui-header-r fl w5">
        <i class="icon iconfont icon-phone"></i>
    </div>
</header>
<style>
    .formheader {
        line-height: 0.7rem;
    }

    .formheader span {
        display: inline-block;
    }

    .formheader input {
        border: none;
    }
</style>
<div class="p3 f30 f30 w75">
    <form action="/app/baby/sitter/add.do" method="post">
        <div class="pt2 pb2">
            姓名：
            <input type="text" name="name" class="w59  form-control" placeholder="请输入您的称呼"/>
        </div>
        <div class="pt2 pb2">
            手机：
            <input type="text" name="phone" class="w59  form-control" placeholder="请输入您的手机号码"/>
        </div>
        <div class="pt2 pb2">
            地址：
            <input type="text" name="address" class="w59  form-control" placeholder="请输入您的地址"/>
        </div>
        <div>
            宝宝的年龄：
            <label class="mr3"><input type="checkbox" name="babyage" value="0" class="check"/>1岁以内</label>
            <label class="mr3"><input type="checkbox" name="babyage" value="1" class="check"/>1~3岁</label>
            <label class="mr3"><input type="checkbox" name="babyage" value="2" class="check"/>3岁以上</label>
        </div>

        <div class="mt4 mb4">
            备注：
            <textarea class="w59 h20 form-control" name="memo" placeholder="备注内容"></textarea>
        </div>
        <div class="t-c mt5">
            <input type="submit" class="btn f30 btn-primary radius10 p2 w50" value="确定提交"/>
        </div>
    </form>
</div>
<script type="text/javascript">
    //icheck 多选框插件
    $('.check').iCheck({
        checkboxClass: 'ui-checkbox check-primary',
        radioClass: 'ui-radio check-primary'
    });

</script>
</body>

</html>