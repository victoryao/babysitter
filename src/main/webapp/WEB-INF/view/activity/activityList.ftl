<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>活动管理</title>

    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/navbar.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="/js/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="/js/ie10-viewport-bug-workaround.js"></script>
    <script language="javascript">
    	$(document).ready(function() {
    		$(".del").click(function(){
    		if(window.confirm('确定要删除吗？')){
			  return true;
			}else{
			  return false;
			}
    	});
    	});
	//到指定的分页页面
	function topage(page){
		var form = document.forms[0];
		form.page.value=page;
		form.submit();
	}
	
	</script>
    
  </head>

  <body>

    <div class="container">
	<#include "../../share/nav.ftl" > 

      <div class="jumbotron">
      <form action="/activity/subject/list.do">
      
    	<table class="table table-bordered thead-table">
      		<input type="hidden" name="page" id="page"/>
            <thead>
                <tr>
                	<th>标题</th>
                	<th>修改时间</th>
                    <th>操作</th>                        
                </tr>
            </thead>
           
            <tbody>
              <#list pageView.records as activity>
                <tr>
                    <td>${activity.subject}</td>
                    <td>${activity.updated?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td>
                    	<#if (activity.status == 1)!>
                    		<a href="/toEditActivity.do?aId=${activity.id}&subject=${activity.subject}" title="编辑">编辑</a>|
                    		<a href="/activity/${activity.id}/del.do" class="del" title="删除">删除</a>|
                    	</#if>
                    	<#if (activity.status == 0 && activity.type == 0)!>
                    		<a href="/activity/${activity.id}/up.do" class="up" title="置顶">置顶</a>|
                    	</#if>
                    	<#if (activity.status == 0 && activity.type == 1)!>
                    		<a href="/activity/${activity.id}/down.do" class="down" title="取消置顶">取消置顶</a>|
                    	</#if>
                    	<#if (activity.status == 1)!>
                    		<a href="/activity/${activity.id}/online.do" class="online" title="上线">上线</a>|
                    	</#if>
                    	<#if (activity.status == 0)!>
                    		<a href="/activity/${activity.id}/offline.do" class="offline" title="下线">下线</a>|
                    	</#if>
                    </td>        
                </tr>
              </#list>
            </tbody>
        
    </table>      
    <#include "../../share/paging.ftl" > 
	</form>
      </div>

    </div> <!-- /container -->

    
   
  </body>
</html>
