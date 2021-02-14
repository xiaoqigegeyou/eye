package cn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobInfoMapper;
import cn.mapper.PpMasterMapper;
import cn.pojo.DataSourcePO;
import cn.pojo.PpMasterPO;
import cn.until.ListSplit;

@Component
@Transactional
public class PpMasterService {
	@Autowired
	private PpMasterMapper ppMasterMapper;
	@Autowired
	private JobInfoMapper jobInfoMapper;
	//获得basic_conf_pp_satellite
	
	public List<DataSourcePO> getDataSource (){
		
		return ppMasterMapper.getDataSource();
	}
	// 获得pp数据getLastStartTime
	public Date getLastFinishTime(String satellite_name) {
		return ppMasterMapper.getLastFinishTime(satellite_name);
	}

	// 获取running表的pp最后开始时间
	public Date getLastRunningStartTime(String satellite_name) {
		return ppMasterMapper.getLastRunningStartTime(satellite_name);
	}

	// 插入pp数据
	public void insertListToPp(List<PpMasterPO> ppLists) {
		if (ppLists != null && ppLists.size() > 0) {
			
			List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
			for (List<PpMasterPO> splitList : splitListBycapacity) {
				ppMasterMapper.insertListToPp(splitList);
			}
		}

	}

	// 插入Running pp数据
	public void insertListToRunningPp(List<PpMasterPO> ppLists) {
		if (ppLists != null && ppLists.size() > 0) {
			jobInfoMapper.clearPpRuning();// 清空
			System.out.println("清");
			List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
			for (List<PpMasterPO> splitList : splitListBycapacity) {
				ppMasterMapper.insertRunningPp(splitList);
			}
		}

	}

	// 把pp插入app
	public void insertPpToApplication(List<PpMasterPO> ppLists) {
		if (ppLists != null && ppLists.size() > 0) {
			
			List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
			for (List<PpMasterPO> splitList : splitListBycapacity) {
				ppMasterMapper.insertPpToApp(splitList);
			}
		}

	}
}
