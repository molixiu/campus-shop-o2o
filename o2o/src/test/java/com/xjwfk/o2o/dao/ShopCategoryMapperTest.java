package com.xjwfk.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.ShopCategory;
import com.xjwfk.o2o.mapper.ShopCategoryMapper;

/**
* @ClassName: ShopCategoryMapperTest
* @Description: TODO(对dao层的ShopCategoryMapper进行测试)
* @author 白巾川
* @date 2019年7月25日
*/
public class ShopCategoryMapperTest extends BaseTest {
	@Autowired
	private ShopCategoryMapper categoryMapper;
	
	@Test
	public void test_queryShopCategoryList() {
		ShopCategory shopCategoryCondition = new ShopCategory();
		List<ShopCategory> queryShopCategory = categoryMapper.queryShopCategory(shopCategoryCondition);
		System.out.println(queryShopCategory.size());
	}
}
