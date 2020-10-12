

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IsraelRail {

	private ArrayList<Ride> allRides;
	

	public IsraelRail() {
		allRides = new ArrayList<Ride>();
		
	}
	
	public IsraelRail(File file) throws FileNotFoundException
	{
		this();
		Scanner scan = new Scanner(file);
		int numRides = Integer.parseInt(scan.nextLine());
		for(int i= 0;i <numRides; i++)
		{
			allRides.add(new Ride(scan));
		}
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
	
	public void saveToFile(File file) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(file);
		pw.write(allRides.size() + "\n");
		for(Ride ride : allRides)
		{
			ride.saveToFile(pw);
		}
		pw.close();
	}
	
}
