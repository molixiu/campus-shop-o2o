package com.xjwfk.o2o.service;

import java.util.List;

import com.xjwfk.o2o.entity.HeadLine;

/**
* @ClassName: HeadLineService
* @Description: TODO(service层关于头条的业务逻辑的接口)
* @author 白巾川
* @date 2019年8月7日
*/
public interface HeadLineService {
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}
