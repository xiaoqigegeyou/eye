package cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobstepInfoMapper;
import cn.pojo.StepPO;

@Component
@Transactional
public class JobstepInfoService {

	@Autowired
	private JobstepInfoMapper jobstepInfoMapper;

	/**
	 * 
	 * @Title: selectjobStepidByjobStepName <p>通过中文名(解压缩,云判...)查询ID</p> @param
	 * jobStepName @return JobstepInfo @throws
	 */
	public StepPO getByjobStepName(String jobStepName) {

		return jobstepInfoMapper.getByjobStepName(jobStepName);

	}

	/**
	 * 
	 * <p>通过后缀名(Un_tar,RPCCAL,.....)查询ID</p> @param jobStepName @return
	 * JobstepInfo @throws
	 */
	public StepPO getBySuffixName(String suffixName) {

		return jobstepInfoMapper.getBySuffixName(suffixName);

	}
}
