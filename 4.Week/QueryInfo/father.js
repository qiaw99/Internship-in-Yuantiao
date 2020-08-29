class Father{
	constructor(x, y) {
	    this.x = x;
		this.y = y;
	}
	
	money(){
		console.log(100);
	}
	
	sum(){
		console.log(this.x + this.y);
	}
}

class Son extends Father{
	constructor(x, y) {
	    super(x, y);
	}
	
	substract(x, y){
		console.log(this.x - this.y);
	}
}

var son = new Son(1, 2);
son.substract();