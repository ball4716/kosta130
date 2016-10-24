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
	FileInputStream fis;  //������ 1byte������ �аڴ� fis.read();
	FileOutputStream fos; //������ 1byte������ ���ڴ� fos.write(��µ�����);
	
	FileReader fr; //������ ����(2byte)������ ���Ͽ� �аڴ�!
	FileWriter fw; //������ ����(2byte)������ ���Ͽ� ���ڴ�!
	
	BufferedReader br;
	//���ڸ� ���ۿ� ��Ҵٰ� Ư����ȣ(����, ���δ���)���Ѳ����� �аڴ�.
	BufferedWriter bw; //���ۿ� ��� �����͸� ���Ͽ� ���ڴ�.
	
	public IOSpeedTest() throws Exception {
		//a.txt --------���Ϻ���---------> b.txt
		
		fis = new FileInputStream("a.txt");//("image/gong.jpg");//("a.txt");
		fos = new FileOutputStream("b.txt");//("image/yoo.jpg");//("b.txt");
		
		int i;
		
		byte b[]=new byte[1024];//���� �迭 ������ 512, 10
		
		long start = System.currentTimeMillis();
		/*while((i=fis.read())!=-1){//���� ����Ʈ�� �ִٸ�
			fos.write(i);
		}*/
		
		while((i=fis.read(b))!=-1){//���� ����Ʈ�� �ִٸ�
			fos.write(b,0,i);//����Ʈ �迭�κ��� read�� ���ڸ�ŭ�� ����!
		}
		long end = System.currentTimeMillis();
		
		System.out.println("���Ϻ��缺��1 : "+(end-start));
		
		fos.close();
		fis.close();
		
		//--------------------------------------------------
		fr = new FileReader("a.txt");
		fw = new FileWriter("b.txt");
		
		start = System.currentTimeMillis();
		while ((i=fr.read())!=-1){//���� ���ڰ� �ִٸ�
			fw.write(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("���Ϻ��缺��2 : "+(end-start));
		fw.close();
		fr.close();
		
		//--------------------------------------------------
		br = new BufferedReader(new FileReader("a.txt"));//("image/gong.jpg"));//("a.txt");
		bw = new BufferedWriter(new FileWriter("b.txt"));//("image/you.jpg"));
		
		String str;
		//br.readLine(): ���������� ���ڿ��� ��ź.,
		               //���� ���̻� ���� ������ ���ٸ� null�� ����
		start = System.currentTimeMillis();
		while((str=br.readLine())!=null){//���� ������ �ִٸ�
			bw.write(str);
		}
		end = System.currentTimeMillis();
		System.out.println("���Ϻ��缺��3 : "+(end-start));
		br.close();
		bw.close();
	}//������
	public static void main(String[] args) throws Exception {
		new IOSpeedTest();
	}
}
