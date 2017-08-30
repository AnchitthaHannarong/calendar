package ku.calendar;

import java.awt.Color;
import java.awt.Component;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tblCalendarRenderer extends DefaultTableCellRenderer{
	private int realYear, realMonth, realDay, currentYear, currentMonth;
	public tblCalendarRenderer (int realYear, int realMonth, int realDay, int currentYear, int currentMonth){
		this.realDay = realDay;
		this.realMonth = realMonth;
		this.realYear = realYear;
		this.currentYear = currentYear;
		this.currentMonth = currentMonth;
	}
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        
        if ((value!=null)&&(value!=" ")&&(value!="00.00")&&(value!="01.00")&&(value!="02.00")&&(value!="03.00")&&(value!="04.00")
        		&&(value!="05.00")&&(value!="06.00")&&(value!="07.00")&&(value!="08.00")&&(value!="09.00")&&(value!="10.00")
        		&&(value!="11.00")&&(value!="12.00")&&(value!="13.00")&&(value!="14.00")&&(value!="15.00")&&(value!="16.00")
        		&&(value!="17.00")&&(value!="18.00")&&(value!="19.00")&&(value!="20.00")&&(value!="21.00")&&(value!="22.00")
        		&&(value!="23.00")){
        	
            setBackground(new Color(255, 220, 220));
        }
        else{
            setBackground(new Color(255, 255, 255));
        }
        
        setBorder(null);
        setForeground(Color.black);
        return this;
    }

}


