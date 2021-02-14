package cn.cluster;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

import cn.pojo.ClusterPO;

@Component
public class ClusterData {
	@Autowired
	private ClusterPO cluster;

	public ClusterPO clusterAnalysis(JsonObject object) {
		// cluster.setName(object.get("name").getAsString());
		cluster.setApps_submit(object.get("appsSubmitted").getAsInt());
		cluster.setApps_complet(object.get("appsCompleted").getAsInt());
		cluster.setApps_pending(object.get("appsPending").getAsInt());
		cluster.setApps_running(object.get("appsRunning").getAsInt());
		cluster.setApps_failed(object.get("appsFailed").getAsInt());
		cluster.setApps_killed(object.get("appsKilled").getAsInt());
		cluster.setMemory_reserved(object.get("reservedMB").getAsBigInteger());
		cluster.setMemory_available(object.get("availableMB").getAsBigInteger());
		cluster.setMemory_allocated(object.get("allocatedMB").getAsBigInteger());
		cluster.setMemory_total(object.get("totalMB").getAsBigInteger());
		cluster.setVcore_reserved(object.get("reservedVirtualCores").getAsBigInteger());
		cluster.setVcore_available(object.get("availableVirtualCores").getAsBigInteger());
		cluster.setVcore_allocated(object.get("allocatedVirtualCores").getAsBigInteger());
		cluster.setVcore_total(object.get("totalVirtualCores").getAsBigInteger());
		cluster.setContainers_allocated(object.get("containersAllocated").getAsInt());
		cluster.setContainers_reserved(object.get("containersReserved").getAsInt());
		cluster.setContainers_pending(object.get("containersPending").getAsInt());
		cluster.setNodes_total(object.get("totalNodes").getAsInt());
		cluster.setNodes_active(object.get("activeNodes").getAsInt());
		cluster.setNodes_lost(object.get("lostNodes").getAsInt());
		cluster.setNodes_unhealthy(object.get("unhealthyNodes").getAsInt());
		cluster.setNodes_decommissioning(-1);// 取不到暂置为-1
		cluster.setNodes_decommissioned(object.get("appsSubmitted").getAsInt());
		cluster.setNodes_rebooted(object.get("rebootedNodes").getAsInt());
		cluster.setNodes_shutdown(-1);// 取不到暂置为-1
		cluster.setCreated_at(new Date());
		return cluster;
	}
}
