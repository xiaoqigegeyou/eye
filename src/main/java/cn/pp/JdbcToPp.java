package cn.pp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cn.pojo.PpPO;
import cn.until.DateFormat;
import cn.until.JDBCUtil;
@Component
public class JdbcToPp {
	public static void main(String[] args) {
//		for (int i = 0; i < 1; i++) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		applicationContext.getBean(PpData.class).ppAnalysis();
//		List<DataSourcePO> pp = applicationContext.getBean(PpMasterService.class).getDataSource();
//		String driver=pp.get(i).getDatabase_driver();
//		String url =pp.get(i).getDatabase_url();
//		String user =pp.get(i).getDatabase_user_name();
//		String pwd =pp.get(i).getDatabase_password();
//		System.out.println(pp.get(i).toString());
//		selectPp(driver, url, user, pwd, DateFormat.toStringDate("1594024350000"), "1");
//		//System.out.println(DateFormat.dateToString(DateFormat.toDate("1594024350000")));
//			
//		}

	}
	public  List<PpPO> selectPp(String driver, String url, String user, String pwd ,String time,String satellite) {
		
		Connection con = JDBCUtil.getConnection(driver, url,user, pwd);
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		List<PpPO> ppLists = new ArrayList<PpPO>();
		try {
			String sql = "SELECT\r\n" + 
					"		a.SATELLITEID,\r\n" + 
					"		a.ORBITID,\r\n" + 
					"		a.SCENEID,\r\n" + 
					"		a.PRODUCTID,\r\n" + 
					"		b.ACTIVITYDEFNAME,\r\n" + 
					"		b.BEGINTIME,\r\n" + 
					"		b.FINISHTIME,\r\n" + 
					"		b.`STATUS`\r\n" + 
					"		FROM\r\n" + 
					"		pp_t_scenetask a JOIN pp_t_sceneactivity b\r\n" + 
					"		ON a.COMMTASKID = b.TASKID\r\n" + 
					"		AND a.L1WFID = b.PROCESSINSTID\r\n" + 
					"		AND a.SATELLITEID='"+satellite+"'\r\n"+
					"		AND b.FINISHTIME >' "+time+"'";
			//System.out.println(sql);
		
			pstmt = con.prepareStatement(sql);
			resultSet = (ResultSet) pstmt.executeQuery();
	
		while (resultSet.next()) {
			
			
			PpPO pp =new PpPO();
			pp.setSATELLITEID(resultSet.getString("SATELLITEID"));
			pp.setORBITID(resultSet.getString("ORBITID"));
			pp.setSCENEID(resultSet.getString("SCENEID"));
			pp.setPRODUCTID(resultSet.getString("PRODUCTID"));
			pp.setACTIVITYDEFNAME(resultSet.getString("ACTIVITYDEFNAME"));
			pp.setBEGINTIME(DateFormat.dateToDate(resultSet.getTimestamp("BEGINTIME")));
			pp.setFINISHTIME(DateFormat.dateToDate(resultSet.getTimestamp("FINISHTIME")));
			pp.setSTATUS(resultSet.getInt("STATUS"));
			//System.out.println(pp.toString()+resultSet.getTimestamp("BEGINTIME"));
			ppLists.add(pp);

		
		}
		} catch (Exception e) {
			 e.printStackTrace();
        }finally{
        	JDBCUtil.Close(con,pstmt,resultSet);
        }
		
		return ppLists;
		
	}
	public static List<PpPO> selectRunningPp(String driver, String url, String user, String pwd ,String satellite) {
		
		Connection con = JDBCUtil.getConnection(driver, url,user, pwd);
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		List<PpPO> ppLists = new ArrayList<PpPO>();
		try {
			con.setAutoCommit(false);

			String sql = "SELECT DISTINCT\r\n" + 
					"		a.SATELLITEID,\r\n" + 
					"		a.ORBITID,\r\n" + 
					"		a.SCENEID,\r\n" + 
					"		a.PRODUCTID,\r\n" + 
					"		b.ACTIVITYDEFNAME,\r\n" + 
					"		b.BEGINTIME,\r\n" + 
					"		b.FINISHTIME,\r\n" + 
					"		b.`STATUS`\r\n" + 
					"		FROM\r\n" + 
					"		pp_t_scenetask a JOIN pp_t_sceneactivity b\r\n" + 
					"		ON a.COMMTASKID = b.TASKID\r\n" + 
					"		AND a.L1WFID = b.PROCESSINSTID\r\n" + 
					"		AND b.STATUS=2\r\n" + 
					"		AND a.SATELLITEID='"+satellite+"'\r\n"
				+"		and b.FINISHTIME is null";
			//System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			resultSet = (ResultSet) pstmt.executeQuery();
	
		while (resultSet.next()) {
			
			
			PpPO pp =new PpPO();
			pp.setSATELLITEID(resultSet.getString("SATELLITEID"));
			pp.setORBITID(resultSet.getString("ORBITID"));
			pp.setSCENEID(resultSet.getString("SCENEID"));
			pp.setPRODUCTID(resultSet.getString("PRODUCTID"));
			pp.setACTIVITYDEFNAME(resultSet.getString("ACTIVITYDEFNAME"));
			pp.setBEGINTIME(DateFormat.dateToDate(resultSet.getTimestamp("BEGINTIME")));
//			if(resultSet.getTimestamp("FINISHTIME")!=null) {
//			pp.setFINISHTIME(DateFormat.dateToDate(resultSet.getTimestamp("FINISHTIME")));
//			}
			pp.setSTATUS(resultSet.getInt("STATUS"));
			//System.out.println(pp.toString()+resultSet.getTimestamp("BEGINTIME"));
			ppLists.add(pp);

		
		}
		con.commit();
		} catch (Exception e) {
			 e.printStackTrace();
        }finally{
        	
        	JDBCUtil.Close(con,pstmt,resultSet);
        }
		
		return ppLists;
		
	}
}
