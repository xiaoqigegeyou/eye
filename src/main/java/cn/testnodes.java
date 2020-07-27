package cn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;


import cn.node.Getnode;
import cn.node.nodeData;
import cn.pojo.node;
import cn.service.NodeInfoService;

public class testnodes {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");

		JsonArray array=applicationContext.getBean(Getnode.class).getNodeDataSourceByFile("nodes.txt");
		List<node> node=applicationContext.getBean(nodeData.class).nodeAnalysis(array);
		applicationContext.getBean(NodeInfoService.class).insert_node(node);
	}
	}
