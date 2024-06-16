class Student {
	private String name;
	private int grade;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int newGrade) {
		this.grade = newGrade;
	}
}

public class Assignment1 {
	public static void main(String[] args) {
		Student student1 = new Student("Tester"); // creating student object
		student1.setGrade(95);	// assigning value of 95 to grade of student1
	}

}
