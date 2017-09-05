package ku.calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class NextListener implements ActionListener{
	private MainView view;
	public NextListener(MainView view){
		this.view = view;
	}
    public void actionPerformed (ActionEvent e){
    	GregorianCalendar cal1 = new GregorianCalendar(this.view.getCurrentYear(), this.view.getCurrentMonth(), 1);
        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
        //System.out.println(this.view.getCurrentMonth());
        if (this.view.getCurrentMonth() == 11){ //Foward one year
        	this.view.setCurrentMonth(0);
            this.view.setCurrentYear(this.view.getCurrentYear()+1);
        }
        else{ //Foward one month
        	this.view.startDay += 7;
        	if(this.view.startDay>nod){
        		//System.out.println(nod);
        		this.view.startDay-=nod;
        		this.view.setCurrentMonth(this.view.getCurrentMonth()+1);
        	}
        }
        
        for(int i=1;i<8;i++){
        	for(int j=1;j<24;j++){
        		//System.out.println(this.view.tblCalendar.getValueAt(j, i));
        		this.view.addEvent(i , j);
        	}
        }
        
        view.refreshCalendar(this.view.getCurrentMonth(), this.view.getCurrentYear());
        
        for(int i=1;i<8;i++){
        	for(int j=1;j<24;j++){
        		this.view.setEvent(i,j);
        		
        	}
        }
        System.out.println(this.view.meeting);
    }

}


