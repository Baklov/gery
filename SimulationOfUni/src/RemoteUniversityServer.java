import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteUniversityServer extends Thread {
	
	static final int SERVER_PORT = 5000;
	private static int netNum = 0;
	private University university;
	UniversityGUI GUI;

	RemoteUniversityServer(University university, UniversityGUI GUI) {
		super("Server of University");
		this.university = university;
		this.GUI = GUI;
		start();
	}

	public void run() {
		ServerSocket s = null;
		try {
			s = new ServerSocket(SERVER_PORT);
			System.out.println("Server started Net.");
			while(true) {
				// Blocks until a connection occurs:
				Socket socket = s.accept();
				new RemoteNetStudent("REMOTE Student:" + netNum++, socket, university, GUI);
			}
		}
		catch (IOException e) {}
		finally {
			try { s.close(); }
			catch (IOException e) { e.printStackTrace(); }
		}
	}
}
