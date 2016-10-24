package com.kosta._0829;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesTest {
   public static void main(String[] args) throws Exception{
	  Properties pro = new Properties();//속성클래스
	  //데이터: 속성, property, attribute
	  //제네릭을 사용하지 않는 이유? String데이터(text)만 입력!!   
	  
	    //데이터 입력
	    //pro.setProperty(String key,String value);//key:변수, value:데이터
	    pro.setProperty("k1", "나길동");
	    pro.setProperty("k2", "차라임");
	    pro.setProperty("k3", "고주원");
	    pro.setProperty("k1", "홍길동");
	    
        //데이터 조회
	    System.out.println("k1키에 저장값="+pro.getProperty("k1"));
	    System.out.println("k2키에 저장값="+pro.getProperty("k2"));
	    System.out.println("k3키에 저장값="+pro.getProperty("k3"));
	    System.out.println("k4키에 저장값="+pro.getProperty("k4"));
	    
	    //properties파일을 로드하기!!
	    //pro.load(Reader reader);
	     pro.load(new FileReader("src/com/kosta/_0829/test.properties"));
	     System.out.println("이름: "+ pro.getProperty("name"));
	     System.out.println("나이: "+pro.getProperty("age"));
	     System.out.println("직업: "+pro.getProperty("job"));
   }
}



