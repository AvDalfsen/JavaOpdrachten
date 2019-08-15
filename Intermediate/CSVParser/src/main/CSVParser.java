package main;

import java.io.*;
import java.util.*;

public class CSVParser {
	ArrayList<String> dataSetString = new ArrayList<String>();
	ArrayList<Entry> dataSetCSV = new ArrayList<Entry>();
	
	public static void main(String[] args) {
		CSVParser csvParser = new CSVParser();
		csvParser.run();
	}
	
	void run() {
		try {
			fileReader();
			String columnInput = columnInput();
			String valueInput = valueInput();
			createEntries();
			findColumnIndex(columnInput, valueInput);
			csvWriter(dataSetString, dataSetCSV);
		}
		catch (IOException FileNotFound) {
			System.out.println("Something went wrong while finding or reading the file. Please ensure it exists and is accessible.");
		}
	}
	
	String columnInput() {
		System.out.println("Which column's values would you like to edit? The current available columns are: \n" + dataSetString.get(0));
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	String valueInput() {
		System.out.println("\nPlease enter what you would like to replace all values with: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	void fileReader() throws FileNotFoundException, IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\avdalfsen\\java-opdrachten\\Intermediate\\CSVParser\\src\\main\\csv-parser.csv")); //Eclipse refused to use a relative path even though it worked in the command prompt. Unsure why.
		String row;
		while ((row = csvReader.readLine()) != null) {
		    dataSetString.add(row);
		}
		csvReader.close();
	}
	
	void createEntries() {
		for (int i = 1; i < dataSetString.size(); i++) {
			String row = dataSetString.get(i);
			String[] values = row.split(",");
			Entry entry = new Entry();
			entry.setFirstName(values[0]);
			entry.setLastName(values[1]);
			entry.setAge(values[2]);
			entry.setCity(values[3]);
			entry.setEyeColour(values[4]);
			entry.setSpecies(values[5]);
			dataSetCSV.add(entry);
		}
	}
	
	void findColumnIndex(String columnInput, String valueInput) {
		int columnIndex = 0;
		String columns = dataSetString.get(0);
		String[] columnsSplit = columns.split(",");
		for(int i = 0; i < columnsSplit.length; i++) {
			if(columnsSplit[i].equalsIgnoreCase(columnInput)) {
				columnIndex = i + 1;
			}
		}
		if(columnIndex == 0) {
			System.out.println("\nThe provided input does not match any of the column names. \nThe input does not have to be case sensitive, but the characters do have to match. \nPlease try again.");
		}
		else {
			editEntries(columnIndex, valueInput);	
		}
	}
	
	void editEntries(int columnIndex, String valueInput) {
		switch(columnIndex) {
			case 1: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setFirstName(valueInput);
			}
				break;
			case 2: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setLastName(valueInput);
			}
				break;
			case 3: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setAge(valueInput);
			}
				break;
			case 4: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setCity(valueInput);
			}
				break;
			case 5: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setEyeColour(valueInput);
			}
				break;
			case 6: for(int i = 0; i < dataSetCSV.size(); i++) {
				dataSetCSV.get(i).setSpecies(valueInput);
			}
				break;
		}
	}
	
	void csvWriter(ArrayList<String> dataSetString, ArrayList<Entry> dataSetCSV) throws IOException {
		FileWriter csvWriter = new FileWriter("output.csv");
		csvWriter.append(dataSetString.get(0));
		for(int i = 0; i < dataSetCSV.size(); i++) {csvWriter.append(dataSetCSV.get(i).toString());}
		csvWriter.flush();
		csvWriter.close();
	}
}

class Entry {
	String firstName;
	String lastName;
	String age;
	String city;
	String eyeColour;
	String species;
	
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setAge(String age) {this.age = age;}
	public void setCity(String city) {this.city = city;}
	public void setEyeColour(String eyeColor) {this.eyeColour = eyeColor;}
	public void setSpecies(String species) {this.species = species;}

	public String toString() { 
		return "\n" + firstName + "," + lastName + "," + age + "," + city + "," + eyeColour + "," + species;
	}
}