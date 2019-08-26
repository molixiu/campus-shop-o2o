package com.xjwfk.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjwfk.o2o.entity.Area;
import com.xjwfk.o2o.mapper.AreaMapper;
import com.xjwfk.o2o.service.AreaService;

/**
* @ClassName: AreaServiceImpl
* @Description: TODO(service层关于区域的业务逻辑接口的实现类)
* @author 白巾川
* @date 2019年7月18日
*/

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaMapper areaMapper;

	@Override
	public List<Area> getAreaList() {
		return areaMapper.queryAreaList();
	}
	
	

}
