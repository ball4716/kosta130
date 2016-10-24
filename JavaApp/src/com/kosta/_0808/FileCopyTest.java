package com.kosta._0808;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	//a.txt를 읽어서 b.txt라는 파일에 내용을 그대로 출력(파일복사)
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
		FileOutputStream fos = new FileOutputStream("b.txt");
		
		byte b[] = new byte[512];//fis -------바이트배열--------> fos 내용전달
				
		int i;//i: 읽은 바이트수가 저장
		while ((i=fis.read(b))!=-1){//fis ----> b
			fos.write(b,0,i);//fos <---- b
		}
		
		//입출력 객체는 자원에 대한 반환
		fos.close();
		
		System.out.println("파일복사성공!!");
	}
}
