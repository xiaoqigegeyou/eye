package cn.pp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.service.PpService;

@Component
public class PpMain {

	@Autowired
	private PpData PpData;
	@Autowired
	private PpService ppService;

	// @Scheduled(fixedDelay = 30000)
	@Scheduled(cron = "55 0/20 * * * ? ")
	public void run() {
		PpData.ppAnalysis();
//			Map<String, String> keyValueMap = new HashMap<String, String>();
////			keyValueMap.put("jdbc.driver", "com.mysql.jdbc.Driver");
////			keyValueMap.put("jdbc.url", "jdbc:mysql://localhost:3306/hadoop_test?characterEncoding=utf-8&serverTimezone=GMT%2b8");
////			keyValueMap.put("jdbc.username", "root");
////			keyValueMap.put("jdbc.password", "123456");
//			
//			keyValueMap.put("pp.jdbc.driver", "com.mysql.jdbc.Driver");
//			keyValueMap.put("pp.jdbc.url", "jdbc:mysql://localhost:3306/oms_tt?characterEncoding=utf-8&serverTimezone=GMT%2b8");
//			keyValueMap.put("pp.jdbc.username", "root");
//			keyValueMap.put("pp.jdbc.password", "123456");
//			PropertiesUtil.updateProperties("jdbc2.properties", keyValueMap);
//			System.out.println(ppService.selectName());
//			
//			keyValueMap.put("pp.jdbc.driver", "com.mysql.jdbc.Driver");
//			keyValueMap.put("pp.jdbc.url", "jdbc:mysql://localhost:3306/oms_z302?characterEncoding=utf-8&serverTimezone=GMT%2b8");
//			keyValueMap.put("pp.jdbc.username", "root");
//			keyValueMap.put("pp.jdbc.password", "123456");
//			PropertiesUtil.updateProperties("jdbc2.properties", keyValueMap);
//				System.out.println(ppService.selectName());
		

	}
}
