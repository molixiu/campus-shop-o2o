package com.xjwfk.o2o.mapper;

import java.util.List;

import com.xjwfk.o2o.entity.Area;

/**
* @ClassName: AreaMapper
* @Description: TODO(对数据库区域表的增删改查)
* @author 白巾川
* @date 2019年7月18日
*/
public interface AreaMapper {
	
	public List<Area> queryAreaList();
}
