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

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		applicationContext.getBean(PpData.class).ppAnalysis();


	}

	public List<PpPO> selectPp(String driver, String url, String user, String pwd, String time, String satellite) {

		Connection con = JDBCUtil.getConnection(driver, url, user, pwd);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<PpPO> ppLists = new ArrayList<PpPO>();
		try {
			String sql = "SELECT a.SATELLITEID, a.ORBITID, a.SCENEID, a.PRODUCTID, "
					+ "b.ACTIVITYDEFNAME, b.BEGINTIME, b.FINISHTIME, b.`STATUS` FROM "
					+ "pp_t_scenetask a JOIN pp_t_sceneactivity b ON a.COMMTASKID = b.TASKID "
					+ "AND a.L1WFID = b.PROCESSINSTID AND a.SATELLITEID='" + satellite + "' "
					+ "AND b.FINISHTIME >' " + time + "'";
			// System.out.println(sql);

			pstmt = con.prepareStatement(sql);
			resultSet = (ResultSet) pstmt.executeQuery();

			while (resultSet.next()) {

				PpPO pp = new PpPO();
				pp.setSATELLITEID(resultSet.getString("SATELLITEID"));
				pp.setORBITID(resultSet.getString("ORBITID"));
				pp.setSCENEID(resultSet.getString("SCENEID"));
				pp.setPRODUCTID(resultSet.getString("PRODUCTID"));
				pp.setACTIVITYDEFNAME(resultSet.getString("ACTIVITYDEFNAME"));
				pp.setBEGINTIME(DateFormat.dateToDate(resultSet.getTimestamp("BEGINTIME")));
				pp.setFINISHTIME(DateFormat.dateToDate(resultSet.getTimestamp("FINISHTIME")));
				pp.setSTATUS(resultSet.getInt("STATUS"));
				// System.out.println(pp.toString()+resultSet.getTimestamp("BEGINTIME"));
				ppLists.add(pp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.Close(con, pstmt, resultSet);
		}

		return ppLists;

	}

	public static List<PpPO> selectRunningPp(String driver, String url, String user, String pwd, String satellite) {

		Connection con = JDBCUtil.getConnection(driver, url, user, pwd);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		List<PpPO> ppLists = new ArrayList<PpPO>();
		try {
			con.setAutoCommit(false);

			String sql = "SELECT DISTINCT a.SATELLITEID,a.ORBITID,a.SCENEID, "
					+ "	a.PRODUCTID, b.ACTIVITYDEFNAME, b.BEGINTIME, "
					+ "b.FINISHTIME, b.`STATUS` FROM "
					+ "pp_t_scenetask a JOIN pp_t_sceneactivity b ON a.COMMTASKID = b.TASKID "
					+ "	AND a.L1WFID = b.PROCESSINSTID AND b.STATUS=2 AND a.SATELLITEID='"+ satellite + "' " + "and b.FINISHTIME is null";
			// System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			resultSet = (ResultSet) pstmt.executeQuery();

			while (resultSet.next()) {

				PpPO pp = new PpPO();
				pp.setSATELLITEID(resultSet.getString("SATELLITEID"));
				pp.setORBITID(resultSet.getString("ORBITID"));
				pp.setSCENEID(resultSet.getString("SCENEID"));
				pp.setPRODUCTID(resultSet.getString("PRODUCTID"));
				pp.setACTIVITYDEFNAME(resultSet.getString("ACTIVITYDEFNAME"));
				pp.setBEGINTIME(DateFormat.dateToDate(resultSet.getTimestamp("BEGINTIME")));
				pp.setSTATUS(resultSet.getInt("STATUS"));
				// System.out.println(pp.toString()+resultSet.getTimestamp("BEGINTIME"));
				ppLists.add(pp);

			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JDBCUtil.Close(con, pstmt, resultSet);
		}

		return ppLists;

	}
}
