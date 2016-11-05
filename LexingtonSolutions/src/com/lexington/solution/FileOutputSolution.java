/**
 * This Program Reads data from file and generates 3 sorted lists
 * 1. Based on Gender then by Last Name
 * 2. Based on BirthDate
 * 3. Based on Last Name in descending
 * 
 * @author Avinash KB
 * @Since  11/02/2016
 */

package com.lexington.solution;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.lexington.businesslogic.BusinessLogic;
import com.lexington.model.PersonDetails;

/**
 * This class reads <code>data from file</code> and
 * <code>Sorts the data</code> and writes
 * <code> the code to txt file</code>
 */
public class FileOutputSolution {

	public static void main(String[] args) throws ParseException, IOException {
		File file = new File("output.txt");
		checkFile(file);
	}

/**
 * Creates a new file and writes the processed data to it
 * @param file <code>containing file name</code>
 * @throws IOException
 */
	static void checkFile(File file) throws IOException {
		// creates the file
		file.createNewFile();

		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file);

		for (int i = 1; i <= 3; i++) {
			System.out.println("Output " + i + ":");
			output("Output " + i, writer);
			System.out.println();
		}
		writer.close();

	}

	
	/**
	 * Creates an ArrayList of PeronsDetails and Prints the sorted list
	 *  to console as well to output file
	 * @param output
	 * @param writer
	 */
	static void output(String output, FileWriter writer) {
		BusinessLogic logic = new BusinessLogic();
		List<PersonDetails> personDetailsList = new ArrayList<PersonDetails>();
		final File folder = new File("input_files");
		logic.listFilesForFolder(folder, personDetailsList);

		// Sort ArrayList
		logic.sortList(personDetailsList, output);

		// Generate Output File
		logic.generateOutputFile(personDetailsList, writer, output);

		// print results
		for (PersonDetails person : personDetailsList) {
			System.out.print(" " + person.getLastName());
			System.out.print(" " + person.getFirstName());
			System.out.print(" " + person.getGender());
			System.out.print(" " + person.getColor());
			System.out.print(" " + person.getDateOfBirth());
			System.out.println();
		}
	}

}
