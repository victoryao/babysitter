<div>
    <div class="wx-index__footer">
        <div class="box">
            <ul>
                <li class="item__home <#if loc='home'>active</#if>">
                    <a href="${base}/toMain.do?loc=home" class="footer">
                        <div class="icon">
                            <i class="wx-index__icon wx-index__icon--home"
                               style="background-image: url(&quot;${base}/images/foot-v2.png&quot;);"></i>
                        </div>
                        <div class="wx-index__footer--title">首页</div>
                    </a>
                </li>

                <li class="item__publish <#if loc='knowledge'>active</#if>">
                    <a href="${base}/app/topic/list.do?loc=knowledge" class="footer">
                        <div class="icon">
                            <span class="wx-index__footer--ishover"></span>
                            <i class="wx-index__icon wx-index__icon--publish"
                               style="background-image: url(&quot;${base}/images/foot-v2.png&quot;);"></i>
                        </div>
                        <div class="wx-index__footer--title">知识</div>
                    </a>
                </li>

                <li class="item__message <#if loc='forum'>active</#if>">
                    <a href="${base}/forum/0/list.do?loc=forum" class="footer">
                        <div class="icon">
                            <i class="wx-index__icon wx-index__icon--message"
                               style="background-image: url(&quot;${base}/images/foot-v2.png&quot;);"></i>
                        </div>
                        <div class="wx-index__footer--title">社区</div>
                        <div class="spot" id="messageSpot"></div>
                    </a>
                </li>

                <li class="item__user <#if loc='my'>active</#if>">
                    <a id="myDiv" class="footer">
                        <input name="token" id="token" type="hidden"/>
                        <div class="icon">
                            <i class="wx-index__icon wx-index__icon--user"
                               style="background-image: url(&quot;${base}/images/foot-v2.png&quot;);"></i>
                        </div>
                        <div class="wx-index__footer--title">我的</div>
                        <div class="spot" id="userSpot" style="display: none;"></div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        var token = $.cookie('kl_token');
        $("#token").val(token);
        $("#myDiv").attr("href", "${base}/app/to/my.do?loc=my&token=" + token);
    });
</script>