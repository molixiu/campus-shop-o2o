package com.xjwfk.o2o.service;


import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.Area;
import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.entity.ShopCategory;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.vo.PageBean;

/**
* @ClassName: ShopServiceTest
* @Description: TODO(对service层的AreaService进行测试)
* @author 白巾川
* @date 2019年7月24日
*/
public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;
	
	@Test
	public void test_addShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setShopId(4L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("modify的店铺");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		shopService.addShop(shop);
	}
	
	@Test
	public void test_modifyShop() {
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
		ExecutionEnum executionEnum = shopService.modifyShop(shop);
		System.out.println(executionEnum.getStateInfo());
	}
	
	@Test
	public void test_getShopList() {
		Shop shopCondition = new Shop();
		PageBean<Shop> pageBean = shopService.getShopList(shopCondition, 0, 3);
		System.out.println(pageBean);
	}
}
