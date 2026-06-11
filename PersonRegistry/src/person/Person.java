package person;


// Abstrakt klass som reprenseterar en generell person (kan vara Student eller Teacher)
public abstract class Person implements Comparable<Person> {
	private int id;   // unikt ID för person
	private String name;  // personens namn

	// Konstruktorn som kräver ID och namn
	public Person(int id, String namn) {
		this.id = id;
		this.name = namn;
	}
	
	// Getter för ID
	public int getId() { return id; }
	
	// Getter för namn
	public String getName() {return name;}


	// Gör en Person kan sorteras automatiskt efter ID
	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.id, other.id);
	}


	// Jämför två personer baserat på id och namn
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Person)) return false;
		Person other = (Person) obj;
		return this.id == other.id && 
				(this.name != null && this.name.equals(other.name));
	}

	// Formaterad utskrift
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " - " + id + ": " + name;
	}

}
