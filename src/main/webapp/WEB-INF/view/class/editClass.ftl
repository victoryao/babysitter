<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>编辑学堂</title>

    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/navbar.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     <script type="text/javascript" src="/js/fckeditor.js"></script>
     <script type="text/javascript">
     	window.onload = function(){
     		var sBasePath = "/fckeditor/" ;
			var oFCKeditor = new FCKeditor( 'content' ) ;
			oFCKeditor.BasePath	= sBasePath ;
			oFCKeditor.Height	= 500 ;
			oFCKeditor.Value	= '' ;
			oFCKeditor.ReplaceTextarea() ;
     	}
     </script>
  </head>

  <body>

    <div class="container">

     <#include "../../share/nav.ftl" > 

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
     <form action="/class/update.do" method="post">
     	<input type="hidden" name="cId" value="${classDO.cId}" />
      	<h3>学堂标题：</h3><input type="text" id="subject" name="subject" maxlength=200 style="width:80%" value="${classDO.subject}" /><br/>
      	<h3>学堂内容：</h3>
		<TEXTAREA rows="4" cols = "60" name="content" id="content">${classDO.content}</TEXTAREA>
		<br />
		<input type="submit" value="提交" />
	</form

      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/js/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
   
  </body>
</html>
