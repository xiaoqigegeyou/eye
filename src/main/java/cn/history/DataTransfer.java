package cn.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.service.JobInfoService;
import cn.service.MapInfoService;

@Component
public class DataTransfer {
	@Autowired
	private JobInfoService jobInfoService;
	@Autowired
	private MapInfoService mapInfoService;

	@Scheduled(cron = "0 0 1 * * ?")
	public void run() {

		jobInfoService.transfer();

		mapInfoService.transfer();

	}
}
