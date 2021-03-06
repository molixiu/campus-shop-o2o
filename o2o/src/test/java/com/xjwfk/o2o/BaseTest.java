package com.xjwfk.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: BaseTest
 * @Description: TODO(只要子类继承此基类,其子类可以很方便对dao层或service层进行单元测试)
 * @author 白巾川
 * @date 2019年7月18日
 */

// 配置spring和junit整合，junit启动时加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件的位置
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-service.xml" })
public class BaseTest {

}
