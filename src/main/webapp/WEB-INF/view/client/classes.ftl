<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="description" content="">
  	<meta name="keywords" content="">
  	<meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>i趣投资社区</title>
	<link rel="stylesheet" href="/css/index.css"/>
	<link rel="stylesheet" href="/css/reset.css"/>
	<script src="/js/jquery.min.js"></script>
	<script language="javascript">
    	$(document).ready(function() {
    	 $.ajax({
            //提交数据的类型 POST GET
            type:"POST",
            //提交的网址
            url:"/api/class/subject/list.do",
            //提交的数据
            data:{limit: 10, page: 1},
            //返回数据的格式
            datatype: "json",
            //成功返回之后调用的函数             
            success:function(data){
            }   ,
            //调用执行后调用的函数
            complete: function(XMLHttpRequest, textStatus){
               	var data =XMLHttpRequest.responseText;
               	var dataObj=eval("("+data+")");//转换为json对象 
              	$.each(dataObj,function(idx,item){ 
              		$("#classesul").append("<li class='lists'><a href='/client/class/content.do?id="+item.id+"&subject="+item.subject+"'>"+item.subject+"</a></li>");
				
				}); 
            },
            //调用出错执行的函数
            error: function(){
                //请求出错处理
            }         
         });
         });
	</script>
</head>
<body class="others">
	<div class="content">
		<header>
			<p class="home"><a href="/"></a></p>
			<h1>i趣投资社区</h1>
			<p class="user">
				<span class="hed"></span>
				<span class="bod"></span>
			</p>
		</header>
		<div class="banner">
			<img src="/imgs/banner.png" alt="i趣"/>
		</div>
		<div class="listnews">
			<div class="newsitem lastlist">
				<ul id="classesul">
					<li class="lists listtit">
						<img src="/imgs/xt.png" alt="">
						<span>i趣学堂</span>
					</li>
				</ul>
			</div>
		</div>
		<footer>
			<ul>
				<li><a href="/client/infos.do">资讯</a></li>
				<li><a href="/client/classes.do">学堂</a></li>
				<li><a href="/client/activities.do">活动</a></li>
				<li><a class="lasta" href="/client/intro.do">简介</a></li>
			</ul>
		</footer>
	</div>
</body>
</html>