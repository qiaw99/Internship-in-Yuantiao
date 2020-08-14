<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://com.yuantiao.webplatform.ui/taglib/pf"
	prefix="pf"%>

<pf:head title="${title}">
	<link rel="shortcut icon" href="${smallIcon}">
	<link href="/page/css/layout.css" rel="stylesheet">
</pf:head>
<pf:body>
<div style="height: 100%; width: 100%" id="pageMenu">
	<header class='main-menubar pf-header-nav'>
		<div class='pf-header-nav-logo-area'>
			<div class='pf-header-nav-logo-icon'>
			<img src='${bigIcon}' style='width: 26px'></div>
			<div class='pf-header-nav-logo-title'>${title}</div>
		</div>
   		<a class='pf-header-nav-logout-content' href='/logout'>
   			<i class='fa fa-power-off'></i>
   		</a>
 		<div class='pf-header-nav-user-content'><span class='pf-header-nav-user-text-name'>${webpfUserName}</span>
 		<span id='msgCount' style=' background-color: red;padding: 2px 5px;border-radius: 10px;cursor: pointer;'>0</span></div>
		<ul id="menu" class="mini-menubar mymenu">
		</ul>
 	</header>
	<div class='content'>
 		<div class='main-content'><iframe id='iframeWindow' style='width: 100%; height: 100%; border: 0' src=''></iframe>
 		</div>
 	</div>
</div>
<script src="/page/js/index.js"></script>
<pf:script>

	dataRender(${menu}, "${nav}", "${title}","${webpfBaseImplAddress}");
	$(".main-content iframe").attr("src","${url}");
	if("${antd}" == "antd"){
		$(".main-menubar").addClass("main-antd");
		$(".content").addClass("main-sidebar-antd");
	}
	$("#msgCount").bind("click",function(){
		pf.open({
			url:bundleUrl+"msgLog/showMsg.html",
			width:500,
			height:400,
			title:"",
			onload:function(){
				var data = YTMsg.getMsgData();
				for(var key in data){
					var count = parseInt($("#msgCount").html());
					$("#msgCount").html(count-1);
					if(data[key].log.sendtime==null||data[key].log.sendtime==""){
						data[key].log.sendtime = pf.formatDate(Date(),'yyyy-MM-dd HH:mm:ss');
					}
					$("#showMsgContent").append(
						'<div class="showMsgBox">'
							+'<div class="showMsgRow">'
								+'<div class="showMsg-title">'+data[key].log.title+'</div>'
								+'<div class="showMsg-time">'+data[key].log.sendtime+'</div>'
							+'</div>'
							+'<div class="showMsgRow">'
								+'<div class="showMsg-content">'+data[key].log.content+'</div>'
							+'</div>'
						+'</div>'
					);
					YTMsg.read(key);
				}
			}
		})
	})
	YTMsg.onMessage=function(data){
		var count = parseInt($("#msgCount").html());
		$("#msgCount").html(count+1)
	}
	YTMsg.open("${msgSocket}","${webpfUserId}","platform","null");

</pf:script>
</pf:body>


