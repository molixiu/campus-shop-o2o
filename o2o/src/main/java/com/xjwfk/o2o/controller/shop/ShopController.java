package com.xjwfk.o2o.controller.shop;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.Shop;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.service.ShopService;
import com.xjwfk.o2o.utils.file.MyUploadFileUtils;
import com.xjwfk.o2o.vo.PageBean;
import com.xjwfk.o2o.vo.Result;

/**
 * @ClassName: ShopController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 白巾川
 * @date 2019年7月25日
 */

@Controller
@RequestMapping("/shopManage/shop/")
public class ShopController {
	/**
	 * @Fields IMAGE_SERVER_URL : TODO(文件服务器的url)
	 */
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> register(Shop shop, @RequestParam(value = "Img", required = false) MultipartFile shopPicture,
			HttpSession session)
			throws IOException, MyException {
		Result<Object> result;

		
		try {
			// 上传店铺的图片
			String shopPicture_uploadPath = MyUploadFileUtils.uploadFile(shopPicture);
			String shopPicture_uploadURL = IMAGE_SERVER_URL + shopPicture_uploadPath;
			shop.setShopImg(shopPicture_uploadURL);

			//自动生成关于商店的一些数据
			PersonInfo user =  (PersonInfo)session.getAttribute("user");
			shop.setOwner(user);
			shop.setCreateTime(new Date());
			shop.setEnableStatus(1);
			
			
			ExecutionEnum executionEnum = shopService.addShop(shop);
			result = new Result<>(executionEnum.getSuccess(), null);// 商店注册成功
		} catch (Exception e) {
			e.printStackTrace();
			//商店注册失败
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), QueryEnum.FAIL.getState(),
					QueryEnum.FAIL.getStateInfo());
		}

		return result;
	}

	@RequestMapping(value = "shop/info", method = RequestMethod.GET)
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

	@RequestMapping(value = "/list")
	@ResponseBody
	public Result<PageBean<Shop>> list(Shop shopCondition, @RequestParam(defaultValue = "0") int pageIndex,
			@RequestParam(defaultValue = "20") int pageSize, HttpSession session) {
		// 获取当前登录用户并封装到查询条件中
		PersonInfo user = (PersonInfo) session.getAttribute("user");
		shopCondition.setOwner(user);

		Result<PageBean<Shop>> result = null;
		try {
			PageBean<Shop> pageBean = shopService.getShopList(shopCondition, pageIndex, pageSize);
			result = new Result<>(true, pageBean);
		} catch (Exception e) {
			result = new Result<>(false, ExecutionEnum.FAIL.getState(), ExecutionEnum.FAIL.getStateInfo());
		}
		return result;
	}

}
