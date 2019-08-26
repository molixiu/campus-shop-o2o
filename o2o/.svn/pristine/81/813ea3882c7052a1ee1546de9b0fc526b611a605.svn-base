package com.xjwfk.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjwfk.o2o.entity.ShopCategory;

/**
 * @ClassName: ShopCategoryMapper
 * @Description: TODO(对数据库商店类别表的增删改查)
 * @author 白巾川
 * @date 2019年7月25日
 */

public interface ShopCategoryMapper {
	/**   
	 * @Title: queryShopCategory   
	 * @Description: TODO(根据条件查询商店类别 比如 parent是否为空)   
	 * @param: @param shopCategoryCondition(商店类别查询条件)
	 * @param: @return      
	 * @return: List<ShopCategory>      
	 * @throws   
	 */  
	public List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
