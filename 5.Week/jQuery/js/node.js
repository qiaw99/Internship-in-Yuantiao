$(function() {
	//原生js中创建节点: documeent.write('<div></div>'); innerHTML, document.createElement('div');

	/* jQuery创建节点: */
	// 1.html()设置或者获取内容
	$('#btnHtml').click(function(){
		// 获取内容：html()方法不加参数
		console.log($('#div1').html());

		//设置内容: 如果设置的内容中包含了标签，标签会被解析出来
		$('#div1').html("changed content <a href='http://news.baidu.com/'>news</a>");
	});
	
	// 2. $()能够创建元素，但是创建的元素只存在于内存中，如果要在页面上显示，就要追加
	$('#btn').click(function(){
		var $link = $('<a href="http:news.baidu.com/">news</a>');
		console.log($link);
		//追加节点
		$('div').append($link);
	})

})
