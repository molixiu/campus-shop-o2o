package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.ShopOperationException;
import com.xjwfk.o2o.mapper.ShopMapper;
import com.xjwfk.o2o.service.ShopService;
import com.xjwfk.o2o.utils.PageCalculator;
import com.xjwfk.o2o.vo.PageBean;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper shopMapper;

	@Override
	@Transactional
	public ExecutionEnum addShop(Shop shop) {
		try {
			if (shop != null) {
				int insertShop = shopMapper.insertShop(shop);
				if (insertShop > 0) {
					return ExecutionEnum.SUCCESS; // 商店添加成功
				} else {
					throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
				}
			} else {
				throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 商店添加失败
			throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public ExecutionEnum modifyShop(Shop shop) {
		try {
			if (shop != null) {
				int updateShop = shopMapper.updateShop(shop);
				if (updateShop > 0) {
					return ExecutionEnum.SUCCESS; // 商店添加成功
				} else {
					throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
				}
			} else {
				throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 更改商店信息失败
			throw new ShopOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public PageBean<Shop> getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		try {
			List<Shop> queryShopList = shopMapper.queryShopList(shopCondition, rowIndex, pageSize);
			int queryShopCount = shopMapper.queryShopCount(shopCondition);

			PageBean<Shop> pageBean = new PageBean<>(queryShopCount, pageSize, queryShopList);
			return pageBean; // 查询商店信息成功
		} catch (Exception e) {
			// 查询商店信息失败
			throw new ShopOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

	@Override
	public Shop getShop(long shopId) {
		try {
			Shop shop = shopMapper.queryByShopId(shopId);
			return shop;	// 查询商店信息成功
		} catch (Exception e) {
			// 查询商店信息失败
			throw new ShopOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

}
