package com.xjwfk.o2o.wechat;

import org.junit.Test;

import com.xjwfk.o2o.utils.wechat.SignUtil;

/**
* @ClassName: SignUtilTest
* @Description: TODO(微信验证工具类测试)
* @author 白巾川
* @date 2019年8月12日
*/
public class SignUtilTest {
	
	@Test
	public void test_checkSignature() {
		String signature ="be4e3a81a917b20e49e31a8c44dae1b9f334d2ef";
		String timestamp ="1565600418";
		String nonce ="312066475";
		boolean checkSignature = SignUtil.checkSignature(signature, timestamp, nonce);
		System.out.println(checkSignature);
	}
}
