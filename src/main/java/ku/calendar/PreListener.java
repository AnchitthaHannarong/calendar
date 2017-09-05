package ku.calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class PreListener implements ActionListener{
	private MainView view;
	public PreListener(MainView view){
		this.view = view;
		}
	
    public void actionPerformed (ActionEvent e){
    	GregorianCalendar cal1 = new GregorianCalendar(this.view.getCurrentYear(), this.view.getCurrentMonth(), 1);
        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
        if (this.view.getCurrentMonth() == 11){ 
        	this.view.setCurrentMonth(0);
            this.view.setCurrentYear(this.view.getCurrentYear()-1);
        }
        else{ //Back one month
        	this.view.startDay -= 7;
        	//System.out.println(this.view.startDay);
        	if(this.view.startDay<1){
        		//System.out.println(nod);
        		this.view.setCurrentMonth(this.view.getCurrentMonth()-1);
        		GregorianCalendar cal2 = new GregorianCalendar(this.view.getCurrentYear(), this.view.getCurrentMonth(), 1);
                int nod1 = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        		this.view.startDay+=nod1;
        		//System.out.println(this.view.startDay);
        	}
        	//System.out.println(startDay);
        }
        
        
        for(int i=1;i<8;i++){
        	for(int j=1;j<24;j++){
        		//System.out.println(this.view.tblCalendar.getValueAt(j, i));
                this.view.addEvent(i , j);

        	}
        }
        //System.out.println(this.view.meeting);
        
        view.refreshCalendar(this.view.getCurrentMonth(), this.view.getCurrentYear());
        
        for(int i=1;i<8;i++){
        	for(int j=1;j<24;j++){
        		this.view.setEvent(i,j);
        	}
        }
    }
}


