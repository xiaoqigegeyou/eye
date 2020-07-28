package cn.node;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;

import cn.pojo.node;
import cn.service.NodeInfoService;
@Component
public class nodeMain {
	@Autowired
	private Getnode getnode;
	@Autowired
	private nodeData nodeData;
	@Autowired
	private NodeInfoService nodeInfoService;
	@Scheduled(fixedDelay = 30000)
	public void run() {
		JsonArray array = getnode.getNodeDataSourceByFile("nodes.txt");	
		List<node> node = nodeData.nodeAnalysis(array);
		nodeInfoService.insert_node(node);
		
	}

}