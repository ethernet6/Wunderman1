package Wunderman1;

import java.util.ArrayList;

public class Person {
	
	String name;
    String email;
    int age;
    
    boolean visited;
    ArrayList<String> family;
    ArrayList<String> friends;
    
    public Person(){}
    
    
    public Person(String name, String email, int age){
    
        this.name = name;
        this.email = email;
        this.age = age;
        family = new ArrayList<String>();
        friends = new ArrayList<String>();
    }
    
    public String getDetails() {
    	
    	
    	return name + " "+ email; 
    }
    
    public String getEmail() {
    	
    	return email;
    }

}
