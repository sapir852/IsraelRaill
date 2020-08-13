package src.q1.src;

import java.util.ArrayList;
import java.util.Collections;

public class IsraelRail {

	private ArrayList<Ride> allRides;

	public IsraelRail() {
		allRides = new ArrayList<Ride>();
	}

	// public static String RideToString(Ride.RideType type) {
	// ArrayList<Ride> rides;
	// if (type == Ride.RideType.Arrival)
	// rides = arrivals;
	// else
	// rides = departures;

	// StringBuffer result = new StringBuffer();
	// for (Ride r : rides) {
	// result.append(r + "\n");
	// }

	// return result.toString();
	// }

	public boolean addRide(String fromLocation, DateTime departureTime, String toLocation, DateTime arrivalTime) {

		allRides.add(new Ride(fromLocation, departureTime, toLocation, arrivalTime));
		return true;
	}

	public String allRidesToString() {
		StringBuffer result = new StringBuffer();
		for (Ride r : allRides) {
			result.append(r.toString() + "\n");
		}

		return result.toString();
	}

	public void sortRidesByTime() {
		Collections.sort(allRides, new SortByTime());

	}

}
