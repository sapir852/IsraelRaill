

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice;
		IsraelRail rail;
		try {
			rail = new IsraelRail(new File("Rides.txt"));
		} catch(Exception e)
		{
			rail = new IsraelRail();
		}
		Scanner s = new Scanner(System.in);
		if(args.length > 0)
		{
		    String outformat = args[0];
		    String source = args[1];
		    String destination = args[2];
		    int hour, minutes;
		    try {
			hour = Integer.parseInt(args[3]);
		    } catch(Exception e)
		    {
			hour = 0;
		    }
		    try {
			minutes = Integer.parseInt(args[4]);
		    } catch(Exception e)
		    {
			minutes = 0;
		    }
		    ArrayList<Ride> rideList = rail.sortByThreeStation(source, destination, new DateTime(hour, minutes));
		    for(Ride ride : rideList)
		    {
			System.out.print(ride.toString());
			if(outformat.equals("html"))
			{
			    System.out.print("<br>");
			}
			else
			{
			    System.out.println();
			}
		    }
		}
		else
		{
			do {
				System.out.println("Please select an option:\r\n" + "1 - Travel details\r\n" + "2 - View Travel details\r\n" +
			"3 - serach a ride \n " + "9 - Exit");
				System.out.println("Enter your choice: ");
				choice = s.nextInt();
				switch (choice) {
				case 1:
					addNewRide(s, rail);
					break;
				case 2:
					rail.sortRidesByTime();
					System.out.println(rail.allRidesToString());
					break;
				case 3:
					s.nextLine();
					System.out.println("please enter current Station: ");
					String currentStation = s.nextLine();
					System.out.println(" please enter destenation: ");
					String destenation = s.nextLine();
					DateTime timeDeparture = getDateFromUser(s);
					System.out.println(rail.sortByThreeStation(currentStation, destenation,timeDeparture));
					break;
				case 9:
					try {
						rail.saveToFile(new File("Rides.txt"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}

			}

			while (choice != 9);
		}

	}

	private static void addNewRide(Scanner s, IsraelRail rail) {
		Ride ride = new Ride();
		s.nextLine();
		System.out.println("\nPlease enter departure station: ");
		String fromLocation = s.nextLine();

		DateTime dTime = getDateFromUser(s);
		s.nextLine();
		System.out.println(
				"Please press 1- to add intermediate station \n" + "2- to finish typing intermediate station  ");
		int choice = s.nextInt();

		while (choice != 2) {
			s.nextLine();
			System.out.println("Please enter intermediate station :");
			String nameIntnermStasion = s.nextLine();
			DateTime sTime = getDateFromUser(s);
			ride.addIntermediateStation(nameIntnermStasion, sTime);
			System.out.println(
					"Please press 1- to add intermediate station \n" + "2- to finish typing intermediate station  ");
			choice = s.nextInt();
		}
		s.nextLine();
		System.out.println("Please enter arrival station: ");
		String toLocation = s.nextLine();
		DateTime aTime = getDateFromUser(s);

		rail.addRide(fromLocation, dTime, ride.getIntermSation(), toLocation, aTime);

	}

	public static DateTime getDateFromUser(Scanner s) {

		System.out.println("Please enter time (hours and minutes) in format xx:xx");
		String[] timeInDay = s.next().split(":");
		int hours = Integer.parseInt(timeInDay[0]);
		int minutes = Integer.parseInt(timeInDay[1]);

		return new DateTime(hours, minutes);
	}

}
