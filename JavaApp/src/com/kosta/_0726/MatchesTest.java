package com.kosta._0726;

public class MatchesTest {
	public static void main(String[] args) {
		String str="c";
		
		//str.matches(String regex)
		System.out.println(str.matches("[abc]"));
		//a¶Ç´Â b¶Ç´Â c¹®ÀÚ°¡ ¹ß»ı
		//strÀÌ [a]¶ó´Â ±ÔÄ¢À» °®´ÂÁö °Ë»ç
		
		/*
		 * [a] : a¹®ÀÚ°¡ 1¹ø ÃâÇö
		 * [a]? : a¹®ÀÚ°¡ 0~1¹ø ÃâÇö
		 * [a]* : a¹®ÀÚ°¡ 0¹ø ~ ¡Ä ÃâÇö
		 * [a]+ : a¹®ÀÚ°¡ 1¹ø ~ ¡Ä ÃâÇö
		 */
		
		String str2="bbbbbbbbbcac";
		System.out.println(str2.matches("[abc]*"));
		
		System.out.println("=========¼ı  ÀÚ Á¶ÇÕ=========");
		//¼ıÀÚ°Ë»ç(¼ıÀÚÁ¶ÇÕ)
		String str3="34";
		System.out.println(str3.matches("[0123456789]")); //0~9Áß ÇÏ³ª
		System.out.println(str3.matches("[0123456789]?"));//0~9Áß ÇÏ³ª, »ı·«°¡´É
		System.out.println(str3.matches("[0123456789]*"));//0~9Á¶ÇÕÀÌ 0 ~ ¡Ä
		System.out.println(str3.matches("[0123456789]+"));//0~9Á¶ÇÕÀÌ 1 ~ ¡Ä
		System.out.println(str3.matches("[0-9]+"));//0~9Á¶ÇÕÀÌ 1 ~ ¡Ä
		System.out.println(str3.matches("[\\d]+"));//0~9Á¶ÇÕÀÌ 1 ~ ¡Ä
		
		
		System.out.println("=========¿µ¹®ÀÚ Á¶ÇÕ=========");
		//¿µ¹®ÀÚÁ¶ÇÕ
		String str4="adF4h";
		System.out.println(str4.matches("[a-zA-Z]+"));
		System.out.println(str4.matches("[a-zA-Z]{3}"));//3ÀÚ¸®
		System.out.println(str4.matches("[a-zA-Z]{3,6}"));//3ÀÚ¸®~6ÀÚ¸®
		
		//¿µ¹®ÀÚÁ¶ÇÕÀÌ ¾Æ´Ñ °ªÀ» Ã¼Å©
		if(!str4.matches("[a-zA-Z]+")){
			//¿µ¹®ÀÚ¸¸ ÀÔ·ÂÇÏ¼¼¿ä!!!
			System.out.println("¿µ¹®ÀÚ¸¸ ÀÔ·ÂÇÏ¼¼¿ä!!");
		}

		System.out.println("=========ÇÑ  ±Û Á¶ÇÕ=========");
		//ÇÑ±ÛÁ¶ÇÕ
		String str5="±èµÎÇÑ";
		System.out.println(str5.matches("[¤¡-ÆR]+"));
		
	}

}
