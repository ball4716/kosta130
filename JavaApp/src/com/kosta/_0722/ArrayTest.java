package com.kosta._0722;

public class ArrayTest {
	public static void main(String[] args) {
		int su [] = {11,22,33,44,55};
		//  su       [0][1][2][3][4]
		
		//��ü�迭�� �����͸� ����Ͻÿ�
		
		System.out.println("�迭�� ũ��: "+ su.length);
		for(int i =0; i<su.length; i++){//�������迭�� ���� �ε����� ǥ�� : 0~4
			//�迭�� �����ʹ� ������ ���� ����
			System.out.println("su["+i+"]����="+su[i]);
		}
		
		System.out.println("===============");
		int su2[][]={  {1} , {2,3} , {4,5,6}  }; //2���� �迭
		//su2.length: ���� ũ��, su2[���ε���].length: �ش� ���� ���� ũ��
		for(int i=0; i<su2.length; i++){//����:��	���ε��� 0~2
			for(int j=0; j<su2[i].length; j++){//���ε��� 0~1
				System.out.println("su2["+i+"]["+j+"]="+su2[i][j]);
			}
		}
	}
}
