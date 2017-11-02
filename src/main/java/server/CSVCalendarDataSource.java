package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class CSVCalendarDataSource implements CalendarDataSource{
	private String filename; 

	public CSVCalendarDataSource(String filename) {
		this.filename = filename;
	}

	
	public CopyOnWriteArrayList<Event> getAllRestaurants() {
		CopyOnWriteArrayList<Event> meeting = new CopyOnWriteArrayList<Event> ();

		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));

			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String[] data = line.split(",");
				// data[0] = name, data[1] = address
				meeting.add(new Event(data[0], data[1],data[2],data[3],data[4], data[5]));	
			}
		} catch(FileNotFoundException e) {
			System.err.println("Event data file name is incorrect");
			System.exit(1);
		} catch(IOException e) {
			System.err.println("Problems reading restaurant data file");
			System.exit(1);
		}
		return meeting;
	}
}
