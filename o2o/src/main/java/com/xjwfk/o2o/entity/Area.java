package com.xjwfk.o2o.entity;

import java.util.Date;

/**
 * @ClassName: Area
 * @Description: TODO(区域信息实体类)
 * @author 白巾川
 * @date 2019年7月17日
 */
public class Area {
	private Integer areaId; // 主键ID
	private String areaName; // 名称
	private Integer priority; // 权重，越大越排前显示
	private Date createTime; // 创建时间
	private Date lastEditTime; // 更新时间
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
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
		
}
