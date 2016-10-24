package com.kosta._0808;

import java.io.File;
import java.io.FileOutputStream;

public class FileTest {
	public static void main(String[] args) throws Exception{
		//File f = new File(String 경로);
		/*
		  <자바의 파일경로 표현방법>
		  - 기본: 전체경로 전부 표기!!
		    "C:\ball4716\workspace\JavaApp\0808\a.txt"
		  
		  - 각 폴더(디렉토리)와 파일을 구분하기 위해 '/'를 사용
		    "C:/ball4716/workspace/JavaApp/0808/a.txt"
		    
		  - 이클립스의 JavaProject로 생성된 프로젝트내의 경로는
		        프로젝트명까지를 생략한 상태로 사용하는 것이 가능.
		    "0808/a.txt" 
		 */
		File f = new File("abb.txt");
		File f2 = new File("0808");
		System.out.println("존재하는 파일?"+f.exists());
		
		System.out.println("f는 파일입니까?"+f.isFile());
		System.out.println("f는 디렉토리(폴더)입니까?"+f.isDirectory());
		
		System.out.println("f2는 파일입니까?"+f2.isFile());
		System.out.println("f2는 디렉토리(폴더)입니까?"+f2.isDirectory());
		
		System.out.println("파일이름: "+f.getName());
		System.out.println("f.getPath(): "+f.getPath());
		System.out.println("f.getAbsolutePath(): "+f.getAbsolutePath());
		System.out.println("f.getCanonicalPath(): "+f.getCanonicalPath());
		
		System.out.println("f.getParent(): "+f.getParent());//f: a.txt
		System.out.println("f.length(): "+f.length());//영문,숫자:1  한글:2//
		
		//파일지우기
		boolean flag = f.delete();
		if(flag){
			System.out.println("파일삭제성공!!");
		}else{
			System.out.println("파일삭제실패");
		}
		
		File f3= new File("junghoon/jeong/a.txt");
		System.out.println("정훈폴더는 존재? "+f3.exists());
		boolean flag2 = f3.mkdirs();//mkdirs: make directory
		
		if(flag2){
			System.out.println("폴더생성성공!!");
		}else{
			System.out.println("폴더생성실패!!");
		}
		
		//파일생성기능은 FileOutputStream, FileWriter가 가지고 있음
		FileOutputStream fos = new FileOutputStream("junghoon/jeong/b.txt");
	}
}