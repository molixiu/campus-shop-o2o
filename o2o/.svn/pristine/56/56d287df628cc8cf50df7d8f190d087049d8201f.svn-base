package com.xjwfk.o2o.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: FrontendForwardController
 * @Description: TODO(主要用来解析(对于顾客前端)路由并转发到相应的html中)
 * @author 白巾川
 * @date 2019年8月7日
 */

@Controller
@RequestMapping(value = "frontend/", method = { RequestMethod.GET })
public class FrontendForwardController {

	@RequestMapping(value = "index")
	public String index() {
		return "frontend/index";
	}

	@RequestMapping(value = "shoplist")
	public String shopList() {
		return "frontend/shop_list";
	}
	
	@RequestMapping(value = "shopdetail")
	public String shopDetail() {
		return "frontend/shop_detail";
	}
	
	@RequestMapping(value = "productdetail")
	public String productDetail() {
		return "frontend/product_detail";
	}
}
