

import java.util.Comparator;

public class SortByTime implements Comparator<Ride> {

	@Override
	public int compare(Ride r1, Ride r2) {
		return r1.getDeparturetime().compareTo(r2.getDeparturetime());
	}
}