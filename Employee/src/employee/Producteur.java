package employee;

public class Producteur extends Employee {

	double nombreUnitesproduites;

	public Producteur(String nom, String prenom, int age, String dateEntree, double nombreUnitesproduites) {
		super(nom, prenom, age, dateEntree);
		this.nombreUnitesproduites = nombreUnitesproduites;
	}

	@Override
	public double calculerSalaire() {
		return this.nombreUnitesproduites * 5 + BonusRisqueProducteur.bonus;
	}

}
