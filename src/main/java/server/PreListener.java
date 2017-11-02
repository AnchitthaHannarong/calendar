package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class PreListener implements ActionListener{
	private MainView view;
	public PreListener(MainView view){
		this.view = view;
		}
	
    public void actionPerformed (ActionEvent e){
    	GregorianCalendar cal1 = new GregorianCalendar(this.view.getPanel1().getCurrentYear(), this.view.getPanel1().getCurrentMonth(), 1);
        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
        if (this.view.getPanel1().getCurrentMonth() == 11){ 
        	this.view.getPanel1().setCurrentMonth(0);
            this.view.getPanel1().setCurrentYear(this.view.getPanel1().getCurrentYear()-1);
        }
        else{ //Back one month
        	this.view.getPanel1().startDay -= 7;
        	//System.out.println(this.view.startDay);
        	if(this.view.getPanel1().startDay<1){
        		//System.out.println(nod);
        		this.view.getPanel1().setCurrentMonth(this.view.getPanel1().getCurrentMonth()-1);
        		GregorianCalendar cal2 = new GregorianCalendar(this.view.getPanel1().getCurrentYear(), this.view.getPanel1().getCurrentMonth(), 1);
                int nod1 = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        		this.view.getPanel1().startDay+=nod1;
        		//System.out.println(this.view.startDay);
        	}
        	//System.out.println(startDay);
        }
        
        
        //for(int i=1;i<8;i++){
        	//for(int j=0;j<24;j++){
        		////System.out.println(this.view.tblCalendar.getValueAt(j, i));
                //this.view.getPanel1().addEvent(i , j);

        	//}
        //}
        //System.out.println(this.view.meeting);
        
        view.getPanel1().refreshCalendar(this.view.getPanel1().getCurrentMonth(), this.view.getPanel1().getCurrentYear());
        
        for(int index = 0; index < view.getPanel1().meeting.size();index++){
        	for(int i=1;i<8;i++){
        		//System.out.println(view.getPanel1().tblCalendar.getColumnName(i));
        		String[] days = view.getPanel1().tblCalendar.getColumnName(i).split(" / ");
            	if(view.getPanel1().meeting.get(index).getDay().equals(days[1])&&(view.getPanel1().meeting.get(index).getMonth().equals(days[2]))){
            		int j = Arrays.asList(view.getPanel1().times).indexOf(view.getPanel1().meeting.get(index).getStartTime());
            	
            		view.getPanel1().setEvent(i,j,index);
            	}
            }
        }

    }
}


