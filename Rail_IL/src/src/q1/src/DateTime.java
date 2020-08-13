package src.q1.src;

import java.util.InputMismatchException;

public class DateTime {

	private int hour; // 00 to 23
	private int minutes;

	public DateTime(int hour, int minute) throws InputMismatchException {

		if (hour < 0 || hour > 23)
			throw new InputMismatchException("Invalid hour");
		this.hour = hour;
		if (minute < 0 || minute > 59)
			throw new InputMismatchException("Invalid minute");
		this.minutes = minute;
	}

	public int gethour() {
		return hour;
	}

	public int getminute() {
		return minutes;
	}

	public String toHourString() {
		StringBuilder s = new StringBuilder();
		if (hour < 10)
			s.append(0);
		s.append(this.hour);
		s.append(":");
		if (minutes < 10)
			s.append(0);
		s.append(this.minutes);
		return s.toString();
	}

	public boolean before(DateTime other) {
		if (this.hour < other.hour)
			return true;
		if (this.hour == other.hour) {
			if (this.minutes < other.minutes)
				return true;

		}
		return false;
	}

	public boolean after(DateTime other) {
		if (this.hour > other.hour)
			return true;
		if (this.hour == other.hour) {
			if (this.minutes > other.minutes)
				return true;

		}
		return false;
	}

	public String toString() {
		return toHourString();
	}

	public int compareTo(DateTime other) {
		return -1 * ((other.hour - this.hour) * 60) + ((other.minutes - this.minutes));
	}

}
