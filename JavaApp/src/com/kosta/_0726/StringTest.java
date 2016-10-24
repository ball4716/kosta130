package com.kosta._0726;

public class StringTest {
	public static void main(String[] args) {
		//Object s1="java";
		//Object s2="JAVA";
		String s1="java";
		String s2="JAVA";
		
		//���ڿ��� ����� �� : ��ü��.equals(��ü��), �޸𸮺� : ==
		
		if(s1.equals(s2)){//equals�� String �ڽ�Ŭ������ �������̵��� equals �޼ҵ� ȣ��!
			System.out.println("s1�� s2���ڿ� ���� ����!!");
		}else{
			System.out.println("s1�� s2���ڿ� ���� �ٸ�!");
		}
		
		//��ҹ��� ���� ���� ��
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("s1�� s2�� ö�ڰ� ����!!");
		}else{
			System.out.println("s1�� s2�� ö�ڰ� �ٸ�!!");
		}
		
		String str="JavaProgramming";
		//�ε���:     012345678901234
		
		System.out.println("str�� ���ڿ�����: "+str.length());
		
		//���ڿ� �빮�ڷ� ����
		System.out.println("str�� �빮�ڷ� ����: "+str.toUpperCase());
		//���ڿ� �ҹ��ڷ� ����
		System.out.println("str�� �ҹ��ڷ� ����: "+str.toLowerCase());
		
		//���ڿ����� 'a' ----> 'o' ��ȯ(��ü) : replace
		System.out.println("str.replace('a', 'o'): "+str.replace('a', 'o'));
		//str = str.replace('a', 'o');
		System.out.println("STR= "+str);
		
		//Ư������('P')�� �ش��ϴ� �ε����� ������!!
		//���ڿ� ���ڴ� ȣȯ�� ����!!  ---> 'a'(97)<100
		System.out.println("str.indexOf('P'): "+str.indexOf('P'));
		//str.indexOf(97) == str.indexOf('a')
		
		//Ư���ε����� �ش��ϴ� ���ڸ� ������
		//charAt(int index)
		System.out.println("str.charAt(4): "+str.charAt(4));
		
		//�κ�substring(int beginIndex)
		System.out.println("str.substring(str.indexOf('P')): "+
							str.substring(str.indexOf('P')));
						  //str.substring(4);
		
		//Ư�����ڿ��� ����: startsWith(String prefix)
		//Ư�����ڿ��� �������� üũ: endsWith(String suffix)
		System.out.println("str.startsWith(\"JAVA\"): "+str.startsWith("Java"));
		System.out.println("str.endsWith(\"ing\"): "+str.endsWith("ing"));
		
		//
		System.out.println("���繮�ڿ� str����(���ڰ���): "+str.length());
		str = str + "  ";
		System.out.println("STR= "+str+"("+str.length()+")");
		
		//���ڿ� �յ��� ���ӵ� ���ڿ��� ����: trim()
		str = str.trim();
		System.out.println("STR(��������)= "+str+"("+str.length()+")");
		

		/*
		 * 		   str.getBytes()			   str.toCharArray()
		 * 			<-----------                ------------->
		 *  byte b[]			String str="abc"			char ch[]
		 *  ={97,98,99}                                     ={'a','b','c'}
		 *  	    ----------->                <-------------
		 *  		new String(b);				new String(ch);
		 */
		String str2 = "abc";
		byte b[] = str2.getBytes();
		for (int  i= 0; i < b.length;i++) {
			System.out.println("["+i+"]="+b[i]);
		}
		
		char ch[] = str2.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.println("ch["+i+"]="+ch[i]);
		}
		
		String str3 = new String(b);
		System.out.println("STR3 = "+str3);
		
	}
}
