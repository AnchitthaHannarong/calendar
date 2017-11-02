package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainView {
	private JFrame frame;
	private CalendarPanel panel1;
	private AddEventPanel panel2;
	//private Container pane;
	
	public MainView(){
		setFrame(new JFrame());
		setPanel1(new CalendarPanel());
		getPanel1().rander();
		getPanel1().setVisible(true);
		setPanel2(new AddEventPanel());
	}
	
	public void initFrame(){
		getFrame().setSize(1000, 400);
	    getFrame().getContentPane().add(panel1);
	    //pane.setLayout(null);
	    getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getFrame().setResizable(false);
	    getFrame().setVisible(true);
	    //pane.add(panel1);
	    
	    
	    //frame.add(panel1,BorderLayout.CENTER);
	    //frame.pack();
	    
	}

	public CalendarPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(CalendarPanel panel1) {
		this.panel1 = panel1;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public AddEventPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(AddEventPanel panel2) {
		this.panel2 = panel2;
	}
}
