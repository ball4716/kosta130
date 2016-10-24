package com.kosta._0727;

public class ExceptionTest2 {//런타임시 Exception 발생 가능성
	public static void main(String[] args) {
		/*
		  		su1     su2
		  		10       5    : 정상
		  		10            : ArrayIndexOutOfBoundsException
		  		ab		 cd   : NumberFormatException
		  		10		 0    : ArithmeticException
		 */
		try{
		System.out.println("매개변수로 받은 두수의 값");
		int su1 = Integer.parseInt(args[0]);//index,number
		int su2 = Integer.parseInt(args[1]);//index,number
		System.out.println("su1= "+su1+", su2="+su2);
		System.out.println("su1을 su2로 나눈 몫= "+(su1/su2));//Arithmetic
		System.out.println("나눗셈을 원활히 수행하였습니다!!!");
		}catch(NumberFormatException e){
			System.out.println("숫자형식 에러: "+ e.getMessage());
			return;
		}catch(Exception e){
			System.out.println("모든예외상황 처리: "+e);
			return;
		}finally{
			System.out.println("finally: 예외발생과 상관없이 무조건 실행하는 문장");
		}
		
		System.out.println("Exception에 return;있으면 실행 안될수도 있는 마지막문장~!!");
		/*catch(ArrayIndexOutOfBoundsException e){
			System.out.println("벗어나는 인덱스 참조 에러:"+ e.getMessage());
		}catch(NumberFormatException e){
			System.out.println("숫자형식 에러: "+ e.getMessage());
		}catch(ArithmeticException e){
			System.out.println("0나누기 에러: "+ e.getMessage());
		}*/
	}
}
