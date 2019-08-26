package com.xjwfk.o2o.controller.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.service.ProductCategoryService;
import com.xjwfk.o2o.service.ProductService;
import com.xjwfk.o2o.service.ShopService;
import com.xjwfk.o2o.vo.PageBean;
import com.xjwfk.o2o.vo.Result;

/**
 * @ClassName: ShopDetailController
 * @Description: TODO(前台商店详情展示)
 * @author 白巾川
 * @date 2019年8月7日
 */

@Controller
@RequestMapping("/frontend/")
public class ShopDetailController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "shop/detail", method = RequestMethod.GET)
	@ResponseBody
	public Result<Shop> shopDetail(long shopId) {
		Result<Shop> result;

		try {
			Shop data = shopService.getShop(shopId);
			result = new Result<>(QueryEnum.SUCCESS.getSuccess(), data);// 查询成功
		} catch (Exception e) {
			// 查询失败
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(),
					QueryEnum.FAIL.getStateInfo());
		}
		return result;
	}

	@RequestMapping(value = "productCategory/list", method = RequestMethod.GET)
	@ResponseBody
	public Result<List<ProductCategory>> listProductCategory(long shopId) {
		Result<List<ProductCategory>> result;

		try {
			List<ProductCategory> data = productCategoryService.getProductCategoryList(shopId);
			result = new Result<>(QueryEnum.SUCCESS.getSuccess(), data);// 查询成功
		} catch (Exception e) {
			// 查询失败
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(),
					QueryEnum.FAIL.getStateInfo());
		}
		return result;
	}

	@RequestMapping(value = "product/list", method = RequestMethod.GET)
	@ResponseBody
	public Result<PageBean<Product>> listProduct(Product productCondition, @RequestParam("pageIndex") int pageIndex,
			@RequestParam("pageSize") int pageSize) {
		Result<PageBean<Product>> result;
		
		try {
				PageBean<Product> data = productService.getProductList(productCondition, pageIndex, pageSize);
				result = new Result<>(QueryEnum.SUCCESS.getSuccess(), data);// 查询成功
		} catch (Exception e) {
			// 查询失败
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(),
					QueryEnum.FAIL.getStateInfo());
		}
		return result;
	}
}
