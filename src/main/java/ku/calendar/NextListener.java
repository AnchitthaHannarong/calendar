package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class NextListener implements ActionListener{
	private MainView view;
	public NextListener(MainView view){
		this.view = view;
	}
    public void actionPerformed (ActionEvent e){
    	GregorianCalendar cal1 = new GregorianCalendar(this.view.getPanel1().getCurrentYear(), this.view.getPanel1().getCurrentMonth(), 1);
        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
        //System.out.println(this.view.getCurrentMonth());
        if (this.view.getPanel1().getCurrentMonth() == 11){ //Foward one year
        	this.view.getPanel1().setCurrentMonth(0);
            this.view.getPanel1().setCurrentYear(this.view.getPanel1().getCurrentYear()+1);
        }
        else{ //Foward one month
        	this.view.getPanel1().startDay += 7;
        	if(this.view.getPanel1().startDay>nod){
        		//System.out.println(nod);
        		this.view.getPanel1().startDay-=nod;
        		this.view.getPanel1().setCurrentMonth(this.view.getPanel1().getCurrentMonth()+1);
        	}
        }
        
        //for(int i=1;i<8;i++){
        	//for(int j=0;j<24;j++){
        		//System.out.println(this.view.tblCalendar.getValueAt(j, i));
        		//this.view.getPanel1().addEvent(i , j);
        	//}
        //}
        
        view.getPanel1().refreshCalendar(this.view.getPanel1().getCurrentMonth(), this.view.getPanel1().getCurrentYear());
        
        for(int index = 0; index < view.getPanel1().meeting.size();index++){
        	for(int i=1;i<8;i++){
        		String[] days = view.getPanel1().tblCalendar.getColumnName(i).split(" / ");
            	if(view.getPanel1().meeting.get(index).getDay().equals(days[1])&&(view.getPanel1().meeting.get(index).getMonth().equals(days[2]))){
            		int j = Arrays.asList(view.getPanel1().times).indexOf(view.getPanel1().meeting.get(index).getStartTime());
            		
            		view.getPanel1().setEvent(i,j,index);
            	}
            }
        }
        

        
    }

}


