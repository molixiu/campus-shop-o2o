package com.xjwfk.o2o.service;

import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.vo.PageBean;

/**
* @ClassName: ShopService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 白巾川
* @date 2019年7月24日
*/
public interface ShopService {
	
	public ExecutionEnum addShop(Shop shop);
	
	public ExecutionEnum modifyShop(Shop shop);
	
	public PageBean<Shop> getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	public Shop getShop(long shopId);
}
