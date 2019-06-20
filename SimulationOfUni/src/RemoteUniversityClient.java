import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RemoteUniversityClient implements Runnable {
	
	University university = null;
	UniversityGUI GUI = null;
	public RemoteUniversityClient(University university, UniversityGUI GUI ) {
		this.university = university;
		this.GUI= GUI;
		// TODO Auto-generated constructor stub
	}
	public  void LaunchClientRemoteStudent() {
		final String SERVER = "localhost";
		Socket socket = null;
		BufferedReader in;
		PrintWriter out;
		String input;

		try {
				InetAddress addr = InetAddress.getByName(SERVER);
				socket = new Socket(addr, RemoteUniversityServer.SERVER_PORT);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				
				while (true) {
					input = in.readLine();
					System.out.println(input);
					if (input.equals("EXAMMING On The NET")) {
						input = in.readLine();
						GUI.updateState(input, "Examming");
						out.println("EXAMMING On The NET");
					} else if (input.equals("READY")) {
			//			sg.updateState(i + "" + sex.charAt(0), "Waiting");
					} else if (input.equals("IN UNIVERSITY On The NET")) {
						input = in.readLine();
						GUI.updateState(input, "In University");	
					} else if (input.equals("GRADUATED On The NET")) {
						input = in.readLine();
						GUI.updateState(input, "Graduated");
					    GUI.setProgressBarGraduated();					
					} else  if (input.equals("NOGRADUATED On The NET")) {							
						input = in.readLine();
						GUI.updateState(input, "NoGraduated");
					} else	if (input.equals("NOPASS On The NET")) {
						input = in.readLine();
						GUI.updateState(input, "NoPass");
					} else	if (input.equals("TERMINATED")) {
						break;
					}
				}
			}
			catch (UnknownHostException e) { e.printStackTrace(); }
			catch (IOException e) { e.printStackTrace(); }
			finally { try { socket.close(); } catch (IOException e) {} }

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		LaunchClientRemoteStudent();
	}
}
