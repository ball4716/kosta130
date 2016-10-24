package com.kosta._0726;

public class StringTest2 {
	public static void main(String[] args) {
		System.out.println("===============����1================");
		String str="Java3Prog8ramm4ing";
		//����1) str�ȿ� ���� ������ ������ ����Ͻÿ�.
		//��Ʈ: getBytes(), toCharArray(), charAt(int index)
		
		byte[] b = str.getBytes(); //����Ʈ�迭�� ��ȯ
		int numCount=0;//����ī��Ʈ
		//'0' ----> 48  '1' ----> 49  '9' ----> 57 : 48~57
		for (int i = 0; i < b.length; i++) {
			if(b[i]>47 && b[i]<58)
				numCount++;
		}
		System.out.println("STR���� ������ ������ "+numCount+"�� �Դϴ�");
		
		
		char ch[] = str.toCharArray(); //ĳ���͹迭�� ��ȯ
		numCount=0;
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]>='0' && ch[i]<='9')
				numCount++;
		}
		System.out.println("STR���� ������ ������ "+numCount+"�� �Դϴ�");
		
		numCount=0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>'0'-1 && str.charAt(i)<'9'+1)
				numCount++;
		}
		System.out.println("STR���� ������ ������ "+numCount+"�� �Դϴ�");
		
		System.out.println("===============����2-1���================");
		
		String tel="010-1234-4567";
		String tel1,tel2,tel3;
		//����2) tel1="010", tel2="1234", tel3="4567"
		//��Ʈ: indexOf(), substring()
		
		//tel.substring(int beginIndex), tel.substring(int beginIndex, int endIndex)
		tel1 = tel.substring(0, 3);
		tel2 = tel.substring(4, 8);
		tel3 = tel.substring(9);
		
		System.out.println("TEL1: "+tel1);
		System.out.println("TEL2: "+tel2);
		System.out.println("TEL3: "+tel3);
		
		System.out.println("===============����2-2���================");
		
		int sliceIndex1=tel.indexOf('-'); // 3
		int sliceIndex2=tel.lastIndexOf('-'); //8
				
		tel1 = tel.substring(0, sliceIndex1); //(0, 3)
		tel2 = tel.substring(sliceIndex1+1, sliceIndex2); //(4, 8)
		tel3 = tel.substring(sliceIndex2+1);//(9)
		
		System.out.println("TEL1: "+tel1);
		System.out.println("TEL2: "+tel2);
		System.out.println("TEL3: "+tel3);
		
		System.out.println("===============����2-3���================");
		
		String temp;
		int sliceIndex=tel.indexOf('-');
		tel1=tel.substring(0, sliceIndex);
		
		temp=tel.substring(sliceIndex+1);
		sliceIndex=temp.indexOf('-');
		
		tel2=temp.substring(0,sliceIndex);
		tel3=temp.substring(sliceIndex+1);
		
		System.out.println("TEL1: "+tel1);
		System.out.println("TEL2: "+tel2);
		System.out.println("TEL3: "+tel3);
	}

}