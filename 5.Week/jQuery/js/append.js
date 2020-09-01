$(function(){
	/* 1.append() 父元素.append(子元素),作为最后一个添加 */
	$('#btnAppend').click(function(){
		var $liNew = $('<li>new li</li>');
		$('#ul1').append($liNew);
		
		//把已经存在的li标签加到ul中：剪贴作为最后一个子元素添加
		var $li3 = $('#li3');
		$('#ul1').append($li3);
		
		//把ul2中的li标签加到ul中： 剪切后作为为最后一个元素
		var $li32= $('#li32');
		$('#ul1').append($li32);
	});
	
	
	/* 2.prepend() 作为第一个元素添加*/
	$('#btnPrepend').click(function(){
		var $liNew = $('<li>new li</li>');
		$('#ul1').prepend($liNew);
	});
	
	/* 3.before() A.before(B): 把元素B插入到元素A的前面，作为兄弟元素 */
	$('#btnBefore').click(function(){
		var $divNew = $('<div>new div</div>');
		$('#ul1').before($divNew);
	});
	
	/* 4.after() */
	$('#btnAfter').click(function(){
		var $divNew = $('<div>new div</div>');
		$('#ul1').after($divNew);
	});
	
	/* 5. appendTo(): 子元素.appendTo(父元素) 把子元素作为父元素的最后一个子元素添加 */
	$('#btnAppendTo').click(function(){
		var $liNew = $('<li>new li</li>');
		$liNew.appendTo('#ul1');
	});
});