package cn.until.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 自定义动态数据源，继承AbstractRoutingDataSource抽象类， 重写determineCurrentLookupKey方法
 * 
 * @author root
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {

		return DataSourceHolder.getDataSource();
	}

}
