package com.hemebiotech.analytics;


import java.util.List;
import java.util.Map;

/**
 * AnalyticsCounter class to handle symptom analytics
 * It uses ISymptomReader to read symptoms and ISymptomWriter to write results
 */
public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

/*
 * Constructor for AnalyticsCounter
 * @param reader ISymptomReader implementation to read symptoms
 * @param writer ISymptomWriter implementation to write symptoms
 */
public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
	this.reader = reader;
	this.writer = writer;
	
	
}
/**
* Get symptoms from the reader
* @return List of symptoms
*/
public List<String> getSymptoms(){
	return reader.GetSymptoms();
}
/**
 * Count occurrences of each symptom
 * @param symptoms List of symptoms
 * @return Map of symptoms and their occurrences
 */
public Map<String, Integer> countSymptoms(List<String> symptoms){
	Map<String, Integer> symptomCount = new java.util.HashMap<>();
	for(String symptom: symptoms) {
		if (symptomCount.containsKey(symptom)) {
			symptomCount.put(symptom, symptomCount.get(symptom) + 1);
		} else {
			symptomCount.put(symptom, 1);
		}
		
	}
	return symptomCount;
}
/**
 * Sort symptoms alphabetically
 * @param symptoms Map of symptoms and their occurrences
 * @return Sorted Map of symptoms and their occurrences
 */
public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
	Map<String, Integer> sortedSymptoms = new java.util.TreeMap<>(symptoms);
	return sortedSymptoms;
}
/**
 * Write symptoms using the writer
 * @param symptoms
 */
public void writeSymptoms(Map<String, Integer> symptoms){
	writer.writeSymptoms(symptoms);
}



	
}
