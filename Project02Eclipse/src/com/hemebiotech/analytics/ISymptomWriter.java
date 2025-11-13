package com.hemebiotech.analytics;

import java.util.Map;
/**
 * Anything that will write symptom data to a destination
 * The important part is, the input value for the operation, which is a map of symptoms
 * and their occurrences
 * The implementation does not need to order the map
 * @param symptoms Map of symptoms and their occurrences
 * 
 */

public interface ISymptomWriter {
    
    void writeSymptoms(Map<String, Integer> symptoms);
       
    }
    

