package server;

import java.util.concurrent.CopyOnWriteArrayList;

public interface CalendarDataSource {
	public CopyOnWriteArrayList<Event> getAllRestaurants() ;

}
