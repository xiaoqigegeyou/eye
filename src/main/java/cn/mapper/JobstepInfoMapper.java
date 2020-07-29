package cn.mapper;

import cn.pojo.jobstepInfo;

/**
 * 
 * <p>application对应的执行步骤信息</p>
 * @author 崔安兵
 * 2019年9月30日
 *
 */
public interface JobstepInfoMapper {


	public	jobstepInfo getBySuffixName(String suffixName);

	public  jobstepInfo getByjobStepName(String stepName);
}