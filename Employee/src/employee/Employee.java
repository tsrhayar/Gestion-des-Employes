package employee;

public abstract class Employee {

	String nom;
	String prenom;
	int age;
	String dateEntree;

	public Employee(String nom, String prenom, int age, String dateEntree) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.dateEntree = dateEntree;
	}

	public abstract double calculerSalaire();

	public String getNom() {
		return this.nom + " " + this.prenom;
	}

	public double bonusRisque() {
		return 200;
	}

}
