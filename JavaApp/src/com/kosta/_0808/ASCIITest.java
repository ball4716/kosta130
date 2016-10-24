package com.kosta._0808;

public class ASCIITest {//코드숫자에 매핑되는 문자를 화면에 출력
	
	public static void main(String[] args) {
		for (int i = 32; i < 127; i++) {
			System.out.write(i);
			if(i%8==7) System.out.write('\n');
			else System.out.write('\t');
		}
		
		System.out.flush();
		System.out.close();
	}
}