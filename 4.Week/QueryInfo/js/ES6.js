/* 箭头函数，小括号里传递形参， 大括号里是函数体 */
/* 箭头函数不绑定this。箭头函数没有自己的this关键字。 如果在箭头函数中使用this，
this关键字指向函数定义位置中的this*/
const fn = (n1, n2) => {
	console.log(n1 + n2);
}

fn(2, 3);

/* 剩余参数 */
function sum(first, ...args){
	console.log(first);
	console.log(args);
}

sum(1, 2, 3);

let students = [1, 2, 3, 4]
let [s1, ...s2] = students;

console.log(s1);
console.log(s2);

/* Array扩展方法 扩展运算符：可以将数组或者对象转为逗号分隔的参数序列 */
console.log(...students);

/* 合并数组 */
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
let arr3 = [...arr1, ...arr2];
console.log(arr3);

//alternative
arr1.push(...arr2);

//伪数组
let arrayLike = {
	'0': '3',
	'1': '4',
	'2': '5',
	length: 3
};

//真正的数组
let arr = Array.from(arrayLike, item => {
	return item * 2;
});
console.log(arr);

let people = [{
	id: 1,
	name: 'p1'
}, {
	id: 2,
	name: 'p2'
}]

//若不存在则返回undefined
let target = people.find((item, index) => item.id == 2);

// 找出第一个符合条件元组的index，如果没有则返回-1
let nums = [1, 5, 10, 15];
let index = nums.findIndex((value, index) => value > 9);
console.log(index);

//数组包含某个特定值
console.log([1, 2, 3].includes(2));

// 模板字符串中可以解析变量
let name = "模板字符串!";
let sayHello = `Hello, my name is ${name}`;
console.log(sayHello);

let str = "Hello World!";
str.startsWith("Hello");
str.endsWith("!");

'x'.repeat(3);	//xxx

// Set data structure
const s = new Set([1, 2, 3, 4, 4, 4]);
console.log(s);

s.add(5);
s.delete(2);
s.has(1);

s.forEach(value =>{
	console.log(value);
})

s.clear();
