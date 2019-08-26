package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.ProductCategoryOperationException;
import com.xjwfk.o2o.mapper.ProductCategoryMapper;
import com.xjwfk.o2o.service.ProductCategoryService;

/**
 * @ClassName: ProductCategoryServiceImpl
 * @Description: TODO(service层关于商品类别的业务逻辑接口的实现类)
 * @author 白巾川
 * @date 2019年8月1日
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	@Override
	public List<ProductCategory> getProductCategoryList(Long shopId) {
		try {
			return productCategoryMapper.queryProductCategoryList(shopId);	//查询成功
		} catch (Exception e) {
			// 查询失败
			throw new ProductCategoryOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

	@Override
	@Transactional
	public ExecutionEnum batchAddProductCategory(List<ProductCategory> productCategoryList) {
		ExecutionEnum executionEnum;

		try {
			if (productCategoryList != null && productCategoryList.size() > 0) {
				int batchInsertProductCategory = productCategoryMapper.batchInsertProductCategory(productCategoryList);
				if (batchInsertProductCategory > 0) {
					executionEnum = ExecutionEnum.SUCCESS; // 操作成功
				} else {
					throw new ProductCategoryOperationException(ExecutionEnum.FAIL.getStateInfo());
				}
			} else {
				throw new ProductCategoryOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 操作失败
			throw new ProductCategoryOperationException(ExecutionEnum.FAIL.getStateInfo());
		}

		return executionEnum;
	}

	@Override
	@Transactional
	public ExecutionEnum removeProductCategory(long productCategoryId, long shopId) {
		ExecutionEnum executionEnum;
		try {
			int deleteProductCategory = productCategoryMapper.deleteProductCategory(productCategoryId, shopId);
			if (deleteProductCategory > 0) {
				executionEnum = ExecutionEnum.SUCCESS; // 操作成功
			} else {
				throw new ProductCategoryOperationException(ExecutionEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 操作失败
			throw new ProductCategoryOperationException(ExecutionEnum.FAIL.getStateInfo());
		}
		return executionEnum;
	}

}
