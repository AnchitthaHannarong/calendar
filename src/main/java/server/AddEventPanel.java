/**
 Anchittha Hannarong
 5810450491
*/
package ku.calendar;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddEventPanel extends JPanel{
	  private JFrame frame;
	  private JTextArea event;
	  private JButton btnSubmit,btnDelete;
	  private JLabel day,month,startTime,endTime;
	  private JComboBox choiceDay,choiceMonth,choiceStartTime,choiceEndTime;
	  private JRadioButton noneRoutine,dailyRoutine,weeklyRoutine,monthlyRoutine;
	  private boolean show = false;
	 
	  
	  
	  public AddEventPanel() {
	        
		  setEvent(new JTextArea(5,30));
		  setBtnSubmit(new JButton("add"));
		  setBtnDelete(new JButton("delete"));
		  day = new JLabel("day");
		  setChoiceDay(new JComboBox());
		  setChoiceMonth(new JComboBox());
		  setChoiceStartTime(new JComboBox());
		  setChoiceEndTime(new JComboBox());
		  month = new JLabel("month");
		  startTime = new JLabel("startTime");
		  endTime = new JLabel("endTime");
		  setNoneRoutine(new JRadioButton("none"));
		  setDailyRoutine(new JRadioButton("daily"));
		  setWeeklyRoutine(new JRadioButton("weekly"));
		  setMonthlyRoutine(new JRadioButton("monthly"));
	    
	    
	    }
	  
	  public void rander(){
		  setFrame(new JFrame());
		  getFrame().setSize(400, 380);
	      getFrame().add(this);
	      frame.setVisible(isShow());
		  Box sizeBox = Box.createVerticalBox();
		  sizeBox.setBorder(BorderFactory.createTitledBorder("routinely"));
		  
		  Box sizeBox1 = Box.createVerticalBox();
		  sizeBox1.setBorder(BorderFactory.createTitledBorder("Event"));
		  
		  Box sizeBox2 = Box.createVerticalBox();
		  sizeBox2.setBorder(BorderFactory.createTitledBorder("Day"));
		  
		  for(int i = 1;i<=31;i++){
			  getChoiceDay().addItem(i);
		  }
		  
		  for(int i = 1;i<=12;i++){
			  getChoiceMonth().addItem(i);
		  }
		  
		  String[] times = {"00.00","01.00","02.00","03.00","04.00","05.00", "06.00", "07.00", "08.00", "09.00", 
	    		  "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00",
	    		 "20.00", "21.00", "22.00", "23.00"}; 
	      for (int i=0; i<24; i++){
	    	  getChoiceStartTime().addItem(times[i]);
	    	  getChoiceEndTime().addItem(times[i]);
	      }

		  
		  
		  
		  sizeBox1.add(getEvent());
		  
		  sizeBox2.add(day);
		  sizeBox2.add(getChoiceDay());
		  sizeBox2.add(month);
		  sizeBox2.add(getChoiceMonth());
		  sizeBox2.add(startTime);
		  sizeBox2.add(getChoiceStartTime());
		  sizeBox2.add(endTime);
		  sizeBox2.add(getChoiceEndTime());
		  
		  ButtonGroup group = new ButtonGroup();
		  group.add(getNoneRoutine());
		  group.add(getDailyRoutine());
		  group.add(getWeeklyRoutine());
		  group.add(getMonthlyRoutine());
		  
		  sizeBox.add(getNoneRoutine());
		  sizeBox.add(getDailyRoutine());
		  sizeBox.add(getWeeklyRoutine());
		  sizeBox.add(getMonthlyRoutine());
		  
		  
		  this.add(sizeBox1);
		  this.add(sizeBox2);
		  this.add(sizeBox);
		  this.add(getBtnSubmit());
		  this.add(getBtnDelete());
	  }

	public JComboBox getChoiceDay() {
		return choiceDay;
	}

	public void setChoiceDay(JComboBox choiceDay) {
		this.choiceDay = choiceDay;
	}

	public JComboBox getChoiceMonth() {
		return choiceMonth;
	}

	public void setChoiceMonth(JComboBox choiceMonth) {
		this.choiceMonth = choiceMonth;
	}

	public JComboBox getChoiceStartTime() {
		return choiceStartTime;
	}

	public void setChoiceStartTime(JComboBox choiceStartTime) {
		this.choiceStartTime = choiceStartTime;
	}

	public JComboBox getChoiceEndTime() {
		return choiceEndTime;
	}

	public void setChoiceEndTime(JComboBox choiceEndTime) {
		this.choiceEndTime = choiceEndTime;
	}

	public JTextArea getEvent() {
		return event;
	}

	public void setEvent(JTextArea event) {
		this.event = event;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public JRadioButton getNoneRoutine() {
		return noneRoutine;
	}

	public void setNoneRoutine(JRadioButton noneRoutine) {
		this.noneRoutine = noneRoutine;
	}

	public JRadioButton getDailyRoutine() {
		return dailyRoutine;
	}

	public void setDailyRoutine(JRadioButton dailyRoutine) {
		this.dailyRoutine = dailyRoutine;
	}

	public JRadioButton getWeeklyRoutine() {
		return weeklyRoutine;
	}

	public void setWeeklyRoutine(JRadioButton weeklyRoutine) {
		this.weeklyRoutine = weeklyRoutine;
	}

	public JRadioButton getMonthlyRoutine() {
		return monthlyRoutine;
	}

	public void setMonthlyRoutine(JRadioButton monthlyRoutine) {
		this.monthlyRoutine = monthlyRoutine;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
		

}
