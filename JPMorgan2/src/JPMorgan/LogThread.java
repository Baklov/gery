package JPMorgan;

import java.util.ArrayList;
import java.util.HashMap;

public class LogThread extends Thread{

    public boolean isFinish=false;
    
	private ArrayList listOperation;

	public ArrayList getListOperation() {
		return listOperation;
	}

	public void setListOperation(ArrayList listOperation) {
		this.listOperation = listOperation;
	}

	public LogThread(ArrayList listOperation) {
		super();
		this.listOperation = listOperation;
	}

	public void run() {
		String message3 ="Add 20p apples";
    	System.out.println(" Report of the adjustments that have been made to"
				+ " each sale type while the application was running");
    	System.out.println(" ------------------------------------------------"
				+ "-------------------------------------------------");
		for (int i=0; i<listOperation.size();i++) {
			JPSale sale = (JPSale) listOperation.get(i);
	        System.out.println("\r\nAdjustments that have been made to sale type:"+sale.getProduct().type+" while the application was running.");
	        System.out.println("Operation - adjustments:"+sale.getOperation()+" "+sale.getProduct().getValue()+"p "+sale.getProduct().type);
					
			for (int j=i; j<listOperation.size();j++) {
				JPSale saleOpTemp = (JPSale) listOperation.get(j);
				if (sale.getProduct().type.equals(saleOpTemp.getProduct().type)) {
			         System.out.println("Operation - adjustments:"+saleOpTemp.getOperation()+" "+saleOpTemp.getProduct().getValue()+"p "+sale.getProduct().type);
			         
				}
			}
		}

		isFinish =true;
    }
 }