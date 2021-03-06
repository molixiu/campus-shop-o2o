package com.xjwfk.o2o.controller.shop;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjwfk.o2o.entity.ProductCategory;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.service.ProductCategoryService;
import com.xjwfk.o2o.vo.Result;

/**
* @ClassName: ProductCategoryController
* @Description: TODO(web层关于商品类别的控制器)
* @author 白巾川
* @date 2019年8月2日
*/

@Controller
@RequestMapping("/shopManage/productCategory/")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping(value ="list",method = RequestMethod.GET)
	@ResponseBody
	public Result< List<ProductCategory> > list(Long shopId){
		Result< List<ProductCategory> > result;
		try {
			List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(shopId);
			result = new Result<List<ProductCategory>>(true, productCategoryList);
		} catch (Exception e) {
			result = new Result<>(false, ExecutionEnum.FAIL.getState(), ExecutionEnum.FAIL.getStateInfo());
		}
		
		return result;
	}
	
	@RequestMapping(value="addProductCategorys",method=RequestMethod.POST)
	@ResponseBody
	public Result<Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList){
		for(ProductCategory productCategory:productCategoryList) {	//把前端传来的商品类别数据加上时间
			productCategory.setCreateTime(new Date());
		}
		
		Result<Object> result;
		try {
			ExecutionEnum executionEnum = productCategoryService.batchAddProductCategory(productCategoryList);
			result = new Result<>(executionEnum.getSuccess(), null);
		} catch (Exception e) {
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), ExecutionEnum.FAIL.getState(), ExecutionEnum.FAIL.getStateInfo());
		}
		
		return result;
	}
	
	@RequestMapping(value = "removeproductcategory", method=RequestMethod.POST)
	@ResponseBody
	public Result<Object> removeproductcategory(long productCategoryId){
		Result<Object> result;
		try {
			ExecutionEnum executionEnum = productCategoryService.removeProductCategory(productCategoryId, 3L);
			result = new Result<>(executionEnum.getSuccess(), null);
		} catch (Exception e) {
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), ExecutionEnum.FAIL.getState(), ExecutionEnum.FAIL.getStateInfo());
		}
		
		return result;
	}
	
}
