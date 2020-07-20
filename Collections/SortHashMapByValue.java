package CollectionsInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMapByValue {

	public static void main(String[] args) {

		HashMap<String, String> countryCapitalMap = new HashMap<String, String>();

		countryCapitalMap.put("Japan", "Tokyo");
		countryCapitalMap.put("France", "Paris");
		countryCapitalMap.put("Russia", "Moscow");
		countryCapitalMap.put("India", "Delhi");

		System.out.println("-----------------------------");
		// Iterating HashMap Using keySet() and for each loop
		System.out.println("Before Sorting");
		System.out.println("-----------------------------");
		for (String countryKey : countryCapitalMap.keySet()) {
			System.out.println("Country:" + countryKey + " and  Capital:" + countryCapitalMap.get(countryKey));

		}

		Set<Entry<String, String>> countryCapitalEntrySet = countryCapitalMap.entrySet();

		List<Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(countryCapitalEntrySet);

		Collections.sort(entryList, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		// Using LinkedHashMop to keep entries in sorted order

		LinkedHashMap<String, String> sortedHashMap = new LinkedHashMap<String, String>();

		for (Entry<String, String> entry : entryList) {
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}

		System.out.println("-----------------------------");
		System.out.println("After Sorting Map by value");
		System.out.println("-----------------------------");

		for (Entry<String, String> entry : sortedHashMap.entrySet()) {
			System.out.println("Country:" + entry.getKey() + " and  Capital:" + entry.getValue());
		}

	}

}
