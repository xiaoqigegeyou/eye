package cn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobInfoMapper;
import cn.mapper.PpDataMapper;
import cn.pojo.PpPO;
import cn.until.dataSource.TargetDataSource;

@Component
@TargetDataSource(name = TargetDataSource.BRANCH1)
@Transactional
public class PpService {
	@Autowired
	private PpDataMapper ppDataMapper;

	public List<PpPO> getPp(Date lastDate) {

		return ppDataMapper.selectPp(lastDate);

	}

	// 获得运行中的pp
	public List<PpPO> getRunningPp(Date lastRunningDate) {

		return ppDataMapper.selectRunningPp(lastRunningDate);

	};

	// 获得当前访问的数据库对应卫星名
	// String selectPpStatellited();
	public String selectPpStatellited() {
		return ppDataMapper.selectPpStatellited();
	}

	public String selectName() {
		return ppDataMapper.selectName();

	}
}
