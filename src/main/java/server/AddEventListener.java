/**
 Anchittha Hannarong
 5810450491
*/
package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AddEventListener implements ActionListener{
	private MainView view;
	public AddEventListener(MainView view){
		this.view = view;

	}
    public void actionPerformed (ActionEvent e){
    	view.getPanel2().setShow(true);
    	view.getPanel2().rander();
    	//view.getPanel1().repaint();
    }

}
