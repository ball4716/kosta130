package com.kosta._0725;

public class Test9 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 9. int su[]={1, 2, 3, 4, 5};
		 * su3�̶�� �迭�� ���� su�迭�� ���� ����
		 * int su3[];
		 *     su3 = su; (x) ��� ���۷����� ����
		 *     su3[2]=33;
		 */
		
		int su[]={1,2,3,4,5}; //length: 5
		//        0 1 2 3 4 ����
		
		int su3[];
		//	su3 = su;//���۷����� �����ϴ� ��
			su3 = new int[su.length];
		
		System.out.println("su3�迭 ���~!!");
		for (int i = 0; i < su3.length; i++) {
			su3[i] = su[i];
			System.out.println("su3["+i+"]="+su3[i]);
		}
		
		su3[2] = 33; //su3[]={1,2,33,4,5}
		
		System.out.println();
		System.out.println("su�迭 ���~!!");
		for (int i = 0; i < su.length; i++) {
			System.out.println("su["+i+"]="+su[i]);
		}
		
		for(int i=0; i<su.length; i++){
			System.out.println(su[su.length-1-i]);
		}
	}

}
