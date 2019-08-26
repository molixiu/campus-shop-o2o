package com.xjwfk.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjwfk.o2o.entity.Shop;

/**
 * @ClassName: ShopMapper
 * @Description: TODO(对数据库商店表的增删改查)
 * @author 白巾川
 * @date 2019年7月24日
 */
public interface ShopMapper {

	public int insertShop(Shop shop);

	public int updateShop(Shop shop);

	public List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	
	public int queryShopCount(@Param("shopCondition") Shop shopCondition);
	
	public Shop queryByShopId(@Param("shopId")long shopId);
}
