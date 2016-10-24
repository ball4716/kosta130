package com.kosta._0808;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
		//파일 읽기 fis.read(): 읽은 byte 대한 숫자코드를 반환
		//                   더 이상 읽을 byte가 없을 시 -1을 리턴
		
		int i;
		/*while((i=fis.read()) != -1){
			System.out.print((char)i); //(char)97 : 'a'
		}*/
		
		System.out.println("\n============================");
		//fis.read(byte b[]);
		//---> fis즉, a.txt를 통해 읽은 코드를 byte배열 b에 저장
		//리턴값은 read()를 통해 읽은 바이트수를 리턴
		byte b[]=new byte[5];
		//System.out.println(fis.read(b));
		//System.out.println(fis.read(b));
		/*while((i=fis.read(b))!=-1){		★
			System.out.println(new String(b));
		}*/
		
		
		//fis.read(byte[] b, int offset, int length) offset: 상대위치
		fis.read(b,3,2);//byte배열 b의 3번지부터 시작해서 2개를 저장!!
		for(int j=0; j<b.length; j++){
			System.out.println("b["+j+"]번지="+b[j]);
		}
		
		//===========출력객체 테스트================
		byte b2[] = {97,98,99,100};// 'a' 'b' 'c' 'd'
		
		FileOutputStream fos = new FileOutputStream("b.txt");
		//만약 b.txt파일이 없다면 해당경로에 b.txt파일을 생성
		
		//코드의 문자를 b.txt에 출력
		/*fos.write(97);
		fos.write(97);
		fos.write(97);*/
		
		//fos.write(b2);//b2배열의 값을 읽어서 fos 즉, b.txt에 출력
		
		//fos.write(byte[] b2, int offset, int length);
		fos.write(b2, 2,2);//b2배열의 2번지부터 2개의 byte를 읽어 fos에 복사
		
		System.out.println("파일출력 성공!!");
	}
}
