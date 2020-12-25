package employee;

public class Manutentionnaire extends Employee {
	
	int nombreHeuresDeTravail;

	public Manutentionnaire(String nom, String prenom, int age, String dateEntree, int nombreHeuresDeTravail) {
		super(nom, prenom, age, dateEntree);
		this.nombreHeuresDeTravail = nombreHeuresDeTravail;
	}

	@Override
	public double calculerSalaire() {
		return this.nombreHeuresDeTravail * 50 + bonusRisque();
	}

}
