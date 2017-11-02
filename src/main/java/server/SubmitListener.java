package server;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitListener implements ActionListener{
	private MainView view;
	public SubmitListener(MainView view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(view.getPanel2().getNoneRoutine().isSelected()){
			boolean check = false;
			// TODO Auto-generated method stub
			if(view.getService().getMeeting().size()==0){
				view.getService().getMeeting().add(new Event(view.getPanel2().getChoiceDay().getSelectedItem().toString(),view.getPanel2().getChoiceMonth().getSelectedItem().toString(),
						"2017",view.getPanel2().getChoiceStartTime().getSelectedItem().toString(),view.getPanel2().getChoiceEndTime().getSelectedItem().toString(),
						view.getPanel2().getEvent().getText()));
			}
			else{
				for(Event y:view.getService().getMeeting()){
					if((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(view.getPanel2().getChoiceMonth().getSelectedItem().toString()))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
						&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
						check = true;	
					}
					else if ((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(view.getPanel2().getChoiceMonth().getSelectedItem().toString()))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
							&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(!y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
						
						y.setMeeting(view.getPanel2().getEvent().getText());				
					}
				}

	  		if(check==false){
	  			view.getService().getMeeting().add(new Event(view.getPanel2().getChoiceDay().getSelectedItem().toString(),view.getPanel2().getChoiceMonth().getSelectedItem().toString(),
						"2017",view.getPanel2().getChoiceStartTime().getSelectedItem().toString(),view.getPanel2().getChoiceEndTime().getSelectedItem().toString(),
						view.getPanel2().getEvent().getText()));
	  		}
		}}
			
		else if(view.getPanel2().getDailyRoutine().isSelected()){
			int month = 0;
			for(int i = 1;i<13;i++){
				if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12)){
					month = 31;
				}
				else if((i==4)||(i==6)||(i==9)||(i==11)){
					month = 30;
				}
				else{
					if((view.getPanel1().currentYear%4==0)&&(view.getPanel1().currentYear%100==0)&&(view.getPanel1().currentYear%400==0)){
						month = 29;
					}
					else{
						month = 28;
					}
				}
				for(int j=1;j<=month;j++){
					boolean check = false;
					for(Event y:view.getService().getMeeting()){
						if((y.getDay().equals(Integer.toString(j)))&&(y.getMonth().equals(Integer.toString(j)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
							&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
							check = true;
						}
						else if ((y.getDay().equals(Integer.toString(j)))&&(y.getMonth().equals(Integer.toString(j)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
								&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(!y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
							
							y.setMeeting(view.getPanel2().getEvent().getText());				
						}
					}
					if(check == false){
						view.getService().getMeeting().add(new Event(Integer.toString(j),Integer.toString(i),
									"2017",view.getPanel2().getChoiceStartTime().getSelectedItem().toString(),view.getPanel2().getChoiceEndTime().getSelectedItem().toString(),
									view.getPanel2().getEvent().getText()));
						}
					}
				}
			}
		
		
		else if(view.getPanel2().getWeeklyRoutine().isSelected()){
			int totalMonth = 0;
			int month = (int) view.getPanel2().getChoiceMonth().getSelectedItem();
			for(int i = (int) view.getPanel2().getChoiceDay().getSelectedItem() ; month<13 ; i=i+7){
				if((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)){
					totalMonth = 31;
				}
				else if((month==4)||(month==6)||(month==9)||(month==11)){
					totalMonth = 30;
				}
				else{
					if((view.getPanel1().currentYear%4==0)&&(view.getPanel1().currentYear%100==0)&&(view.getPanel1().currentYear%400==0)){
						totalMonth = 29;
					}
					else{
						totalMonth = 28;
					}
				}
				if(i>totalMonth){
					i = i-totalMonth;
					month++;
				}
				
				boolean check = false;
				for(Event y:view.getService().getMeeting()){
					if((y.getDay().equals(Integer.toString(i)))&&(y.getMonth().equals(Integer.toString(month)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
							&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
						check = true;
					}
					else if ((y.getDay().equals(Integer.toString(i)))&&(y.getMonth().equals(Integer.toString(month)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
							&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(!y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
						
						y.setMeeting(view.getPanel2().getEvent().getText());				
					}
				}
				
				
				if(check == false){
					view.getService().getMeeting().add(new Event(Integer.toString(i),Integer.toString(month),
							"2017",view.getPanel2().getChoiceStartTime().getSelectedItem().toString(),view.getPanel2().getChoiceEndTime().getSelectedItem().toString(),
							view.getPanel2().getEvent().getText()));
					}
				}
			}
		
		
		else if(view.getPanel2().getMonthlyRoutine().isSelected()){
			boolean check = false;
			for(int i = 1;i<13;i++){
				for(Event y:view.getService().getMeeting()){
					if((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(Integer.toString(i)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
						&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
							check = true;
					}
				}
				if(check == false){
					view.getService().getMeeting().add(new Event(view.getPanel2().getChoiceDay().getSelectedItem().toString(),Integer.toString(i),
							"2017",view.getPanel2().getChoiceStartTime().getSelectedItem().toString(),view.getPanel2().getChoiceEndTime().getSelectedItem().toString(),
							view.getPanel2().getEvent().getText()));
				}
			}
		}
		
			
		
  		view.getPanel2().getFrame().remove(view.getPanel2());
  		//this.view.getPanel2().getFrame().add(this.view.getPanel2());
  		view.getPanel2().getFrame().setVisible(false);
 
  		
			
		
		
	}

}
