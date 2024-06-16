import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Assignment9 {

	public static void main(String arg[]) {
		JSONObject student = new JSONObject();
		student.put("Name", "Tester");
		student.put("Marks", 98);
		student.put("Age", 21);
		student.put("School", "Home schooled");

		System.out.println("Student Object : " + student);

		String JSONText = JSONValue.toJSONString(student);

		System.out.println("JSON String : " + JSONText);

		// add new key value pair
		student.put("City", "Aamchi mumbai");
		System.out.println("Updated Student Object : " + student);

		// removing city
		student.remove("City");

		String name = (String) student.get("Name");
	}

}
