package com.kosta._0808;

public class ASCIIGetBytesTest {
	public static void main(String[] args) {
		String str="hi java stream!!!";
		/*
		 <byte�迭��ȯ>
		  byte b[] = str.getBytes();
		 <char�迭��ȯ>
		  char ch[] = str.toCharArray();
		 */
		byte b [] = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.write(b[i]);//����--->�������!!
			if(i%3==2) System.out.write('\n'); //3���� ���� ����� �ٹٲ�
		}
		
		//System.out.flush();//flush(): ��Ʈ���� �����ִ� �����͸� ���!!
						   //		    ��°�ü���� �����ϴ� �޼ҵ�.
		System.out.close();//System.out��ü�� �� ����߰� �ڿ��� ��ȯ
						   //flush()����� �⺻������ ����
	}
}
