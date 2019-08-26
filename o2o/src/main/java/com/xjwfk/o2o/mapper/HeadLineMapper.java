package com.xjwfk.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjwfk.o2o.entity.HeadLine;

/**
 * @ClassName: HeadLineMapper
 * @Description: TODO(对数据库头条表的增删改查)
 * @author 白巾川
 * @date 2019年8月7日
 */

public interface HeadLineMapper {
	public int insertHeadLine(HeadLine headLine);

	public List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
