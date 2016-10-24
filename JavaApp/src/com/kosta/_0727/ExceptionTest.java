package com.kosta._0727;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ExceptionTest {
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("a.txt");
			// 파일의 경로는 "드라이브:\경로\파일명" "C:\ball4716\workspace\JavaApp\a.txt"
			// 이클립스 JavaProject의 경우는 프로젝트까지의 경로를 생략하는 것이 가능!
			//System.out.println(fr.read());//더이상 읽을 문자가 없을때 -1리턴
			//(char)97 98 99 -1 -1
			int i;
			while((i=fr.read()) != -1){
				System.out.print((char)i+" ");
			}
		} catch (FileNotFoundException e) {
			//try영역에 예외가 발생했을때 실행할 블럭!!
			System.out.println("예외객체 e : "+e);//e == e.toString()
			System.out.println("예외객체 e.toString() : "+e.toString());
			System.out.println("e.getMessage() : "+e.getMessage());
			e.printStackTrace();//원인과 인과관계를 명확히 보여준다
		} catch (IOException e) {

		}
	}// main
}
