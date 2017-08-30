package ku.calendar;

import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainController{
	private MainView view;
	public void startApplication(){
		setView(new MainView());
		getView().rander();

		getView().getbtnNext().addActionListener(new NextListener(getView()));
		getView().getbtnPrev().addActionListener(new PreListener(getView()));
		getView().cmbYear.addActionListener(new SelectYearListener(getView()));
    
  }
	public MainView getView() {
		return view;
	}
	public void setView(MainView view) {
		this.view = view;
	}
}
