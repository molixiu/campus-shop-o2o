package com.xjwfk.o2o.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.entity.WechatAuth;
import com.xjwfk.o2o.enumes.ExecutionEnum;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.WechatOperationException;
import com.xjwfk.o2o.mapper.PersonInfoMapper;
import com.xjwfk.o2o.mapper.WechatAuthMapper;

/**
 * @ClassName: WechatAuthServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 白巾川
 * @date 2019年8月12日
 */

@Service
public class WechatAuthServiceImpl implements WechatAuthService {
	@Autowired
	private WechatAuthMapper wechatAuthMapper;

	@Autowired
	private PersonInfoMapper personInfoMapper;

	@Override
	public WechatAuth getWechatAuthByOpenId(String openId) {
		try {
			WechatAuth wechatAuth = wechatAuthMapper.queryWechatInfoByOpenId(openId);
			if (wechatAuth != null) {
				return wechatAuth; // 查询成功
			} else {
				throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 查询失败
			throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

	@Override
	@Transactional
	public ExecutionEnum register(WechatAuth wechatAuth) {
		try {
			if (wechatAuth != null) {
				PersonInfo personInfo = wechatAuth.getPersonInfo();
				if (personInfo != null) {
					int insertPersonInfo = personInfoMapper.insertPersonInfo(personInfo);
					if (insertPersonInfo > 0) {
						wechatAuth.setPersonInfo(personInfo);
						int insertWechatAuth = wechatAuthMapper.insertWechatAuth(wechatAuth);
						if (insertWechatAuth > 0) {
							return ExecutionEnum.SUCCESS; // 账号注册成功
						} else {
							throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
						}
					} else {
						throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
					}
				} else {
					throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
				}
			} else {
				throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			// 账号注册失败
			throw new WechatOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

}
