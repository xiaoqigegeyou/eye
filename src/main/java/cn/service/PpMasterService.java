package cn.service;

import cn.mapper.PpMasterMapper;
import cn.pojo.MapPO;
import cn.pojo.PpMasterPO;
import cn.until.ListSplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Component
@Transactional
public class PpMasterService {
	@Autowired
	private PpMasterMapper ppMasterMapper;
	
	//获得pp数据getLastStartTime
		public Date getLastFinishTime() {
			return ppMasterMapper.getLastFinishTime();
		}
		//获取running表的pp最后开始时间
			public	Date  getLastRunningStartTime() {
				return ppMasterMapper.getLastRunningStartTime();
			}
	//插入pp数据
		public void insertListToPp( List<PpMasterPO> ppLists) {
			if(ppLists != null && ppLists.size()>0) {
				
				List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
				for(List<PpMasterPO> splitList : splitListBycapacity) {
					ppMasterMapper.insertListToPp(ppLists);
				}
			}
			
		}

		//插入Running pp数据
		public void insertListToRunningPp( List<PpMasterPO> ppLists) {
if(ppLists != null && ppLists.size()>0) {
				
				List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
				for(List<PpMasterPO> splitList : splitListBycapacity) {
					ppMasterMapper.insertRunningPp(ppLists);
				}
			}
			
		}
		//把pp插入app
		public void insertPpToApplication( List<PpMasterPO> ppLists) {
				if(ppLists != null && ppLists.size()>0) {
				
				List<List<PpMasterPO>> splitListBycapacity = ListSplit.splitListBycapacity(ppLists, 2000);
				for(List<PpMasterPO> splitList : splitListBycapacity) {
					ppMasterMapper.insertPpToApp(ppLists);
				}
			}
			
		}
}
