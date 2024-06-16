import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Assignment10 {

	public static void main(String[] args) {
		String xmlString = """
				<students>
				    <student id="1">
				        <name>John Doe</name>
				        <marks>85</marks>
				        <courses>
				            <course>Math</course>
				            <course>Science</course>
				        </courses>
				    </student>
				    <student id="2">
				        <name>Jane Smith</name>
				        <marks>78</marks>
				        <courses>
				            <course>English</course>
				            <course>History</course>
				        </courses>
				    </student>
				</students>
				""";

		try {
			// Create a document builder factory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Create a document builder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse the XML string into a Document object
			Document document = builder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes()));

			// Get the "students" element
			Element studentsElement = (Element) document.getElementsByTagName("students").item(0);

			// Add a new student
			Element newStudent = document.createElement("student");
			newStudent.setAttribute("id", "3"); // Set student ID
			Element studentName = document.createElement("name");
			studentName.setTextContent("Alice White");
			Element studentMarks = document.createElement("marks");
			studentMarks.setTextContent("90");
			Element studentCourses = document.createElement("courses");
			Element course1 = document.createElement("course");
			course1.setTextContent("Art");
			Element course2 = document.createElement("course");
			course2.setTextContent("Literature");
			studentCourses.appendChild(course1);
			studentCourses.appendChild(course2);
			newStudent.appendChild(studentName);
			newStudent.appendChild(studentMarks);
			newStudent.appendChild(studentCourses);
			studentsElement.appendChild(newStudent);

			System.out.println("Updated XML with new student:");
			System.out.println(document.toString()); // Print the entire modified document

			// Update an existing student's marks (find by ID)
			NodeList students = studentsElement.getElementsByTagName("student");
			for (int i = 0; i < students.getLength(); i++) {
				Element student = (Element) students.item(i);
				String studentId = student.getAttribute("id");
				if (studentId.equals("2")) { // Update student with ID "2"
					Element marksElement = (Element) student.getElementsByTagName("marks").item(0);
					marksElement.setTextContent("82"); // Update marks
					break;
				}
			}

			System.out.println("\nUpdated XML with modified marks:");
			System.out.println(document.toString()); // Print the entire modified document again

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
