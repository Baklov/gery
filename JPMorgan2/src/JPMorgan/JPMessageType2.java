package JPMorgan;

public class JPMessageType2 implements iMessage {

	private JPProduct product;
	public JPProduct getProduct() {
		return product;
	}
	public void setProduct(JPProduct product) {
		this.product = product;
	}
	private long numberOccurence;
	public JPMessageType2(JPProduct product, long numberOccurence) {
		super();
		this.product = product;
		this.numberOccurence = numberOccurence;
	}
	public long getNumberOccurence() {
		return numberOccurence;
	}
	public void setNumberOccurence(long numberOccurence) {
		this.numberOccurence = numberOccurence;
	}
	
	@Override
	public JPProduct getMessage() {		
		return product;
	}
	@Override
	public boolean setMessage(JPProduct product) {
		this.product = product;
		return false;
	}
	@Override
	public boolean setMessage(String type, double value) {
		// TODO Auto-generated method stub
		return false;
	}

}
