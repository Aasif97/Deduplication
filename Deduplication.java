import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Deduplication {
	public static void main(String[] args) throws IOException {

		if(args.length != 1 && args.length != 2) {
			System.out.println("Usage: java Deduplication <input_file> [output_file]");
			System.exit(1);
		}

		String csvFile = args[0];

		LinkedList<Patient> listOfPatients = new LinkedList<Patient>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				Patient temp = new Patient();
				// use comma as separator
				String[] country = line.split(cvsSplitBy);
				temp.last_name = country[0];
				temp.dob = country[1];
				temp.gn = country[2];
				temp.first_name = country[3];
				listOfPatients.add(temp);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		} catch (IOException e) {
			System.out.println("Internal Error");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		for (int i = 0; i < listOfPatients.size(); i++) {
			Patient m = listOfPatients.get(i);
			for (int j = i + 1; j < listOfPatients.size(); j++) {
				if (listOfPatients.get(j).isEquals(m)) {
					listOfPatients.remove(j);
					j = j - 1;
				}
			}
		}
		FileWriter fout;
		if(args.length == 1) {
			// Default name of out file output
			fout = new FileWriter("output");
		} else {
			fout = new FileWriter(args[2]);
		}
		
		for (int i = 0; i < listOfPatients.size(); i++) {
			Patient m = listOfPatients.get(i);
			fout.append("\n" + m.dob + " " + m.first_name + " " + m.gn + " " + m.last_name);
		}
		fout.close();

	}

}
