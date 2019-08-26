package com.xjwfk.o2o.entity;

import java.util.Date;

/**
 * @ClassName: LocalAuth
 * @Description: TODO(本地账户实体类，主要用来做帐号密码的登录)
 * @author 白巾川
 * @date 2019年7月17日
 */
public class LocalAuth {
	private Long localAuthId; // 主键ID
	private String username; // 帐号
	private String password; // 密码
	private Date createTime; // 创建时间
	private Date lastEditTime; // 最近一次的更新时间
	private PersonInfo personInfo; // 个人信息，关系为一一对应

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
