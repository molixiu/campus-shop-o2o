package com.xjwfk.o2o.entity;

import java.util.Date;

/**
 * @ClassName: ProductCategory
 * @Description: TODO(商品类别实体类)
 * @author 白巾川
 * @date 2019年7月17日
 */
public class ProductCategory {
	private Long productCategoryId; // 主键ID
	private Long shopId; // 该类别是属于哪个店铺的
	private String productCategoryName; // 类别名
	private Integer priority; // 权重，越大越排前显示
	private Date createTime; // 创建时间

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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

}
