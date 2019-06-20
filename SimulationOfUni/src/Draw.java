import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Draw extends JPanel
                              implements ChangeListener {
    protected JLabel lableBanner;
    
    JTabbedPane tabbedPaneForStatistic = new JTabbedPane();
 
    public Draw(JPanel panelMain, JProgressBar progressBarGraduated) {
        super(new BorderLayout());

        //Set up the banner at the top of the window
        lableBanner = new JLabel("Simulation of University!", JLabel.CENTER);
        lableBanner.setForeground(Color.red);
        lableBanner.setBackground(Color.lightGray);
        lableBanner.setOpaque(true);
        lableBanner.setFont(new Font("SansSerif", Font.BOLD, 24));
        lableBanner.setSize(new Dimension(10, 65));

        JPanel bannerPanel = new JPanel(new BorderLayout());       
        bannerPanel.add(lableBanner, BorderLayout.CENTER);
        bannerPanel.setBorder(BorderFactory.createTitledBorder(""));

        JSlider progressBarManOrWoman = new JSlider(JSlider.HORIZONTAL, Util.FPS_MIN, Util.FPS_MAX, Util.FPS_INIT);
        progressBarManOrWoman.addChangeListener(this);
        
        JLabel labelManOrWoman= new JLabel("Choise % man and women: ");
        JLabel labelMan= new JLabel("Man");
        JLabel labelWoman = new JLabel("Woman");
        JComponent panelManOrWoman = new JPanel();        
        panelManOrWoman.setBorder(BorderFactory.createLineBorder(Color.black));
        panelManOrWoman.add(labelManOrWoman);
        panelManOrWoman.add(labelMan);
        panelManOrWoman.add(progressBarManOrWoman);
        panelManOrWoman.add(labelWoman);
        
        JLabel labelPercentGraduatedStudent= new JLabel("Graduated % Student :");
        JLabel LabelPercentGraduatedStudentCount= new JLabel(""+Util.countStudent);
        JComponent panelPercentGraduatedStudent = new JPanel();
        panelPercentGraduatedStudent.setBorder(BorderFactory.createLineBorder(Color.black));
        panelPercentGraduatedStudent.add(labelPercentGraduatedStudent);        
        panelPercentGraduatedStudent.add(progressBarGraduated);
        panelPercentGraduatedStudent.add(LabelPercentGraduatedStudentCount);
        
        ImageIcon icon = null;
        tabbedPaneForStatistic.addTab("Options   ", icon, panelManOrWoman, "Options");
        tabbedPaneForStatistic.addTab("Statistics", icon, panelPercentGraduatedStudent,  "Statistics");
        
        add(bannerPanel, BorderLayout.NORTH);
        add(panelMain,  BorderLayout.CENTER);
        add(tabbedPaneForStatistic, BorderLayout.PAGE_END);
    }
  
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static void createAndShowGUI(JFrame frame, JPanel p, JProgressBar progressBar) {
        //Create and set up the window.
       // JFrame frame = new JFrame("ColorChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Draw(p,progressBar);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setSize(Util.frameWidth, Util.frameHigh);
        frame.setVisible(true);
    }


	@Override
	public void stateChanged(ChangeEvent paramChangeEvent) {
	//	JOptionPane.showMessageDialog(null,   "Start1.","Start1....",JOptionPane.WARNING_MESSAGE);
		JSlider source = (JSlider)paramChangeEvent.getSource();
	    if (!source.getValueIsAdjusting()) {
	        double fps = (double)source.getValue();
	        if (fps == 0) {
	        	 Util.SexPercent= 0;
	        } else {
	            Util.SexPercent= fps/100;
	        }
	    }
		
	}

}