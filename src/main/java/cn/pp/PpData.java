package cn.pp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.pojo.DataSourcePO;
import cn.pojo.PpMasterPO;
import cn.pojo.PpPO;
import cn.service.PpMasterService;
import cn.service.PpService;
import cn.until.DateFormat;

@Component
public class PpData {
	@Autowired
	private PpMasterService ppMasterService;
	@Autowired
	private PpService ppService;
	@Autowired
	private JdbcToPp jdbcToPp;

	public void ppAnalysis() {
		List<DataSourcePO> dataSource = ppMasterService.getDataSource();
		
		String satellite = null;
//				ppService.selectPpStatellited();// 获得当前数据库对应的卫星名
//		Date lastDate = ppMasterService.getLastFinishTime(satellite);
//		Date lastRunningDate = ppMasterService.getLastRunningStartTime(satellite);
//		if (lastDate == null)
//			lastDate = DateFormat.toDate("1594024350000");// 2020-07-06 16:32:30
//		if (lastRunningDate == null)
//			lastRunningDate = DateFormat.toDate("1594024350000");// 2020-07-06 16:32:30
		// System.out.println(lastDate);
		List<PpMasterPO> master = new ArrayList<PpMasterPO>();
		List<PpMasterPO> masterRunning = new ArrayList<PpMasterPO>();
		
		List<PpPO> ppLists = new ArrayList<PpPO>();
		List<PpPO> ppRunningLists = new ArrayList<PpPO>();
		
		for (DataSourcePO dataSourcePO : dataSource) {
			List<PpPO> ppList=null;
			List<PpPO> ppRunningList=null;
			
			String driver=dataSourcePO.getDatabase_driver();
			String url =dataSourcePO.getDatabase_url();
			String user =dataSourcePO.getDatabase_user_name();
			String pwd =dataSourcePO.getDatabase_password();
			String lastDate =null;
			String lastRunningDate =null;
			
			satellite = dataSourcePO.getStatellite_name();
			
			
			Date last = ppMasterService.getLastFinishTime(satellite);
			Date lastRunning = ppMasterService.getLastRunningStartTime(satellite);
			
			if (last == null)
				last = DateFormat.toDate("1594024350000");// 2020-07-06 16:32:30
			if (lastRunning == null)
				lastRunning = DateFormat.toDate("1594024350000");// 2020-07-06 16:32:30
			
				 lastDate =DateFormat.dateToString(last);
				 lastRunningDate = DateFormat.dateToString(lastRunning);
			
			System.out.println(satellite+" "+ lastDate+" "+lastRunningDate);
			
			ppList =jdbcToPp.selectPp(driver, url, user, pwd, lastDate, satellite);
			ppRunningList = jdbcToPp.selectRunningPp(driver, url, user, pwd,  satellite);
			
			ppLists.addAll(ppList);
			ppRunningLists.addAll(ppRunningList);
			
		}
//		Set<PpPO> set = new HashSet<PpPO>(ppLists);
//		if(set.size() < ppLists.size()){
//		   System.out.println("yes");
//		}
//		List<PpPO> ppLists = ppService.getPp(lastDate);
//		List<PpPO> ppRunningLists = ppService.getRunningPp(lastRunningDate);
		int o=0;
		for (PpPO ppPO : ppLists) {
			// System.out.println(ppPO.toString());
			PpMasterPO pm = new PpMasterPO();
			pm.setSatellite_name(ppPO.getSATELLITEID());
			pm.setOrbit_no(ppPO.getORBITID());
			pm.setScene_no(ppPO.getSCENEID());
			pm.setProduct_id(ppPO.getPRODUCTID());
			pm.setStarted_time(ppPO.getBEGINTIME());
			pm.setFinished_time(ppPO.getFINISHTIME());
			// 姿轨精化 3 推送 4 标准产品生产1 精化匹配 2
			if (ppPO.getACTIVITYDEFNAME().equals("标准产品生产")) {
				pm.setStep_id(1);
			} else if (ppPO.getACTIVITYDEFNAME().equals("精化匹配")) {
				pm.setStep_id(2);
			} else if (ppPO.getACTIVITYDEFNAME().equals("姿轨精化")) {
				pm.setStep_id(3);
			} else if (ppPO.getACTIVITYDEFNAME().equals("推送")) {
				pm.setStep_id(4);
			}

			if (ppPO.getSTATUS() == 2) {// 运行
				pm.setState("RUNNING");
			} else if (ppPO.getSTATUS() == 7) {// 完成
				pm.setState("SUCCEEDED");
			} else if (ppPO.getSTATUS() == 8) {// 出错
				pm.setState("FAILED");
			} else
				pm.setState("未知状态");
			pm.setPp(1);
			o++;
			//System.out.println(pm.toString());
			master.add(pm);

		}
	
		//System.out.println("o:"+o);
		int k=0;
		for (PpPO ppPO : ppRunningLists) {
			// System.out.println(ppPO.toString());
			PpMasterPO pm = new PpMasterPO();
			pm.setSatellite_name(ppPO.getSATELLITEID());
			pm.setOrbit_no(ppPO.getORBITID());
			pm.setScene_no(ppPO.getSCENEID());
			pm.setProduct_id(ppPO.getPRODUCTID());
			pm.setStarted_time(ppPO.getBEGINTIME());
			pm.setFinished_time(ppPO.getFINISHTIME());
			//  标准产品生产1 精化匹配 2姿轨精化3 推送 4
			if (ppPO.getACTIVITYDEFNAME().equals("标准产品生产")) {
				pm.setStep_id(1);
			} else if (ppPO.getACTIVITYDEFNAME().equals("精化匹配")) {
				pm.setStep_id(2);
			} else if (ppPO.getACTIVITYDEFNAME().equals("姿轨精化")) {
				pm.setStep_id(3);
			} else if (ppPO.getACTIVITYDEFNAME().equals("推送")) {
				pm.setStep_id(4);
			}

			if (ppPO.getSTATUS() == 2) {// 运行
				pm.setState("RUNNING");
			} else if (ppPO.getSTATUS() == 7) {// 完成
				pm.setState("SUCCEEDED");
			} else if (ppPO.getSTATUS() == 8) {// 出错
				pm.setState("FAILED");
			} else
				pm.setState("未知状态");
			pm.setPp(1);
			k++;
			masterRunning.add(pm);

		}
//		System.out.println("k"+k);
//		int l=0;
//		for (PpMasterPO ppPO : master) {
//			l++;
		
//		}
//		System.out.println(l);
		ppMasterService.insertListToPp(master);
		ppMasterService.insertPpToApplication(master);

		ppMasterService.insertListToRunningPp(masterRunning);

		System.out.println("pp插入成功");

	}

}
