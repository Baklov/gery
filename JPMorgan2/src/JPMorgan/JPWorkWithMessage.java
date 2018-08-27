package JPMorgan;
import java.util.ArrayList;
import java.util.HashMap;

public class JPWorkWithMessage implements iWorkWithMessage {

	
	@Override
	public JPSale receiveMessage(iMessage message) {
		// TODO Auto-generated method stub
		JPProduct product = null;
		JPSale sale = new JPSale();
		
		if (message instanceof JPMessageType1) {
			product = message.getMessage();
			sale.setProduct(product) ;
			sale.setNumberOccurence(1);	
		}
		if (message instanceof JPMessageType2) {
			JPMessageType2 messageType2 = (JPMessageType2)message;
			product = messageType2.getMessage();
			sale.setProduct(product);
			sale.setNumberOccurence(messageType2.getNumberOccurence());
	
		}
		if (message instanceof JPMessageType3) {
			JPMessageType3 messageType3 = (JPMessageType3)message;
			product = messageType3.getMessage();
			sale.setProduct(product);
			sale.setOperation(messageType3.getOperation());
			
		}
		return sale;

	}

}
