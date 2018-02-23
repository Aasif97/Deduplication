package deduplication;

import java.awt.FocusTraversalPolicy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class deduplication {
	public static void main(String [] arg ) throws IOException {
		 String csvFile = "C:\\Users\\Aasif\\Downloads\\123.csv";
	 	
		// System.out.println(k);
		  csvFile = "C:\\Users\\Aasif\\Downloads\\123.csv";
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
                     temp.last_name =  country[0];
                     temp.dob =  country[1];
                     temp.gn =  country[2];
                     temp.first_name =  country[3];
	               listOfPatients.add(temp) ;
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	          
	        for ( int i=0; i<listOfPatients.size();i++ ) {
	        	Patient m  = listOfPatients.get(i);
	        	for (int j = i+1 ; j <listOfPatients.size();j++ ) {
	        		if(listOfPatients.get(j).isEquals(m))
	        		{		listOfPatients.remove(j);
	        	            j = j-1;
	        		}
	        		}
	        }
	        	FileWriter fout=new FileWriter("bin.txt");
			
	        
	        for ( int i=0; i<listOfPatients.size();i++ ) {
	        	Patient m  = listOfPatients.get(i);
	        	fout.append("\n"+m.dob + " " + m.first_name + " " + m.gn + " " +m.last_name);
	        }
	       fout.close();
	      //  System.out.println(listOfPatients.size());
	        
	}
	
}	
	
	
