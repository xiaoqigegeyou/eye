package cn.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.ApplicationPO;
import cn.pojo.PpPO;

public interface PpDataMapper {

	List<PpPO> selectPp(@Param("lastFinishTime") Date lastFinishTime);

	// 获得运行中的pp
	List<PpPO> selectRunningPp(@Param("lastRunningStartTime") Date lastRunningStartTime);

	// 获得当前访问的数据库对应卫星名
	String selectPpStatellited();

	// 测试
	String selectName();
}
