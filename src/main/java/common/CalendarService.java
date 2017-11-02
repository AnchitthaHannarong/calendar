package common;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

import server.Event;
import server.MainView;

public interface CalendarService extends Serializable{
	public CopyOnWriteArrayList<Event> getMeeting();
	public void removeMeeting(Event y);

}
