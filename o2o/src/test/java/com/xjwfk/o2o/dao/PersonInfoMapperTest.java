package com.xjwfk.o2o.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.mapper.PersonInfoMapper;

/**
* @ClassName: PersonInfoMapperTest
* @Description: TODO(对dao层的HeadLineMapper进行测试)
* @author 白巾川
* @date 2019年8月12日
*/

public class PersonInfoMapperTest extends BaseTest {
	@Autowired
	private PersonInfoMapper personInfoMapper;
	
	@Test
	public void test_insertPersonInfo() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setEnableStatus(1);
		personInfo.setUserType(1);
		
		personInfoMapper.insertPersonInfo(personInfo);
	}
	
	@Test
	public void test_queryPersonInfoById() {
		PersonInfo queryPersonInfoById = personInfoMapper.queryPersonInfoById(1);
		System.out.println(queryPersonInfoById);
	}
}
