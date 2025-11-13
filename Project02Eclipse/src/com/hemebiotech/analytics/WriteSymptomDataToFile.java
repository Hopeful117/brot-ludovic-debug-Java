package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
*Implementation of ISymptomWriter interface
*Write symptoms and their occurrences to a file
*Output file is named "result.out"
*If no symptoms are found, writes "no symptom found" to the file
*Each symptom and its count are written on a new line in the format: symptom: count
*The exceptions during file operations are caught and printed to the stack trace
@param symptoms Map of symptoms and their occurrences
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
  
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {	
		
		
		FileWriter writer = new FileWriter ("result.out");
		if (symptoms.isEmpty()) {
			writer.write("no symptom found");
		}
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
		writer.close();
		
	}
	catch (IOException e) {
		e.printStackTrace();
	}
    
}
}
