package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("/home/ludo/Documents/OC/Debug-Java/brot-ludovic-debug-Java/Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        List<String> symptom=counter.getSymptoms();
        Map<String,Integer>countResult=counter.countSymptoms(symptom);
        Map<String,Integer>sortedResult=counter.sortSymptoms(countResult);
        counter.writeSymptoms(sortedResult);


        // You can test the functionality here if needed
        
    }
    
}
