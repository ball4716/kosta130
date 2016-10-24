package com.kosta._0808;

public class ASCIIGetBytesTest {
	public static void main(String[] args) {
		String str="hi java stream!!!";
		/*
		 <byte배열변환>
		  byte b[] = str.getBytes();
		 <char배열변환>
		  char ch[] = str.toCharArray();
		 */
		byte b [] = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.write(b[i]);//숫자--->문자출력!!
			if(i%3==2) System.out.write('\n'); //3개의 문자 출력후 줄바꿈
		}
		
		//System.out.flush();//flush(): 스트림에 남아있는 데이터를 출력!!
						   //		    출력객체에만 존재하는 메소드.
		System.out.close();//System.out객체를 다 사용했고 자원을 반환
						   //flush()기능을 기본적으로 내장
	}
}
