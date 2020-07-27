package cn.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class job {
	

	private Integer id;//id 自动递增
	private String job_id;//任务id
	private String job_name;//任务名称,,为空
	private String state;//任务当前状态
	private String product_id;//该任务所处理的产品号
	private String satellite_name;//卫星名称
	private String job_user;//任务提交的用户
	private String final_status;//任务最终运行状态
	private Date started_time;//任务开始时间
	private Date finished_time;//任务结束时间
	private Float elapsed_time;//任务运行时间戳
	private String tracking_url;//任务详细信息链接
	private String timestamp;//任务完成时间戳
	private String province_id;//省份id
	private Integer step_id;//步骤与step表对应
	private String resultpath;//
	private String remark;//
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getSatellite_name() {
		return satellite_name;
	}
	public void setSatellite_name(String satellite_name) {
		this.satellite_name = satellite_name;
	}
	public String getJob_user() {
		return job_user;
	}
	public void setJob_user(String job_user) {
		this.job_user = job_user;
	}
	public String getFinal_status() {
		return final_status;
	}
	public void setFinal_status(String final_status) {
		this.final_status = final_status;
	}
	public Date getStarted_time() {
		return started_time;
	}
	public void setStarted_time(Date started_time) {
		this.started_time = started_time;
	}
	public Date getFinished_time() {
		return finished_time;
	}
	public void setFinished_time(Date finished_time) {
		this.finished_time = finished_time;
	}
	public Float getElapsed_time() {
		return elapsed_time;
	}
	public void setElapsed_time(Float elapsed_time) {
		this.elapsed_time = elapsed_time;
	}
	public String getTracking_url() {
		return tracking_url;
	}
	public void setTracking_url(String tracking_url) {
		this.tracking_url = tracking_url;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getProvince_id() {
		return province_id;
	}
	public void setProvince_id(String province_id) {
		this.province_id = province_id;
	}
	public Integer getStep_id() {
		return step_id;
	}
	public void setStep_id(Integer step_id) {
		this.step_id = step_id;
	}
	public String getResultpath() {
		return resultpath;
	}
	public void setResultpath(String resultpath) {
		this.resultpath = resultpath;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "job [id=" + id + ", job_id=" + job_id + ", job_name=" + job_name + ", state=" + state + ", product_id="
				+ product_id + ", satellite_name=" + satellite_name + ", job_user=" + job_user + ", final_status="
				+ final_status + ", started_time=" + started_time + ", finished_time=" + finished_time
				+ ", elapsed_time=" + elapsed_time + ", tracking_url=" + tracking_url + ", timestamp=" + timestamp
				+ ", province_id=" + province_id + ", step_id=" + step_id + ", resultpath=" + resultpath + ", remark="
				+ remark + "]";
	}
	

}
