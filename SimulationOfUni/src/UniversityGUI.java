import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UniversityGUI implements ActionListener {
	private Map<String, String> map;
	private Map<String, Color> mapColor;
	private JTextArea examming, waiting, inUniversity, Graduated, NoGraduated,NoPass;
	
	Color colorOfGroupCourse= new Color(0);
	private JFrame UniversityFrame;
	private JPanel pWithScrollPanels = new JPanel(new FlowLayout());
	private JPanel pMain = new JPanel(new FlowLayout());
	JButton StartBut = new JButton("Start");
	JButton StopBut = new JButton("Stop");
	JButton StartServerBut = new JButton("Start Server");
	JButton StopServerBut = new JButton("Stop Server");
	JLabel UniversityOpenClosed = new JLabel("University is closed!!", null,  JLabel.CENTER);
	JLabel RemoteUniversityOpenClosed = new JLabel("Remote University is closed!!", null,  JLabel.CENTER);
	JProgressBar progressBarGraduated =new JProgressBar( SwingConstants.HORIZONTAL);	
	
	public  Boolean startServer=false;
	
	University university = new University(this,"My University");
	public static Boolean startProcess=new Boolean(false);;
	StartNormalUniversity startNormalUniversity=null;

	UniversityGUI(JFrame UniversityFrame) {
		this.UniversityFrame = UniversityFrame;
		progressBarGraduated.setValue(0);
		progressBarGraduated.setStringPainted(true);
		progressBarGraduated.setMaximum(100);
		progressBarGraduated.setMinimum(0);;
	   // progressBar.setIndeterminate(true);
		UniversityOpenClosed.setForeground(Color.red);
		UniversityOpenClosed.setOpaque(true);
		UniversityOpenClosed.setFont(new Font("SansSerif", Font.BOLD, 18));
		RemoteUniversityOpenClosed.setForeground(Color.red);
		RemoteUniversityOpenClosed.setOpaque(true);
		RemoteUniversityOpenClosed.setFont(new Font("SansSerif", Font.BOLD, 18));
		pMain.setLayout(new BorderLayout());
		pWithScrollPanels.setLayout(new FlowLayout());
		Draw.createAndShowGUI(UniversityFrame,pMain,progressBarGraduated);
		JPanel TitlePanel = new JPanel();
		JPanel ButtonsPanel = new JPanel();
		TitlePanel.add(UniversityOpenClosed);
		TitlePanel.add(RemoteUniversityOpenClosed);
		pMain.add(TitlePanel,BorderLayout.NORTH);
		pMain.add(pWithScrollPanels,BorderLayout.CENTER);
		pMain.add(ButtonsPanel,BorderLayout.SOUTH);
		
		examming	 	= new JTextArea(27, 10);		examming.setEditable(false); 		
		JScrollPane scrollPaneEx =    new JScrollPane(examming,   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneEx.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		NoPass 			= new JTextArea(27, 20);		NoPass.setEditable(false); 			
		JScrollPane scrollPaneNoPass =    new JScrollPane(NoPass,   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneNoPass.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		inUniversity	= new JTextArea(27, 20);		inUniversity.setEditable(false);	
		JScrollPane scrollPaneUni =    new JScrollPane(inUniversity,   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneUni.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		Graduated		= new JTextArea(27, 20);		Graduated.setEditable(false);		
		JScrollPane scrollPaneGrade =    new JScrollPane(Graduated,   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneGrade.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		NoGraduated 	= new JTextArea(27, 20);			NoGraduated.setEditable(false); 	
		JScrollPane scrollPaneNoGrade =    new JScrollPane(	NoGraduated,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneNoGrade.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		waiting 		= new JTextArea(27, 20);		waiting.setEditable(false);			
		JScrollPane scrollPaneWait =    new JScrollPane(waiting,   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneWait.setPreferredSize(new Dimension(Util.sizeHigh_TextArea, Util.sizeWidthTextArea));
		
		pWithScrollPanels.add(scrollPaneEx);
		pWithScrollPanels.add(scrollPaneWait);
		pWithScrollPanels.add(scrollPaneNoPass);
		pWithScrollPanels.add(scrollPaneUni);
		pWithScrollPanels.add(scrollPaneGrade);
		pWithScrollPanels.add(scrollPaneNoGrade);
			
		StartBut.setActionCommand("Start");
		StartBut.addActionListener(this);
		
		StopBut.setActionCommand("Stop");
		StopBut.addActionListener(this);
		
		StartServerBut.setActionCommand("Start Server");
		StartServerBut.addActionListener(this);
		
		StopServerBut.setActionCommand("Stop Server");
		StopServerBut.addActionListener(this);
				
		ButtonsPanel.add(StartBut);
		ButtonsPanel.add(StopBut);
		ButtonsPanel.add(StartServerBut);
		ButtonsPanel.add(StopServerBut);
		
		UniversityFrame.validate();
		map = Collections.synchronizedMap(new HashMap<String, String>());
		mapColor = Collections.synchronizedMap(new HashMap<String, Color>());
		repopulate();
		
		StopBut.hide();
		StopServerBut.hide();
		startNormalUniversity=new StartNormalUniversity(university, this, startProcess);
		new Thread(startNormalUniversity).start();
		StartServer(university);
		
	}
	
	public void actionPerformed(ActionEvent e) {
        if ("Start".equals(e.getActionCommand())) {
        	//default title and icon
        	JOptionPane.showMessageDialog(UniversityFrame,   "Start.","Start ....",JOptionPane.WARNING_MESSAGE);
        	startNormalUniversity.startProcess= true;
        	StartBut.hide();
        	StopBut.show();;
        	UniversityOpenClosed.setText("University is open!!");
        	UniversityOpenClosed.setForeground(Color.green);
        	
        } 
        if ("Stop".equals(e.getActionCommand())) {
        	JOptionPane.showMessageDialog(UniversityFrame,   "Stop.","Stop....",JOptionPane.WARNING_MESSAGE);
        	startNormalUniversity.startProcess=false;
        	StartBut.show();;
        	StopBut.hide();;
        	UniversityOpenClosed.setText("University is closed!!");
        	UniversityOpenClosed.setForeground(Color.red);
        }
        if ("Start Server".equals(e.getActionCommand())) {
        	JOptionPane.showMessageDialog(UniversityFrame,   "Start Server.","Start....",JOptionPane.WARNING_MESSAGE);
        	startServer=true;
        	StartServerBut.hide();;
        	StopServerBut.show();;
        	RemoteUniversityOpenClosed.setText("Remote University is open!!");
        	RemoteUniversityOpenClosed.setForeground(Color.blue);
        }
        if ("Stop Server".equals(e.getActionCommand())) {
        	JOptionPane.showMessageDialog(UniversityFrame,   "Stop Server.","Stop....",JOptionPane.WARNING_MESSAGE);
        	startServer=false;
        	StartServerBut.show();;
        	StopServerBut.hide();;
        	RemoteUniversityOpenClosed.setText("Remote University is closed!!");
        	RemoteUniversityOpenClosed.setForeground(Color.red);
        }
    }

	private void repopulate() {
		Util.maleWaitingCount = 0;
		Util.femaleWaitingCount = 0;
		Util.maleExammingCount = 0;
		Util.femaleExammingCount = 0;
		Util.maleNoPassCount = 0;
		Util.femaleNoPassCount = 0;
		Util.maleInUniCount = 0; 
		Util.femaleInUniCount = 0; 
		Util.maleGraduatedCount = 0; 
		Util.femaleGraduatedCount = 0;
		Util.maleNoGraduatedCount = 0;
		Util.femaleNoGraduatedCount = 0;
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			if (pairs.getValue() == "Examming") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleExammingCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleExammingCount++;
				}
			}
		}
		
		Iterator<Map.Entry<String, String>> itWait = map.entrySet().iterator();
		while (itWait.hasNext()) {
			Entry<String, String> pairs = itWait.next();
			if (pairs.getValue() == "Waiting") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleWaitingCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleWaitingCount++;
				}
			}
		}
		Iterator<Map.Entry<String, String>> itNP = map.entrySet().iterator();
		while (itNP.hasNext()) {
			Entry<String, String> pairs = itNP.next();
			if (pairs.getValue() == "NoPass") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleNoPassCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleNoPassCount++;
				}
			}
		}
		Iterator<Map.Entry<String, String>> itUni = map.entrySet().iterator();
		while (itUni.hasNext()) {
			Entry<String, String> pairs = itUni.next();
			if (pairs.getValue() == "In University") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleInUniCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleInUniCount++;
				}
			}
		}
		Iterator<Map.Entry<String, String>> itGrad = map.entrySet().iterator();
		while (itGrad.hasNext()) {
			Entry<String, String> pairs = itGrad.next();
			if (pairs.getValue() == "Graduated") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleGraduatedCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleGraduatedCount++;
				}
			}
		}
		Iterator<Map.Entry<String, String>> itNG = map.entrySet().iterator();
		while (itNG.hasNext()) {
			Entry<String, String> pairs = itNG.next();
			if (pairs.getValue() == "NoGraduated") {
				if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'm') {
					Util.maleNoGraduatedCount++;
				} else if (((String) pairs.getKey()).charAt(((String) pairs.getKey()).length() - 1) == 'f') {
					Util.femaleNoGraduatedCount++;
				}
			}
		}
		
		examming.setText		("Examming , f: " 			+ Util.femaleExammingCount 		+ ", m: " + Util.maleExammingCount 	 + "\n");
		NoPass.setText			("NoPass : f: " 			+ Util.femaleNoPassCount 		+ ", m: " + Util.maleNoPassCount 	 + "\n");
		waiting.setText			("Wait:enter to Exam, f: " 	+ Util.femaleWaitingCount 		+ ", m: " + Util.maleWaitingCount 	 + "\n");
		inUniversity.setText	("In University are, f: " 	+ Util.femaleInUniCount 		+ ", m: " + Util.maleInUniCount 	 + "\n");
		Graduated.setText		("Graduated: f: " 			+ Util.femaleGraduatedCount 	+ ", m: " + Util.maleGraduatedCount  + "\n");
		NoGraduated.setText		("NoGraduated: f: " 		+ Util.femaleNoGraduatedCount 	+ ", m: " + Util.maleNoGraduatedCount + "\n");
		
		it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Entry<String, String> pairs = it.next();
	        if (pairs.getValue() == "Examming") {
	        	examming.append((String) pairs.getKey() + "\n");
	        } else if (pairs.getValue() == "Waiting") {
	        	waiting.append((String) pairs.getKey() + "\n");
	        } else if (pairs.getValue() == "In University") {
	        	inUniversity.append((String) pairs.getKey() + "\n");
	        } else if (pairs.getValue() == "Graduated") {
	        	Graduated.append((String) pairs.getKey() + "\n");
	        } else if (pairs.getValue() == "NoGraduated") {
	 	       	NoGraduated.append((String) pairs.getKey() + "\n");
	 	    }   else if (pairs.getValue() == "NoPass") {
	 	    	NoPass.append((String) pairs.getKey() + "\n");
	 	    }
	    }
	  
	    UniversityFrame.validate();
	}

	synchronized public void updateState(String customer, String state) {
		map.put(customer, state);
		repopulate();
	}
	synchronized public void updateState(String customer, String state,Color color) {
		this.colorOfGroupCourse=color;
		map.put(customer, state);
		mapColor.put(customer, color);
		repopulate();
		this.colorOfGroupCourse=new Color(0);		
	}
	
	void setProgressBarGraduated() {
		  if (Util.femaleGraduatedCount!=0 ||Util.maleGraduatedCount!=0) {
			  double graduated = (Util.femaleGraduatedCount+Util.maleGraduatedCount);
			  double nograduated = (Util.femaleNoGraduatedCount+Util.maleNoGraduatedCount);
			  double percent = (double) ((graduated/(graduated+nograduated))*100);
			  int p = (int) Math.round(percent);
			 
			  progressBarGraduated.setValue(p);
		  }
		  UniversityFrame.validate();
	}

	public void StartServer(University university){
		int kGroupForYear=0;
		double BorderExaminPeople=Util.MinStudent;

		new RemoteUniversityServer(university, this);
		while (true){
			while (!startServer){

				Util.sleepForSomeTime(300);
				
			}	
			
			if (++kGroupForYear>BorderExaminPeople){	
				Util.sleepForSomeTime(Util.StudentYear);
				Util.flagSynch=true;
				
				kGroupForYear=0;
				BorderExaminPeople = Math.random()*Util.RemoteMaxStudent;
				Util.countStudent++;
				setProgressBarGraduated();
			}
			
			new Thread(new RemoteUniversityClient(university, this)).start();	
		}
	}
	
}
