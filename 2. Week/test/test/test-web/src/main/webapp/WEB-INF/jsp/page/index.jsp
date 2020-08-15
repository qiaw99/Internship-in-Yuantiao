<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://com.yuantiao.webplatform.ui/taglib/pf"
	prefix="pf"%>

<pf:head title="${title}">
	<link rel="shortcut icon" href="${smallIcon}">
	<link href="/page/css/layout.css" rel="stylesheet">
</pf:head>
<pf:body>
	<pf:box addClass="pf-header-nav">
		<pf:box addClass="pf-header-nav-logo-area">
			<pf:box addClass="pf-header-nav-logo-icon">
				<img src="${bannerIcon}" style="width: 26px" />
			</pf:box>
			<pf:box addClass="pf-header-nav-logo-title">${title}</pf:box>
		</pf:box>
		<a class="pf-header-nav-logout-content" href="/logout"> <i
			class="fa fa-power-off"></i>
		</a>
		<pf:box addClass="pf-header-nav-user-content">
			<span class="pf-header-nav-user-text-name">${webpfUserName}</span>
			<span id="msgCount" style=" background-color: red;padding: 2px 5px;border-radius: 10px;cursor: pointer;">0</span>
		</pf:box>        
		
		<pf:box addClass="pf-header-nav-menu-area">
			<pf:menu navbar="true" id="menu" idField="id"
				parentField="menuParentId" textField="menuTitle" imgPath="../img/"
				></pf:menu>
		</pf:box>
	</pf:box>
	<pf:support name="fit" style="width:100%">
		<iframe id="indexIframe" src="${url}"
			frameborder="0" width="100%" height="100%"></iframe>
	</pf:support>
	<pf:script>
var menu = pf.get("menu");
var content = $('#content');
var indexIframe = $("#indexIframe");
menu.loadList(${menu},'menuId','menuParentId');

menu.on('itemclick',function(e){
	if(e.isLeaf){
		e.item.menuPath=e.item.menuPath.replace("pfweb","${webpfBaseImplAddress}");
		if(e.item.menuPath.indexOf("http")>=0){
			indexIframe.attr("src", e.item.menuPath)
		}else if(e.item.menuPath.indexOf("chrome-extension")>=0){
			indexIframe.attr("src", e.item.menuPath)
		}else if(e.item.menuPath.indexOf("?")>=0){
			indexIframe.attr("src", "../.."+e.item.menuPath.substring(0,e.item.menuPath.indexOf("?"))+"?v="+Math.random()+"&"+e.item.menuPath.substring(e.item.menuPath.indexOf("?")+1))
		}else{
			indexIframe.attr("src", ("../.."+e.item.menuPath+"?v="+Math.random()).replace("~",bundleUrl))
		}
		$(".mini-menuitem").removeClass("pf-header-nav-click");
		$(e.item.ownerMenu.ownerItem.el).addClass("pf-header-nav-click");
	}
});

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

