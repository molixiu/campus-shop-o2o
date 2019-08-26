package com.xjwfk.o2o.exceptions;

/**
* @ClassName: HeadLineOperationException
* @Description: TODO(自定义头条操作失败的异常)
* @author 白巾川
* @date 2019年8月7日
*/

public class HeadLineOperationException extends RuntimeException {
	private final static String name = "头条:";

	public HeadLineOperationException(String msg) {
		super(name + msg);
	}
}
