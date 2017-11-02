package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener{
	private MainView view;

	public SearchListener(MainView view) {
		this.view = view;


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		view.getPanel2().getEvent().setText("");
		for(Event y:view.getService().getMeeting()){
			if((y.getDay().equals(view.getPanel2().getChoiceDay().getSelectedItem().toString()))&&(y.getMonth().equals(view.getPanel2().getChoiceMonth().getSelectedItem().toString()))){
				view.getPanel2().getEvent().append(y.getStartTime()+"-"+y.getEndTime()+": "+y.getMeeting()+"\n");

			}
		}
		
	}

}
