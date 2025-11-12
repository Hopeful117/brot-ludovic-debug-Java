package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import com.hemebiotech.Symptom;

public class AnalyticsCounter {
	static Set<Symptom> symptoms;


	public static void main(String args[]) throws Exception {
		Set <Symptom> symptoms = new HashSet<Symptom>();
		boolean found = false;
		// first get input
		try {
		Path path = Path.of("/home/ludo/Documents/OC/Debug-Java/brot-ludovic-debug-Java/Project02Eclipse/symptoms.txt");
		BufferedReader reader = new BufferedReader (new FileReader(path.toFile()));
		String line = reader.readLine();

		
		
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			if(symptoms.isEmpty()) {
				Symptom newSymptom = new Symptom(line);
				newSymptom.incrementCount();
				symptoms.add(newSymptom);
				
			}
			for (Symptom symptom: symptoms) {
				if (symptom.getName().equals(line)) {
					symptom.incrementCount();
				}
				else {
					found = false;
				}
			}
			if (!found) {
				Symptom newSymptom = new Symptom(line);
				newSymptom.incrementCount();
				symptoms.add(newSymptom);

			}
			
		

			line = reader.readLine();	// get another symptom
		}
		reader.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	// now write output
		try {	
		
		
		FileWriter writer = new FileWriter ("result.out");
		if (symptoms.isEmpty()) {
			writer.write("no symptom found");
		}
		for (Symptom symptom: symptoms) {
			writer.write(symptom.toString() + "\n");
		}
		writer.close();
		
	}
	catch (IOException e) {
		e.printStackTrace();
	}
}
}
