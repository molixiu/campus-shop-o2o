package com.xjwfk.o2o.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.HeadLine;
import com.xjwfk.o2o.mapper.HeadLineMapper;

/**
* @ClassName: HeadLineMapperTest
* @Description: TODO(对dao层的HeadLineMapper进行测试)
* @author 白巾川
* @date 2019年8月7日
*/
public class HeadLineMapperTest extends BaseTest {
	@Autowired
	private HeadLineMapper headLineMapper;
	
	@Test
	public void test_insertHeadLine() {
		HeadLine headLine = new HeadLine();
		headLine.setCreateTime(new Date());
		headLine.setEnableStatus(1);
		headLine.setLastEditTime(new Date());
		headLine.setLineName("冷饮");
		headLine.setLineLink("aa");
		headLine.setPriority(3);
		headLine.setLineImg("");
		
		int insertHeadLine = headLineMapper.insertHeadLine(headLine);
		System.out.println(insertHeadLine);
	}
	
	@Test
	public void test_queryHeadLine() {
		HeadLine headLine = new HeadLine();
		headLine.setEnableStatus(1);
		List<HeadLine> queryHeadLine = headLineMapper.queryHeadLine(headLine);
		System.out.println(queryHeadLine.size());
	}
}
