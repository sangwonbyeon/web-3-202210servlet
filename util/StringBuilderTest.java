package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {
		String str = "문자열1";
		
		str += "문자열2";
		str = str.replaceAll("문자열2", "문자열3"); //주소가 바뀌는게 아닌 새로운 메모리가 할당이 된다(메모리가 낭비된다)
		
		System.out.println(str);
		
		StringBuilder builder = new StringBuilder(); //비동기  thread 쓰지 않는 환경에서 builder를 쓴다
		StringBuffer buffer = new StringBuffer();  //동기 thread 쓰는 환경에서 butter를 쓴다
		
		

	}

}
