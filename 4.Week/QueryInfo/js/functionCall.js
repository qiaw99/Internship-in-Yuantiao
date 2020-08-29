/* 1.自定义函数 */
function fn() {};

/* 2.函数表达式 */
var fun = function() {};

/* 3.利用new Function("arg1", "arg2", ..., function body) */
var f = new Function("a", "b", "console.log(a + b)");

// f(2, 3);

/* 改变函数内的this指向：call(), apply(), bind() */

/* 1. call() */
var obj = {
	name: "p1",
};

function fn(a, b) {
	// window
	console.log(this);
	console.log(a + b);
}

fn.call(obj, 1, 2);

/* 2. apply(), 参数要使用数组*/
fn.apply(obj, [1, 2]);

var arr = [1, 2, 3, 4, 5];
console.log(Math.max.apply(Math, arr));

/* 3. bind():不会调用函数，但是能改变函数内部this指向,
 返回的是原函数改变this之后产生的新函数*/
var f = fn.bind(obj, 1, 3);
f();

var btn = document.querySelector("button");
// var that = this;
btn.onclick = function() {
	this.disabled = true; // this指向button
	setTimeout(function(){
		// that.disabled = false;
		//定时器函数里的this指向的是window
		this.disabled = false;	
	}.bind(this), 3000);
}
