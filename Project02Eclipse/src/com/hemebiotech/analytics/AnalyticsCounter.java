package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;


	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
		// constructor
		
	}
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
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
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		Map<String, Integer> sortedSymptoms = new java.util.TreeMap<>(symptoms);
		return sortedSymptoms;
	}
	public void writeSymptoms(Map<String, Integer> symptoms){
		writer.writeSymptoms(symptoms);
	}



	
}
