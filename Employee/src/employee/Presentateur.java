package employee;

public class Presentateur extends Employee {

	double chiffreAffaire;

	public Presentateur(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree);
		this.chiffreAffaire = chiffreAffaire;
	}

	@Override
	public double calculerSalaire() {
		return 2500 + this.chiffreAffaire * 0.2;
	}

}
