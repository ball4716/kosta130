//ajax.js

var xhr=null;

function setXMLHttpRequest() {
	if (window.ActiveXObject) {//브라우저에서 ActiveXObject객체를 지원한다면(~IE10)
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");//IE6이상
		} catch (e) {
			xhr = new ActiveXObject("Microsoft.XMLHTTP");//IE5이하
		}
	} else if (window.XMLHttpRequest) {//비IE(크롬,사파리,파이어폭스,오페라..),IE11
		xhr = new XMLHttpRequest();
	}
}//setXMLHttpRequest

function sendRequest(url,params,callback,method){//서버페이지요청
	setXMLHttpRequest();//xhr초기화
	
	//open,send에 사용할 인자에 대한 초기화
	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	
	var httpParams = (params==null || params=='') ? null : params;
	var httpUrl = url;
	
	if(httpMethod=='GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams; // hello.jsp?name=길동
	}
	
	xhr.onreadystatechange = callback;
	xhr.open(httpMethod,httpUrl,true);//요청방식, 요청URL, 비동기
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xhr.send(httpMethod=='POST' ? httpParams : null);//POST였을때만 "name=길동"
}