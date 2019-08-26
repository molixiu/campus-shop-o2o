package com.xjwfk.o2o.mapper;

import com.xjwfk.o2o.entity.WechatAuth;

/**
* @ClassName: WechatAuth
* @Description: TODO(对数据库微信用户表的增删改查)
* @author 白巾川
* @date 2019年8月12日
*/

public interface WechatAuthMapper {

	public int insertWechatAuth(WechatAuth wechatAuth);
	
	public WechatAuth queryWechatInfoByOpenId(String openId);
}
