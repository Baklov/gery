package JPMorgan;

public class JPProduct {
	public JPProduct(String type, double value) {
		super();
		this.type = type;
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	String type;
	double value;
}
