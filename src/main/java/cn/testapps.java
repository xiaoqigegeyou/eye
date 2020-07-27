package cn;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonArray;

import cn.application.Getappliction;
import cn.application.applicationData;
import cn.cluster.Getcluster;
import cn.pojo.job;
import cn.service.JobInfoService;



public class testapps {
	
	
public static void main(String[] args) {
		
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
	//	JsonArray array=applicationContext.getBean(Getcluster.class).getClusterDataSourceByFile("单个cluster.txt");
		//applicationContext.getBean(test.class).get11();
		JsonArray array=applicationContext.getBean(Getappliction.class).getjobApplicationDataSourceByFile("apps.txt");
		
		
		
		Map<String, List<job>> jobAnalysisResult = applicationContext.getBean(applicationData.class).jobAnalysis(array);//得到job分析结果
		List<job> runingJobList = jobAnalysisResult.get("runing");//正在运行的任务列表
		List<job> finishedJobList = jobAnalysisResult.get("finished");//已经完成的任务列表
		  // job a=finishedJobList.get(0);
		  // System.out.println(a.toString());
//		   applicationContext.getBean(JobInfoService.class).insert_job_info_runing(runingJobList);
		  // applicationContext.getBean(JobInfoService.class).insert_job_info_today(finishedJobList);
		//System.out.println(runingJobList.get(0).toString());
	}
}
