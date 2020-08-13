package src.q1.src;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice;
		Scanner s = new Scanner(System.in);

		IsraelRail r = new IsraelRail();

		do {
			System.out.println("Please select an option:\r\n" + "1 - Travel details\r\n" + "2 - View Travel details\r\n"
					+ "9 - Exit");
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			switch (choice) {
			case 1:
				addNewRide(s, r);
				break;
			case 2:
				r.sortRidesByTime();
				System.out.println(r.allRidesToString());

				break;

			}

		}

		while (choice != 9);

	}

	private static void addNewRide(Scanner s, IsraelRail r) {

		s.nextLine();
		System.out.println("\nPlease enter departure station: ");
		String fromLocation = s.nextLine();

		DateTime dTime = getDateFromUser(s);
		s.nextLine();
		System.out.println("Please enter arrival station: ");
		String toLocation = s.nextLine();
		DateTime aTime = getDateFromUser(s);

		r.addRide(fromLocation, dTime, toLocation, aTime);

	}

	public static DateTime getDateFromUser(Scanner s) {

		System.out.println("Please enter time (hours and minutes) in format xx:xx");
		String[] timeInDay = s.next().split(":");
		int hours = Integer.parseInt(timeInDay[0]);
		int minutes = Integer.parseInt(timeInDay[1]);

		return new DateTime(hours, minutes);
	}
}
