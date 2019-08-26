package com.xjwfk.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjwfk.o2o.entity.ProductCategory;

/**
* @ClassName: ProductCategoryMapper
* @Description: TODO(对数据库商品类别表的增删改查)
* @author 白巾川
* @date 2019年8月1日
*/
public interface ProductCategoryMapper {
	public List<ProductCategory> queryProductCategoryList(Long shopId);
	
	public int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	
	public int deleteProductCategory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId);
}
