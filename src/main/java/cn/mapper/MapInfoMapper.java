package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.MapPO;

public interface MapInfoMapper {

	void insert_map(@Param("mapinfos") List<MapPO> mapList);

	// 转移map数据
	void transferMap();

	// 清除map_info的数据
	void clearAllMap();
}
