package abc.phone.book.transport;

/**
 * Model for message returned on failure, to be serialized as JSON.
 */
public class ErrorTransport extends RuntimeException {

	public ErrorTransport(String exception) {
		super(exception);
	}

}
