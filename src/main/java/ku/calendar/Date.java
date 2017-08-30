package ku.calendar;

public class Date {
	private String meeting,day,time; 
	private int year;
	
	public Date(String day,int year,String time,String meeting){
		this.setDay(day);
		this.setYear(year);
		this.setMeeting(meeting);
		this.setTime(time);
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMeeting() {
		return meeting;
	}

	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

}
