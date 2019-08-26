package com.xjwfk.o2o.service;

import java.util.List;

import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.enumes.ExecutionEnum;

/**
 * @ClassName: ProductCategoryService
 * @Description: TODO(service层关于商品类别的业务逻辑的接口)
 * @author 白巾川
 * @date 2019年8月1日
 */
public interface ProductCategoryService {
	public List<ProductCategory> getProductCategoryList(Long shopId);

	public ExecutionEnum batchAddProductCategory(List<ProductCategory> productCategoryList);

	public ExecutionEnum removeProductCategory(long productCategoryId, long shopId);
}
