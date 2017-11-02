package server;
/**
Anchittha Hannarong
5810450491
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener{
	private MainView view;
	public DeleteListener(MainView view){
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(view.getPanel2().getNoneRoutine().isSelected()){
			for(Event y:view.getService().getMeeting()){
				if((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(view.getPanel2().getChoiceMonth().getSelectedItem().toString()))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
					&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
					view.getService().removeMeeting(y);				
					}
			}

		}
		
		else if(view.getPanel2().getDailyRoutine().isSelected()){
			for(Event y:view.getService().getMeeting()){
				if((y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
					view.getService().removeMeeting(y);	
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
			for(Event y:view.getService().getMeeting()){
				if((y.getDay().equals(Integer.toString(i)))&&(y.getMonth().equals(Integer.toString(month)))&&(y.getYear()==Integer.toString(view.getPanel1().getCurrentYear()))
					&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))){
					view.getService().removeMeeting(y);	
				}
			}
		}
	}
	
	else if(view.getPanel2().getMonthlyRoutine().isSelected()){
		for(Event y:view.getService().getMeeting()){
			if((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))
				&&(y.getStartTime().equals(view.getPanel2().getChoiceStartTime().getSelectedItem()))&&(y.getEndTime().equals(view.getPanel2().getChoiceEndTime().getSelectedItem().toString()))&&(y.getMeeting().equals(view.getPanel2().getEvent().getText()))){
				view.getService().removeMeeting(y);	
			}
		}
	}
	
	
	
		view.getPanel2().getFrame().remove(view.getPanel2());
		//this.view.getPanel2().getFrame().add(this.view.getPanel2());
		view.getPanel2().getFrame().setVisible(false);
	}


}
