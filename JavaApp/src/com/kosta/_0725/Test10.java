package com.kosta._0725;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10. int su[]={1,2,3,4,5};
		// ----> for���� ���� [0]����~[4]�������� ����� ������
		// 5 4 3 2 1 �� ���� ��µǵ��� �Ͻÿ�

		int su[] = { 1, 2, 3, 4, 5, 6 };
		int temp;
		for (int i = 0, j = su.length - 1; i < su.length / 2; i++, j--) {
			temp = su[i];
			su[i] = su[j];
			su[j] = temp;
		}

		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i] + " ");
		}
	}

}
