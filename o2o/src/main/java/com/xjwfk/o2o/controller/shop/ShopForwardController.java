package com.xjwfk.o2o.controller.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* @ClassName: ShopForwardController
* @Description: TODO(主要用来解析路由并转发到相应的html中)
* @author 白巾川
* @date 2019年7月24日
*/
@Controller
@RequestMapping(value = "shop", method = { RequestMethod.GET })
public class ShopForwardController {
	@RequestMapping(value = "/register")
	public String shop_register() {
		// 转发至店铺注册页面
		return "shop/shop_register";
	}
	
	@RequestMapping(value = "/list")
	public String shop_list() {
		// 转发至店铺列表展示页面
		return "shop/shop_list";
	}
	
	@RequestMapping(value = "/manage")
	public String shop_manage() {
		// 转发至店铺管理展示页面
		return "shop/shop_manage";
	}
	
	@RequestMapping(value = "/product/manage")
	public String shop_product_manage() {
		// 转发至店铺管理展示页面
		return "shop/product_manage";
	}
	
	@RequestMapping(value="/productCategory_manage")
	public String productCategory_manage() {
		//转发至商品类别管理页面
		return "shop/productCategory_manage";
	}
	
	@RequestMapping(value="/product/add")
	public String product_manage() {
		//转发至商品类别管理页面
		return "shop/product_add";
	}
}
