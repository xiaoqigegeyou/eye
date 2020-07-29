package cn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mapper.JobstepInfoMapper;
import cn.pojo.jobstepInfo;




@Component
@Transactional
public class JobstepInfoService {
	
	@Autowired
	private JobstepInfoMapper jobstepInfoMapper;
	/**
	 * 
	 * @Title: selectjobStepidByjobStepName   
	 *  <p>通过中文名(解压缩,云判...)查询ID</p>
	 * @param jobStepName
	 * @return  JobstepInfo        
	 * @throws
	 */
	public jobstepInfo getByjobStepName(String jobStepName) {
		jobstepInfo byjobStepName = jobstepInfoMapper.getByjobStepName(jobStepName);
		return byjobStepName;
	}
	
	
	/**
	 * 
	 *  <p>通过后缀名(Un_tar,RPCCAL,.....)查询ID</p>
	 * @param jobStepName
	 * @return  JobstepInfo        
	 * @throws
	 */
	public jobstepInfo getBySuffixName(String suffixName) {
		jobstepInfo bySuffixName = jobstepInfoMapper.getBySuffixName(suffixName);
		return bySuffixName;
	
	}
}
