var obj = {
	id: 1,
	pname: "xiaomi",
	price: 1999
};

/* 1. 以前的对象添加或者修改属性的方式*/
obj.num = 1000;
obj.price = 999;

/* 2.利用Object.defineProperty(obj, prop, descriptor)
descriptor{value: , writable: ,enumerable: , configurable}
value默认为undefined
writable: 值是否可以重写；configurable：属性是否可以被删除或是否可以再次修改特性
都默认为false
 */
Object.defineProperty(obj, 'num', {
	value: 1000,
});

Object.defineProperty(obj, 'id', {
	writable: false,
}); 

/* 遍历的时候该属性不会被显示 */
Object.defineProperty(obj, 'address',{
	value: "山东蓝翔",
	enumerable: false,
	configurable: false,
});

/* 获取自身所有的属性名称 */
var arr = Object.keys(obj);
arr.forEach(function(value){
	console.log(value);
});

/* 该属性不会被删除，因为在定义的时候的configurable属性为false */
delete obj.address;
