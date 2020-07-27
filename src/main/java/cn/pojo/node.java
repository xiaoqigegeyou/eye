package cn.pojo;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class node {
	private int id;//id(主键)
	private String node_id;//节点id
	private String rack;//此节点的机架位置(主键）
	private String state;//节点的状态
	private String host_name;//主机名
	private String http_address;//HTTP地址
	private Date last_health_update;//最近一次报告状况
	private String hadoop_version;//hadoop版本
	private BigInteger num_containers;//运行的容器的总数,运行的任务数量
	private BigInteger used_memory;//当前使用的内存
	private BigInteger avail_memory;//当前可用的内存
	private BigInteger used_vcore;//使用的vcore总数
	private BigInteger available_vcote;//可用的vcore总数
	private double memory_physical;//物理内存利用率
	private double memory_virtual;//虚拟内存利用率
	private double CPU_usage;//CPU利用率
	private double containers_CPU_usage;//容器的聚合CPU利用率
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getRack() {
		return rack;
	}
	public void setRack(String rack) {
		this.rack = rack;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getHttp_address() {
		return http_address;
	}
	public void setHttp_address(String http_address) {
		this.http_address = http_address;
	}
	public Date getLast_health_update() {
		return last_health_update;
	}
	public void setLast_health_update(Date last_health_update) {
		this.last_health_update = last_health_update;
	}
	public String getHadoop_version() {
		return hadoop_version;
	}
	public void setHadoop_version(String hadoop_version) {
		this.hadoop_version = hadoop_version;
	}
	public BigInteger getNum_containers() {
		return num_containers;
	}
	public void setNum_containers(BigInteger num_containers) {
		this.num_containers = num_containers;
	}
	public BigInteger getUsed_memory() {
		return used_memory;
	}
	public void setUsed_memory(BigInteger used_memory) {
		this.used_memory = used_memory;
	}
	public BigInteger getAvail_memory() {
		return avail_memory;
	}
	public void setAvail_memory(BigInteger avail_memory) {
		this.avail_memory = avail_memory;
	}
	public BigInteger getUsed_vcore() {
		return used_vcore;
	}
	public void setUsed_vcore(BigInteger used_vcore) {
		this.used_vcore = used_vcore;
	}
	public BigInteger getAvailable_vcote() {
		return available_vcote;
	}
	public void setAvailable_vcote(BigInteger available_vcote) {
		this.available_vcote = available_vcote;
	}
	public double getMemory_physical() {
		return memory_physical;
	}
	public void setMemory_physical(double memory_physical) {
		this.memory_physical = memory_physical;
	}
	public double getMemory_virtual() {
		return memory_virtual;
	}
	public void setMemory_virtual(double memory_virtual) {
		this.memory_virtual = memory_virtual;
	}
	public double getCPU_usage() {
		return CPU_usage;
	}
	public void setCPU_usage(double cPU_usage) {
		CPU_usage = cPU_usage;
	}
	public double getContainers_CPU_usage() {
		return containers_CPU_usage;
	}
	public void setContainers_CPU_usage(double containers_CPU_usage) {
		this.containers_CPU_usage = containers_CPU_usage;
	}

	
	
}
