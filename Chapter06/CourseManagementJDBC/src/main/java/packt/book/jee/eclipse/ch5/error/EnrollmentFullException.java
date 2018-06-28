package packt.book.jee.eclipse.ch5.error;

public class EnrollmentFullException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EnrollmentFullException (String message) {
		super(message);
	}
	
	public EnrollmentFullException (Throwable th) {
		super(th);
	}
}
