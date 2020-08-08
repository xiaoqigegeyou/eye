package cn.pp;

import cn.pojo.PpMasterPO;
import cn.pojo.PpPO;
import cn.service.PpMasterService;
import cn.service.PpService;
import cn.until.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PpData {
	@Autowired
	private PpMasterService ppMasterService;
	@Autowired
	private PpService ppService;
	
	public void  ppAnalysis() {
		Date lastDate = ppMasterService.getLastFinishTime();
		Date lastRunningDate=ppMasterService.getLastRunningStartTime();
		if(lastDate==null) lastDate= DateFormat.toDate("1594024350000");//2020-07-06 16:32:30
		if(lastRunningDate==null) lastRunningDate= DateFormat.toDate("1594024350000");//2020-07-06 16:32:30
		//System.out.println(lastDate);
		List<PpMasterPO> master = new ArrayList<PpMasterPO>();
		List<PpMasterPO> masterRunning = new ArrayList<PpMasterPO>();
		
		List<PpPO> ppLists = ppService.getPp(lastDate);
		List<PpPO> ppRunningLists = ppService.getRunningPp(lastRunningDate);
		
		for (PpPO ppPO : ppLists) {
			//System.out.println(ppPO.toString());
			PpMasterPO pm = new PpMasterPO();
			pm.setSatellite_name(ppPO.getSATELLITEID());
			pm.setOrbit_no(ppPO.getORBITID());
			pm.setScene_no(ppPO.getSCENEID());
			pm.setProduct_id(ppPO.getPRODUCTID());
			pm.setStarted_time(ppPO.getBEGINTIME());
			pm.setFinished_time(ppPO.getFINISHTIME());
			//姿轨精化 3  推送 4    标准产品生产1   精化匹配 2
			if(ppPO.getACTIVITYDEFNAME().equals("标准产品生产")) {
				pm.setStep_id(1);
			}else if(ppPO.getACTIVITYDEFNAME().equals("精化匹配")) {
				pm.setStep_id(2);
			}else if(ppPO.getACTIVITYDEFNAME().equals("姿轨精化")) {
				pm.setStep_id(3);
			}else if(ppPO.getACTIVITYDEFNAME().equals("推送")) {
				pm.setStep_id(4);
			}
			
			if(ppPO.getSTATUS()==2) {//运行
				pm.setState("RUNNING");
			}else if(ppPO.getSTATUS()==7) {//完成
				pm.setState("SUCCEEDED");
			}else if(ppPO.getSTATUS()==8) {//出错
				pm.setState("FAILED");
			}else pm.setState("未知状态");
			pm.setPp(1);
			master.add(pm);
		
		}
		for (PpPO ppPO : ppRunningLists) {
			//System.out.println(ppPO.toString());
			PpMasterPO pm = new PpMasterPO();
			pm.setSatellite_name(ppPO.getSATELLITEID());
			pm.setOrbit_no(ppPO.getORBITID());
			pm.setScene_no(ppPO.getSCENEID());
			pm.setProduct_id(ppPO.getPRODUCTID());
			pm.setStarted_time(ppPO.getBEGINTIME());
			pm.setFinished_time(ppPO.getFINISHTIME());
			//姿轨精化3  推送 4    标准产品生产1   精化匹配 2
			if(ppPO.getACTIVITYDEFNAME().equals("标准产品生产")) {
				pm.setStep_id(1);
			}else if(ppPO.getACTIVITYDEFNAME().equals("精化匹配")) {
				pm.setStep_id(2);
			}else if(ppPO.getACTIVITYDEFNAME().equals("姿轨精化")) {
				pm.setStep_id(3);
			}else if(ppPO.getACTIVITYDEFNAME().equals("推送")) {
				pm.setStep_id(4);
			}
			
			if(ppPO.getSTATUS()==2) {//运行
				pm.setState("RUNNING");
			}else if(ppPO.getSTATUS()==7) {//完成
				pm.setState("SUCCEEDED");
			}else if(ppPO.getSTATUS()==8) {//出错
				pm.setState("FAILED");
			}else pm.setState("未知状态");
			pm.setPp(1);
			masterRunning.add(pm);
		
		}
		ppMasterService.insertListToPp(master);
		ppMasterService.insertPpToApplication(master);
		
		ppMasterService.insertListToRunningPp(masterRunning);
		
		System.out.println("pp插入成功");
		
	}
	
}
