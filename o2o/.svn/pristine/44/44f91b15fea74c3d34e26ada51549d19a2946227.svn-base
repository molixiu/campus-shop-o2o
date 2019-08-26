package com.xjwfk.o2o.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjwfk.o2o.BaseTest;
import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.WechatAuth;
import com.xjwfk.o2o.enumes.ExecutionEnum;

/**
* @ClassName: WechatAuthServicetEST
* @Description: TODO(对service层的AreaService进行测试)
* @author 白巾川
* @date 2019年8月12日
*/

public class WechatAuthServiceTest extends BaseTest {
	@Autowired
	private WechatAuthService wechatAuthService;
	
	@Test
	public void test_getWechatAuthByOpenId() {
		WechatAuth wechatAuthByOpenId = wechatAuthService.getWechatAuthByOpenId("123121");
		System.out.println(wechatAuthByOpenId);
	}
	
	@Test
	public void test_register() {
		PersonInfo personInfo = new PersonInfo();
		personInfo.setEnableStatus(1);
		personInfo.setUserType(1);
		
		WechatAuth wechatAuth = new WechatAuth();
		wechatAuth.setPersonInfo(personInfo);
		wechatAuth.setOpenId("11111");
		
		ExecutionEnum register = wechatAuthService.register(wechatAuth);
		System.out.println(register.getStateInfo());
	}
}
