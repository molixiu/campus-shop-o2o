package com.xjwfk.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjwfk.o2o.entity.Product;

/**
 * @ClassName: ProductMapper
 * @Description: TODO(对数据库商品表的增删改查)
 * @author 白巾川
 * @date 2019年8月4日
 */
public interface ProductMapper {
	public int insertProduct(Product product);

	public int deleteProduct(@Param("productId") long productId, @Param("shopId") long shopId);
	
	public int updateProduct(Product product);

	public List<Product> queryProductList(@Param("productCondition") Product productCondition,
			@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
	
	public int queryProductCount(@Param("productCondition") Product productCondition);
	
	public Product queryProductById(long productId);
}
