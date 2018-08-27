package JPMorgan;

public class JPMessageType1 implements iMessage {

	private JPProduct product;
	public JPMessageType1(JPProduct product) {
		super();
		this.product = product;
	}
	public JPProduct getProduct() {
		return product;
	}
	public void setProduct(JPProduct product) {
		this.product = product;
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
