package JPMorgan;

public class JPSale {
	public JPProduct getProduct() {
		return product;
	}
	public void setProduct(JPProduct product) {
		this.product = product;
	}
	public long getNumberOccurence() {
		return numberOccurence;
	}
	public void setNumberOccurence(long numberOccurence) {
		this.numberOccurence = numberOccurence;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	private JPProduct product;
	private long numberOccurence;
	private String operation;
}
