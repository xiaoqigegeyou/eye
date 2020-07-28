package cn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class start {
	
	public static void main(String[] args) {
		AbstractApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();//启动Spring容器
	
	}
}
