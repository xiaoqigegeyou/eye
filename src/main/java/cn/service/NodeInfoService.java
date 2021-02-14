package cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.NodeInfoMapper;
import cn.pojo.NodePO;

@Component
@Transactional
public class NodeInfoService {
	@Autowired
	private NodeInfoMapper nodeInfoMapper;

	public int insert_node(List<NodePO> lnode) {
		int insertList = -1;
		if (lnode != null && lnode.size() > 0) {
			nodeInfoMapper.insertNode(lnode);
		}
		return insertList;

	}
}
