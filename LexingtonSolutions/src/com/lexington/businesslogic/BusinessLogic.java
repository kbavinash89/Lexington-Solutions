package com.lexington.businesslogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lexington.model.PersonDetails;

/**
 * This Class formats <code>Output File</code> 
 * Adds details<code> to PersonDetails Class</code>
 * Sorts ArrayList Based on 
 * 1. Based on Gender then by Last Name
 * 2. Based on BirthDate
 * 3. Based on Last Name in descending
 * 
 * @author Avinash
 */

public class BusinessLogic {
	
	//Generate the file and write the data to file
	public void generateOutputFile(List<PersonDetails> personDetailsList, FileWriter writer, String output) {
		try {
			writer.write(output);
			writer.write(":");
			writer.write(System.lineSeparator());
			for (PersonDetails person : personDetailsList) {
				writer.write(person.getLastName());
				writer.write(" ");
				writer.write(person.getFirstName());
				writer.write(" ");
				writer.write(person.getGender());
				writer.write(" ");
				writer.write(person.getDateOfBirth());
				writer.write(" ");
				writer.write(person.getColor());
				writer.write(System.lineSeparator());

			}
			writer.write(System.lineSeparator());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This class adds details to PersonDetals Class obtained from the files
	 * @param folder
	 * @param personDetailsList
	 */
	public void listFilesForFolder(final File folder, List<PersonDetails> personDetailsList) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry, personDetailsList);
			} else {
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()));
					String currentLine;

					while ((currentLine = reader.readLine()) != null) {
						PersonDetails person = new PersonDetails();
						if (fileEntry.getName().equalsIgnoreCase("comma.txt")) {
							String[] words = currentLine.split(",");
							person.setLastName(words[0].trim());
							person.setFirstName(words[1].trim());
							person.setGender(words[2].trim());
							person.setColor(words[3].trim());
							person.setDateOfBirth(words[4].trim());
						} else if (fileEntry.getName().equalsIgnoreCase("space.txt")) {
							String gender;
							String[] words = currentLine.split(" ");
							if (words[3].trim().equalsIgnoreCase("F")) {
								gender = "Female";
							} else {
								gender = "Male";
							}
							person.setLastName(words[0].trim());
							person.setFirstName(words[1].trim());
							person.setInitial(words[2].trim());
							person.setGender(gender);
							person.setDateOfBirth(words[4].replace('-', '/').trim());
							person.setColor(words[5].trim());

						} else {
							String gender;
							String[] words = currentLine.split("\\|");

							if (words[3].trim().equalsIgnoreCase("F")) {
								gender = "Female";
							} else {
								gender = "Male";
							}
							person.setLastName(words[0].trim());
							person.setFirstName(words[1].trim());
							person.setInitial(words[2].trim());
							person.setGender(gender);
							person.setColor(words[4].trim());
							person.setDateOfBirth(words[5].replace('-', '/').trim());
						}
						personDetailsList.add(person);
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * Sorts the AttayList using Comparator Based on
	 * 1. Based on Gender then by Last Name
	 * 2. Based on BirthDate
	 * 3. Based on Last Name in descending
	 * @param personDetailsList
	 * @param output
	 */
	public void sortList(List<PersonDetails> personDetailsList, String output) {
		Collections.sort(personDetailsList, new Comparator<PersonDetails>() {

			public int compare(PersonDetails p1, PersonDetails p2) {
				if (output.equalsIgnoreCase("Output 1")) {
					int res = p1.getGender().compareToIgnoreCase(p2.getGender());
					if (res == 0) {
						return p1.getLastName().compareTo(p2.getLastName());
					} else {
						return res;
					}
				} else if (output.equalsIgnoreCase("Output 2")) {
					DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
					try {
						return date.parse(p1.getDateOfBirth()).compareTo(date.parse(p2.getDateOfBirth()));
					} catch (ParseException e) {
						throw new IllegalArgumentException(e);
					}
				} else {
					int res = p2.getLastName().compareToIgnoreCase(p1.getLastName());
					return res;
				}
			}

		});
	}
}
