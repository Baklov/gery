package src.com.JP.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JPClient {
		 public JPClient(String entity, char buyOrSaleFlag, double agreedFx, String currency, Date instruction_Date,
			Date settlement_Date, double unit, double price_Per_Unit) {
				super();
				Entity = entity;
				BuyOrSaleFlag = buyOrSaleFlag;
				AgreedFx = agreedFx;
				Currency = currency;
				Instruction_Date = instruction_Date;
				//A trade can only be settled on a working day.
				boolean isCheckFor_AED_SAR =ReportUtills.checkForWorkSunday(currency);				
//				If an instructed settlement date falls on a weekend, then the settlement date should be changed to the next working day.
				String settlement_DateStr = ReportUtills.SettleDayToNextWorkingDay(ReportUtills.Date_to_String(settlement_Date, "dd MMM yyyy"), isCheckFor_AED_SAR,"dd MMM yyyy");
				Settlement_Date = ReportUtills.String_to_Date(settlement_DateStr,"dd MMM yyyy");
				Unit = unit;
				Price_Per_Unit = price_Per_Unit;
				setUSD_Amount_Of_A_Trade();
		 }
		
		
		 
		public JPClient(String entity, char buyOrSaleFlag, double agreedFx, String currency, String instruction_Date_Str,
				String settlement_Date_Str, int unit, double price_Per_Unit) throws ParseException {
				SimpleDateFormat dt = new SimpleDateFormat("dd MMM yyyy");
			// TODO Auto-generated constructor stub
		
			Entity = entity;
			BuyOrSaleFlag = buyOrSaleFlag;
			AgreedFx = agreedFx;
			Currency = currency;

			Instruction_Date = dt.parse(instruction_Date_Str);
			//A trade can only be settled on a working day.
			boolean isCheckFor_AED_SAR =ReportUtills.checkForWorkSunday(currency);				
//			If an instructed settlement date falls on a weekend, then the settlement date should be changed to the next working day.
			String settlement_DateStr = ReportUtills.SettleDayToNextWorkingDay(settlement_Date_Str, isCheckFor_AED_SAR,"dd MMM yyyy");
			Settlement_Date = ReportUtills.String_to_Date(settlement_DateStr,"dd MMM yyyy");
			Unit = unit;
			Price_Per_Unit = price_Per_Unit;
			setUSD_Amount_Of_A_Trade();
		}
		private String Entity;
		 private char BuyOrSaleFlag;
		 private double AgreedFx;
		 private String Currency;
		 
		 private Date Instruction_Date;
		 private Date Settlement_Date;	
		 
		 private double Unit;
		 private double Price_Per_Unit;
		 private double USD_Amount_Of_A_Trade;
		 
		 public double getUSD_Amount_Of_A_Trade() {
			return USD_Amount_Of_A_Trade;
		}
		public void setUSD_Amount_Of_A_Trade() {
			//USD amount of a trade = Price per unit * Units * Agreed Fx
			USD_Amount_Of_A_Trade = getPrice_Per_Unit()*getUnit()*getAgreedFx();
		}
		public String getEntity() {
			return Entity;
		}
		public void setEntity(String entity) {
			Entity = entity;
		}
		public char getBuyOrSaleFlag() {
			return BuyOrSaleFlag;
		}
		public void setBuyOrSaleFlag(char buyOrSaleFlag) {
			BuyOrSaleFlag = buyOrSaleFlag;
		}
		public double getAgreedFx() {
			return AgreedFx;
		}
		public void setAgreedFx(double agreedFx) {
			AgreedFx = agreedFx;
		}
		public String getCurrency() {
			return Currency;
		}
		public void setCurrency(String currency) {
			Currency = currency;
		}
		public Date getInstruction_Date() {
			return Instruction_Date;
		}
		public void setInstruction_Date(Date instruction_Date) {
			Instruction_Date = instruction_Date;
		}
		public Date getSettlement_Date() {
			return Settlement_Date;
		}
		public void setSettlement_Date(Date settlement_Date,String currency) {
			boolean isCheckFor_AED_SAR =ReportUtills.checkForWorkSunday(currency);				
//			If an instructed settlement date falls on a weekend, then the settlement date should be changed to the next working day.
			String settlement_DateStr = ReportUtills.SettleDayToNextWorkingDay(ReportUtills.Date_to_String(settlement_Date, "dd MMM yyyy"), isCheckFor_AED_SAR,"dd MMM yyyy");
			Settlement_Date = ReportUtills.String_to_Date(settlement_DateStr,"dd MMM yyyy");
		}
		public double getUnit() {
			return Unit;
		}
		public void setUnit(double unit) {
			Unit = unit;
		}
		public double getPrice_Per_Unit() {
			return Price_Per_Unit;
		}
		public void setPrice_Per_Unit(double price_Per_Unit) {
			Price_Per_Unit = price_Per_Unit;
		}
		@Override
		public String toString() {
			return "JPClient [Entity=" + Entity + ", BuyOrSaleFlag=" + BuyOrSaleFlag + ", AgreedFx=" + AgreedFx
					+ ", Currency=" + Currency + ", Instruction_Date=" + Instruction_Date + ", Settlement_Date="
					+ Settlement_Date + ", Unit=" + Unit + ", Price_Per_Unit=" + Price_Per_Unit + "]";
		}
		

}
