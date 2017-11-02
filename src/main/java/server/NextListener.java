package server;
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
    	GregorianCalendar cal1 = new GregorianCalendar(view.getPanel1().getCurrentYear(), view.getPanel1().getCurrentMonth(), 1);
        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
        //System.out.println(this.view.getCurrentMonth());
        if (view.getPanel1().getCurrentMonth() == 11){ //Foward one year
        	view.getPanel1().setCurrentMonth(0);
            view.getPanel1().setCurrentYear(view.getPanel1().getCurrentYear()+1);
        }
        else{ //Foward one month
        	view.getPanel1().startDay += 7;
        	if(view.getPanel1().startDay>nod){
        		//System.out.println(nod);
        		view.getPanel1().startDay-=nod;
        		view.getPanel1().setCurrentMonth(view.getPanel1().getCurrentMonth()+1);
        	}
        }
        
        //for(int i=1;i<8;i++){
        	//for(int j=0;j<24;j++){
        		//System.out.println(this.view.tblCalendar.getValueAt(j, i));
        		//this.view.getPanel1().addEvent(i , j);
        	//}
        //}
        
        view.getPanel1().refreshCalendar(view.getPanel1().getCurrentMonth(), view.getPanel1().getCurrentYear());
        
        for(int index = 0; index < view.getService().getMeeting().size();index++){
        	for(int i=1;i<8;i++){
        		String[] days = view.getPanel1().getTblCalendar().getColumnName(i).split(" / ");
            	if(view.getService().getMeeting().get(index).getDay().equals(days[1])&&(view.getService().getMeeting().get(index).getMonth().equals(days[2]))){
            		int j = Arrays.asList(view.getPanel1().getTimes()).indexOf(view.getService().getMeeting().get(index).getStartTime());
            		
            		view.getPanel1().setEvent(i,j,index);
            	}
            }
        }
        

        
    }

}


