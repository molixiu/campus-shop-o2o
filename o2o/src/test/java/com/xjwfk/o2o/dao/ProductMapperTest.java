package com.xjwfk.o2o.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.mapper.ProductMapper;

/**
* @ClassName: ProductMapperTest
* @Description: TODO(对dao层的ProductMapper进行测试)
* @author 白巾川
* @date 2019年8月4日
*/
public class ProductMapperTest extends BaseTest {
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void test_insertProduct() {
		Shop shop1 = new Shop();
		shop1.setShopId(3L);
		
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(1L);
		
		Product product1 = new Product();
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		
		product1.setProductName("辣椒");
		product1.setProductDesc("111");
		product1.setNormalPrice("");
		product1.setPromotionPrice("");
		product1.setImgAddr("http://49.234.182.67:8888/group1/M00/00/00/rBEABF1VU4aESIKOAAAAAIr1Lwo041.jpg");
		product1.setPriority(4);
		product1.setCreateTime(new Date());
		product1.setEnableStatus(1);
		
		
		int insertProduct = productMapper.insertProduct(product1);
		System.out.println(insertProduct);
	}
	
	@Test
	public void test_deleteProduct() {
		int deleteProduct = productMapper.deleteProduct(2L, 3L);
		System.out.println(deleteProduct);
	}
	
	@Test
	public void test_queryProductList() {
		Product productCondition = new Product();
		
		List<Product> productList = productMapper.queryProductList(productCondition, 0, 10);
		System.out.println(productList.size());
	}
	
	@Test
	public void test_queryProductCount() {
		Product productCondition = new Product();
		int queryProductCount = productMapper.queryProductCount(productCondition);
		System.out.println(queryProductCount);
	}
	
	@Test
	public void test_queryProductByProductId() {
		Product product = productMapper.queryProductById(3L);
		System.out.println(product);
	}
	
	@Test
	public void test_updateProduct() {
		Product product = productMapper.queryProductById(1L);
		product.setEnableStatus(0);
		int updateProduct = productMapper.updateProduct(product);
		System.out.println(updateProduct);
	}
}
