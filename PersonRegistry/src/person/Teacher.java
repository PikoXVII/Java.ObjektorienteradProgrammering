package person;


// Teacher är också en subklass till Person
public class Teacher extends Person {
	public Teacher(int id, String name) {
		super(id, name);
	}

}


// fungerar exak som Student, den ärvar allt från Person.