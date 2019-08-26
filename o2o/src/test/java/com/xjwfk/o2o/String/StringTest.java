package com.xjwfk.o2o.String;

import org.junit.Test;

/**
* @ClassName: StringTest
* @Description: TODO(主要对JDK提供的对字符串操作的API的测试)
* @author 白巾川
* @date 2019年7月24日
*/
public class StringTest {

	@Test
	public void test_join() {
		String[] strings = new String[] {"A","B"};
		String join = String.join("-", strings);
		System.out.println(join);
	}
	
	@Test
	public void test_indexOf() {
		String string = "addaasd/ssaa/sad";
		System.out.println(string.substring(0,string.indexOf("/")));
		System.out.println( string.substring(string.indexOf("/")+1) );
	}
	
	@Test
	public void test_replace() {
		String a = "http://49.234.182.67:8888/group1/M00/00/00/rBEABF1VX52EX20XAAAAAIr1Lwo872.jpg";
		String  b = "http://49.234.182.67:8888/";
		String c = a.replaceAll(b, "");
		System.out.println(c);
	}
	
}
