package oracle;

import java.util.ArrayList;
import java.util.Collections;

public class Person implements Comparable<Person> {

    String firstName;
    String lastName;// Jitendra Saini 
    
    public int compareTo(Person p) {
    	
    	String name = p.lastName+p.firstName;
    	ArrayList<String>list = new ArrayList<String>();
    	list.add(name);
    	list.add(this.lastName+this.firstName);
    	Collections.sort(list);
    	if(p.equals(this)) {
    		return 0;
    	}
    	if(list.get(0).equals(name)) {
    		return 1;
    	}
    	else 
    		return -1;
    	
    }
    
    public boolean equals(Object o) {
    	Person person = ((Person)o);
    	String name = lastName+firstName;
    	if(name.equals(this.lastName+firstName))
    		return true;
		return false;
    	
    }
    
    public int hashCode() {
    	return this.lastName.hashCode()*3*this.firstName.hashCode()*17;
    }
    

}
