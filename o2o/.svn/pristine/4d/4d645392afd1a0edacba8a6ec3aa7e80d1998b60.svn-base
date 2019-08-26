package com.xjwfk.o2o.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.enumes.ExecutionEnum;

/**
 * @ClassName: ProductCategoryServiceTest
 * @Description: TODO(对service层的ProductCategoryService进行测试)
 * @author 白巾川
 * @date 2019年8月1日
 */
public class ProductCategoryServiceTest extends BaseTest {
	@Autowired
	private ProductCategoryService productCategoryService;

	@Test
	public void test_getProductCategoryList() {
		List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(3L);
		System.out.println(productCategoryList);
	}

	@Test
	public void test_batchAddProductCategory() {
		List<ProductCategory> productCategoryList = new ArrayList<>();

		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCreateTime(new Date());
		productCategory1.setPriority(2);
		productCategory1.setShopId(3L);
		productCategory1.setProductCategoryName("寿司");

		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setCreateTime(new Date());
		productCategory2.setPriority(1);
		productCategory2.setShopId(3L);
		productCategory2.setProductCategoryName("冷面");

		productCategoryList.add(productCategory1);
		productCategoryList.add(productCategory2);
		productCategoryService.batchAddProductCategory(productCategoryList);
	}
	
	@Test
	public void test_removeProductCategory() {
		ExecutionEnum executionEnum = productCategoryService.removeProductCategory(15L, 3L);
		System.out.println(executionEnum.getStateInfo());
	}
}
