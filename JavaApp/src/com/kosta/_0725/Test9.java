package com.kosta._0725;

public class Test9 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 9. int su[]={1, 2, 3, 4, 5};
		 * su3이라는 배열을 만들어서 su배열의 값을 복사
		 * int su3[];
		 *     su3 = su; (x) 요건 레퍼런스를 복사
		 *     su3[2]=33;
		 */
		
		int su[]={1,2,3,4,5}; //length: 5
		//        0 1 2 3 4 번지
		
		int su3[];
		//	su3 = su;//레퍼런스를 복사하는 것
			su3 = new int[su.length];
		
		System.out.println("su3배열 출력~!!");
		for (int i = 0; i < su3.length; i++) {
			su3[i] = su[i];
			System.out.println("su3["+i+"]="+su3[i]);
		}
		
		su3[2] = 33; //su3[]={1,2,33,4,5}
		
		System.out.println();
		System.out.println("su배열 출력~!!");
		for (int i = 0; i < su.length; i++) {
			System.out.println("su["+i+"]="+su[i]);
		}
		
		for(int i=0; i<su.length; i++){
			System.out.println(su[su.length-1-i]);
		}
	}

}
