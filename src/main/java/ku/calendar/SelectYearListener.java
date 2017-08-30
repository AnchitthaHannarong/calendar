package ku.calendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class SelectYearListener implements ActionListener{
	private MainView view;

	public SelectYearListener(MainView view){
		this.view = view;
	}
    public void actionPerformed (ActionEvent e){
        if (this.view.cmbYear.getSelectedItem() != null){
        	String b = this.view.cmbYear.getSelectedItem().toString();
        	this.view.setCurrentYear(Integer.parseInt(b));
            view.refreshCalendar(this.view.getCurrentMonth(), this.view.getCurrentYear());
        }
    }
}


