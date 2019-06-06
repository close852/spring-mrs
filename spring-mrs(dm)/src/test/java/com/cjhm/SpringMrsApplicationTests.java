package com.cjhm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjhm.entity.Money;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMrsApplicationTests {

	@Test
	public void contextLoads() {
		Money m = new Money(1000);
	}

}
