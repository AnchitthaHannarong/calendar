package ku.calendar;
/**
Anchittha Hannarong
5810450491
*/
public class Date {
	private String meeting,day,startTime,month,endTime; 
	private int year;
	
	public Date(String day,String month,int year,String startTime,String endTime,String meeting){
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
		this.setMeeting(meeting);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}
	
	public int spaceTime(){
		float spaceTime = 0;
		spaceTime = Float.parseFloat(endTime)-Float.parseFloat(startTime);
		return Math.round(spaceTime);
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getMeeting() {
		return meeting;
	}

	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
