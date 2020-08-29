/* 如果函数没有参数，在调用的时候也可以传递参数， 
   通过arguments数组对象获得所有请求参数；
   
   如果函数有参数，调用是也可以不传参数*/
function a(){
	for(var i = 0; i < arguments.length; i++){
		console.log(i);
	}
	console.log("Hello World");
}

var user = {
	userName: "tom",
	say: function(){
		console.log("hello world");
	}
}

function Animal(){
	this.name = "animal", 
	this.say = function(){
		console.log("My name is: " + this.name);
	}
}

function Dog(){
	this.name = "Dog";
}

var animal = new Animal();
var dog = new Dog();

/* 实现调用其他对象的方法, call和apply的区别是传递参数的方法不一样*/
animal.say.call(dog, "", "");
//animal.say.apply(dog, ["", ""]);

a(1, 2, 3); 
user.say();