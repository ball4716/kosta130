package com.kosta._0722;

public class ArrayTest {
	public static void main(String[] args) {
		int su [] = {11,22,33,44,55};
		//  su       [0][1][2][3][4]
		
		//전체배열의 데이터를 출력하시오
		
		System.out.println("배열의 크기: "+ su.length);
		for(int i =0; i<su.length; i++){//일차원배열에 대한 인덱스를 표현 : 0~4
			//배열의 데이터는 번지를 통해 접근
			System.out.println("su["+i+"]번지="+su[i]);
		}
		
		System.out.println("===============");
		int su2[][]={  {1} , {2,3} , {4,5,6}  }; //2차원 배열
		//su2.length: 행의 크기, su2[행인덱스].length: 해당 행의 열의 크기
		for(int i=0; i<su2.length; i++){//기준:행	행인덱스 0~2
			for(int j=0; j<su2[i].length; j++){//열인덱스 0~1
				System.out.println("su2["+i+"]["+j+"]="+su2[i][j]);
			}
		}
	}
}
