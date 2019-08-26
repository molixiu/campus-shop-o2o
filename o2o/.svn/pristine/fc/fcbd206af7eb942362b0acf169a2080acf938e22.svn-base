package com.xjwfk.o2o.controller.frontend;

import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjwfk.o2o.entity.HeadLine;
import com.xjwfk.o2o.entity.ShopCategory;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.service.HeadLineService;
import com.xjwfk.o2o.service.ShopCategoryService;
import com.xjwfk.o2o.vo.Result;

/**
* @ClassName: MainPageController
* @Description: TODO(前台的主页)
* @author 白巾川
* @date 2019年8月7日
*/

@Controller
@RequestMapping("/frontend/")
public class MainPageController {
	@Autowired
	private HeadLineService headLineService;
	
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@RequestMapping(value = "headLine/list", method = RequestMethod.GET)
	@ResponseBody
	public Result< List<HeadLine> > listHeadLine(){
		Result< List<HeadLine> > result;
		
		try {
			//设置头条的查询条件
			HeadLine headLineCondition = new HeadLine();
			headLineCondition.setEnableStatus(1);
			
			List<HeadLine> data = headLineService.getHeadLineList(headLineCondition);
			result = new Result<>(QueryEnum.SUCCESS.getSuccess(), data);//查询成功
		} catch (Exception e) {
			//查询失败
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(), QueryEnum.FAIL.getStateInfo());
		}
		
		return result;
	}
	
	@RequestMapping(value = "shopCategory/list", method = RequestMethod.GET)
	@ResponseBody
	public Result< List<ShopCategory> > listShopCategory(){
		Result< List<ShopCategory> > result;
		
		try {
			List<ShopCategory> data = shopCategoryService.getShopCategoryList(null);
			result = new Result<>(QueryEnum.SUCCESS.getSuccess(), data);//查询成功
		} catch (Exception e) {
			//查询失败
			result = new Result<>(QueryEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(), QueryEnum.FAIL.getStateInfo());
		}
		return result;
	}
}
