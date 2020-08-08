package cn.pojo;

import java.util.Date;

public class MapPO {
	
	private int id;
	private String job_info_id;
	private String task_id;
	private String task_name;
	private String map_node;
	private Date start_time;
	private Date finished_time;
	private float elapsed_time;
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_info_id() {
		return job_info_id;
	}
	public void setJob_info_id(String job_info_id) {
		this.job_info_id = job_info_id;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getMap_node() {
		return map_node;
	}
	public void setMap_node(String map_node) {
		this.map_node = map_node;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getFinished_time() {
		return finished_time;
	}
	public void setFinished_time(Date finished_time) {
		this.finished_time = finished_time;
	}
	public float getElapsed_time() {
		return elapsed_time;
	}
	public void setElapsed_time(float elapsed_time) {
		this.elapsed_time = elapsed_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "MapPO [id=" + id + ", job_info_id=" + job_info_id + ", task_id=" + task_id + ", task_name=" + task_name
				+ ", map_node=" + map_node + ", start_time=" + start_time + ", finished_time=" + finished_time
				+ ", elapsed_time=" + elapsed_time + ", state=" + state + "]";
	}

    
}
