package src.com.JP.code;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class JPClientsUtility {
	 public HashMap<String, Double> getRanksClientBuy() {
		return ranksClientBuy;
	}
	public void setRanksClientBuy(HashMap<String, Double> ranksClientBuy) {
		this.ranksClientBuy = ranksClientBuy;
	}
	public HashMap<String, Double> getRanksClientSale() {
		return ranksClientSale;
	}
	public void setRanksClientSale(HashMap<String, Double> ranksClientSale) {
		this.ranksClientSale = ranksClientSale;
	}
	public HashMap<String, Boolean> getRanksClientUnits() {
		return ranksClientUnits;
	}
	public void setRanksClientUnits(HashMap<String, Boolean> ranksClientUnits) {
		this.ranksClientUnits = ranksClientUnits;
	}
	HashMap<String, Double> ranksClientBuy 	= new HashMap();
	 
	 HashMap<String, Double> ranksClientSale 	= new HashMap();
	 HashMap<String, Boolean> ranksClientUnits 	= new HashMap();
	 ArrayList<JPClient> JPClients 			= new ArrayList<>();
	public ArrayList<JPClient> getJPClients() {
		return JPClients;
	}
	public void setJPClients(ArrayList<JPClient> jPClients) {
		JPClients = jPClients;
	}
	public JPClientsUtility(ArrayList<JPClient> jPClients) {
		super();
		JPClients = jPClients;
	}
	 public JPClientsUtility() {
		// TODO Auto-generated constructor stub
	}
	 
	int SetRanking_Of_Entities(JPClient client, boolean flag1){
		double rankToNowBuy = 0;
		if (!ranksClientBuy.isEmpty()){
//			if (client.getBuyOrSaleFlag() == 'B'){
				boolean isExisistEntity = ranksClientBuy.containsKey(client.getEntity());
				if (isExisistEntity)
					rankToNowBuy 	= ranksClientBuy.get(client.getEntity());
//			}
			
		}
		double rankToNowSale = 0;
		if (!ranksClientSale.isEmpty()){
//			if (client.getBuyOrSaleFlag() == 'S'){
				boolean isExisistEntity = ranksClientSale.containsKey(client.getEntity());
				if (isExisistEntity)
					rankToNowSale 	= ranksClientSale.get(client.getEntity());
//			}
						
		}
		if (flag1){

			if (client.getBuyOrSaleFlag() == 'B'){
				rankToNowBuy += client.getUSD_Amount_Of_A_Trade();
				ranksClientBuy.put(client.getEntity(), rankToNowBuy);
			}
			if (client.getBuyOrSaleFlag() == 'S'){
				rankToNowSale += client.getUSD_Amount_Of_A_Trade();
				ranksClientSale.put(client.getEntity(), rankToNowSale);
			}
			//Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy instruction, then foo is rank 1 for outgoing9
			if (rankToNowBuy < rankToNowSale)
				ranksClientUnits.put(client.getEntity(), Boolean.TRUE);
			else
				ranksClientUnits.put(client.getEntity(), Boolean.FALSE);
			
		}

		
		return 0;
		
	}
	public void add(JPClient client) {
		// TODO Auto-generated method stub
		SetRanking_Of_Entities(client, true);
		JPClients.add(client);
	}
	Date ClientPutReportDate(Scanner scanner){
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		    Date parsedDate = null;
		    Date now = new Date();
		    System.out.println("please select date for report");
	    String str[] = {"year", "month", "day" };
	    String date = "";
	    System.out.println("Report will be for");
	    System.out.println("1. today");
	    System.out.println("all the othere key for archive");
	    
	    System.out.print("Your choice:");
		
	      char choise = scanner.next().charAt(0);
	  if (choise!='1'){

	    for(int i=0; i<3; i++) {
	        System.out.println("Enter " + str[i] + ": ");
	        date = date + scanner.next() + "/";
	    }
	    date = date.substring(0, date.length()-1);
	    System.out.println("date: "+ date);
	  }
	  else{
		  date = dateFormat.format(now);
		  System.out.println("date: "+ date);
	  }
	   
	    try {
	        parsedDate = dateFormat.parse(date);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return parsedDate;
	}

}
