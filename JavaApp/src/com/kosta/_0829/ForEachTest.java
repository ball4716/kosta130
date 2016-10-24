package com.kosta._0829;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForEachTest {
	public static void main(String[] args) {
		// for(초기값; 조건식; 증감자)
		// for(변수선언:배열) ===> for(자료형 변수명:배열명)
		// ===> 개선된 for문, forEach문 (JDK5버전 지원)
		int su[] = { 11, 22, 33, 44, 55 };

		for (int i = 0; i < su.length; i++) {
			System.out.println(su[i]);
		}
		System.out.println("=========");
		for (int i : su) {// su배열의 크기만큼 loop를 돌면서 얻어온 각각의 값을 i에 저장
			System.out.println(i);
		}

		List<String> list = new ArrayList<>();
		list.add("기호창");
		list.add("이하은");
		list.add("전성원");
		list.add("정다운");
		list.add("최용석");

		for (String str : list) {// 단점: 인덱스를 사용할 수 없다!!
			System.out.println(str);
		}
		System.out.println("===========");
		Set<String> set = new HashSet<>();
		set.add("김혜정");
		set.add("박재현");
		set.add("안선영");
		set.add("윤철");
		set.add("채효원");
		set.add("박재현");
		set.add("윤철");
		

		for (String name : set) {
			System.out.println(name);
		}
	}
}
