package cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobInfoMapper;
import cn.pojo.ApplicationPO;
import cn.pojo.PpMasterPO;
import cn.until.ListSplit;

/**
 * <p>
 * 对于Job信息的数据库操作
 * </p>
 * 
 * @author 崔安兵 2019年9月27日
 *
 */
@Component
@Transactional
public class JobInfoService {

	@Autowired
	private JobInfoMapper jobInfoMapper;

	/**
	 * 
	 * @Title: insert_job_info_runing <p>正在运行的application信息 </p> @param
	 * jobinfo @return int @throws
	 */
	public int insert_job_info_runing(ApplicationPO jobinfo) {
		int insertToRuning = jobInfoMapper.insertToRuning(jobinfo);
		return insertToRuning;
	}

	/**
	 * 
	 * @Title: insert_job_info_runing <p>正在运行的application信息 </p> @param list @return
	 * int @throws
	 */
	public int insert_job_info_runing(List<ApplicationPO> list) {
		int insertList = -1;
		if (list != null && list.size() > 0) {
			//jobInfoMapper.clearAllRuning();// 清空
			List<List<ApplicationPO>> splitListBycapacity = ListSplit.splitListBycapacity(list, 2000);
			for (List<ApplicationPO> splitList : splitListBycapacity) {
				insertList += jobInfoMapper.insertListToRuning(splitList);
			}
		}
		return insertList;
	}

	/**
	 * 
	 * @Title: insert_job_info_today <p>今天的application信息 </p> @param jobInfo @return
	 * int @throws
	 */
	public int insert_job_info_today(ApplicationPO jobInfo) {
		int insertToToday = jobInfoMapper.insertToToday(jobInfo);
		return insertToToday;
	}

	/**
	 * 
	 * @Title: insert_job_info_today <p>今天的application信息 </p> @param list @return
	 * int @throws
	 */
	public int insert_job_info_today(List<ApplicationPO> list) {
		int insertList = -1;
		if (list != null && list.size() > 0) {
			List<List<ApplicationPO>> splitListBycapacity = ListSplit.splitListBycapacity(list, 2000);
			for (List<ApplicationPO> splitList : splitListBycapacity) {
				insertList += jobInfoMapper.insertListToToday(splitList);
			}
		}

		return insertList;
	}

	/**
	 * 
	 * @Title: selectOfLast <p>查询最晚插入的application信息的时间 </p> @return long @throws
	 */
	public long selectOfLast() {
		long result = -1L;
		Long selectOfHistoryLastTime = jobInfoMapper.selectOfHistoryLastTime();
		Long selectOfTodayLastTime = jobInfoMapper.selectOfTodayLastTime();
		if (selectOfTodayLastTime == null) {
			if (selectOfHistoryLastTime != null) {
				result = selectOfHistoryLastTime;
			}
		} else {
			if (selectOfHistoryLastTime == null) {
				result = selectOfTodayLastTime;
			} else {
				if (selectOfHistoryLastTime.longValue() > selectOfTodayLastTime.longValue()) {
					result = selectOfHistoryLastTime;
				} else {
					result = selectOfTodayLastTime;
				}
			}
		}
		return result;
	}

	// 数据转移
	public void transfer() {
		jobInfoMapper.transferApplication();
		jobInfoMapper.clearAllApplication();

	}

	// 获取圈号跟景号
	public PpMasterPO get_orbit_scene(String satellite_name, String product_id) {

		return jobInfoMapper.get_orbit_scene(satellite_name, product_id);

	}
	//删除running表；
	public void clearPpRuning() {
		jobInfoMapper.clearPpRuning();
	}
	public void clearAppRunning() {
		jobInfoMapper.clearAppRunning();
	}

}
