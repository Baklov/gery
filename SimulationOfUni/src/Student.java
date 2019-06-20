import java.awt.Color;

public class Student extends Thread {
	protected String sex;
	protected String name;
	protected String EGN;
	protected String FakNum; //Number of student in university
	protected String TypeStudent;//Magister, Bachelor, Doctor
	protected Color ColorOfGroup;
	protected static University university;

	Student(String name, University university) {
		super(name);
		this.name = name;
		sex = "";
		Student.university = university;
	}

	public void run() {	}
}