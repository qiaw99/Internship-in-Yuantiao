var menuConfig = {
	baseImpAddress:null,
	data:null,
	treeData:null,
	title:null
}
function dataRender(data, config, title, baseImpAddress){
	menuConfig.baseImpAddress = baseImpAddress;
	menuConfig.title = title;
	menuConfig.data = data;
	data.map(function(item){
		item.icon = item.iconCls;
		item.id = item.menuId;
		item.pid = item.menuParentId;
		item.url = item.menuPath;
		item.text = item.menuTitle;
		delete item.iconCls;
		delete item.menuParentId;
		delete item.menuPath;
		delete item.menuTitle;
	})
	menuConfig.treeData = treeList(data);
	switch(config){
	case "left":
		menuConfig.treeData.map(function(item){
		    if(item.children){
		      item.vertical = item.children;
		      delete item.children;
		    }
		  })
		break;
	case "left-only":
		menuConfig.treeData=[{img:"",id:"0",url:null,menuId:"0",key:"0",text:"",vertical:menuConfig.treeData}]
		break;
	case "default":
		break;
	}
	pf.get("menu").on("itemclick",function(e){
		itemClickCallback(e.item.id);
	})
	pf.get("menu").setData(menuConfig.treeData);
	if(config.indexOf("left-only")>=0){
		itemClickCallback("0");
	}
	$("body").delegate(".main-menubar .mini-menuitem","click",function(){
		$(".main-menubar .mini-menuitem").removeClass("menuActive");
		$(this).addClass("menuActive");
	})
	$("body").delegate(".mini-menu-open .mini-menuitem.menuClick","mousedown",function(){
		$(".main-menubar .mini-menuitem").removeClass("menuActive");
		$(".main-menubar .mini-menuitem.mini-menu-popup").addClass("menuActive");
	})
}
function treeList(data) {
    // 删除 所有 children,以防止多次调用
    data.forEach(function (item) {
    	item.key = item.id;
        delete item.children;
    });

    // 将数据存储为 以 id 为 KEY 的 map 索引数据列
    var map = {};
    data.forEach(function (item) {
        map[item.id] = item;
    });
    var val = [];
    data.forEach(function (item) {
        // 以当前遍历项，的pid,去map对象中找到索引的id
        var parent = map[item.pid];
        // 好绕啊，如果找到索引，那么说明此项不在顶级当中,那么需要把此项添加到，他对应的父级中
        if (parent) {
            (parent.children || ( parent.children = [] )).push(item);
        } else {
            // 如果没有在map中找到对应的索引ID,那么直接把 当前的item添加到 val结果集中，作为顶级
            val.push(item);
        }
    });
    return val;
}
function itemClickCallback(str){
	var data = getData(str, "horizontal");
    $(".main-sidebar").remove();
    if(data.url){
    	var url = setUrl(data.url);
        document.getElementById("iframeWindow").src=url;
    }else if(data.vertical){
        $(".main-sidebar").remove();
        sidebarDevelop(data.vertical);
    }
}
function setUrl(url){
	if(url==null){
		return;
	}
	url=url.replace("pfweb",menuConfig.baseImpAddress);
	if(url.indexOf("@")>=0){
		window.open(url.substring(url.indexOf("@")+1));
		return 
	}else if(url.indexOf("http")>=0 || url.indexOf("chrome-extension")>=0){
		url = url;
	}else if(url.indexOf("?")>=0){
		url = "../.."+url.substring(0,url.indexOf("?"))+"?v="+Math.random()+"&"+url.substring(url.indexOf("?")+1);
	}else{
		url = ("../.."+url+"?v="+Math.random()).replace("~",bundleUrl);
	}
	return url
}

function sidebarDevelop(data, type){
    if(type == "true"){
        $(".content").prepend("<aside class='main-sidebar main-sidebar-vertical'><div class='main-sidebarIn'><section  class='sidebar'><ul class='sidebar-menu'></ul></section></div><div class='main-sidebar-btn' style='background: #000;' ><i class='fa fa-angle-left'></i></div></div>"); 
    }else{
        $(".content").prepend("<aside class='main-sidebar'><div class='main-sidebarIn'><section  class='sidebar'><ul class='sidebar-menu'></ul></section></div><div class='main-sidebar-btn' style='background: #000;' ><i class='fa fa-angle-left'></i></div></div>"); 
    }
    $(document).on("click", ".main-sidebar-btn", function(){
	    $(".main-sidebar").toggleClass("main-sidebar-collapse");
	    $(".main-sidebar-btn i").toggleClass("fa-angle-right");
	})
    var arr = sidebarChild(data);
    $(".sidebar-menu").append(arr);
    $(".sidebar-menu .treeview-angle a").eq(0).trigger('click');
    $(document).find(".sidebar-menu .treeview-angle").eq(0).trigger('click');

    if(data[0].children){
        $(".sidebar-menu li a").eq(0).trigger('click');
        if(data[0].children[0].children){
            $(".sidebar-menu li a").eq(1).trigger('click');
        }
    }
    $(".treeview-angle").bind("click",function(e){
    	var $this = $(this);
        $(" .treeview-angle").removeClass("treeview-angle-active");
        $this.addClass("treeview-angle-active");
        var index = this.getAttribute("key");
        var data = getData(index, "vertical");
        var url = setUrl(data.url);
        document.getElementById("iframeWindow").src=url;
    })
    $(".sidebar-menu li a").bind("click",function(e){
    	var animationSpeed = 300;
    	var $this = $(this);
        var checkElement = $this.next();
        if (checkElement.is('.treeview-menu') && checkElement.is(':visible')) {
	        checkElement.slideUp(animationSpeed, function() {
	            checkElement.removeClass('menu-open');
	        });
	        checkElement.parent("li").removeClass("active");
        }
        else if ((checkElement.is('.treeview-menu')) && (!checkElement.is(':visible'))) {
        	var parent = $this.parents('ul').first();
        	var parent_li = $this.parent("li");
        	checkElement.slideDown(animationSpeed, function() {
        		checkElement.addClass('menu-open');
        		parent_li.addClass('active');
        	});
        }
        if (checkElement.is('.treeview-menu')) {
        e.preventDefault();
        }
    })
    
    $(".treeview-angle").eq(0).click();
}

function sidebarChild(data){
    var child = "";
    var arr = "";
    data.map(function(item){
        if(item.type == "separator"){
            return
        }
        if(item.children){
            arr = "<ul class='treeview-menu'>" + sidebarChild(item.children) + "</ul>";
            child = child + "<li class='treeview' key='"+ item.key +"'><a href='#'><i class='"+ item.icon +"'></i><span>"+ item.text +"</span><i class='fa fa-angle-down pull-right'></i></a>"+ arr +"</li>"
        }else{
            child = child + "<li class='treeview treeview-angle' key='"+ item.key +"'><a href='#'><i class='"+ item.icon +"'></i><span>"+ item.text +"</span></a></li>"
        }
    })
    return child
}

function getData(str, type){
	if(str=="0"){
		return menuConfig.treeData[0];
	}
	for(var i=0;i<menuConfig.data.length;i++){
		if(menuConfig.data[i].id==str){
			return menuConfig.data[i];
		}
	}
    return null   
}





