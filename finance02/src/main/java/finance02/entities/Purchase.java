package entities;

import java.math.BigDecimal;
import java.time.*;

public class Purchase {
    String organCode;
	LocalDate tranDate;
	String tranTime;
	String applicationCode;
	String taCode;
	String prodCode;
	BigDecimal tradeQuot;
	String tradeCode;

	public Purchase(
		String organCode, 
		LocalDate tranDate, 
		String tranTime, 
		String applicationCode,
		String taCode,
		String prodCode,
		BigDecimal tradeQuot,
		String tradeCode
		) {
			this.organCode = organCode;
			this.tranDate = tranDate;
			this.tranTime = tranTime;
			this.applicationCode = applicationCode;
			this.taCode = taCode;
			this.prodCode = prodCode;
			this.tradeQuot = tradeQuot;
			this.tradeCode = tradeCode;
		}
	
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public LocalDate getTranDate() {
		return tranDate;
	}
	public void setTranDate(LocalDate tranDate) {
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

	public BigDecimal getTradeQuot() {
		return tradeQuot;
	}
	public void setTradeQuot(BigDecimal tradeQuot) {
		this.tradeQuot = tradeQuot;
	}

	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
}