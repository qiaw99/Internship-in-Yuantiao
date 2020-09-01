$(function(){
	/* 显示隐藏 */
	$('#show').click(function(){
		/* 参数1：执行动画的时常（毫秒）
		   或者是表示时长的字符串
				fast：200ms
				normal：400ms
				slow：600ms
		   参数2： 动画执行完毕后的回调函数
		*/
		$('#div1').show(2000, function(){
			alert('animation completed!')
		});
	});
	
	$('#hide').click(function(){
		$('#div1').hide(2000, function(){
			alert("Animation hidden!");
		});
	});
	
	$('#toggle').click(function(){
		$('#div1').toggle(2000);
	});
	
	/* 滑入滑出 */
	$('#slideDown').click(function(){
		$('#div1').slideDown(2000);
	});
	
	$('#slideUp').click(function(){
		$('#div1').slideUp(2000);
	});
	
	$('#slideToggle').click(function(){
		$('#div1').slideToggle(2000);
	});
	
	/* 淡入淡出 */
	$('#fadeIn').click(function(){
		$('#div1').fadeIn(2000);
	});
	
	$('#fadeOut').click(function(){
		$('#div1').fadeOut(2000);
	});
	
	$('#fadeToggle').click(function(){
		$('#div1').fadeToggle(2000);
	});
	
	$('#fadeTo').click(function(){
		$('#div1').fadeTo(2000, 0.5);
	});
	
	/* 自定义动画
	   参数1： 对象，需要坐做的动画的属性
	   参数2： 速度, 执行动画的时长
	   参数3： easing 代表是缓动还算匀速 swing linear 默认是swing
	   参数4： 回调函数  
	 */
	$('#lr800').click(function(){
		$('#div2').animate({
			left: "300px",
			width: 300,
			height: 300,
			opacity: 0.5
		}, 2000, "swing", function(){
			$('#div2').animate({
				left: "150px",
				width: 200,
				height: 300,
				top: 150,
				opacity: 1
			}, 2000)
		});
	});
	
	/* 动画队列 */
	$('#start').click(function(){
		$('#div2').stop(true, false).slideDown(2000);
	});
	
	/* 停止动画	
	   第一个参数： 是否清除队列
	   第二个参数： 是否跳转到最终效果
	   默认都是false
	 */
	$('#end').click(function(){
		$('#div2').stop(true, false).slideUp(2000);
	});
	
});
