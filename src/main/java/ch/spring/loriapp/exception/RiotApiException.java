package ch.spring.loriapp.exception;

@SuppressWarnings("serial")
public class RiotApiException extends Exception {

	public RiotApiException(String message) {
		super(message);
	}
}
