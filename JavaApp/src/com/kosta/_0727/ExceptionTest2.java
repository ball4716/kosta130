package com.kosta._0727;

public class ExceptionTest2 {//��Ÿ�ӽ� Exception �߻� ���ɼ�
	public static void main(String[] args) {
		/*
		  		su1     su2
		  		10       5    : ����
		  		10            : ArrayIndexOutOfBoundsException
		  		ab		 cd   : NumberFormatException
		  		10		 0    : ArithmeticException
		 */
		try{
		System.out.println("�Ű������� ���� �μ��� ��");
		int su1 = Integer.parseInt(args[0]);//index,number
		int su2 = Integer.parseInt(args[1]);//index,number
		System.out.println("su1= "+su1+", su2="+su2);
		System.out.println("su1�� su2�� ���� ��= "+(su1/su2));//Arithmetic
		System.out.println("�������� ��Ȱ�� �����Ͽ����ϴ�!!!");
		}catch(NumberFormatException e){
			System.out.println("�������� ����: "+ e.getMessage());
			return;
		}catch(Exception e){
			System.out.println("��翹�ܻ�Ȳ ó��: "+e);
			return;
		}finally{
			System.out.println("finally: ���ܹ߻��� ������� ������ �����ϴ� ����");
		}
		
		System.out.println("Exception�� return;������ ���� �ȵɼ��� �ִ� ����������~!!");
		/*catch(ArrayIndexOutOfBoundsException e){
			System.out.println("����� �ε��� ���� ����:"+ e.getMessage());
		}catch(NumberFormatException e){
			System.out.println("�������� ����: "+ e.getMessage());
		}catch(ArithmeticException e){
			System.out.println("0������ ����: "+ e.getMessage());
		}*/
	}
}
