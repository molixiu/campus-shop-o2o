package com.xjwfk.o2o.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.WechatAuth;
import com.xjwfk.o2o.mapper.WechatAuthMapper;

/**
* @ClassName: WechatAuthMapperTest
* @Description: TODO(对dao层的WechatAuthMapper进行测试)
* @author 白巾川
* @date 2019年8月12日
*/

public class WechatAuthMapperTest extends BaseTest {
	@Autowired
	private WechatAuthMapper wechatAuthMapper;
	
	@Test
	public void test_insertWechatAuth() {
		WechatAuth wechatAuth = new WechatAuth();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId("123121");
		int insertWechatAuth = wechatAuthMapper.insertWechatAuth(wechatAuth);
		System.out.println(insertWechatAuth);
	}
	
	@Test
	public void test_queryWechatInfoByOpenId() {
		WechatAuth wechatAuth = wechatAuthMapper.queryWechatInfoByOpenId("123121");
		System.out.println(wechatAuth);
	}
}
