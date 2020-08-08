package cn.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.ApplicationPO;
import cn.pojo.PpMasterPO;


;


/**
 * 
 * <p> Application的信息  </p>
 * @author 崔安兵
 * 2019年9月30日
 *
 */
public interface JobInfoMapper {

	Long selectOfHistoryLastTime();
	Long selectOfTodayLastTime();
	
	
	int insertToToday(ApplicationPO jobinfo);
	int insertListToToday(@Param("jobinfos")List<ApplicationPO> jobinfos);
	
//	int insertToHistory(job jobinfo);
//	int insertListToHistory(@Param("jobinfos")List<job> jobinfos);
	
	int insertToRuning(ApplicationPO jobinfo);
	int insertListToRuning(@Param("jobinfos")List<ApplicationPO> jobinfos);
	
	int clearAllRuning();
	//转移application数据
	void  transferApplication();
	//清除application_info的数据
	void  clearAllApplication();
	//查询圈号跟景号
	PpMasterPO get_orbit_scene(@Param("satellite_name")String satellite_name,@Param("product_id")String product_id);

}