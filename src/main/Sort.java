package main;

import java.util.ArrayList;

import profiles.Profile;

public class Sort {

	public static int[][] countGeneralAvailablility(ArrayList<Profile> theProfiles) {

		int[][] masterSchedule = new int[Constants.GENERAL_ROW_SIZE][Constants.GENERAL_COLUMN_SIZE];
		
		for (Profile profile : theProfiles) {
			for (int row = 0; row < Constants.GENERAL_ROW_SIZE; row++) {
				for (int col = 0; col < Constants.GENERAL_COLUMN_SIZE; col++) {
//					if (0 == profile.getMySchedule()[row][col]){
//						masterSchedule[row][col]++;
//					}
				}
			}
		}//end for
		
		return masterSchedule;

	}

}
