package cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobInfoMapper;
import cn.pojo.job;
import cn.until.ListSplit;




/**
 * <p> 对于Job信息的数据库操作</p>
 * @author 崔安兵 2019年9月27日
 *
 */
@Component
@Transactional
public class JobInfoService {
	
	@Autowired
	private  JobInfoMapper jobInfoMapper;
	
	/**
	 * 
	 * @Title: insert_job_info_runing   
	 *  <p>正在运行的application信息 </p>
	 * @param jobinfo
	 * @return  int        
	 * @throws
	 */
	public int insert_job_info_runing(job jobinfo ) {
		int insertToRuning = jobInfoMapper.insertToRuning(jobinfo);
		return insertToRuning;
	}
	/**
	 * 
	 * @Title: insert_job_info_runing   
	 *  <p>正在运行的application信息 </p>
	 * @param list
	 * @return  int        
	 * @throws
	 */
	public int insert_job_info_runing(List<job> list) {
		int insertList = -1;
		if(list != null && list.size()>0) {
			jobInfoMapper.clearAllRuning();//清空
			List<List<job>> splitListBycapacity = ListSplit.splitListBycapacity(list, 2000);
			for(List<job> splitList : splitListBycapacity) {
				insertList += jobInfoMapper.insertListToRuning(splitList);
			}
		}
		return insertList;
	}
	
	
	/**
	 * 
	 * @Title: insert_job_info_today   
	 *  <p>今天的application信息   </p>
	 * @param jobInfo
	 * @return  int        
	 * @throws
	 */
	public int insert_job_info_today(job jobInfo ) {
		int insertToToday = jobInfoMapper.insertToToday(jobInfo);
		return insertToToday;
	}
	/**
	 * 
	 * @Title: insert_job_info_today   
	 *  <p>今天的application信息   </p>
	 * @param list
	 * @return  int        
	 * @throws
	 */
	public int insert_job_info_today(List<job> list) {
		int insertList = -1;
		if(list != null && list.size()>0) {
			List<List<job>> splitListBycapacity = ListSplit.splitListBycapacity(list, 2000);
			for(List<job> splitList : splitListBycapacity) {
				insertList += jobInfoMapper.insertListToToday(splitList);
			}
		}
		
		return insertList;
	}
	/**
	 * 
	 * @Title: insert_job_info_history   
	 *  <p>application的历史信息   </p>
	 * @param jobinfo
	 * @return  int        
	 * @throws
	 */
//	public int insert_job_info_history(job jobinfo) {
//		int insertToHistory = jobInfoMapper.insertToHistory(jobinfo);
//		return insertToHistory;
//	}
	
	/**
	 * 
	 * @Title: insert_job_info_history   
	 *  <p>application的历史信息</p>
	 * @param list
	 * @return  int        
	 * @throws
	 */
//	public int insert_job_info_history(List<job> list) {
//		int insertList = -1;
//		if(list != null && list.size()>0) {
//			List<List<job>> splitListBycapacity = ListSplit.splitListBycapacity(list, 2000);
//			for(List<job> splitList : splitListBycapacity) {
//				insertList += jobInfoMapper.insertListToHistory(splitList);
//			}
//		}
//		return insertList;
//	}
	
	/**
	 * 
	 * @Title: selecttest   
	 *  <p>测试方法   </p>
	 * @return  List<JobInfo>        
	 * @throws
	 */
	public  List<job> selecttest(){
		return null;
	}
	
	/**
	 * 
	 * @Title: selectOfLast   
	 *  <p>查询最晚插入的application信息的时间   </p>
	 * @return  long        
	 * @throws
	 */
//	public long selectOfLast() {
//		long result = -1L;
//		Long selectOfHistoryLastTime = jobInfoMapper.selectOfHistoryLastTime();
//		Long selectOfTodayLastTime = jobInfoMapper.selectOfTodayLastTime();
//		if(selectOfTodayLastTime == null) {
//			if(selectOfHistoryLastTime != null) {
//				result = selectOfHistoryLastTime;
//			}else {
//			}
//		}else {
//			if(selectOfHistoryLastTime == null) {
//				result = selectOfTodayLastTime;
//			}else {
//				if(selectOfHistoryLastTime.longValue() > selectOfTodayLastTime.longValue()) {
//					result = selectOfHistoryLastTime;
//				}else {
//					result = selectOfTodayLastTime;
//				}
//			}
//		}
//		return result;
//	}
}
