package cn.pojo;

import java.util.Date;

public class PpMasterPO {
	   private  int id;
	   private String job_id;
	   private String satellite_name;
	   private String orbit_no;
	   private String scene_no;
	   private String product_id;
	   private int province_id;
	   private Date started_time;
	   private Date finished_time;
	   private Float elapsed_time;
	   private int step_id;
	   private String state;
	   private int pp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getSatellite_name() {
		return satellite_name;
	}
	public void setSatellite_name(String satellite_name) {
		this.satellite_name = satellite_name;
	}
	public String getOrbit_no() {
		return orbit_no;
	}
	public void setOrbit_no(String orbit_no) {
		this.orbit_no = orbit_no;
	}
	public String getScene_no() {
		return scene_no;
	}
	public void setScene_no(String scene_no) {
		this.scene_no = scene_no;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getProvince_id() {
		return province_id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
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
	public int getStep_id() {
		return step_id;
	}
	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	@Override
	public String toString() {
		return "PpMasterPO [id=" + id + ", job_id=" + job_id + ", satellite_name=" + satellite_name + ", orbit_no="
				+ orbit_no + ", scene_no=" + scene_no + ", product_id=" + product_id + ", province_id=" + province_id
				+ ", started_time=" + started_time + ", finished_time=" + finished_time + ", elapsed_time="
				+ elapsed_time + ", step_id=" + step_id + ", state=" + state + ", pp=" + pp + "]";
	}
	   
}
