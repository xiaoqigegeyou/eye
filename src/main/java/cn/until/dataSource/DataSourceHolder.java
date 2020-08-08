package cn.until.dataSource;
/**
*设置数据库类型，指定使用哪个数据库
*@author root
*/
public class DataSourceHolder {
	  
	   // 线程本地环境
	      private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
	 
	     // 设置数据源
	      public static void setDataSource(String customerType) {
	         dataSources.set(customerType);
	     }
	 
	     // 获取数据源
	     public static String getDataSource() {
	         return (String) dataSources.get();
	     }
	 
	     // 清除数据源
	     public static void clearDataSource() {
	         dataSources.remove();
	     }
    
}
