public class Assignment6 {

	public static void main(String[] args) {

		try {
			// Code that might throw exceptions
			divideByZero(); // Example of potential ArithmeticException

			String maybeNullString = null;
			int stringLength = maybeNullString.length(); // Example of potential NullPointerException

		} catch (ArithmeticException e) {
			// Handle ArithmeticException (e contains details about the exception)
			handleError("Error: Division by zero!");
		} catch (NullPointerException e) {
			// Handle NullPointerException (e contains details about the exception)
			handleError("Error: Null reference!");
		} catch (Exception e) { // Catch-all for any other exceptions
			// Handle unexpected exceptions
			handleError("An unexpected error occurred!");
		} finally {
			// Code that always executes, regardless of exceptions (optional cleanup)
			cleanupResources();
		}
	}

	private static void divideByZero() {
		int result = 10 / 0; // Intentionally causing ArithmeticException
	}

	private static void handleError(String errorMessage) {
		// (Simulate error handling logic, e.g., logging or error messages)
		// You can store or use the errorMessage for further processing.
	}

	private static void cleanupResources() {
		// (Simulate resource cleanup, e.g., closing files or database connections)
	}

	public static void anotherMethod() throws IOException {
		// This method throws an IOException (indicates potential I/O issues)
		throw new IOException("Simulated I/O error");
	}
}
