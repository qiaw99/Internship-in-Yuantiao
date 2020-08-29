/* 工厂方式创建类  */
function Car(name, color){
	var obj = new Object();
	obj.name = name;
	obj.color = color;
	obj.run = function(){
		console.log(this.name + " " + this.color + " is running...");
	}
	
	return obj;
}

/* 动态原型创建， run方法只会被创建一次 */
function Auto(name, color){
	this.name = name;
	this.color = color;
	if(typeof Auto.init() == "undefined"){
		Car.prototype.run = function(){
			console.log(this.name + " " + this.color + " is running...");
		}
		Car.init = true;
	}
}

var car = new Car("BMW", "red");
car.run();
