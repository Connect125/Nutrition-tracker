package application;

public class NumericOnlyException extends Exception {

	//Only contains default exception constructors 
	
	public NumericOnlyException() {
	}

	public NumericOnlyException(String message) {
		super(message);
	}

	public NumericOnlyException(Throwable cause) {
		super(cause);
	}

	public NumericOnlyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumericOnlyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
