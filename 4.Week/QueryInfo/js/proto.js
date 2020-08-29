console.log(Array.prototype);
Array.prototype.sum = function(){
	var sum = 0;
	for(var i = 0; i < this.length; i++){
		sum += this[i];
	}
	return sum;
}
console.log(Array.prototype);
var arr = [1, 2, 3];
console.log(arr.sum());
