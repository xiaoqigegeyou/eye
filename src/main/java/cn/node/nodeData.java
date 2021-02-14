package cn.node;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.pojo.ClusterPO;
import cn.pojo.NodePO;
import cn.until.DateFormat;

@Component
public class NodeData {

	public List<NodePO> nodeAnalysis(JsonArray array) {
		List<NodePO> lnode = new ArrayList<NodePO>();
		int j = array.size();// JSON数组大小

		for (int i = 0; i < j; i++) {
			NodePO node = new NodePO();
			JsonObject subObject = array.get(i).getAsJsonObject();
			node.setNode_id(subObject.get("id").getAsString());
			node.setRack(subObject.get("rack").getAsString());
			node.setState(subObject.get("state").getAsString());
			node.setHost_name(subObject.get("nodeHostName").getAsString());
			node.setHttp_address(subObject.get("nodeHTTPAddress").getAsString());
			node.setLast_health_update(DateFormat.toDate(subObject.get("lastHealthUpdate").getAsString()));
			node.setHadoop_version(subObject.get("version").getAsString());
			node.setNum_containers(subObject.get("numContainers").getAsBigInteger());
			node.setUsed_memory(subObject.get("usedMemoryMB").getAsBigInteger());
			node.setAvail_memory(subObject.get("availMemoryMB").getAsBigInteger());
			node.setUsed_vcore(subObject.get("usedVirtualCores").getAsBigInteger());
			node.setAvailable_vcote(subObject.get("availableVirtualCores").getAsBigInteger());
//			node.setMemory_physical(memory_physical);
//			node.setMemory_virtual(memory_virtual);
//			node.setCPU_usage(cPU_usage);
//			node.setContainers_CPU_usage(containers_CPU_usage);
			node.setCreated_at(new Date());
			lnode.add(node);
		}
		return lnode;
	}
}
