package src.q1.src;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.Collections;

public class IsraelRail {

	private ArrayList<Ride> allRides;
	

	public IsraelRail() {
		allRides = new ArrayList<Ride>();
		
	}

	public boolean addRide(String fromLocation, DateTime departureTime,ArrayList<IntermediateStation> intermSation, String toLocation, DateTime arrivalTime) {

		allRides.add(new Ride(fromLocation, departureTime,intermSation, toLocation, arrivalTime));
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
	public ArrayList<Ride> sortByThreeStation(String currentStation, String destenation, DateTime timeDeparture) {
		ArrayList<Ride> result = new ArrayList<Ride>();
		for(int i =0;i<allRides.size(); i++)
		{
			boolean fits = true;
			Ride ride = allRides.get(i);
			if(!currentStation.trim().isEmpty() && !ride.getFromLocation().equals(currentStation) && !ride.isIntermStation(currentStation))
			{
				fits = false;
			}
			if(!destenation.trim().isEmpty() && !ride.getToLocation().equals(destenation) && !ride.isIntermStation(destenation))
			{
				fits = false;
			}
			if(timeDeparture.compareTo(ride.getDeparturetime()) == 1)
			{
				fits = false;
			}
			if(fits)
			{
				result.add(ride);
			}
		}
		Collections.sort(result, new SortByTime());
		while(result.size()>3)
		{
			result.remove(result.size()-1);
		}
		return result;
		
	}
	
}
