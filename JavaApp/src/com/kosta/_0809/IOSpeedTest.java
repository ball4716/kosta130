package com.kosta._0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

public class IOSpeedTest {
	FileInputStream fis;  //파일을 1byte단위로 읽겠다 fis.read();
	FileOutputStream fos; //파일을 1byte단위로 쓰겠다 fos.write(출력데이터);
	
	FileReader fr; //파일을 문자(2byte)단위로 파일에 읽겠다!
	FileWriter fw; //파일을 문자(2byte)단위로 파일에 쓰겠다!
	
	BufferedReader br;
	//문자를 버퍼에 담았다가 특정신호(엔터, 라인단위)에한꺼번에 읽겠다.
	BufferedWriter bw; //버퍼에 담긴 데이터를 파일에 쓰겠다.
	
	public IOSpeedTest() throws Exception {
		//a.txt --------파일복사---------> b.txt
		
		fis = new FileInputStream("a.txt");//("image/gong.jpg");//("a.txt");
		fos = new FileOutputStream("b.txt");//("image/yoo.jpg");//("b.txt");
		
		int i;
		
		byte b[]=new byte[1024];//보통 배열 사이즈 512, 10
		
		long start = System.currentTimeMillis();
		/*while((i=fis.read())!=-1){//읽을 바이트가 있다면
			fos.write(i);
		}*/
		
		while((i=fis.read(b))!=-1){//읽을 바이트가 있다면
			fos.write(b,0,i);//바이트 배열로부터 read한 숫자만큼만 복사!
		}
		long end = System.currentTimeMillis();
		
		System.out.println("파일복사성공1 : "+(end-start));
		
		fos.close();
		fis.close();
		
		//--------------------------------------------------
		fr = new FileReader("a.txt");
		fw = new FileWriter("b.txt");
		
		start = System.currentTimeMillis();
		while ((i=fr.read())!=-1){//읽을 문자가 있다면
			fw.write(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("파일복사성공2 : "+(end-start));
		fw.close();
		fr.close();
		
		//--------------------------------------------------
		br = new BufferedReader(new FileReader("a.txt"));//("image/gong.jpg"));//("a.txt");
		bw = new BufferedWriter(new FileWriter("b.txt"));//("image/you.jpg"));
		
		String str;
		//br.readLine(): 라인한줄을 문자열로 리탄.,
		               //만약 더이상 읽을 라인이 없다면 null을 리턴
		start = System.currentTimeMillis();
		while((str=br.readLine())!=null){//읽을 라인이 있다면
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("파일복사성공3 : "+(end-start));
		br.close();
		bw.close();
	}//생성자
	public static void main(String[] args) throws Exception {
		new IOSpeedTest();
	}
}
