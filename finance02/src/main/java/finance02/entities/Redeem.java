package entities;

import java.util.Date;

public class Redeem {
    String organCode;
	Date tranDate;
	String tranTime;
	String applicationCode;
	String taCode;
	String prodCode;
	double tradeQuot;
    String tradeCode;
    int regeemSequence;
	String appiontApplicationCode;
	
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getTaCode() {
		return taCode;
	}
	public void setTaCode(String taCode) {
		this.taCode = taCode;
	}

	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public double getTradeQuot() {
		return tradeQuot;
	}
	public void setTradeQuot(double tradeQuot) {
		this.tradeQuot = tradeQuot;
	}

	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public int getRegeemSequence() {
		return regeemSequence;
	}
	public void setRegeemSequence(int regeemSequence) {
		this.regeemSequence = regeemSequence;
	}

	public String getAppiontApplicationCode() {
		return appiontApplicationCode;
	}
	public void setAppiontApplicationCode(String appiontApplicationCode) {
		this.appiontApplicationCode = appiontApplicationCode;
	}
}