package Wunderman1;

public class Person {
	
	String name;
    String email;
    int age;
    
    public Person(){}
    
    
    public Person(String name, String email, int age){
    
        this.name = name;
        this.email = email;
        this.age = age;
    }
    
    public String getDetails() {
    	
    	
    	return name + " "+ email; 
    }
    
    public String getEmail() {
    	
    	return email;
    }

}
