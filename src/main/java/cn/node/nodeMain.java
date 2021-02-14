package cn.node;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

import cn.pojo.NodePO;
import cn.service.NodeInfoService;

@Component
public class NodeMain {
	@Autowired
	private Getnode getnode;
	@Autowired
	private NodeData nodeData;
	@Autowired
	private NodeInfoService nodeInfoService;

	// @Scheduled(fixedDelay = 30000)
	@Scheduled(cron = "5 0/30 * * * ? ") // 每30分钟调度一次 [秒] [分] [小时] [日] [月] [周] [年]
	public void run() {

		// JsonArray array = getnode.getNodeDataSourceByFile("nodes.txt");
		JsonArray array = getnode.getApplicationDataSource();
		List<NodePO> node = nodeData.nodeAnalysis(array);
		nodeInfoService.insert_node(node);
		System.out.println("获取node");
	}

}
