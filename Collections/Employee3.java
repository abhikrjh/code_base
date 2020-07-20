package CollectionsInterview;

import java.util.Iterator;
import java.util.TreeSet;
 
public class Employee3 implements Comparable {
 public String name;
 
 public int compareTo(Object o) {
  return 0;
 }
 
 public static void main(String args[]) {
  Employee3 employeeOne = new Employee3();
  Employee3 employeeTwo = new Employee3();
  employeeOne.name = "John";
  employeeTwo.name = "Martin";
  TreeSet<Employee3> employeeSet = new TreeSet<Employee3>();
  employeeSet.add(employeeOne);
  employeeSet.add(employeeTwo);
  Iterator<Employee3> empIt = employeeSet.iterator();
  while (empIt.hasNext()) {
   System.out.println(empIt.next().name);
  }
 }
}
