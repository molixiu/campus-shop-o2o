package com.xjwfk.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.ShopCategory;

/**
* @ClassName: ShopCategoryServiceTest
* @Description: TODO(对service层的ShopCategoryService进行测试)
* @author 白巾川
* @date 2019年7月26日
*/
public class ShopCategoryServiceTest extends BaseTest {
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Test
	public void test_getShopCategoryList() {
		List<ShopCategory> shopCategoryList = shopCategoryService.getShopCategoryList(null);
		System.out.println(shopCategoryList.size());
	}
	
	public void tt(int k) {
		
	}
}
