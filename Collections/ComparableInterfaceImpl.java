package CollectionsInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class State implements Comparable<State>{
	
	int  id;
	String name;
	
	State(int id, String name){
		this.id = id;
		this.name =name;
	}
	
	@Override
	public int compareTo(State o) {
		return (this.id<o.id) ? -1: (this.id>o.id)? 1 : 0;
	}
	
	@Override
	public String toString() {
		return " id : "+ id +" name : "+name;
	}
	
}


public class ComparableInterfaceImpl {
	
	public static void main(String[] args) {
		
		List<State> list = new ArrayList<State>();
		
		State s1= new State(7, "G");
		State s2= new State(2, "B");
		State s3= new State(3, "C");
		State s4= new State(1, "A");
		State s5= new State(5, "E");
		State s6= new State(6, "F");
		State s7= new State(4, "D");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		list.add(s7);
		
		for(State s : list) {
			System.out.println(s);
		}
		
		System.out.println("After Sorting");
		
		Collections.sort(list);
		
		for(State s : list) {
			System.out.println(s);
		}
		
	}
}
