package ku.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import client.CalendarPanel;
import server.Event;

public class RemoveEvent {
	@Test
	public void test() {
		CalendarPanel view = new CalendarPanel();
		view.rander();
		Event date = new Event("30","8",2017,"03.00","04.00","eat with mom");
		view.getMeeting().add(date);
		System.out.println(view.getMeeting().get(0).getDay());
		System.out.println(view.getMeeting().get(0).getYear());
		System.out.println(view.getMeeting().get(0).getStartTime());
		System.out.println(view.getMeeting().get(0).getEndTime());
		System.out.println(view.getMeeting().get(0).getMeeting());
		view.getMeeting().remove(0);
		boolean test = view.getMeeting().contains(date);
		assertEquals(test,false);

	}

}
