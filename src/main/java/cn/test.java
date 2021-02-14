package cn;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;

import cn.node.Getnode;
import cn.node.NodeData;
import cn.pojo.NodePO;
import cn.pojo.PpMasterPO;
import cn.service.NodeInfoService;
import cn.service.PpService;
import cn.until.DateFormat;
import cn.until.dataSource.PropertiesUtil;

public class Test {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			PpMasterPO pp= new PpMasterPO();
			pp.setId(1);
			pp.setId(2);
			System.out.println(pp.getId());
//pp.jdbc.driver=com.mysql.jdbc.Driver
//pp.jdbc.url=jdbc:mysql://localhost:3306/oms_z302?characterEncoding=utf-8&serverTimezone=GMT%2b8
//pp.jdbc.username=root
//pp.jdbc.password=123456
//	jdbc.driver=com.mysql.jdbc.Driver
//			jdbc.url=jdbc:mysql://localhost:3306/hadoop_test?characterEncoding=utf-8&serverTimezone=GMT%2b8
//			jdbc.username=root
//			jdbc.password=123456
		// applicationContext.getBean(PPService.class).getPP(lastDate);
		Map<String, String> keyValueMap = new HashMap<String, String>();
//	keyValueMap.put("jdbc.driver", "com.mysql.jdbc.Driver");
//	keyValueMap.put("jdbc.url", "jdbc:mysql://localhost:3306/hadoop_test?characterEncoding=utf-8&serverTimezone=GMT%2b8");
//	keyValueMap.put("jdbc.username", "root");
//	keyValueMap.put("jdbc.password", "123456");

//	keyValueMap.put("pp.jdbc.driver", "com.mysql.jdbc.Driver");
//	keyValueMap.put("pp.jdbc.url", "jdbc:mysql://localhost:3306/oms_tt?characterEncoding=utf-8&serverTimezone=GMT%2b8");
//	keyValueMap.put("pp.jdbc.username", "root");
//	keyValueMap.put("pp.jdbc.password", "123456");
//	PropertiesUtil.updateProperties("jdbc2.properties", keyValueMap);
//	System.out.println(applicationContext.getBean(PpService.class).selectName());

//	keyValueMap.put("pp.jdbc.driver", "com.mysql.jdbc.Driver");
//	keyValueMap.put("pp.jdbc.url", "jdbc:mysql://localhost:3306/oms_z302?characterEncoding=utf-8&serverTimezone=GMT%2b8");
//	keyValueMap.put("pp.jdbc.username", "root");
//	keyValueMap.put("pp.jdbc.password", "123456");
//	PropertiesUtil.updateProperties("jdbc2.properties", keyValueMap);
//	System.out.println(applicationContext.getBean(PpService.class).selectName());

	}

}
