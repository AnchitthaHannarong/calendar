package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainController{
	private MainView view;
	
	public MainController(){
		view = new MainView();
	}
	
	public void startApplication(){
		//setView(new CalendarPanel());
		
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
					String starttime = resultSet.getString(3);
					//System.out.println(starttime);
					String meeting = resultSet.getString(4);
					String month = resultSet.getString(5);
					String endtime = resultSet.getString(6);
					
					view.getPanel1().meeting.add(new Date(day,month,year,starttime,endtime,meeting));
					
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
		
		view.initFrame();

		view.getPanel1().getbtnNext().addActionListener(new NextListener(view));
		view.getPanel1().getbtnPrev().addActionListener(new PreListener(view));
		view.getPanel1().getBtnSubmit().addActionListener(new AddEventListener(view));
		view.getPanel2().getBtnSubmit().addActionListener(new SubmitListener(view));
		view.getPanel2().getBtnDelete().addActionListener(new DeleteListener(view));
		
    
  }
}
