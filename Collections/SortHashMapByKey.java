package CollectionsInterview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

//Sorting by keys can be easily done using TreeMap. You just need to pass HashMap to the constructor of TreeMap.

class Countryy implements Comparable<Countryy> {

	String name;
	long population;

	public Countryy(String name, long population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	// when we need to sort by name
	
//	@Override
//	public int compareTo(Countryy o) {
//		return this.getName().compareTo(o.getName());
//	}

	// when we need to sort by population
	
	@Override
	public int compareTo(Countryy o) {
		return this.population < o.population ? -1 : this.population > o.population ? 1 : 0;
	}

}

public class SortHashMapByKey {

	public static void main(String[] args) {
		Countryy india = new Countryy("India", 1000);
		Countryy japan = new Countryy("Japan", 10000);

		Countryy france = new Countryy("France", 2000);
		Countryy russia = new Countryy("Russia", 20000);

		HashMap<Countryy, String> countryCapitalMap = new HashMap<Countryy, String>();
		countryCapitalMap.put(india, "Delhi");
		countryCapitalMap.put(japan, "Tokyo");
		countryCapitalMap.put(france, "Paris");
		countryCapitalMap.put(russia, "Moscow");

		TreeMap<Countryy, String> tm = new TreeMap<Countryy, String>(countryCapitalMap);

		Iterator<Countryy> itr = tm.keySet().iterator();

		while (itr.hasNext()) {
			Countryy obj = itr.next();
			System.out.println(obj.getName() + " " + obj.population);
		}
	}

}
