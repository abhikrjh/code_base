package CollectionsInterview;

import java.util.HashSet;

public class Employee1 {
 public String name;
 
 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  Employee1 other = (Employee1) obj;
  if (name == null) {
   if (other.name != null)
    return false;
  } else if (!name.equals(other.name))
   return false;
  return true;
 }
 
 public static void main(String args[]) {
  Employee1 EmployeeOne = new Employee1();
  Employee1 EmployeeTwo = new Employee1();
  EmployeeOne.name = "John";
  EmployeeTwo.name = "John";
 
  HashSet<Employee1> EmployeeSet = new HashSet<Employee1>();
  EmployeeSet.add(EmployeeOne);
  EmployeeSet.add(EmployeeTwo);
  System.out.println(EmployeeSet.size());
 }
}
