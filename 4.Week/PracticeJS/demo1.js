function Person(name, age){
	this.name = name;
	this.age = age;
	this.sayHello = function(){
		console.info("hello");
	}
};

/* 添加一个在多个实例中共享的属性 */
Person.prototype.city="Hangzhou";

new Person("p1", 20).sayHello()
console.log(new Person("p1", 20).city);