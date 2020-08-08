package cn;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import com.google.gson.JsonObject;

import cn.cluster.Getcluster;
import cn.cluster.ClusterData;
import cn.pojo.ClusterPO;
import cn.service.ClusterInfoService;

public class ClusterTest {
	
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		JsonObject object=applicationContext.getBean(Getcluster.class).getClusterDataSourceByFile("单个cluster.txt");
		//JsonObject object=applicationContext.getBean(Getcluster.class).getClusterDataSource();
		System.out.println(object.toString());
//		cluster cluster =applicationContext.getBean(cluster.class);
//		cluster=applicationContext.getBean(clusterData.class).clusterAnalysis(object);
//		applicationContext.getBean(ClusterInfoService.class).insertCluster(cluster);
		
	}
	public  void get11() {
		System.out.println(11);
		//JsonArray applicationDataSource = getappliction.getjobApplicationDataSourceByFile("apps.txt");
	}
	
}
