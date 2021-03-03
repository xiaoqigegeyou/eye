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


	}
}
