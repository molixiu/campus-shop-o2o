package com.xjwfk.o2o.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.ProductImg;
import com.xjwfk.o2o.mapper.ProductImgMapper;

/**
* @ClassName: ProductImgMapperTest
* @Description: TODO(对dao层的ProductImgMapper进行测试)
* @author 白巾川
* @date 2019年8月5日
*/

public class ProductImgMapperTest extends BaseTest {
	@Autowired
	private ProductImgMapper productImgMapper;
	
	@Test
	public void test_batchInsertProductImg() {
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(2L);
		
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setPriority(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(2L);
		
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		
		int batchInsertProductImg = productImgMapper.batchInsertProductImg(productImgList);
		System.out.println(batchInsertProductImg);
	}
	
	@Test
	public void test_deleteProductImgByProductId() {
		int deleteProductImgByProductId = productImgMapper.deleteProductImgByProductId(2L);
		System.out.println(deleteProductImgByProductId);
	}
}
