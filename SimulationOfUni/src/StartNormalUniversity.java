import java.awt.Color;


public class StartNormalUniversity implements Runnable{
	public static Boolean startProcess=null;
	
	University university=null;
	UniversityGUI GUI= null;
	StartNormalUniversity(University university, UniversityGUI GUI, Boolean startProcess){
		this.university = university;
		this.GUI = GUI;
		this.startProcess = startProcess;
	}
	@Override
	public void run() {
		StartUniversity( university, GUI);
	}
	public void StartUniversity(University university, UniversityGUI GUI){
		int i = 0;
		int kGroupForYear=0;
		double BorderExaminPeople=Util.MinStudent;
		Color colorOfGroupStudent=Util.randomColor();
		while (true) {
			while (!startProcess){
				Util.sleepForSomeTime(300);
			}	
			
			if (++kGroupForYear>BorderExaminPeople){
				Util.sleepForSomeTime(Util.StudentYear);
	
				kGroupForYear=0;
				BorderExaminPeople = Math.random()*Util.MaxStudent;
				Util.countStudent++;
				colorOfGroupStudent=Util.randomColor();
			}
						
			(new EnrolledStudent("Student" + i++, (Math.random() > Util.SexPercent ? "male" : "female"), university, GUI,colorOfGroupStudent)).start();
		}
		
	}
}