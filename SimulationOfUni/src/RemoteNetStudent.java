import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class RemoteNetStudent extends Student {
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	UniversityGUI GUI=null;
	University university=null;
	

	RemoteNetStudent(String name, Socket sock, University university, UniversityGUI GUI) throws IOException {
		super(name, university);
		this.GUI = GUI;
		this.university=university;
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())), true);
		start();
	}

	public void setSex(String sex) { this.sex = sex; }

	public void run() {
		out.println("HELLO");

			setSex(Math.random() > Util.SexPercent ? "male" : "female");
			System.out.println("+ A " + sex + "(" + name + ") is go to exam to enter the University.");
			out.println("EXAMMING On The NET");
			out.println(name + sex.charAt(0));
			Util.countStudent++;
			Util.sleepForSomeTime(Util.TimeEnroled);
			if (Math.random() > Util.NoPassPercent){
				System.out.println("+ A " + sex + "(" + name + ") is enrolled to  the Remote University.");
				System.out.println(" A " + sex + "(" + name + ") is in the Remote University.");
				out.println("IN UNIVERSITY On The NET");
				out.println(name + sex.charAt(0));
				Util.sleepForSomeTime(Util.TimeSemester * Util.CountSemester);
				if (Math.random() > Util.NoGraduatedPercent){
					System.out.println("+ A " + sex + "(" + name + ") has Graduates in the Remote University.");
					out.println("GRADUATED On The NET");
					out.println(name + sex.charAt(0));
				} 
				else{
					System.out.println("+ A " + sex + "(" + name + ") has not Graduates in the Remote University.");
					out.println("NOGRADUATED On The NET");
					out.println(name + sex.charAt(0));
				}
			} else {
				System.out.println("+ A " + sex + "(" + name + ") is not Pass in  the University. Try again!");
				System.out.println(" A " + sex + "(" + name + ") is not Pass in  the University. Try again!");
				out.println("NOPASS On The NET");
				out.println(name + sex.charAt(0));
				
			}
			out.println("TERMINATED");
	}
}
