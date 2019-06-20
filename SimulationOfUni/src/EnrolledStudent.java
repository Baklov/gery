import java.awt.Color;

import javax.swing.SwingUtilities;

public class EnrolledStudent extends Student {
	UniversityGUI GUI;

	EnrolledStudent(String name, String sex, University university, UniversityGUI GUI, Color color) {
		super(name, university);
		this.name = name;
		this.sex = sex;
		this.GUI = GUI;
		this.ColorOfGroup=color;
	}

	public void run() {
		Util.sleepForSomeTime(1000);
		university.enterExam(sex);
		System.out.println("+ A " + sex + "(" + name + ") is go for in Examine to enter the University.");
		GUI.updateState(name + sex.charAt(0), "Examming",ColorOfGroup);
		Util.countStudent++;
		university.leaveExam();
		
		Util.sleepForSomeTime(Util.TimeEnroled1);
		if (Math.random() > Util.NoPassPercent){
			
			System.out.println("+ A " + sex + "(" + name + ") is enrolled to  the University.");
			System.out.println(" A " + sex + "(" + name + ") is in the University.");
			GUI.updateState(name + sex.charAt(0), "In University",ColorOfGroup);
			
			Util.sleepForSomeTime(Util.TimeSemester * Util.CountSemester);
			if (Math.random() > Util.NoGraduatedPercent){
				System.out.println("+ A " + sex + "(" + name + ") has Graduated the University.");
				GUI.setProgressBarGraduated();
				GUI.updateState(name + sex.charAt(0), "Graduated",ColorOfGroup);
			} else {
				System.out.println("+ A " + sex + "(" + name + ") has not Graduated the University.");
				GUI.updateState(name + sex.charAt(0), "NoGraduated",ColorOfGroup);
				
			}
		} else {
			
			System.out.println(" A " + sex + "(" + name + ") is not Pass in  the University. Try again!");
			GUI.updateState(name + sex.charAt(0), "NoPass",ColorOfGroup);
		}		
		
	}
}
