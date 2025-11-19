package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
/**
 * Main class to run the symptom analytics program
 * It initializes the reader and writer, processes the symptoms,
 * and writes the results to a file
 * Handles exceptions during the process
 */
public class Main {
    public static void main(String[] args) {
        try{
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        List<String> symptom=counter.getSymptoms();
        Map<String,Integer>countResult=counter.countSymptoms(symptom);
        Map<String,Integer>sortedResult=counter.sortSymptoms(countResult);
        counter.writeSymptoms(sortedResult);
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }


       
        
    }
    
}
