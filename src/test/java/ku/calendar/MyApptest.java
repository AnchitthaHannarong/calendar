package ku.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyApptest {

	@Test
	public void test() {
		MainView view = new MainView();
		view.rander();
		view.meeting.add(new Date("Wed / 30 / 8",2017,"03.00","eat with mom"));
		System.out.println(view.meeting.get(0).getDay());
		System.out.println(view.meeting.get(0).getYear());
		System.out.println(view.meeting.get(0).getTime());
		System.out.println(view.meeting.get(0).getMeeting());
		assertEquals(view.meeting.get(0).getDay(),"Wed / 30 / 8");
		assertEquals(view.meeting.get(0).getYear(),2017);
		assertEquals(view.meeting.get(0).getTime(),"03.00");
		assertEquals(view.meeting.get(0).getMeeting(),"eat with mom");
	}

}
