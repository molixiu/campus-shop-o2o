package com.xjwfk.o2o.exceptions;

/**
* @ClassName: ProductOperationException
* @Description: TODO(自定义商品操作失败的异常)
* @author 白巾川
* @date 2019年8月4日
*/
public class ProductOperationException extends RuntimeException {
	private final static String name = "商品:";

	public ProductOperationException(String msg) {
		super(name + msg);
	}
}
