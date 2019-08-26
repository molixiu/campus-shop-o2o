package com.xjwfk.o2o.controller.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xjwfk.o2o.entity.Product;
import com.xjwfk.o2o.entity.ProductImg;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.service.ProductService;
import com.xjwfk.o2o.utils.file.FastDFSClient;
import com.xjwfk.o2o.utils.file.MyFileUtils;
import com.xjwfk.o2o.utils.file.MyUploadFileUtils;
import com.xjwfk.o2o.vo.PageBean;
import com.xjwfk.o2o.vo.Result;

/**
 * @ClassName: ProductController
 * @Description: TODO(web层关于商品的控制器)
 * @author 白巾川
 * @date 2019年8月4日
 */

@Controller
@RequestMapping("/shopManage/product/")
public class ProductController {
	/**
	 * @Fields IMAGE_SERVER_URL : TODO(文件服务器的url)
	 */
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;

	// 支持上传商品详情图的最大数量
	private static final int IMAGEMAXCOUNT = 6;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addProduct(Product product,
			@RequestParam(value = "thumbnail", required = false) MultipartFile thumbnail,
			@RequestParam(value = "detailImgs", required = false) MultipartFile[] detailImgs) throws IOException, MyException {
		//上传商品的缩略图
		String thumbnail_uploadPath = MyUploadFileUtils.uploadFile(thumbnail);
		String thumbnail_uploadURL = IMAGE_SERVER_URL + thumbnail_uploadPath;
		product.setImgAddr(thumbnail_uploadURL);
		//上传商品的详情图
		List<ProductImg> productImgs = new ArrayList<>();
		for(int i = 0; i < detailImgs.length; i++) {
			String detailImg_uploadPath = MyUploadFileUtils.uploadFile(detailImgs[i]);
			String detailImg_uploadURL = IMAGE_SERVER_URL + detailImg_uploadPath;
			
			ProductImg productImg = new ProductImg();
			productImg.setImgAddr(detailImg_uploadURL);
			productImg.setCreateTime(new Date());
			productImg.setPriority(IMAGEMAXCOUNT - i);
			productImgs.add(productImg);
		}
		product.setProductImgList(productImgs);
		//自动生成商品的创建时间和上架状态
		product.setCreateTime(new Date());
		product.setEnableStatus(1);
		Result<Object> result;
		try {
			ExecutionEnum executionEnum = productService.addProduct(product);
			result = new Result<>(executionEnum.getSuccess(), null); // 添加商品成功
		} catch (Exception e) {
			// 添加商品失败
			//TODO添加商品失败把图片把图片删除
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), ExecutionEnum.FAIL.getState(),
					ExecutionEnum.FAIL.getStateInfo());
		}
		//明天重定向
		String redirectURL = "redirect:/shop/product/manage?shopId=" + product.getShop().getShopId();
		return redirectURL;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
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

	@RequestMapping(value = "modifyProductStatus", method = RequestMethod.GET)
	@ResponseBody
	public Result<Object> modifyProductStatus(Product product) {
		Result<Object> result;

		try {
			ExecutionEnum executionEnum = productService.modifyProduct(product, null);
			result = new Result<>(executionEnum.getSuccess(), null); // 更改商品状态成功
		} catch (Exception e) {
			// 更改商品状态失败
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), ExecutionEnum.FAIL.getState(),
					ExecutionEnum.FAIL.getStateInfo());
		}

		return result;

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public Result<Object> deleteProduct(@RequestParam("productId") Long productId,
			@RequestParam("shopId") Long shopId) {
		Result<Object> result;

		try {
			ExecutionEnum executionEnum = productService.removeProduct(productId, shopId);
			result = new Result<>(executionEnum.getSuccess(), null);// 删除成功
		} catch (Exception e) {
			// 删除失败
			result = new Result<>(ExecutionEnum.FAIL.getSuccess(), ExecutionEnum.FAIL.getState(),
					ExecutionEnum.FAIL.getStateInfo());
		}

		return result;
	}

}
