package com.xjwfk.o2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjwfk.o2o.entity.PersonInfo;
import com.xjwfk.o2o.enumes.QueryEnum;
import com.xjwfk.o2o.exceptions.PersonInfoOperationException;
import com.xjwfk.o2o.mapper.PersonInfoMapper;
import com.xjwfk.o2o.service.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
	@Autowired
	private PersonInfoMapper personInfoMapper;

	@Override
	public PersonInfo getPersonInfoById(long userId) {
		try {
			PersonInfo personInfo = personInfoMapper.queryPersonInfoById(userId);
			if (personInfo != null) {
				return personInfo;	//查询成功
			} else {
				throw new PersonInfoOperationException(QueryEnum.FAIL.getStateInfo());
			}
		} catch (Exception e) {
			//查询失败
			throw new PersonInfoOperationException(QueryEnum.FAIL.getStateInfo());
		}
	}

}
