package com.kosta._0808;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputOutputTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
		//���� �б� fis.read(): ���� byte ���� �����ڵ带 ��ȯ
		//                   �� �̻� ���� byte�� ���� �� -1�� ����
		
		int i;
		/*while((i=fis.read()) != -1){
			System.out.print((char)i); //(char)97 : 'a'
		}*/
		
		System.out.println("\n============================");
		//fis.read(byte b[]);
		//---> fis��, a.txt�� ���� ���� �ڵ带 byte�迭 b�� ����
		//���ϰ��� read()�� ���� ���� ����Ʈ���� ����
		byte b[]=new byte[5];
		//System.out.println(fis.read(b));
		//System.out.println(fis.read(b));
		/*while((i=fis.read(b))!=-1){		��
			System.out.println(new String(b));
		}*/
		
		
		//fis.read(byte[] b, int offset, int length) offset: �����ġ
		fis.read(b,3,2);//byte�迭 b�� 3�������� �����ؼ� 2���� ����!!
		for(int j=0; j<b.length; j++){
			System.out.println("b["+j+"]����="+b[j]);
		}
		
		//===========��°�ü �׽�Ʈ================
		byte b2[] = {97,98,99,100};// 'a' 'b' 'c' 'd'
		
		FileOutputStream fos = new FileOutputStream("b.txt");
		//���� b.txt������ ���ٸ� �ش��ο� b.txt������ ����
		
		//�ڵ��� ���ڸ� b.txt�� ���
		/*fos.write(97);
		fos.write(97);
		fos.write(97);*/
		
		//fos.write(b2);//b2�迭�� ���� �о fos ��, b.txt�� ���
		
		//fos.write(byte[] b2, int offset, int length);
		fos.write(b2, 2,2);//b2�迭�� 2�������� 2���� byte�� �о� fos�� ����
		
		System.out.println("������� ����!!");
	}
}
