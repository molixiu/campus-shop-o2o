package com.xjwfk.o2o.entity;

import java.util.Date;

/**
 * @ClassName: WechatAuth
 * @Description: TODO(微信登录实体类)
 * @author 白巾川
 * @date 2019年7月17日
 */
public class WechatAuth {
	private Long wechatAuthId; // 主键ID
	private String openId; // 微信获取用户信息的凭证，对于某个公众号具有唯一性
	private Date createTime; // 创建时间
	private PersonInfo personInfo; // 用户信息
	
	

	public WechatAuth() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WechatAuth(String openId, Date createTime, PersonInfo personInfo) {
		super();
		this.openId = openId;
		this.createTime = createTime;
		this.personInfo = personInfo;
	}

	public Long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
