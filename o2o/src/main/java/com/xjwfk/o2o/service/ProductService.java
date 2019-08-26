package com.xjwfk.o2o.service;

import java.util.List;

import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.entity.ProductImg;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.vo.PageBean;

/**
* @ClassName: ProductService
* @Description: TODO(service层关于商品的业务逻辑的接口)
* @author 白巾川
* @date 2019年8月4日
*/
public interface ProductService {
	public ExecutionEnum addProduct(Product product);
	
	public ExecutionEnum batchAddProductImg(List<ProductImg> productImgList);
	
	public ExecutionEnum removeProduct(long productId, long shopId);
	
	public ExecutionEnum modifyProduct(Product product, List<ProductImg> productImgList);
	
	public PageBean<Product> getProductList(Product productCondition, int pageIndex, int pageSize);
	
	public Product getProduct(long productId);
}
