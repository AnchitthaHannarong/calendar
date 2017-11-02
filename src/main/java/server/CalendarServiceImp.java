package server;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import common.CalendarService;

public class CalendarServiceImp implements CalendarService{
	
	CopyOnWriteArrayList<Event> meeting;
	CalendarDataSource source;
	
	public CalendarServiceImp(CalendarDataSource source) {
		this.source = source;
		this.meeting = source.getAllRestaurants();
	}

	@Override
	public CopyOnWriteArrayList<Event> getMeeting() {
		return this.meeting;
	}

	@Override
	public void removeMeeting(Event y) {
		this.meeting.remove(y);
	}

}
