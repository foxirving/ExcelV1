package main;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;

import profiles.Schedule;
import profiles.Profile;
import profiles.ETSchedule;

public class Main {

	public static void main(String[] args) {

		Profile prof1 = new Profile();
		prof1.setMyFirstName("Amy");
		prof1.setMyLastName("I");
		int arr[][] = { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		//Schedule schedule = new ETSchedule("Summer", "PUY", 3, 3, arr, 2);
		
		

		// List<String> list = FileIO.listSourceFiles(Constants.EXCEL_SCR);
		//
		// ArrayList<GeneralProfile> profiles = FileIO.sortExcelFiles(list);
		//
		// int[][] masterSchedule = Sort.countGeneralAvailablility(profiles);
		// FileIO.writeMasterGeneralSchedule(masterSchedule);
		//
		// for (GeneralProfile generalProfile : profiles) {
		// try {
		// FileIO.marshaller(generalProfile);
		// } catch (JAXBException e) {
		// e.printStackTrace();
		// }
		// }

	}

}
