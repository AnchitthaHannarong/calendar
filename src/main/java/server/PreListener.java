package server;
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
    	// TODO Auto-generated method stub
    			GregorianCalendar cal1 = new GregorianCalendar(view.getPanel1().getCurrentYear(), view.getPanel1().getCurrentMonth(), 1);
    	        int nod = cal1.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	        int som = cal1.get(GregorianCalendar.DAY_OF_WEEK);
    	        if (view.getPanel1().getCurrentMonth() == 11){ 
    	        	view.getPanel1().setCurrentMonth(0);
    	            view.getPanel1().setCurrentYear(view.getPanel1().getCurrentYear()-1);
    	        }
    	        else{ //Back one month
    	        	view.getPanel1().startDay -= 7;
    	        	//System.out.println(this.view.startDay);
    	        	if(view.getPanel1().startDay<1){
    	        		//System.out.println(nod);
    	        		view.getPanel1().setCurrentMonth(view.getPanel1().getCurrentMonth()-1);
    	        		GregorianCalendar cal2 = new GregorianCalendar(view.getPanel1().getCurrentYear(), view.getPanel1().getCurrentMonth(), 1);
    	                int nod1 = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    	        		view.getPanel1().startDay+=nod1;
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
    	        
    	        view.getPanel1().refreshCalendar(view.getPanel1().getCurrentMonth(), view.getPanel1().getCurrentYear());
    	        
    	        for(int index = 0; index < view.getService().getMeeting().size();index++){
    	        	for(int i=1;i<8;i++){
    	        		//System.out.println(view.getPanel1().tblCalendar.getColumnName(i));
    	        		String[] days = view.getPanel1().getTblCalendar().getColumnName(i).split(" / ");
    	            	if(view.getService().getMeeting().get(index).getDay().equals(days[1])&&(view.getService().getMeeting().get(index).getMonth().equals(days[2]))){
    	            		int j = Arrays.asList(view.getPanel1().getTimes()).indexOf(view.getService().getMeeting().get(index).getStartTime());
    	            	
    	            		view.getPanel1().setEvent(i,j,index);
    	            	}
    	            }
    	        }
    	
    	

    }
}


