package cn.pojo;

public class DataSourcePO {
	
	private int  id;
	private String database_url;//数据库url
	private String database_user_name;//数据库用户名
	private String database_password;//数据库密码
	private String database_driver;//数据库驱动
	private String statellite_name;//卫星名
	private String pk;//自增Id记录
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatabase_url() {
		return database_url;
	}
	public void setDatabase_url(String database_url) {
		this.database_url = database_url;
	}
	public String getDatabase_user_name() {
		return database_user_name;
	}
	public void setDatabase_user_name(String database_user_name) {
		this.database_user_name = database_user_name;
	}
	public String getDatabase_password() {
		return database_password;
	}
	public void setDatabase_password(String database_password) {
		this.database_password = database_password;
	}
	public String getDatabase_driver() {
		return database_driver;
	}
	public void setDatabase_driver(String database_driver) {
		this.database_driver = database_driver;
	}
	public String getStatellite_name() {
		return statellite_name;
	}
	public void setStatellite_name(String statellite_name) {
		this.statellite_name = statellite_name;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	@Override
	public String toString() {
		return "DataSourcePO [id=" + id + ", database_url=" + database_url + ", database_user_name="
				+ database_user_name + ", database_password=" + database_password + ", database_driver="
				+ database_driver + ", statellite_name=" + statellite_name + ", pk=" + pk + "]";
	}
	
	
}
