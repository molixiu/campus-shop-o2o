package com.xjwfk.o2o.exception;

import org.junit.Test;

import com.xjwfk.o2o.exceptions.ProductCategoryOperationException;

public class ExceptionTest {
	
	@Test
	public void test1() {
		try {
			try {
				throw new ProductCategoryOperationException("操作失败");
			} catch (Exception e) {
				throw new ProductCategoryOperationException("操作失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
