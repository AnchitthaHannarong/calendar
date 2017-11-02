package server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
	public static void main(String[] args) throws Exception{
		ApplicationContext bf = new ClassPathXmlApplicationContext("event.xml");
		System.out.println("Server is ready.");
	}

}
