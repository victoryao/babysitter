<!--<font color="#000000"> 当前页:第${pageView.currentpage}页 | 总记录数:${pageView.totalrecord}条 | 每页显示:${pageView.maxresult}条 | 总页数:${pageView.totalpage}页</font>-->　
<#if pageView.pageindex.endindex!=0>
	<div style="text-align:center">
		<#list pageView.pageindex.startindex..pageView.pageindex.endindex as wp>
			<#if pageView.currentpage==wp>
				<b><font color="#000000">第${wp}页</font></b>
			</#if>
			<#if pageView.currentpage!=wp>
				<a href="javascript:topage('${wp}')" class="a03">第${wp}页</a>
			</#if>
		</#list>
	</div>
</#if>