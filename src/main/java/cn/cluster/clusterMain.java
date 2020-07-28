package cn.cluster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

import cn.pojo.cluster;
import cn.service.ClusterInfoService;
@Component
public class clusterMain {
	@Autowired
	private Getcluster getcluster;
	@Autowired
	private clusterData clusterData;
	@Autowired
	private ClusterInfoService clusterInfoService;
	
	@Scheduled(fixedDelay = 30000)	
	public void run() {
		//JsonObject object = getcluster.getClusterDataSource();
		JsonObject object = getcluster.getClusterDataSourceByFile("单个cluster.txt");
		cluster cluster =new cluster();
		cluster = clusterData.clusterAnalysis(object);
		clusterInfoService.insertCluster(cluster);
	}

}
