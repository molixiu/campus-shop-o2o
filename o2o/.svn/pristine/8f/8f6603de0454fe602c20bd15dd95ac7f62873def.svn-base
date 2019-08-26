package com.xjwfk.o2o.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.mapper.ProductCategoryMapper;

/**
* @ClassName: ProductCategoryMapperTest
* @Description: TODO(对dao层的ProductCategoryMapper进行测试)
* @author 白巾川
* @date 2019年8月1日
*/
public class ProductCategoryMapperTest extends BaseTest {
	@Autowired
	private ProductCategoryMapper productCategoryMapper;
	
	@Test
	public void test_queryProductCategoryList() {
		List<ProductCategory> queryProductCategoryList = productCategoryMapper.queryProductCategoryList(3L);
		System.out.println(queryProductCategoryList);
	}
	
	@Test
	public void test_batchInsertProductCategory() {
		List<ProductCategory> productCategoryList = new ArrayList<>();
		
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCreateTime(new Date());
		productCategory1.setPriority(2);
		productCategory1.setShopId(3L);
		productCategory1.setProductCategoryName("烧烤");
		
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setCreateTime(new Date());
		productCategory2.setPriority(2);
		productCategory2.setShopId(3L);
		productCategory2.setProductCategoryName("火锅");

		productCategoryList.add(productCategory1);
		productCategoryList.add(productCategory2);
		productCategoryMapper.batchInsertProductCategory(productCategoryList);
	}
	
	@Test
	public void test_deleteProductCategory() {
		int deleteProductCategory = productCategoryMapper.deleteProductCategory(16L, 3L);
		System.out.println(deleteProductCategory);
	}
}
