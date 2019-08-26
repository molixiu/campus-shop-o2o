package com.xjwfk.o2o.exceptions;

/**
* @ClassName: ProductCategoryOperationException
* @Description: TODO(自定义商品类别操作失败的异常)
* @author 白巾川
* @date 2019年8月2日
*/
public class ProductCategoryOperationException extends RuntimeException {
	
	private final static String name = "商品类别:";
	
	public ProductCategoryOperationException(String msg) {
		super(name + msg);
	}
	
}
