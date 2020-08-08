package cn.pp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class PpMain {
	
	@Autowired
	private PpData PpData;
	@Scheduled(cron="5 0/10 * * * ? ")
		public void run() {
			
			PpData.ppAnalysis();
			
		}
}
