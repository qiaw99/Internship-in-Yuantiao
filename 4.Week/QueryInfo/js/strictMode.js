/* 严格模式 */
'use strict';
/* 
1、变量必须用var声明
2、不能删除已经声明的变量
3、严格模式下全局作用域中函数的this是undefined
4、如果构造函数不加new调用，this会报错
5、定时器的this还是指向window
6、函数中的形参不允许重名
*/

function fn(){
	'use strict';
	num = 10;
	console.log(num);
}

function fun(){
	num = 10;
	console.log(num);
}

fun();