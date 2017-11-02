package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.CalendarService;

/**
	Anchittha Hannarong
	5810450491
*/
public class App {
	private static MainController main;
    public static void main( String[] args )
    {
    	ApplicationContext bf =
				new ClassPathXmlApplicationContext("event-client.xml");
    	CalendarService service = (CalendarService) bf.getBean("calenService");
    	setMain(new MainController(service));
        getMain().startApplication();
    }
	public static MainController getMain() {
		return main;
	}
	public static void setMain(MainController main) {
		App.main = main;
	}
}
