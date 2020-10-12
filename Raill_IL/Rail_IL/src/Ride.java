

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ride {


	private String fromLocation;
	private String toLocation;
	private ArrayList<IntermediateStation>intermStation;
	private DateTime DepartureTime;
	private DateTime arrivalTime;

	public Ride() {
		intermStation = new ArrayList<IntermediateStation>();
		
	}
	
	public Ride(Scanner scan) {
		this();
		fromLocation = scan.nextLine();
		toLocation  = scan.nextLine();
		int numStation = Integer.parseInt(scan.nextLine());
		for(int i =0; i < numStation ; i++)
		{
			intermStation.add(new IntermediateStation(scan));
		}
		DepartureTime = new DateTime(scan);
		arrivalTime = new DateTime(scan);
	}
	

	public Ride(String fromLocation, DateTime departureTime,ArrayList<IntermediateStation>intermSation, String toLocation, DateTime arrivalTime) {

		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.intermStation = intermSation;
		DepartureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	
	
	public boolean addIntermediateStation(String name ,DateTime sTime) { 
		intermStation.add(new IntermediateStation(name, sTime));
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
		return intermStation;
	}


	public void setIntermSation(ArrayList<IntermediateStation> intermSation) {
		this.intermStation = intermSation;
	}


	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append(fromLocation + " " + DepartureTime +"\n");
		for (IntermediateStation i:intermStation) {
		     	result.append(i.toString() + "\n");
		}
		result.append( toLocation + " " + arrivalTime+"\n");
	
		return result.toString();
	}
	
	public boolean isIntermStation(String stationName)
	{
		for(IntermediateStation station : intermStation)
		{
			if(station.getName().equals(stationName))
			{
				return true;
			}
		}
		return false;
	}
	
	public void saveToFile(PrintWriter file)
	{
		file.write(fromLocation+ "\n" + toLocation + "\n");
		file.write(intermStation.size() + "\n");
		for(IntermediateStation station: intermStation)
		{
			station.saveToFile(file);
		}
		DepartureTime.saveToFile(file);
		arrivalTime.saveToFile(file);
	}

	

}
