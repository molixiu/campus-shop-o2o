package com.xjwfk.o2o.service;

import com.xjwfk.o2o.entity.WechatAuth;
import com.xjwfk.o2o.enumes.ExecutionEnum;

public interface WechatAuthService {

	
	public WechatAuth getWechatAuthByOpenId(String openId);

	
	public ExecutionEnum register(WechatAuth wechatAuth);

}
