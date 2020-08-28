var a = 10;
var b = 10;
var temp = a + b;

var str = new String("test");
//alert(str);

var reg = new RegExp("/^c*$/");

/* 普通方式创建的正则对象， 除非全部字符不符合正则-->返回false */
/* var reg2 = /\s+/;
alert(reg2.test(" ")); */

/* 只要由一个字符不符合就返回false */
var reg2 = /^\s+$/;
//alert(reg2.test(" "));

// initialize the array
var arr = [1, 2, 3, 4, 5];
var arr = new Array();
var arr = new Array(5);
var arr = new Array(1, 2, 3, 4, 5);

str = arr.join();
//alert(str);
var id;

function run(id){
	alert("running");
	//取消循环定时器
	clearInterval(id);
}

function run2(){
	alert("running...");
}

//循环定时器
id = setInterval("run(id)", 100);

//一次性定时器
var newId = setTimeout("run2()", 1000);
clearTimeout(newId); 

