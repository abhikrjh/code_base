package CollectionsInterview;
/*
You have list of Man, now you need to sort them on the basis of name then age. 
It means if names are equals, then sort it by age.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Man {
	public String name;
	public int age;

	public Man(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}

public class SortByAgeIfNameisSame {
	public static void main(String args[]) {

		List<Man> employees = new ArrayList<Man>();
		Man emp1 = new Man("John", 26);
		Man emp2 = new Man("Martin", 23);
		Man emp3 = new Man("John", 20);
		Man emp4 = new Man("Martin", 19);
		Man emp5 = new Man("Arpit", 27);

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		System.out.println("List before sorting : ");
		for (Man e : employees) {
			System.out.println(e.name + " - " + e.age);
		}

		Collections.sort(employees, new Comparator<Man>() {

			@Override
			public int compare(Man o1, Man o2) {

				if (o1.name.compareTo(o2.name) == 0) {
					return o1.age - o2.age;
				} else {
					return o1.name.compareTo(o2.name);
				}

			}
		});

		System.out.println("List after sorting : ");

		for (Man e : employees) {
			System.out.println(e.name + " - " + e.age);
		}

	}
}
