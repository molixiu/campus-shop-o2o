package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjwfk.o2o.entity.ShopCategory;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.ShopCategoryOperationException;
import com.xjwfk.o2o.mapper.ShopCategoryMapper;
import com.xjwfk.o2o.service.ShopCategoryService;

/**
* @ClassName: ShopCategoryServiceImpl
* @Description: TODO(service层关于商店类别的业务逻辑接口的实现类)
* @author 白巾川
* @date 2019年7月26日
*/

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		try {
			List<ShopCategory> shopCategoryList = shopCategoryMapper.queryShopCategory(shopCategoryCondition);
			return shopCategoryList;	//查询成功
		} catch (Exception e) {
			//查询失败
			throw new ShopCategoryOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

}
