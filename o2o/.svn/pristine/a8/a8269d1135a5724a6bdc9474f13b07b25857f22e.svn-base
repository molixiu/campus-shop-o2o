package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjwfk.o2o.entity.HeadLine;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.HeadLineOperationException;
import com.xjwfk.o2o.mapper.HeadLineMapper;
import com.xjwfk.o2o.service.HeadLineService;

/**
* @ClassName: HeadLineServiceImpl
* @Description: TODO(service层关于头条的业务逻辑接口的实现类)
* @author 白巾川
* @date 2019年8月7日
*/

@Service
public class HeadLineServiceImpl implements HeadLineService{
	@Autowired
	private HeadLineMapper headLineMapper;
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
		try {
			List<HeadLine> headLineList = headLineMapper.queryHeadLine(headLineCondition);
			return headLineList;	//查询成功
		} catch (Exception e) {
			//查询失败
			throw new HeadLineOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}
}
