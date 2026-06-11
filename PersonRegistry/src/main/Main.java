package main;


import registry.Registry;
import java.util.*;
import person.*;

public class Main {
	public static void main(String[] args) {
		
		
		// Skapar två separater register
		Registry<Student> studentRegistry = new Registry<>();
		Registry<Teacher> teacherRegistry = new Registry<>();
		
		// Lägger till exempelvis: fyra studenter mmed olika ID och namn
		studentRegistry.addItem(new Student(1004, "Deniz"));
		studentRegistry.addItem(new Student(1001, "Alice"));
		studentRegistry.addItem(new Student(1003, "Cem"));
		studentRegistry.addItem(new Student(1002, "Ali"));
		
		// Samma sak men för fyra lärare...
		teacherRegistry.addItem(new Teacher(2001, "Elif"));
		teacherRegistry.addItem(new Teacher(2002, "Fatma"));
		teacherRegistry.addItem(new Teacher(2003, "Ece"));
		teacherRegistry.addItem(new Teacher(2004, "Zeynep"));
		
		
		// === STUDENTER === 
		
		System.out.println("Students:");
        studentRegistry.listItems();

        System.out.println("\nSorted by name:");
        studentRegistry.sortItems(Comparator.comparing(Student::getName));
        studentRegistry.listItems();

        System.out.println("\nGrouped by initial:");
        studentRegistry.countByInitial();

        // === LÄRARE ===
        
        System.out.println("\nTeachers:");
        teacherRegistry.listItems();

        System.out.println("\nSorted Teachers by name:");
        teacherRegistry.sortItems(Comparator.comparing(Teacher::getName));
        teacherRegistry.listItems();
        
        System.out.println("\nTeachers grouped by initial:");
        teacherRegistry.countByInitial();

        // Ta bort en student och en lärare (matchar equals)
        studentRegistry.removeItem(new Student(1003, "Cem"));     
        teacherRegistry.removeItem(new Teacher(2003, "Ece"));

        // Sjriver ut listorna efter borttagning
        System.out.println("\nAfter removal:");

        System.out.println("\nRemaining Students:");
        studentRegistry.listItems();

        System.out.println("\nRemaining Teachers:");
        teacherRegistry.listItems();
	}

}
