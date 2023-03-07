package ws0307;

public class insufficientbalanceException extends Exception {
	public insufficientbalanceException() {

	}

	public insufficientbalanceException(String msgcode) {
		super(msgcode);
	}
}
