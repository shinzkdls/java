package bank;

public class insufficientbalanceException extends Exception {
	public insufficientbalanceException() {

	}

	public insufficientbalanceException(String msgcode) {
		super(msgcode);
	}
}
