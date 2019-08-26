package com.xjwfk.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.Area;
import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.entity.ShopCategory;
import com.xjwfk.o2o.mapper.ShopMapper;

/**
* @ClassName: ShopMapperTest
* @Description: TODO(对dao层的ShopMapper进行测试)
* @author 白巾川
* @date 2019年7月24日
*/
public class ShopMapperTest extends BaseTest {
	@Autowired
	private ShopMapper shopMapper;
	
	@Test
	public void test_insertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		int insertShop = shopMapper.insertShop(shop);
		assertEquals(1, insertShop);
	}
	
	@Test
	public void test_updateShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setShopId(3L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("更新的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		int updatetShop = shopMapper.updateShop(shop);
		assertEquals(1, updatetShop);
		System.out.println(updatetShop);
	}
	
	@Test
	public void test_queryShopList() {
		Shop shopCondition = new Shop();
		Area area = new Area();
		area.setAreaId(1);
		shopCondition.setArea(area);
		List<Shop> queryShopList = shopMapper.queryShopList(shopCondition, 0, 10);
		System.out.println(queryShopList.size());
	}
	
	@Test
	public void test_queryShopCount() {
		Shop shopCondition = new Shop();
		Area area = new Area();
		area.setAreaId(1);
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setShopCategoryId(1L);
		shopCondition.setArea(area);
		shopCondition.setShopCategory(shopCategory);
		int queryShopCount = shopMapper.queryShopCount(shopCondition);
		System.out.println(queryShopCount);
	}
	
	@Test
	public void test_queryByShopId() {
		Shop shop = shopMapper.queryByShopId(4L);
		System.out.println(shop.getShopName());
	}
	
	
}
