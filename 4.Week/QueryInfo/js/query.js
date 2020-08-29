var data = [{
	id: 1,
	pname: "小米",
	price: 3999
}, {
	id: 2,
	pname: "oppo",
	price: 999
}, {
	id: 3,
	pname: "荣耀",
	price: 1299
}, {
	id: 4,
	pname: "华为",
	price: 1999
}];

var tbody = document.querySelector("tbody");

var search_price = document.querySelector(".search-price");
var start = document.querySelector(".start");
var end = document.querySelector(".end");
var product = document.querySelector(".product");
var search_pro = document.querySelector(".search-pro");

setData(data);

function setData(data) {
	tbody.innerHTML = '';
	data.forEach(function(value) {
		/* console.log(value); */
		var tr = document.createElement("tr");
		tr.innerHTML = "<td>" + value.id + "</td>" + "<td>" + value.pname + "</td>" + "<td>" + value.price + "</td>";
		tbody.appendChild(tr)
	});
}

search_price.addEventListener("click", function() {
	var newArray = data.filter(function(value) {
		return value.price >= start.value && value.price <= end.value;
	});
	setData(newArray);
});

search_pro.addEventListener("click", function(){
	var arr = [];
	data.some(function(value){
		if(value.pname === product.value){
			arr.push(value);
			return true;
		}
	});
	setData(arr);
});
