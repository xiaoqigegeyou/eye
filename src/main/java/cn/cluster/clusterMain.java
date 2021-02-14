package cn.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

import cn.pojo.ClusterPO;
import cn.service.ClusterInfoService;

@Component
public class ClusterMain {
	@Autowired
	private Getcluster getcluster;
	@Autowired
	private ClusterData clusterData;
	@Autowired
	private ClusterInfoService clusterInfoService;

	// @Scheduled(fixedDelay = 30000)
	@Scheduled(cron = "5 0/30 * * * ? ") // 每30分钟调度一次 [秒] [分] [小时] [日] [月] [周] [年]
	public void run() {

		JsonObject object = getcluster.getClusterDataSource();
		// JsonObject object = getcluster.getClusterDataSourceByFile("单个cluster.txt");
		ClusterPO cluster = new ClusterPO();
		cluster = clusterData.clusterAnalysis(object);
		clusterInfoService.insertCluster(cluster);
		System.out.println("获取cluster");
		// System.out.println(cluster);
	}

}
