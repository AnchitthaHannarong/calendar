package ku.calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:eventcalendar.db";
			Connection conn = DriverManager.getConnection(dbURL);
			if(conn != null){
				String query = "Select * from eventcalendar";
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				
				while (resultSet.next()) {
					String day = resultSet.getString(1);
					int year = (int) resultSet.getFloat(2);
					String time = resultSet.getString(3);
					String meeting = resultSet.getString(4);
					
					view.meeting.add(new Date(day,year,time,meeting));
					
					//System.out.println(view.meeting);
					}
			}
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
