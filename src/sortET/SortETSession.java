package sortET;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import profiles.Schedule;
import profiles.Profile;

public class SortETSession {

	private Schedule myFoundationalSchedule;
	private List<Profile> profiles;
	private List<Point> mySessionTimes;

	public SortETSession(Schedule theFoundationalSchedule, List<Profile> theProfiles,
			List<Point> theSessionTimes) {
		super();
		this.myFoundationalSchedule = theFoundationalSchedule;
		this.profiles = theProfiles;
		this.mySessionTimes = theSessionTimes;
	}

	public void start() {

		List<Integer> finalSchedule = new ArrayList<Integer>();

		// Calculate the max value
		int V[] = new int[mySessionTimes.size()];
		V[0] = 0;
		for (int i = 1; i < mySessionTimes.size(); i++) {
			V[i] = Math.max((1 + V[rightMostInterval(i)]), V[i - 1]);
		}

		// Find start room
		int i = V.length;
		while (V[i] == V[i - 1]) {
			i--;
		}
		finalSchedule.add(i);

		// Find all rooms connected with the starting room
		while (0 != rightMostInterval(i)) {
			finalSchedule.add(rightMostInterval(i));
			i = rightMostInterval(i);
		}

		System.out.println("DONE");
		System.out.println(finalSchedule.toString());
	}

	/**
	 * First calculate P(i) for each index by counting the index of the
	 * rightmost that end before the current interval starts.
	 * 
	 * @param theCurrentIndex
	 * @return
	 */
	private int rightMostInterval(int theCurrentIndex) {
		int rightInterval = 0;
		for (int i = theCurrentIndex - 1; i >= 0; i++) {
			if (mySessionTimes.get(i).getY() < mySessionTimes.get(theCurrentIndex).getX()) {
				rightInterval = i;
				break;
			}
		}
		return rightInterval;
	}

}
