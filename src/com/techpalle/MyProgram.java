package com.techpalle;

public class MyProgram {

	public static void main(String[] args) {
		Student s = new Student();
		s.creating();
		s.read();		
		s.inserting("Rani", "java", "rani@gmail.com");
	    s.inserting("Shreya", ".net", "shreya@gmail.com");	
	    s.updating(2, "shreya", "java", "shreya@gmail.com");
	    s.delete(3);		
	}
}
