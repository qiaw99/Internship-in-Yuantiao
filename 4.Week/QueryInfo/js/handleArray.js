var arr = [1, 2, 3];
var sum = 0;
arr.forEach(function(value, index, array){
	console.log(value);
	console.log(index);
	console.log(array);
	console.log("********");
	sum += value;
	console.log(sum);
});

var arr1 = [12, 66, 4, 88];
var newArr = arr1.filter(function(value, index, array){
	return value >= 20;
});
console.log(newArr);

var arr2 = [10, 30, 4];
var flag = arr2.some(function(value, index, array){
	return value >= 20;
});
console.log(flag);
