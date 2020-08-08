package cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.MapInfoMapper;
import cn.pojo.ApplicationPO;
import cn.pojo.MapPO;
import cn.until.ListSplit;

@Component
@Transactional
public class MapInfoService {
	@Autowired
	private MapInfoMapper mapInfoMapper;
	
	public void insertMap(List<MapPO> mapList) {
		
		if(mapList != null && mapList.size()>0) {
			
			List<List<MapPO>> splitListBycapacity = ListSplit.splitListBycapacity(mapList, 2000);
			for(List<MapPO> splitList : splitListBycapacity) {
				 mapInfoMapper.insert_map(splitList);
			}
		}
		
	}
	//数据转移
	public void transfer() {
		mapInfoMapper.transferMap();
		mapInfoMapper.clearAllMap();
		
	}
}
