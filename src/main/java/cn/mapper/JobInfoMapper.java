package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.job;


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
	
	int insertToToday(job jobinfo);
	int insertListToToday(@Param("jobinfos")List<job> jobinfos);
	
//	int insertToHistory(job jobinfo);
//	int insertListToHistory(@Param("jobinfos")List<job> jobinfos);
	
	int insertToRuning(job jobinfo);
	int insertListToRuning(@Param("jobinfos")List<job> jobinfos);
	
	int clearAllRuning();

}