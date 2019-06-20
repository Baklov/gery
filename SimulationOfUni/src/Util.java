import java.awt.Color;
import java.util.Random;


 public class Util {
	 public static int frameWidth=1100;
	 public static int frameHigh=500;
	 public static int TimeEnroled=10000;
	 public static int TimeEnroled1=100;
	 public static int TimeSemester=15000;
	 public static int CountSemester=5;
	 public static double NoPassPercent=0.1;
	 public static double NoGraduatedPercent=0.1;
	 public static int StudentYear=20000;
	 public static double SexPercent=0.5;
	 public static int MaxStudent=15;
	 public static int RemoteMaxStudent=15;
	 public static int MaxTeacherAngagedToCheck=3;
	 public static int MinStudent=5;
	 public static int timeForExaming=500;
	 public static boolean sleepForBegin=false;
	 public static boolean sleepForBegin1=false;
	 
	 public static boolean flagSynch =false;
	 
	 static final int FPS_MIN = 0;
     static final int FPS_MAX = 100;
     static final int FPS_INIT = 50;  
     
     public static  long countStudent=0;
     public static  long countStudentM=0;
     public static  long countStudentF=0;
     
     public static long countStudentG=0;
     public static long countStudentGM=0;
     public static long countStudentGF=0;
	 
	 public static int maleWaitingCount = 0, femaleWaitingCount = 0, maleExammingCount = 0, femaleExammingCount = 0,  maleNoPassCount = 0, femaleNoPassCount = 0;
	 public static int maleInUniCount = 0, femaleInUniCount = 0, maleGraduatedCount = 0, femaleGraduatedCount = 0, maleNoGraduatedCount = 0, femaleNoGraduatedCount = 0;
	     
	 public static final int sizeWidthTextArea=400	;
	 public static final int sizeHigh_TextArea=170;
     
     
	 public static Color randomColor()
	 {
	   Random random=new Random(); // Probably really put this somewhere where it gets executed only once
	   int red	=random.nextInt(256);
	   int green=random.nextInt(256);
	   int blue	=random.nextInt(256);
	   return new Color(red, green, blue);
	 }
	 
	
	 static void sleepForSomeTime(long timeToSleepBeforeNextCheck) {
		try {
			Thread.sleep(timeToSleepBeforeNextCheck);
		} catch (InterruptedException e) { e.printStackTrace(); }
			
	 }
}
