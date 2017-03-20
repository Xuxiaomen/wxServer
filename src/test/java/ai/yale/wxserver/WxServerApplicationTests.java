package ai.yale.wxserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ai.yale.wxserver.bean.MyProps;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxServerApplicationTests {

	@Autowired
	MyProps myProps;
	
	@Test
	public void contextLoads() {
		System.out.println(myProps.getSimpleProp());
	}

}
