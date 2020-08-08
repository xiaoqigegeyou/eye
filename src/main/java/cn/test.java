package cn;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;

import cn.node.Getnode;
import cn.node.NodeData;
import cn.pojo.NodePO;
import cn.service.NodeInfoService;
import cn.service.PpService;
import cn.until.DateFormat;

public class Test {
public static void main(String[] args) {
	ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

	//applicationContext.getBean(PPService.class).getPP(lastDate);
}

    public static void  test1(String a ) {
    	
    	System.out.println(a);
	}
}
