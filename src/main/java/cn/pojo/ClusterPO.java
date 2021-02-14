package cn.pojo;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ClusterPO {

	private int id;
	private String name;// 名称
	private int apps_submit;// Application提交数量
	private int apps_complet;// Application完成数量
	private int apps_pending;// Application等待的数量
	private int apps_running;// 正在运行的Application的数量
	private int apps_failed;// Application失败的数量
	private int apps_killed;// 杀死的应用程序的数量
	private BigInteger memory_reserved;// 保留的内存量
	private BigInteger memory_available;// 可用的内存量
	private BigInteger memory_allocated;// 分配的内存量
	private BigInteger memory_total;// 内存的总量
	private BigInteger vcore_reserved;// 保留的虚拟核的数量
	private BigInteger vcore_available;// 可用虚拟核的数量
	private BigInteger vcore_allocated;// 分配的虚拟核的数量
	private BigInteger vcore_total;// 虚拟核的总数
	private int containers_allocated;// 分配的containers数量
	private int containers_reserved;// 预留的containers数量
	private int containers_pending;// 待处理的containers数量
	private int nodes_total;// 节点的总数
	private int nodes_active;// 活动节点的数量
	private int nodes_lost;// 丢失节点的数量
	private int nodes_unhealthy;// 不健康节点的数量
	private int nodes_decommissioning;// 正在退役的节点数量
	private int nodes_decommissioned;// 已退役节点的数量
	private int nodes_rebooted;// 重新启动的节点数
	private int nodes_shutdown;// 关闭节点的数量
	private Date created_at;// 数据插入时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getApps_submit() {
		return apps_submit;
	}

	public void setApps_submit(int apps_submit) {
		this.apps_submit = apps_submit;
	}

	public int getApps_complet() {
		return apps_complet;
	}

	public void setApps_complet(int apps_complet) {
		this.apps_complet = apps_complet;
	}

	public int getApps_pending() {
		return apps_pending;
	}

	public void setApps_pending(int apps_pending) {
		this.apps_pending = apps_pending;
	}

	public int getApps_running() {
		return apps_running;
	}

	public void setApps_running(int apps_running) {
		this.apps_running = apps_running;
	}

	public int getApps_failed() {
		return apps_failed;
	}

	public void setApps_failed(int apps_failed) {
		this.apps_failed = apps_failed;
	}

	public int getApps_killed() {
		return apps_killed;
	}

	public void setApps_killed(int apps_killed) {
		this.apps_killed = apps_killed;
	}

	public BigInteger getMemory_reserved() {
		return memory_reserved;
	}

	public void setMemory_reserved(BigInteger memory_reserved) {
		this.memory_reserved = memory_reserved;
	}

	public BigInteger getMemory_available() {
		return memory_available;
	}

	public void setMemory_available(BigInteger memory_available) {
		this.memory_available = memory_available;
	}

	public BigInteger getMemory_allocated() {
		return memory_allocated;
	}

	public void setMemory_allocated(BigInteger memory_allocated) {
		this.memory_allocated = memory_allocated;
	}

	public BigInteger getMemory_total() {
		return memory_total;
	}

	public void setMemory_total(BigInteger memory_total) {
		this.memory_total = memory_total;
	}

	public BigInteger getVcore_reserved() {
		return vcore_reserved;
	}

	public void setVcore_reserved(BigInteger vcore_reserved) {
		this.vcore_reserved = vcore_reserved;
	}

	public BigInteger getVcore_available() {
		return vcore_available;
	}

	public void setVcore_available(BigInteger vcore_available) {
		this.vcore_available = vcore_available;
	}

	public BigInteger getVcore_allocated() {
		return vcore_allocated;
	}

	public void setVcore_allocated(BigInteger vcore_allocated) {
		this.vcore_allocated = vcore_allocated;
	}

	public BigInteger getVcore_total() {
		return vcore_total;
	}

	public void setVcore_total(BigInteger vcore_total) {
		this.vcore_total = vcore_total;
	}

	public int getContainers_allocated() {
		return containers_allocated;
	}

	public void setContainers_allocated(int containers_allocated) {
		this.containers_allocated = containers_allocated;
	}

	public int getContainers_reserved() {
		return containers_reserved;
	}

	public void setContainers_reserved(int containers_reserved) {
		this.containers_reserved = containers_reserved;
	}

	public int getContainers_pending() {
		return containers_pending;
	}

	public void setContainers_pending(int containers_pending) {
		this.containers_pending = containers_pending;
	}

	public int getNodes_total() {
		return nodes_total;
	}

	public void setNodes_total(int nodes_total) {
		this.nodes_total = nodes_total;
	}

	public int getNodes_active() {
		return nodes_active;
	}

	public void setNodes_active(int nodes_active) {
		this.nodes_active = nodes_active;
	}

	public int getNodes_lost() {
		return nodes_lost;
	}

	public void setNodes_lost(int nodes_lost) {
		this.nodes_lost = nodes_lost;
	}

	public int getNodes_unhealthy() {
		return nodes_unhealthy;
	}

	public void setNodes_unhealthy(int nodes_unhealthy) {
		this.nodes_unhealthy = nodes_unhealthy;
	}

	public int getNodes_decommissioning() {
		return nodes_decommissioning;
	}

	public void setNodes_decommissioning(int nodes_decommissioning) {
		this.nodes_decommissioning = nodes_decommissioning;
	}

	public int getNodes_decommissioned() {
		return nodes_decommissioned;
	}

	public void setNodes_decommissioned(int nodes_decommissioned) {
		this.nodes_decommissioned = nodes_decommissioned;
	}

	public int getNodes_rebooted() {
		return nodes_rebooted;
	}

	public void setNodes_rebooted(int nodes_rebooted) {
		this.nodes_rebooted = nodes_rebooted;
	}

	public int getNodes_shutdown() {
		return nodes_shutdown;
	}

	public void setNodes_shutdown(int nodes_shutdown) {
		this.nodes_shutdown = nodes_shutdown;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "cluster [id=" + id + ", name=" + name + ", apps_submit=" + apps_submit + ", apps_complet="
				+ apps_complet + ", apps_pending=" + apps_pending + ", apps_running=" + apps_running + ", apps_failed="
				+ apps_failed + ", apps_killed=" + apps_killed + ", memory_reserved=" + memory_reserved
				+ ", memory_available=" + memory_available + ", memory_allocated=" + memory_allocated
				+ ", memory_total=" + memory_total + ", vcore_reserved=" + vcore_reserved + ", vcore_available="
				+ vcore_available + ", vcore_allocated=" + vcore_allocated + ", vcore_total=" + vcore_total
				+ ", containers_allocated=" + containers_allocated + ", containers_reserved=" + containers_reserved
				+ ", containers_pending=" + containers_pending + ", nodes_total=" + nodes_total + ", nodes_active="
				+ nodes_active + ", nodes_lost=" + nodes_lost + ", nodes_unhealthy=" + nodes_unhealthy
				+ ", nodes_decommissioning=" + nodes_decommissioning + ", nodes_decommissioned=" + nodes_decommissioned
				+ ", nodes_rebooted=" + nodes_rebooted + ", nodes_shutdown=" + nodes_shutdown + ", created_at="
				+ created_at + "]";
	}

}
