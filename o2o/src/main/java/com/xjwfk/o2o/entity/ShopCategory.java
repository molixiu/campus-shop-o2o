package com.xjwfk.o2o.entity;

import java.util.Date;

/**
 * @ClassName: ShopCategory
 * @Description: TODO(店铺类别实体类)
 * @author 白巾川
 * @date 2019年7月17日
 */
public class ShopCategory {
	private Long shopCategoryId; // 主键ID
	private String shopCategoryName; // 类别名
	private String shopCategoryDesc; // 类别描述
	private String shopCategoryImg; // 类别图片地址(针对一级类别)
	private Integer priority; // 权重，越大越排前显示
	private Date createTime; // 创建时间
	private Date lastEditTime; // 最近的更新时间
	private ShopCategory parent; // 父类别

	public Long getShopCategoryId() {
		return shopCategoryId;
	}

	public void setShopCategoryId(Long shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public String getShopCategoryName() {
		return shopCategoryName;
	}

	public void setShopCategoryName(String shopCategoryName) {
		this.shopCategoryName = shopCategoryName;
	}

	public String getShopCategoryDesc() {
		return shopCategoryDesc;
	}

	public void setShopCategoryDesc(String shopCategoryDesc) {
		this.shopCategoryDesc = shopCategoryDesc;
	}

	public String getShopCategoryImg() {
		return shopCategoryImg;
	}

	public void setShopCategoryImg(String shopCategoryImg) {
		this.shopCategoryImg = shopCategoryImg;
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

	public ShopCategory getParent() {
		return parent;
	}

	public void setParent(ShopCategory parent) {
		this.parent = parent;
	}

}
