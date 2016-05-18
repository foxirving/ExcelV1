package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import profiles.Profile;

public class FileIO {

	/**
	 * Converts Java Objects into XML.
	 */
	public static void marshaller(Profile thegeneralProfile) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Profile.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshal the employees list in console
		// jaxbMarshaller.marshal(thegeneralProfile, System.out);

		// Marshal the employees list in file
		jaxbMarshaller.marshal(thegeneralProfile, new File(Constants.XML_DEST + "/" + thegeneralProfile.getMyFirstName()
				+ thegeneralProfile.getMyLastName() + ".xml"));
	}

	/**
	 * Converts XML Objects into Java.
	 */
	public static void unmarshaller() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Profile.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		// We had written this file in marshalling example
		Profile prof = (Profile) jaxbUnmarshaller
				.unmarshal(new File(Constants.XML_DEST + "/employees.xml"));

		System.out.println("UNMARCHALLER");
		System.out.println(prof.getMyFirstName() + " " + prof.getMyLastName());
	}

	/**
	 * Gets the list of Excel files to be evaluated.
	 * 
	 * @param theDirectory
	 * @return
	 */
	public static List<String> listSourceFiles(String theDirectory) {
		// List of file names to be returned.
		List<String> fileNames = new ArrayList<>();

		// Create a path to the desired directory
		Path path = FileSystems.getDefault().getPath(theDirectory);

		// Opens a directory stream and adds files ending with ".xlsx" or ".xls"
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
			for (Path thisPath : directoryStream) {
				if (thisPath.toString().toLowerCase().endsWith(".xlsx")
						|| thisPath.toString().toLowerCase().endsWith(".xls")) {
					fileNames.add(thisPath.toString());
				}
			}
		} catch (IOException ex) {
		}
		return fileNames;
	}

	/**
	 * 
	 * 
	 * @param thePathArray
	 * @return
	 */
	public static ArrayList<Profile> sortExcelFiles(List<String> thePathArray) {

		// Our variable.
		ArrayList<Profile> profiles = new ArrayList<Profile>();

		// Sort each file given the path.
		for (String path : thePathArray) {
			sortExcelFile(path, profiles);
		}

		// Returns the list of profiles.
		return profiles;
	}

	/**
	 * 
	 * 
	 * @param thePath
	 * @param profiles
	 */
	public static void sortExcelFile(String thePath, ArrayList<Profile> theProfiles) {

		try {
			// Open a workbook from the file path given.
			Workbook workbook = Workbook.getWorkbook(new java.io.File(thePath));
			// initialize the profile given the workbook and add the result to
			// our out variable (theProfiles).
			theProfiles.add(initializeGeneralProfile(workbook));
			workbook.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param workbook
	 * @return
	 */
	public static Profile initializeGeneralProfile(Workbook theWorkbook) {

		// empty profile to be filled out and returned.
		Profile profile = new Profile();

		// Open the first sheet from the workbook given.
		Sheet sheet = theWorkbook.getSheet(0);

		// Get String values from the cells
		String firstName = sheet.getCell(1, 3).getContents();
		String lastName = sheet.getCell(2, 3).getContents();

		// 2D schedule meant to resemble the EXCEL schedule.
		int[][] schedule = new int[Constants.GENERAL_ROW_SIZE][Constants.GENERAL_COLUMN_SIZE];

		/*
		 * Iterate through the Excel file and set the values in the 2D array
		 * based on what is in the Excel cell. If the Cell is empty, the client
		 * is available - 0. If the Cell contains an "X", the client is
		 * unavailable - 1.
		 */

		int rowEnd = Constants.GENERAL_ROW_START + Constants.GENERAL_ROW_SIZE;
		int colEnd = Constants.GENERAL_COLUMN_START + Constants.GENERAL_COLUMN_SIZE;

		for (int row = Constants.GENERAL_ROW_START; row < rowEnd; row++) {
			for (int col = Constants.GENERAL_COLUMN_START; col < colEnd; col++) {

				String value = sheet.getCell(col, row).getContents().trim().toLowerCase();

				if ("x".equals(value)) {
					int setRow = row - Constants.GENERAL_ROW_START;
					int setCol = col - Constants.GENERAL_COLUMN_START;
					schedule[setRow][setCol] = Constants.UNAVAILABLE;
				}
			}
		}

		// for (int i = 0; i < schedule.length; i++) {
		// System.out.println(Arrays.toString(schedule[i]));
		// }

		// Sets the value in the profile.
		profile.setMyFirstName(firstName);
		profile.setMyLastName(lastName);
		//profile.setMySchedule(schedule.clone());

		return profile;
	}

	public static void writeMasterGeneralSchedule(int[][] theSchedule) {

		Workbook generalTemplateWorkbook = null;
		WritableWorkbook workbookCopy = null;
		try {
			generalTemplateWorkbook = Workbook.getWorkbook(new File(Constants.GENERAL_TEMPLATE_SRC));
			workbookCopy = Workbook.createWorkbook(new File(Constants.RESULTS_DEST + "/MasterSchedule.xls"),
					generalTemplateWorkbook);
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}

		WritableSheet sheetToEdit = workbookCopy.getSheet(0);

		int rowEnd = Constants.GENERAL_ROW_START + Constants.GENERAL_ROW_SIZE;
		int colEnd = Constants.GENERAL_COLUMN_START + Constants.GENERAL_COLUMN_SIZE;

		for (int row = Constants.GENERAL_ROW_START; row < rowEnd; row++) {
			for (int col = Constants.GENERAL_COLUMN_START; col < colEnd; col++) {

				int getRow = row - Constants.GENERAL_ROW_START;
				int getCol = col - Constants.GENERAL_COLUMN_START;

				String value = Integer.toString(theSchedule[getRow][getCol]);
				try {
					sheetToEdit.addCell(new Label(col, row, value));
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			workbookCopy.write();
			workbookCopy.close();
			generalTemplateWorkbook.close();
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
