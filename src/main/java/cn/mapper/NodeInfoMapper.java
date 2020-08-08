package cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.NodePO;

public interface NodeInfoMapper {
	
		public int insertNode(@Param("nodes")List<NodePO> node);
}
