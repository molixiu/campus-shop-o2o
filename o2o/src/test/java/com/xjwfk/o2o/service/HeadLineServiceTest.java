package com.xjwfk.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.HeadLine;

/**
* @ClassName: HeadLineServiceTest
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 白巾川
* @date 2019年8月7日
*/

public class HeadLineServiceTest extends BaseTest {
	@Autowired
	private HeadLineService headLineService;
	
	@Test
	public void test_getHeadLineList() {
		List<HeadLine> headLineList = headLineService.getHeadLineList(null);
		System.out.println(headLineList.size());
	}
}
