package src.com.JP.code;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class ReportUtills {
	 public static int getDay_Of_Week(Date d){
		 
		 Calendar c = Calendar.getInstance();
		 c.setTime(d);
		 int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
		 
	 }

	 public  static String Date_to_String(Date date){
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 String dateStr = dateFormat.format(date);
		return dateStr;
	 }
	 
	 public  static String Date_to_String(Date date, String date_format){
		 SimpleDateFormat dateFormat = new SimpleDateFormat(date_format);
		 String dateStr = dateFormat.format(date);
		return dateStr;
	 }
	 public static Date String_to_Date(String str_date, String format_date){
		 SimpleDateFormat dateFormat = new SimpleDateFormat(format_date);
		 Date parsedDate = null;
		 try {
		        parsedDate = dateFormat.parse(str_date);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		return parsedDate;
		 
	 }
	
	 public static Date Add_One_Day(Date d, String format_date){
		 SimpleDateFormat dateFormat = new SimpleDateFormat(format_date);
		 Calendar c = Calendar.getInstance();
		 c.setTime(d);
		 c.add(Calendar.DATE, 1);
		 String strDate = dateFormat.format(c.getTime());
		 try {
		        d = dateFormat.parse(strDate);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		return d;
		 
	 }
	 
		//A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday.
	 public static boolean isWeekend(String SettleDate,boolean flagCheckForWorkSunday, String format_date ){
		 String rez=SettleDate;
		 Date parsedDate = null;
		 SimpleDateFormat dateFormat = new SimpleDateFormat(format_date);
		 try {
		        parsedDate = dateFormat.parse(SettleDate);
	     } catch (ParseException e) {
	         	e.printStackTrace();
	     }
		 int dayOfWeek = getDay_Of_Week(parsedDate);
		 boolean isWeekday = ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY));
		
		 if (flagCheckForWorkSunday){
			 isWeekday = ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.THURSDAY)||dayOfWeek == Calendar.SUNDAY);
			 
		 }
		 else{
			
		 }
		 
		return isWeekday;
		 
	 }
	 
	 //A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday.
	 public static boolean checkForWorkSunday(String currency){
		 boolean rez=false;
		 if ("SAR".equalsIgnoreCase(currency)||"AED".equalsIgnoreCase(currency)){
			
			rez=true;
		 }
		
		return rez;
		 
	 }
	 

	//A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday.
		 public static String SettleDayToNextWorkingDay(String SettleDate,boolean flagCheckForWorkSunday, String Format_Date){
			 String rez=SettleDate;
			 Date parsedDate = null;
			 SimpleDateFormat dateFormat = new SimpleDateFormat(Format_Date);
			 try {
			        parsedDate = dateFormat.parse(SettleDate);
		     } catch (ParseException e) {
		         	e.printStackTrace();
		     }
			 int dayOfWeek = getDay_Of_Week(parsedDate);
			
			 if (flagCheckForWorkSunday){
				 if (dayOfWeek ==Calendar.FRIDAY ){
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
				 }
				 if (dayOfWeek ==Calendar.SATURDAY){
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
				 }
				 rez = dateFormat.format(parsedDate);
			 }
			 else{
				 if (dayOfWeek ==Calendar.SATURDAY ){
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
				 }
				 if (dayOfWeek ==Calendar.SUNDAY){
					 parsedDate=Add_One_Day(parsedDate,Format_Date);
				 }
				 rez = dateFormat.format(parsedDate);
			 }
			 
			return rez;
			 
		 }
}
