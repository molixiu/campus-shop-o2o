package com.xjwfk.o2o.service;

import java.util.List;

import com.xjwfk.o2o.entity.ShopCategory;

/**
* @ClassName: ShopCategoryService
* @Description: TODO(service层关于商店类别的业务逻辑的接口)
* @author 白巾川
* @date 2019年7月26日
*/
public interface ShopCategoryService {
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
