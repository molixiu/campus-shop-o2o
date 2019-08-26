package com.xjwfk.o2o.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.PersonInfo;

/**
* @ClassName: PersonInfoServiceTest
* @Description: TODO(对service层的PersonInfoService进行测试)
* @author 白巾川
* @date 2019年8月13日
*/

public class PersonInfoServiceTest extends BaseTest {
	@Autowired
	private PersonInfoService personInfoService;
	
	@Test
	public void test_getPersonInfoById() {
		PersonInfo personInfoById = personInfoService.getPersonInfoById(1L);
		System.out.println(personInfoById);
	}
}
