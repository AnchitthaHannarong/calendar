package ku.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveEvent {
	@Test
	public void test() {
		CalendarPanel view = new CalendarPanel();
		view.rander();
		Date date = new Date("30","8",2017,"03.00","04.00","eat with mom");
		view.meeting.add(date);
		System.out.println(view.meeting.get(0).getDay());
		System.out.println(view.meeting.get(0).getYear());
		System.out.println(view.meeting.get(0).getStartTime());
		System.out.println(view.meeting.get(0).getEndTime());
		System.out.println(view.meeting.get(0).getMeeting());
		view.meeting.remove(0);
		boolean test = view.meeting.contains(date);
		assertEquals(test,false);

	}

}
