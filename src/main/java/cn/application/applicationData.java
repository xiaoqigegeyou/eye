package cn.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cn.pojo.ApplicationPO;
import cn.pojo.PpMasterPO;
import cn.service.JobInfoService;
import cn.service.JobstepInfoService;
import cn.until.DateFormat;

@Component
public class ApplicationData {
	@Autowired
	private ApplicationPO app;
	@Autowired
	private JobstepInfoService jobstepInfoService;
	@Autowired
	private JobInfoService jobInfoService;

	public Map<String, List<ApplicationPO>> applicationAnalysis(JsonArray array) {
		Map<String, List<ApplicationPO>> job = new HashMap<String, List<ApplicationPO>>();
		List<ApplicationPO> runingJob = new ArrayList<ApplicationPO>();
		List<ApplicationPO> finishedJob = new ArrayList<ApplicationPO>();

		long lastTime = 0;// 最后一个任务完成的时间戳
		long tmpTime;// 现在任务时间
		int j = array.size();// JSON数组大小
		lastTime = jobInfoService.selectOfLast();// 获得最后一个数据的时间
		for (int i = 0; i < j; i++) {
			JsonObject subObject = array.get(i).getAsJsonObject();
			// 获得名称 CresdaAI_AIInfoDA_GF1_5314231_2018-07-22_GF1_4323_3341763
			String jobAllName = subObject.get("name").getAsString();

			String state = subObject.get("state").getAsString();
			
			if (state.equals("ACCEPTED")) {// 正在队列内的任务，还没有运行
				continue;
			} else if (state.equals("RUNNING")) {// 正在运行的任务
				
				String[] nameArray = jobAllName.split("_");
				// GF2_4439_3333865
				if (nameArray.length !=8) {
					continue;
				}
				/** 通用部分代码 **/
				app = jsonToJob(subObject);
				// 非解压任务（现在是对所有任务经行处理，不管是否解压）
				job_NoUnTar(nameArray, app);
				//添加圈号景号
				PpMasterPO po = get_orbit_scene(app.getSatellite_name(), app.getProduct_id());
				
				if (po != null) {
					app.setOrbit_no(po.getOrbit_no());
					app.setScene_no(po.getScene_no());
				}
				runingJob.add(app);
			} else {// 已经完成的(成功和失败的)
				tmpTime = Long.parseLong(subObject.get("finishedTime").getAsString());
				if (tmpTime <= lastTime) {//筛选符合条件的数据
					continue;
				}
				else {
					String[] nameArray = jobAllName.split("_");
					if (nameArray.length !=8) {
						// System.out.println("任务命名不对");
						continue;
					}
					/** 通用部分代码 **/
					app = jsonToJob(subObject);
					/** 非解压任务用用 */
					job_NoUnTar(nameArray, app);

				}
				// 添加景号与圈号
				PpMasterPO po = get_orbit_scene(app.getSatellite_name(), app.getProduct_id());
				if (po != null) {
					app.setOrbit_no(po.getOrbit_no());
					app.setScene_no(po.getScene_no());
				}
				finishedJob.add(app);
			}
		}
		job.put("runing", runingJob);
		job.put("finished", finishedJob);
		return job;
	}

	// 无需处理的数据
	private ApplicationPO jsonToJob(JsonObject json) {
		ApplicationPO app = new ApplicationPO();

		String applicationsid = json.get("id").getAsString();
		String id = applicationsid.substring(12);
		app.setJob_id(id);// 得到Application的id
		app.setState(json.get("state").getAsString());
		app.setJob_user(json.get("user").getAsString());// 提交用户
		app.setFinal_status(json.get("finalStatus").getAsString());// 任务状态
		app.setStarted_time(DateFormat.toDate(json.get("startedTime").getAsString()));
		app.setFinished_time(DateFormat.toDate(json.get("finishedTime").getAsString()));// 得到任务完成的时间
		app.setElapsed_time(Float.valueOf(json.get("elapsedTime").getAsString()));// 任务完成时间
		app.setTracking_url(json.get("trackingUrl").getAsString());
		app.setTimestamp(json.get("finishedTime").getAsString());// 完成时间的时间戳

		return app;
	}

	// 未解压
	private void job_NoUnTar(String[] nameArray, ApplicationPO app) {
		int setStepID = 0;
		// String jobName = nameArray[5] + "_" + nameArray[6] + "_" + nameArray[7];

		app.setSatellite_name(nameArray[2]);// 得到卫星名称
		app.setProvince_id(nameArray[6]);// 得到省编号
		setStepID = jobstepInfoService.getBySuffixName((nameArray[1])).getId();// 查询数据库的到处理步骤相对相应的id
		app.setStep_id(setStepID);// 处理步骤编号
		app.setProduct_id(nameArray[7]);// 产品号
		app.setScene_no(nameArray[3]);// 景号
		// app.setResultpath("/images/img.jpg");// 默认预览图像

	}

	// 获取圈号与景号
	public PpMasterPO get_orbit_scene(String satellite_name, String product_id) {

		return jobInfoService.get_orbit_scene(satellite_name, product_id);

	}

}
