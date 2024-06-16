public class Assignment4 {

	public void stringMethods() {

		String str = "This is a Sample String";

		// String methods and explanations:

		// 1. Length: Get the string length
		int length = str.length();

		// 2. CharAt: Get a character at specific index (avoid out-of-bounds)
		if (length > 3) { // Check index validity before accessing
			char charAtIndex = str.charAt(3);
		} else {

		}

		// 3. Contains: Check if a substring exists
		boolean containsSample = str.contains("Sample");

		// 4. ToUpperCase: Convert to uppercase
		String upperCaseStr = str.toUpperCase();

		// 5. ToLowerCase: Convert to lowercase
		String lowerCaseStr = str.toLowerCase();

		// 6. Trim: remove whitespace and trailing spaces
		String trimmedString = str.trim();

	}

	public void arrayBlock() {

		// Array examples:

		// 1. integer array
		int[] numbers = { 19, 26, 11 };

		// Accessing element (without exception handling for simplicity)
		int secondNumber = numbers[1];

		// Updating element
		numbers[2] = 25; // Update the age of the third element

		// 2. String array for phone brands
		String[] brands = { "Nothing", "iPhone", "Samsung" };

		try {
			String brand = brands[4];
		} catch (ArrayIndexOutOfBoundsException e) {
			// do something
		}

	}

	public static void main(String[] args) {

		Assignment4 object = new Assignment4();

		object.stringMethods();
		object.arrayBlock();
	}
}
