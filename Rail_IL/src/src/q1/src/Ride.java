package src.q1.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ride {

	// public enum RideType {
	// Departure, Arrival
	// };

	private String fromLocation;
	private String toLocation;
	// private RideType rideType; // false = Departure, true = Arrival
	private DateTime DepartureTime;
	private DateTime arrivalTime;

	public Ride(String fromLocation, DateTime departureTime, String toLocation, DateTime arrivalTime) {

		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		DepartureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public DateTime getDeparturetime() {
		return DepartureTime;
	}

	public void setDeparturetime(DateTime departuretime) {
		DepartureTime = departuretime;
	}

	public DateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(DateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	@Override
	public String toString() {
		return fromLocation + " " + DepartureTime + " , " + toLocation + " " + arrivalTime;
	}

}
