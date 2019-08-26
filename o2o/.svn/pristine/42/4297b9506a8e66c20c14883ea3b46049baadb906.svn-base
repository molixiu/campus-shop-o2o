package com.xjwfk.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.Area;
import com.xjwfk.o2o.mapper.AreaMapper;

/**
* @ClassName: AreaDaoTest
* @Description: TODO(对dao层的AreaMapper进行测试)
* @author 白巾川
* @date 2019年7月18日
*/
public class AreaMapperTest extends BaseTest {
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Test
	public void test_queryArea() {
		List<Area> queryAreaList = areaMapper.queryAreaList();
		System.out.println(queryAreaList.size());
	}
}
