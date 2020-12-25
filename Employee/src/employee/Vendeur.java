package employee;

public class Vendeur extends Employee {
	
	double chiffreAffaire;

	public Vendeur(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
		super(nom, prenom, age, dateEntree);
		this.chiffreAffaire = chiffreAffaire;
	}

	@Override
	public double calculerSalaire() {
		return 1500 + this.chiffreAffaire * 0.2;
	}

	

}
