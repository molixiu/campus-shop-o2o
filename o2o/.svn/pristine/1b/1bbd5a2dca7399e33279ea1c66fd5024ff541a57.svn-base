package com.xjwfk.o2o.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.service.ProductService;
import com.xjwfk.o2o.vo.Result;

/**
* @ClassName: ProductDetailController
* @Description: TODO(前台商品详情展示)
* @author 白巾川
* @date 2019年8月8日
*/

@Controller
@RequestMapping("/frontend/")
public class ProductDetailController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "product/detail", method = RequestMethod.GET)
	@ResponseBody
	public Result<Product> productDetail(long productId){
		Result<Product> result;
		
		try {
			Product data = productService.getProduct(productId);
			result = new Result<Product>(QueryEnum.SUCCESS.getSuccess(), data);
		} catch (Exception e) {
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(), QueryEnum.FAIL.getStateInfo());
		}
		return result;
	}
}
