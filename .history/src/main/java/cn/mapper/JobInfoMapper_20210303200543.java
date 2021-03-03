package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.ApplicationPO;
import cn.pojo.PpMasterPO;

/**
 * 
 * <p>
 * Application的信息
 * </p>
 * 
 *
 */
public interface JobInfoMapper {

	Long selectOfHistoryLastTime();

	Long selectOfTodayLastTime();

	int insertToToday(ApplicationPO jobinfo);

	int insertListToToday(@Param("jobinfos") List<ApplicationPO> jobinfos);

//	int insertToHistory(job jobinfo);
//	int insertListToHistory(@Param("jobinfos")List<job> jobinfos);

	int insertToRuning(ApplicationPO jobinfo);

	int insertListToRuning(@Param("jobinfos") List<ApplicationPO> jobinfos);

	int clearPpRuning();
	
	int clearAppRunning();

	// 转移application数据
	void transferApplication();

	// 清除application_info的数据
	void clearAllApplication();

	// 查询圈号跟景号
	PpMasterPO get_orbit_scene(@Param("satellite_name") String satellite_name, @Param("product_id") String product_id);

}