package src.com.JP.code;


import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StartReport {

	public static double createReport(JPClient jpClient,Date Settlement_Date,Date DateForReportIngoingOrOutgoing){
		double sum=0.0;
		if (Settlement_Date.compareTo(DateForReportIngoingOrOutgoing)==0){
			System.out.println(jpClient.toString());
			sum=jpClient.getUSD_Amount_Of_A_Trade();			
		}
		return sum;		
	}

	public static void main(String[] args) {
		int i=0;
		ArrayList<JPClient> JPClients = new ArrayList<>();
		JPClientsUtility clientUtil = new JPClientsUtility();
		try {
			JPClient client = new JPClient("foo",'B',0.50,"SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
			clientUtil.add(client) ;
			clientUtil.add(new JPClient("bar",'S',0.22,"AED", "05 Jan 2016", "07 Jan 2016", 450, 150.5)) ;
			//02 Mar 2018 is Friday
			clientUtil.add(new JPClient("f1",'B',0.3,"AED", "01 Mar 2018", "02 Mar 2018", 100, 50.5)) ;
			clientUtil.add(new JPClient("f2",'S',0.1,"SGP", "01 Mar 2018", "02 Mar 2018", 200, 40.7)) ;
			clientUtil.add(new JPClient("f1",'S',0.2,"AED", "01 Mar 2018", "02 Mar 2018", 100, 150.5)) ;
			clientUtil.add(new JPClient("f2",'S',0.22,"SGP", "01 Mar 2018", "02 Mar 2018", 250, 150.5)) ;
			//03 Mar 2018 is Saturday
			clientUtil.add(new JPClient("f3",'S',0.5,"SAR", "01 Mar 2018", "03 Mar 2018", 100, 150.5)) ;
			
			//04 Mar 2018 is Sunday
			clientUtil.add(new JPClient("f3",'S',0.22,"SGP", "01 Mar 2018", "04 Mar 2018", 250, 150.5)) ;
			clientUtil.add(new JPClient("f4",'B',0.22,"SAR", "01 Mar 2018", "04 Mar 2018", 250, 150.5)) ;
			//05 Mar 2018 is Monday
			clientUtil.add(new JPClient("f5",'S',0.22,"SGP", "01 Mar 2018", "05 Mar 2018", 250, 150.5)) ;
			clientUtil.add(new JPClient("f5",'B',0.22,"SAR", "01 Mar 2018", "05 Mar 2018", 100, 150.5)) ;
			clientUtil.add(new JPClient("f5",'B',0.22,"SGP", "01 Mar 2018", "06 Mar 2018", 150, 150.5)) ;
			JPClients = clientUtil.getJPClients();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		do {		
			
			System.out.println("*********************************************************************************");
		    System.out.println("Please select menu item");
		    System.out.println("1-Create report for clients to JP Morgan to execute in the international market");
		    System.out.println("2-Amount in USD settled incoming everyday");
		    System.out.println("3-Amount in USD settled outgoing everyday");
		    System.out.println("4 Ranking of entities based on incoming and outgoing amount");
		    System.out.println("5 Ranking of entities based on incoming and outgoing amount everyday");
		    System.out.println("6 - exit");
		    System.out.println("*********************************************************************************");
			   
		    System.out.print("Your choice:");
			  
		    int select;
		    Scanner scanner = new Scanner(System.in);
		    select = scanner.nextInt();
		    	i = select;
		    switch (select) {
		        case 1:
				
		        	System.out.println("1-Instruction:, 2-Entity:, 3-Instruction Date, 4-Settlement Date:, 5-Buy/Sell flag:, Agreed Fx, 6-Units:");
					for (JPClient jpClient : JPClients) {
						System.out.println(jpClient.toString());
					}
				
				break;
		        case 2:
				   	System.out.println("Amount in USD settled incoming everyday");
		        	Date DateForReportIngoing = clientUtil.ClientPutReportDate(scanner);
		        	System.out.println("settled incoming are");
					double sumIngoing = 0.0;
		        	for (JPClient jpClient : JPClients) {
		        		if (jpClient.getBuyOrSaleFlag()=='B'){	

		        			sumIngoing+=createReport(jpClient,jpClient.getSettlement_Date(),DateForReportIngoing);
		        		}
					}
		        	System.out.println("for date "+ReportUtills.Date_to_String(DateForReportIngoing,"dd MMM yyyy")+" settled incoming are:"+sumIngoing);
		            break;
		        case 3:
		        	double sumOutgoing = 0.0;
		        	System.out.println("Amount in USD settled outgoing everyday");
		        	Date DateForReportOutgoing = clientUtil.ClientPutReportDate(scanner);
		        	for (JPClient jpClient : JPClients) {
		        		if (jpClient.getBuyOrSaleFlag()=='S')
		        			sumOutgoing+=createReport(jpClient,jpClient.getSettlement_Date(),DateForReportOutgoing);
					}
		          	System.out.println("for date "+ReportUtills.Date_to_String(DateForReportOutgoing,"dd MMM yyyy")+" settled outgoing are:"+sumOutgoing);
				      
		            break;
		        case 4:
					
		        	System.out.println("Ranking of entities based on incoming and outgoing amount");
//		        	clientUtil.getRanksClientUnits()	
		        	Iterator it = clientUtil.getRanksClientUnits().entrySet().iterator();
		    		while (it.hasNext()) {
		    			Map.Entry entity = (Map.Entry) it.next();
		    			System.out.println("The Rank of Entity "+entity.getKey() + " is " + entity.getValue());
		    		}
		        	
		            break;
		        case 5:
					
		        	System.out.println("Ranking of entities based on incoming and outgoing amount everyday");
		        	double sumOutgoingRank = 0.0;
		        	double sumIncomingRank = 0.0;
		        	HashMap<String, Double> ranksClientBuy 	= new HashMap();
	         		 
	         		 HashMap<String, Double> ranksClientSale 	= new HashMap();
	         		 HashMap<String, Boolean> ranksClientUnits 	= new HashMap();
		        	Date DateForReportRanking = clientUtil.ClientPutReportDate(scanner);
//		        	clientUtil.getRanksClientUnits()	
		         	for (JPClient jpClient : JPClients) {
		         		
		         		if (jpClient.getBuyOrSaleFlag()=='B'){	
	        				sumIncomingRank+=createReport(jpClient,jpClient.getSettlement_Date(),DateForReportRanking);
	        				ranksClientBuy.put(jpClient.getEntity(), sumIncomingRank);
		        		}
		        		if (jpClient.getBuyOrSaleFlag()=='S'){
		        			sumOutgoingRank+=createReport(jpClient,jpClient.getSettlement_Date(),DateForReportRanking);
		        			ranksClientSale.put(jpClient.getEntity(), sumOutgoingRank);
		        		}
	        			
	        			
	        			if (sumIncomingRank < sumOutgoingRank)
	        				ranksClientUnits.put(jpClient.getEntity(), Boolean.TRUE);
	        			else
	        				ranksClientUnits.put(jpClient.getEntity(), Boolean.FALSE);
					}
		         	Iterator it1 = ranksClientUnits.entrySet().iterator();
		    		while (it1.hasNext()) {
		    			Map.Entry entity = (Map.Entry) it1.next();
		    			System.out.println("The Rank of Entity "+entity.getKey() +" for date "+ReportUtills.Date_to_String(DateForReportRanking,"dd MMM yyyy")+ " is " + entity.getValue());
		    		}
		        	        	
		            break;
		        case 6:
		            System.out.println("Good Bye!!!!");
		            i=5;
		            break;
		    }

		} while (i != 6);

	    
	    System.exit(0);
	}

}
