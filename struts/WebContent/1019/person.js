//person.js

/*
<클래스 정의>
클래스명 = function(){

}

<속성도 정의>
클래스명=function(){
	this.속성명=데이터;
}

<함수(메소드) 정의>
클래스명.prototype.함수명=function(){

}
*/

/*Person = function(){
	alert('Person생성자');
}*/

Person = function(name,age,job){
	this.name=name;
	this.age=age;
	this.job=job;
}

Person.prototype.toString=function(){
	return "[이름:"+this.name+", 나이:"+this.age+", 직업:"+this.job+"]";
}

Person.prototype.setAge=function(age){
	this.age=age;
}

Person.prototype.setJob=function(job){
	this.job=job;
}

Person.prototype.getName=function(){
	return this.name;
}