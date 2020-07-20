package CollectionsInterview;

import java.util.HashSet;

class Person1 {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}

	/*
	 * @Override public boolean equals(Object obj) {
	 * 
	 * // checking if both the object references are // referring to the same
	 * object. if(this == obj) return true;
	 * 
	 * // it checks if the argument is of the // type Person1 by comparing the
	 * classes // of the passed argument and this object. // if(!(obj instanceof
	 * Person1)) return false; ---> avoid. if(obj == null || obj.getClass()!=
	 * this.getClass()) return false;
	 * 
	 * // type casting of the argument. Person1 person1 = (Person1) obj;
	 * 
	 * // comparing the state of argument with // the state of 'this' Object. return
	 * (person1.name == this.name); }
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

public class HashCodeQues {
	public static void main(String args[]) {
		Person1 employeeOne = new Person1();
		Person1 employeeTwo = new Person1();
		employeeOne.name = "John";
		employeeTwo.name = "John";
		HashSet<Person1> employeeSet = new HashSet<Person1>();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
