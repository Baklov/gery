package JPMorgan;

public interface iMessage {
	boolean setMessage(JPProduct product);
	boolean setMessage(String type, double value);
	JPProduct getMessage();
}
