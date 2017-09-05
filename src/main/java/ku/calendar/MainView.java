package ku.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//import test.CalendarProgram.btnNext_Action;
//import test.CalendarProgram.btnPrev_Action;
//import test.CalendarProgram.cmbYear_Action;

public class MainView
{
  private JFrame frame;
  static JLabel lblMonth, lblYear;
  static JButton btnPrev, btnNext;
  static JTable tblCalendar;
  static JComboBox cmbYear;
  static Container pane;
  static DefaultTableModel mtblCalendar;
  static JScrollPane stblCalendar; 
  static JPanel pnlCalendar;
  static JPanel panel;
  static JTextArea day;
  static int realYear, realMonth, realDay, currentYear, currentMonth, startDay;
  static JTableHeader header;
  static int nod, som; //Number Of Days, Start Of Month
  static ArrayList<Date> meeting;
  
  public MainView() {
    this.frame = new JFrame();
    lblYear = new JLabel ("Change year:");
    cmbYear = new JComboBox();
    btnPrev = new JButton ("<<");
    btnNext = new JButton (">>");
    meeting = new ArrayList<Date>();
    mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return true;}};
    tblCalendar = new JTable(mtblCalendar);
    stblCalendar = new JScrollPane(tblCalendar);
    pnlCalendar = new JPanel(null);
    }
  
  public void rander(){
	  //System.out.println(meeting);
      frame.setSize(1000, 375);
      pane = frame.getContentPane();
      pane.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      pane.add(pnlCalendar);
      pnlCalendar.add(lblYear);
      pnlCalendar.add(cmbYear);
      pnlCalendar.add(btnPrev);
      pnlCalendar.add(btnNext);
      pnlCalendar.add(stblCalendar);
      
      pnlCalendar.setBounds(0, 0, 1000, 335);
      lblYear.setBounds(10, 305, 80, 20);
      cmbYear.setBounds(230, 305, 80, 20);
      btnPrev.setBounds(10, 25, 50, 25);
      btnNext.setBounds(930, 25, 50, 25);
      stblCalendar.setBounds(10, 50, 970, 250);
      
      frame.setResizable(false);
      frame.setVisible(true);
      
      //Get real month/year
      GregorianCalendar cal = new GregorianCalendar();
      realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); 
      realMonth = cal.get(GregorianCalendar.MONTH); 
      realYear = cal.get(GregorianCalendar.YEAR); 
      
      
      
      currentMonth = realMonth;
      currentYear = realYear;
      
      String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      GregorianCalendar cal1 = new GregorianCalendar(realYear, realMonth, 1);
      nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
      som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
      
      String[] headers = new String[8]; //All headers
      int column1  =  (realDay+som-2)%7;
      if(column1!=0){
    	  startDay = realDay-column1;
      }
      int column = 0;
      int newcurrentMonth = currentMonth;
      for (int i=startDay; column<6; i++){
    	  if(i>nod){
    		  i=1;
    		  newcurrentMonth = currentMonth + 1;
    		  GregorianCalendar cal2 = new GregorianCalendar(realYear, newcurrentMonth, 1);
    	      nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	      som = cal2.get(GregorianCalendar.DAY_OF_WEEK);
    	      int row1 = new Integer((i+som-2)/7);
        	  column  =  (i+som-2)%7;
        	  headers[column+1] = days[column]+" / "+Integer.toString(i)+" / "+Integer.toString(newcurrentMonth+1);
    	  }
    	  else if(currentMonth>realMonth){
    		  GregorianCalendar cal2 = new GregorianCalendar(realYear, newcurrentMonth, 1);
    	      nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	      som = cal2.get(GregorianCalendar.DAY_OF_WEEK);
    	      int row1 = new Integer((i+som-2)/7);
        	  column  =  (i+som-2)%7;
        	  headers[column+1] = days[column]+" / "+Integer.toString(i)+" / "+Integer.toString(newcurrentMonth+1);
    	  }
    	  else{
    		  int row1 = new Integer((i+som-2)/7);
        	  column  =  (i+som-2)%7;
        	  headers[column+1] = days[column]+" / "+Integer.toString(i)+" / "+Integer.toString(newcurrentMonth+1);
    	  }
      
      }
      
      for (int i=0; i<8; i++){
    	  mtblCalendar.addColumn(headers[i]);
      }
      
      tblCalendar.getParent().setBackground(tblCalendar.getBackground());
      
      tblCalendar.getTableHeader().setResizingAllowed(false);
      tblCalendar.getTableHeader().setReorderingAllowed(false);
      
      tblCalendar.setColumnSelectionAllowed(true);
      tblCalendar.setRowSelectionAllowed(true);
      tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      //Set row/column count
      tblCalendar.setRowHeight(38);
      mtblCalendar.setColumnCount(8);
      mtblCalendar.setRowCount(24);
      
    //Add time
      String[] times = {"00.00","01.00","02.00","03.00","04.00","05.00", "06.00", "07.00", "08.00", "09.00", 
    		  "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00", "19.00",
    		 "20.00", "21.00", "22.00", "23.00"}; 
      for (int i=0; i<24; i++){
    	  mtblCalendar.setValueAt(times[i],i,0);
      }
      
      //Populate table
      for (int i=realYear-100; i<=realYear+100; i++){
          cmbYear.addItem(String.valueOf(i));
      }
      if(meeting.size()!=0){
    	  for(int i=1;i<8;i++){
    		  for(int j=1;j<24;j++){
    			  setEvent(i,j);
    			  }
    		  }
    	  }
      }
  public static void refreshCalendar(int month, int year){
	  String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
     
      
      GregorianCalendar cal2 = new GregorianCalendar(currentYear, currentMonth, 1);
      nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
      som = cal2.get(GregorianCalendar.DAY_OF_WEEK);
      
      //Allow/disallow buttons
      btnPrev.setEnabled(true);
      btnNext.setEnabled(true);
      if (month == 0 && year <= realYear-10){
    	  btnPrev.setEnabled(false);
    	  } //Too early
      if (month == 11 && year >= realYear+100){
    	  btnNext.setEnabled(false);
    	  } //Too late
    
      cmbYear.setSelectedItem(String.valueOf(year)); 

      String[] headers = new String[8]; 
      int column = 0;
      for (int i=startDay; column<7; i++){
    	  if(i>nod){
    		  int day = i - nod ;
    		  headers[column+1] = days[column]+" / "+Integer.toString(day)+" / "+Integer.toString(currentMonth+2);
    	  }
    	  else if(i<1){
    		  int day = i + nod ;
    		  headers[column+1] = days[column]+" / "+Integer.toString(day)+" / "+Integer.toString(currentMonth-1);
    	  }
    	  else{
    		  headers[column+1] = days[column]+" / "+Integer.toString(i)+" / "+Integer.toString(currentMonth+1);
    	  }
    	  column++;
      }
      mtblCalendar.setColumnIdentifiers(headers);
      
      
      //Clear table
      for (int i=1; i<8; i++){
          for (int j=1; j<24; j++){
              mtblCalendar.setValueAt(null, j, i);
          }
      }

      //Apply renderers
      tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer(realYear,realMonth,realDay,currentYear,currentMonth));
  }
  
  public void setEvent(int i,int j){
	  for(int z=0;z<meeting.size();z++){
		  //System.out.println(meeting.get(z).getMeeting());
		  deleteEvent(z);
	  }
	  
	  for(int z=0;z<meeting.size();z++){
			if((meeting.get(z).getDay().equals(tblCalendar.getColumnName(i)))&&(meeting.get(z).getYear()==getCurrentYear())
					&&(meeting.get(z).getTime().equals(tblCalendar.getValueAt(j, 0).toString()))){
				tblCalendar.setValueAt(meeting.get(z).getMeeting(), j, i);
				
			}
		}
  }
  
  public void deleteEvent(int z){
	  if(meeting.get(z).getMeeting().equals("")){
		  meeting.remove(z);	  
	  }
  }
  
  public void addEvent(int i , int j){
	  if((tblCalendar.getValueAt(j, i)!=null)){
			boolean check = false;
			if(meeting.size()==0){
				meeting.add(new Date(tblCalendar.getColumnName(i)
          			,getCurrentYear(),tblCalendar.getValueAt(j, 0).toString(),tblCalendar.getValueAt(j, i).toString()));
			}
			else{
				for(Date y:meeting){
					
      			//System.out.println((!y.getDay().equals(this.view.tblCalendar.getColumnName(i)))&&(y.getYear()!=this.view.getCurrentYear()));
					if((y.getDay().equals(tblCalendar.getColumnName(i)))&&(y.getYear()==getCurrentYear())
    					&&(y.getTime().equals(tblCalendar.getValueAt(j, 0).toString()))&&(y.getMeeting().equals(tblCalendar.getValueAt(j, i)))){
						check = true;	
					}
					else if ((y.getDay().equals(tblCalendar.getColumnName(i)))&&(y.getYear()==getCurrentYear())
    					&&(y.getTime().equals(tblCalendar.getValueAt(j, 0).toString()))&&(!y.getMeeting().equals(tblCalendar.getValueAt(j, i)))){
						
					y.setMeeting(tblCalendar.getValueAt(j, i).toString());				
					}
				}

      		if(check==false){
      			meeting.add(new Date(tblCalendar.getColumnName(i)
              			,getCurrentYear(),tblCalendar.getValueAt(j, 0).toString(),tblCalendar.getValueAt(j, i).toString()));
      		}
				
			}
		}
  }
  
  public JFrame getFrame()
  {
    return this.frame;
  }
  
  public void setFrame(JFrame frame)
  {
    this.frame = frame;
  }
  
  public JButton getbtnNext()
  {
    return this.btnNext;
  }
  public JButton getbtnPrev()
  {
    return this.btnPrev;
  }
  public int getRealMonth() {
		return realMonth;
	}
	public void setRealMonth(int realMonth) {
		this.realMonth = realMonth;
	}
	public int getRealYear() {
		return realYear;
	}
	public void setRealYear(int realYear) {
		this.realYear = realYear;
	}
	public int getCurrentMonth() {
		return currentMonth;
	}
	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}
	public int getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
  
}