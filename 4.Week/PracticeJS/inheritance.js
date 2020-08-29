function Father(){
	this.name = "father";
	this.show = function(){
		console.log("Hello " + this.name);
	}
}

Father.prototype. say = function(){
	console.log("hello father");
}

function Son(){
	
}

/* 1、原型链继承 */
Son.prototype = new Father();
Son.prototype.name = "son";


/* 2、构造继承：只能继承父类的实例方法，不能继承原型方法 */
function Son(){
	Father.call(this);
	this.name = "son";
}


/* 3、实例继承： 返回的不是真正的子类对象而是父类对象 */
function Son(){
	var f = new Father();
	f.name = "son";
	return f;
}


/* 4、拷贝继承： 内存消耗较大 */
function Son(){
	var f = new Father();
	
	for(var p in f){
		// f.name == f[name]
		Son.prototype[p] = f[p];
	}
	Son.prototype.name = "son";
}


/* 5. 组合继承 */
function Son(){
	Father.call(this);
}
//解决父类的原型属性和方法
Son.prototype = new Father();


/*6、寄生组合继承  */
function Son(){
	Father.call(this);
}

(function (){
	var Temp = function(){};
	Temp.prototype = Father.prototype;
	Son.prototype = new Temp();
})();

var s = new Son();
s.show(); 
s.say();