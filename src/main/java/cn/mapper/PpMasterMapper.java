package cn.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import cn.pojo.PpMasterPO;


public interface PpMasterMapper {
	//获得pp表的最后结束时间
		Date  getLastFinishTime();
	//获取running表的pp最后开始时间
		Date  getLastRunningStartTime();
	//插入pp数据
		void insertListToPp(@Param("ppLists")List<PpMasterPO> ppLists);
	//插入Running pp数据
		void insertRunningPp(@Param("ppRunningLists")List<PpMasterPO> ppRunningLists);
	//吧pp插入app
		void insertPpToApp(@Param("ppToAppLists")List<PpMasterPO> ppToAppLists);
}
