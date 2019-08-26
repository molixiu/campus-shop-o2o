package com.xjwfk.o2o.exceptions;

/**
* @ClassName: PersonInfoOperationException
* @Description: TODO(自定义用户操作失败的异常)
* @author 白巾川
* @date 2019年8月13日
*/
public class PersonInfoOperationException extends RuntimeException {
	private final static String name = "用户:";

	public PersonInfoOperationException(String msg) {
		super(name + msg);
	}
}
