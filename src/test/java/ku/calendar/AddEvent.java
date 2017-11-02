package ku.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

import client.CalendarPanel;
import server.Event;

public class AddEvent {

	@Test
	public void test() {
		CalendarPanel view = new CalendarPanel();
		view.rander();
		view.getMeeting().add(new Event("30","8",2017,"03.00","04.00","eat with mom"));
		System.out.println(view.getMeeting().get(0).getDay());
		System.out.println(view.getMeeting().get(0).getYear());
		System.out.println(view.getMeeting().get(0).getStartTime());
		System.out.println(view.getMeeting().get(0).getEndTime());
		System.out.println(view.getMeeting().get(0).getMeeting());
		assertEquals(view.getMeeting().get(0).getDay(),"30");
		assertEquals(view.getMeeting().get(0).getMonth(),"8");
		assertEquals(view.getMeeting().get(0).getYear(),2017);
		assertEquals(view.getMeeting().get(0).getStartTime(),"03.00");
		assertEquals(view.getMeeting().get(0).getEndTime(),"04.00");
		assertEquals(view.getMeeting().get(0).getMeeting(),"eat with mom");
	}

}
