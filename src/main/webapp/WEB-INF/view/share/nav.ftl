<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">i趣社区后台</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            <li class="dropdown <#if highLightDiv='info'>active</#if>">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">资讯管理 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="/toAddInfo.do">增加资讯</a></li>
                  <li><a href="/info/subject/list.do">管理资讯</a></li>
                </ul>
              </li>
              <li class="dropdown <#if highLightDiv='class'>active</#if>" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">学堂管理 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="/toAddClass.do">增加学堂</a></li>
                  <li><a href="/class/subject/list.do">管理学堂</a></li>
                </ul>
              </li>
              <li class="dropdown <#if highLightDiv='activity'>active</#if>">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">活动管理 <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="/toAddActivity.do">增加活动</a></li>
                  <li><a href="/activity/subject/list.do">管理活动</a></li>
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>