package ws0307;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {

	}

	public NegativeNumberException(String msgcode) {
		super(msgcode);
	}
}
