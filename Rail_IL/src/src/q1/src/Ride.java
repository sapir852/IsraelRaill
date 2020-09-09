package src.q1.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ride {


	private String fromLocation;
	private String toLocation;
	private ArrayList<IntermediateStation>intermSation;
	private DateTime DepartureTime;
	private DateTime arrivalTime;
	
//	public Ride() {
//		
//	}
	public Ride() {
		intermSation = new ArrayList<IntermediateStation>();
		
	}
	

	public Ride(String fromLocation, DateTime departureTime,ArrayList<IntermediateStation>intermSation, String toLocation, DateTime arrivalTime) {

		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.intermSation = intermSation;
		DepartureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	
	public boolean addIntermediateStation(String name ,DateTime sTime) { 
		intermSation.add(new IntermediateStation(name, sTime));
		return true;
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
	
	public ArrayList<IntermediateStation> getIntermSation() {
		return intermSation;
	}


	public void setIntermSation(ArrayList<IntermediateStation> intermSation) {
		this.intermSation = intermSation;
	}


	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append(fromLocation + " " + DepartureTime +"\n");
		for (IntermediateStation i:intermSation) {
		     	result.append(i.toString() + "\n");
		}
		result.append( toLocation + " " + arrivalTime+"\n");
	
		return result.toString();
	}
	
	public boolean isIntermStation(String stationName)
	{
		for(IntermediateStation station : intermSation)
		{
			if(station.getName().equals(stationName))
			{
				return true;
			}
		}
		return false;
	}

	

}
