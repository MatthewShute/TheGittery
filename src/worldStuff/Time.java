package worldStuff;

public class Time {

	private int centiseconds, seconds, minutes, hours, day, month, year;
	public int wait = 0;
	private double waitD = 0;

	public Time() {
		// Default constructor...
		centiseconds = 1; seconds = 55; minutes = 30; hours = 15; day = 7; month = 1; year = 1993;
	}
	
	public int getCentiseconds() {
		return centiseconds;
	}

	public void setCentiseconds(int centiseconds) {
		this.centiseconds = centiseconds;
		sortTime();
	}

	public void addCentiseconds(int centiseconds) {
		this.centiseconds += centiseconds;
		sortTime();
	}
	
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
		sortTime();
	}
	
	public void addSeconds(int seconds) {
		this.seconds += seconds;
		sortTime();
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
		sortTime();
	}
	
	public void addMinutes(int minutes) {
		this.minutes += minutes;
		sortTime();
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
		sortTime();
	}
	
	public void addHours(int hours) {
		this.hours += hours;
		sortTime();
	}
	
	public void nextHour() {
		hours++;
		sortTime();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
		sortTime();
	}
	
	public void nextDay() {
		day++;
		sortTime();
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
		sortTime();
	}
	
	public void nextMonth() {
		month++;
		sortTime();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void nextYear() {
		year++;
	}
	
	public void sortTime() {
		
		int xcsec, xsec, xmin, xhr, xday, xmon;
		
		if (centiseconds > 99) {
			xcsec = (centiseconds - 100);
			seconds++;
			centiseconds = xcsec;
		}
		if (seconds > 59) {
			xsec = (seconds - 60);
			minutes++;
			seconds = xsec;
		}		
		if (minutes > 59) {
			xmin = (minutes - 60);
			hours++;
			minutes = xmin;
		}	
		if (hours > 23) {
			xhr = (hours - 24);
			day++;
			hours = xhr;
		}	
		if (day > 28) {
			xday = (day - 28);
			month++;
			day = xday;
		}
		if (month > 12) {
			xmon = (month - 12);
			year++;
			month = xmon;
		}
		
	}
	
	public String getDayAsString() {
		
		String sDay = "";
		
		sortTime();
		
		if (day == 1 || day == 8 || day == 15 || day == 22) sDay = "Monday";
		if (day == 2 || day == 9 || day == 16 || day == 23) sDay = "Tuesday";
		if (day == 3 || day == 10 || day == 17 || day == 24) sDay = "Wednesday";	
		if (day == 4 || day == 11 || day == 18 || day == 25) sDay = "Thursday";	
		if (day == 5 || day == 12 || day == 19 || day == 26) sDay = "Friday";	
		if (day == 6 || day == 13 || day == 20 || day == 27) sDay = "Saturday";	
		if (day == 7 || day == 14 || day == 21 || day == 28) sDay = "Sunday";	
		
		return sDay;
	}
	
	public String getMonthAsString() {

		String sMonth = "";
		
		sortTime();
		
		if (month == 1) sMonth = "January";
		if (month == 2) sMonth = "Febuary";
		if (month == 3) sMonth = "March";
		if (month == 4) sMonth = "April";
		if (month == 5) sMonth = "May";
		if (month == 6) sMonth = "June";
		if (month == 7) sMonth = "July";
		if (month == 8) sMonth = "August";
		if (month == 9) sMonth = "September";
		if (month == 10) sMonth = "October";
		if (month == 11) sMonth = "November";
		if (month == 12) sMonth = "December";
		
		return sMonth;
	}
	
	public String getTimeAsString() {
		
		sortTime();
		
		int hrs = hours;
		String timeAsString = "",  ampm = "AM", houro = "", mino = "";
		
		if (hrs > 12) {
			hrs -= 12;
			ampm = "PM";
		}
		
		if (hrs < 10) houro = "0";
		if (minutes < 10) mino = "0";
		
		timeAsString = getDayAsString() + " - " + houro + hrs + ":" + mino + minutes + " " + ampm + ". " + day + " " + getMonthAsString() + ", " + year;
		
		return timeAsString;
	}
	
	public void plusWD() {
		waitD += 0.08;
		wait = (int) waitD;
		checkWait();
	}
	
	public void minusWD() {
		waitD -= 0.08;
		wait = (int) waitD;
		checkWait();
	}
	
	public void checkWait() {
		if (wait < 0) wait = 0;
		if (wait > 60) wait = 60;
		if (waitD < 0.0) waitD = 0.0;
		if (waitD > 60.0) waitD = 60.0;		
	}
	
	public void resetWait() {
		wait = 0; waitD = 0;
	}
	
}
