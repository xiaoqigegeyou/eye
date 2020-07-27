package cn.mapper;

import cn.pojo.JobstepInfo;

/**
 * 
 * <p>application对应的执行步骤信息</p>
 * @author 崔安兵
 * 2019年9月30日
 *
 */
public interface JobstepInfoMapper {


	public	JobstepInfo getBySuffixName(String suffixName);

	public  JobstepInfo getByjobStepName(String stepName);
}