package cn.mapper;

import cn.pojo.StepPO;

/**
 * 
 * <p>
 * application对应的执行步骤信息
 * </p>
 * 
 * @author 崔安兵 2019年9月30日
 *
 */
public interface JobstepInfoMapper {

	public StepPO getBySuffixName(String suffixName);

	public StepPO getByjobStepName(String stepName);
}