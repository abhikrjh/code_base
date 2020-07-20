package CollectionsInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
	private int id;
	private String name;
	private int age;

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "id : "+ this.id +" name : "+this.name+" age : "+this.age;
	}
	
}

public class ComparatorInterfaceImpl {

	public static void main(String[] args) {

		Person e1 = new Person(4, "John", 20);
		Person e2 = new Person(3, "Martin", 40);
		Person e3 = new Person(1, "Mary", 28);
		Person e4 = new Person(2, "Andrew", 35);

		List<Person> listofPersons = new ArrayList<Person>();
		listofPersons.add(e1);
		listofPersons.add(e2);
		listofPersons.add(e3);
		listofPersons.add(e4);

		// sort person on the basis of their id
		System.out.println(" sort person on the basis of their id ");
		Collections.sort(listofPersons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getId() - o2.getId();
			}
		});
		
		
		for(Person p : listofPersons) {
			System.out.println(p);
		}
		
		
		// sort person list on the basis of name
		System.out.println(" sort person list on the basis of name ");
		Collections.sort(listofPersons, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			};
		});
		
		
		for(Person p : listofPersons) {
			System.out.println(p);
		}
		
		
		// sort person list on the basis of their age
		System.out.println(" sort person list on the basis of their age ");
		Collections.sort(listofPersons, new Comparator<Person>() {
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getAge() - o2.getAge();
		}
		});
		
		for(Person p : listofPersons) {
			System.out.println(p);
		}
	}

}
