package JPMorgan;

public class JPMessageType3 implements iMessage {

	private JPProduct product;
	private String operation;
	public JPMessageType3(JPProduct product, String operation) {
		super();
		this.product = product;
		this.operation = operation;
	}
	public JPProduct getProduct() {
		return product;
	}
	public void setProduct(JPProduct product) {
		this.product = product;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
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
