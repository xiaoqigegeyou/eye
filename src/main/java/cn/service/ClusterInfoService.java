package cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.ClusterInfoMapper;
import cn.pojo.ClusterPO;

@Component
@Transactional
public class ClusterInfoService {
	@Autowired
	private ClusterInfoMapper clusterInfoMapper;
	
	public void insertCluster(ClusterPO cluster) {
		clusterInfoMapper.insertCluster(cluster);
	}
}
