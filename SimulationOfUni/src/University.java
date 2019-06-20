import java.util.Timer;
import java.util.TimerTask;

public class University {
	private static final int WAIT_TIME = 3000;
	private int teacherAngagedToCheck;
	private int totalForSemester;
	private String studentSex;
	Boolean congested = false;
	private String nameOfUniversity="";
	public String getNameOfUniversity() {
		return nameOfUniversity;
	}

	public void setNameOfUniversity(String nameOfUniversity) {
		this.nameOfUniversity = nameOfUniversity;
	}

	Timer timer;
	UniversityGUI GUI;
	
	class ResetBan extends TimerTask {
		public void run() {
			resetBan();
		}
	}

	University(UniversityGUI GUI, String nameOfUniversity) {
		teacherAngagedToCheck = 0;
		totalForSemester = 5;
		studentSex = "";
		this.GUI = GUI;
		this.nameOfUniversity=nameOfUniversity;
	}

	public void resetBan() {
		System.out.println("= Resetting ban.");
		timer.cancel();
	}

	public synchronized void enterExam(String sex) {		
		while ( congested ) {
			try {		
					System.out.println(
						"x A " + sex + "(" + Thread.currentThread().getName() + ") is waiting " + (WAIT_TIME + 100) + " ms. Reason Wait for check work for exams. There is no body to check exam work to Student"
					);
					GUI.updateState(Thread.currentThread().getName() + sex.charAt(0), "Waiting");
					wait(WAIT_TIME + 10000);
		
			}
			catch (InterruptedException e) { System.err.println(e); }
		}
		if (++teacherAngagedToCheck == Util.MaxTeacherAngagedToCheck ) 
			congested = true;
		Util.sleepForSomeTime(Util.timeForExaming);
		System.out.println("Total student's candidates so far from teachers: " + teacherAngagedToCheck + ".");
		studentSex = sex;
		System.out.print("* The University has " + teacherAngagedToCheck +"for Students.");
	}

	public synchronized void leaveExam() {
		--teacherAngagedToCheck;
		System.out.println("* The University has no more " + teacherAngagedToCheck +  "to check work of Students.");
		if (teacherAngagedToCheck == 0) {
			System.out.println("= 3 seconds wait for next work of " + studentSex + " Students.");
			timer = new Timer();
			timer.schedule(new ResetBan(), WAIT_TIME);
			studentSex = "";
			congested = false;
			notifyAll();
		}
	}
	

}