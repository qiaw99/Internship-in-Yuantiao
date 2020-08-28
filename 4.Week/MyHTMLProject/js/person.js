// define a class
function Person(name, age){
	this.name = name;
	this.age = age;
}

var p = new Person("p1", 20);
console.log(p.age);

var flag = confirm("delete");
alert(flag);