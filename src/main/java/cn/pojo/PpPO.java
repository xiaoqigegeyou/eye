package cn.pojo;

import java.util.Date;

public class PpPO {

	private String SATELLITEID;
	private String ORBITID;
	private String SCENEID;
	private String PRODUCTID;
	// private int province_id;
	private Date BEGINTIME;
	private Date FINISHTIME;
	// private Float elapsed_time;
	private String ACTIVITYDEFNAME;
	private int STATUS;

	// private byte pp;
	public String getSATELLITEID() {
		return SATELLITEID;
	}

	public void setSATELLITEID(String sATELLITEID) {
		SATELLITEID = sATELLITEID;
	}

	public String getORBITID() {
		return ORBITID;
	}

	public void setORBITID(String oRBITID) {
		ORBITID = oRBITID;
	}

	public String getSCENEID() {
		return SCENEID;
	}

	public void setSCENEID(String sCENEID) {
		SCENEID = sCENEID;
	}

	public String getPRODUCTID() {
		return PRODUCTID;
	}

	public void setPRODUCTID(String pRODUCTID) {
		PRODUCTID = pRODUCTID;
	}

	public Date getBEGINTIME() {
		return BEGINTIME;
	}

	public void setBEGINTIME(Date bEGINTIME) {
		BEGINTIME = bEGINTIME;
	}

	public Date getFINISHTIME() {
		return FINISHTIME;
	}

	public void setFINISHTIME(Date fINISHTIME) {
		FINISHTIME = fINISHTIME;
	}

	public String getACTIVITYDEFNAME() {
		return ACTIVITYDEFNAME;
	}

	public void setACTIVITYDEFNAME(String aCTIVITYDEFNAME) {
		ACTIVITYDEFNAME = aCTIVITYDEFNAME;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	@Override
	public String toString() {
		return "PpPO [SATELLITEID=" + SATELLITEID + ", ORBITID=" + ORBITID + ", SCENEID=" + SCENEID + ", PRODUCTID="
				+ PRODUCTID + ", BEGINTIME=" + BEGINTIME + ", FINISHTIME=" + FINISHTIME + ", ACTIVITYDEFNAME="
				+ ACTIVITYDEFNAME + ", STATUS=" + STATUS + "]";
	}

}
