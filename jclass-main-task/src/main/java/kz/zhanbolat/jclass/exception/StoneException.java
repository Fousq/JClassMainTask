package kz.zhanbolat.jclass.exception;

public abstract class StoneException extends Exception {

	public StoneException() {
		super();
	}

	public StoneException(String message, Throwable cause) {
		super(message, cause);
	}

	public StoneException(String message) {
		super(message);
	}

	public StoneException(Throwable cause) {
		super(cause);
	}

}
