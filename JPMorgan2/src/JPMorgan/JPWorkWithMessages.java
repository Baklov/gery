package JPMorgan;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class JPWorkWithMessages {
	JPWorkWithMessage work = new JPWorkWithMessage();
	ArrayList listSales = new ArrayList<>();
	ArrayList listOperation = new ArrayList<>();

	iMessage message = null;
	int i10=0;
	int i50=0;
	int i=0;
	
	public void doMessages(ArrayList<iMessage> messages) {
		boolean flagMoreMessages=true;
		while(flagMoreMessages){
			if (i10++==10) {
				
				logReport10Messages();
				i10=1;
			}
			if (i50++ == 50) {

				logReport50Messages();
				i50=1;
			}
			message = messages.get(i++);
			if(messages.size() == i)
				flagMoreMessages=false;

			JPSale sale = work.receiveMessage(message);
			String type = null;
			if (message instanceof JPMessageType1) {
				type="Message Type 1";
				listSales.add(sale);
			}
			if (message instanceof JPMessageType2) {
				type="Message Type 2";
				listSales.add(sale);				
			}

			if (message instanceof JPMessageType3) {
				type="Message Type 3";
				listOperation.add(sale);
				workWithMessage3Operations(listSales,sale);
			}

		}
	}
	private void workWithMessage3Operations(ArrayList listSales2, JPSale sale) {
		// TODO Auto-generated method stub
		for (int i=0; i<listSales2.size();i++) {
			String operation =sale.getOperation();
			JPSale saleTemp = (JPSale) listSales2.get(i);
			if (sale.getProduct().getType().equals(saleTemp.getProduct().getType())) {		
				if (operation.equals(JPTypeOfOperation.ADD)) {
					((JPSale) listSales2.get(i)).getProduct().value += sale.getProduct().getValue();					
				}
				if (operation.equals(JPTypeOfOperation.SUB)) {
					((JPSale) listSales2.get(i)).getProduct().value -= sale.getProduct().getValue();		
				}
				if (operation.equals(JPTypeOfOperation.MUL)) {
					((JPSale) listSales2.get(i)).getProduct().value *= sale.getProduct().getValue();
				}
			}
		} 
		
	}
	private void logReport10Messages() {
		System.out.println(" Report detailing the number " + 
				"of sales of each product and their total value");
		System.out.println(" ----------------------------" + 
				"----------------------------------------------");
		HashMap hashProduct = new HashMap<>();
	    HashMap hashProductNumber = new HashMap<>();
		for (int i=0; i<listSales.size();i++) {
			JPSale sale = (JPSale) listSales.get(i);
			boolean exist =  hashProductNumber.containsKey(sale.getProduct().type);
			if (exist) {
				hashProduct.put(sale.getProduct().type,  (double) hashProduct.get(sale.getProduct().type)+(sale.getProduct().value*sale.getNumberOccurence()));
				hashProductNumber.put(sale.getProduct().type, (long) hashProductNumber.get(sale.getProduct().type)+sale.getNumberOccurence());
			}
			else {
				hashProduct.put(sale.getProduct().type,  (double)(sale.getProduct().value*sale.getNumberOccurence()));
				hashProductNumber.put(sale.getProduct().type, (long)sale.getNumberOccurence());
			}
		}
		
		Set<String> keySet = hashProduct.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
	     
        for (String key : listOfKeys) 
        {
            System.out.println("The number of sales of product "+key+" is "+hashProductNumber.get(key)+" and their total value is " +hashProduct.get(key));
        }
        
	}
	private void logReport50Messages() {
		boolean isRunning=false;
		LogThread  logThread = new LogThread(listOperation);
	     
		logThread.start();
		do {
			try {
	            Thread.sleep(100);
	        }
			catch (InterruptedException ie)
	        {
	            System.out.println("Scanning...");
	        }
			isRunning=!logThread.isFinish;
		}
		while(isRunning);
		        
     
	}
	

}
