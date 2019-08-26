package com.xjwfk.o2o.controller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xjwfk.o2o.entity.PersonInfo;

/**
* @ClassName: LoginTestController
* @Description: TODO(用来测试登录的，上线后删除)
* @author 白巾川
* @date 2019年8月13日
*/

@Controller
@RequestMapping("test")
public class LoginTestController {
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public void login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		PersonInfo user = new PersonInfo();
		user.setUserId(1L);
		user.setUserType(2);
		session.setAttribute("user", user);
	}
}
