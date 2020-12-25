package employee;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection con = DBInfo.connDB();

		Scanner sc = new Scanner(System.in);
		int id, choix, choix2, age, nombreHeuresDeTravail;
		String nom, prenom, dateEntree;
		double chiffreAffaire, nombreUnitesproduites;
		boolean quit = false;

		while (quit != true) {

			System.out.println(
					"Taper:" + "\n1 pour afficher une categorie" + "\n2 pour ajouter un employe dans une categotie"
							+ "\n3 pour modifier un employe dans une categotie"
							+ "\n4 pour supprimer un employe dans une categotie" + "\n0 pour quitter");
			choix = sc.nextInt();
			switch (choix) {
			case 1:
				System.out.println("Taper:" + "\n1 pour afficher le vendeur" + "\n2 pour afficher le producteur"
						+ "\n3 pour afficher le presentateur" + "\n4 pour afficher le manutentionnaire");
				choix2 = sc.nextInt();
				switch (choix2) {
				case 1:
					Personnel.selectEmploye("vendeur", con);
					break;
				case 2:
					Personnel.selectEmploye("producteur", con);
					break;
				case 3:
					Personnel.selectEmploye("presentateur", con);
					break;
				case 4:
					Personnel.selectEmploye("manutentionnaire", con);
					break;
				}
				break;
			case 2:
				System.out.println("Taper:" + "\n1 pour ajouter le vendeur" + "\n2 pour ajouter le producteur"
						+ "\n3 pour ajouter le presentateur" + "\n4 pour ajouter le manutentionnaire");
				choix2 = sc.nextInt();
				switch (choix2) {
				case 1:
					if (Personnel.ifIsSet("vendeur", con) == 1) {
						System.out.println("Il ya déjà un vendeur");
					} else {
						System.out.println("Taper le nom:");
						nom = sc.next();
						System.out.println("Taper le prenom:");
						prenom = sc.next();
						System.out.println("Taper l'age:");
						age = sc.nextInt();
						System.out.println("Taper la date d'entree:");
						dateEntree = sc.next();
						System.out.println("Taper le chiffre d'affaire:");
						chiffreAffaire = sc.nextDouble();
						Vendeur vendeur = new Vendeur(nom, prenom, age, dateEntree, chiffreAffaire);
						Personnel.ajouterEmploye("vendeur", vendeur, con);
					}
					break;
				case 2:
					if (Personnel.ifIsSet("producteur", con) == 1) {
						System.out.println("Il ya déjà un producteur");
					} else {
						System.out.println("Taper le nom:");
						nom = sc.next();
						;
						System.out.println("Taper le prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper l'age:");
						age = sc.nextInt();
						System.out.println("Taper la date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le chiffre le nombre d'unites produites:");
						nombreUnitesproduites = sc.nextDouble();
						Producteur producteur = new Producteur(nom, prenom, age, dateEntree, nombreUnitesproduites);
						Personnel.ajouterEmploye("producteur", producteur, con);
					}
					break;
				case 3:
					if (Personnel.ifIsSet("presentateur", con) == 1) {
						System.out.println("Il ya déjà un presentateur");
					} else {
						System.out.println("Taper le nom:");
						nom = sc.next();
						;
						System.out.println("Taper le prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper l'age:");
						age = sc.nextInt();
						System.out.println("Taper la date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le chiffre d'affaire:");
						chiffreAffaire = sc.nextDouble();
						Presentateur presentateur = new Presentateur(nom, prenom, age, dateEntree, chiffreAffaire);
						Personnel.ajouterEmploye("presentateur", presentateur, con);
					}
					break;
				case 4:
					if (Personnel.ifIsSet("manutentionnaire", con) == 1) {
						System.out.println("Il ya déjà un manutentionnaire");
					} else {
						System.out.println("Taper le nom:");
						nom = sc.next();
						;
						System.out.println("Taper le prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper l'age:");
						age = sc.nextInt();
						System.out.println("Taper la date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le nombre d'heures travailé");
						nombreHeuresDeTravail = sc.nextInt();
						Manutentionnaire manutentionnaire = new Manutentionnaire(nom, prenom, age, dateEntree,
								nombreHeuresDeTravail);
						Personnel.ajouterEmploye("manutentionnaire", manutentionnaire, con);
					}
					break;
				}
				break;
			case 3:
				System.out.println("Taper:" + "\n1 pour modifier le vendeur" + "\n2 pour modifier le producteur"
						+ "\n3 pour modifier le presentateur" + "\n4 pour modifier le manutentionnaire");
				choix2 = sc.nextInt();
				switch (choix2) {
				case 1:
					if (Personnel.ifIsSet("vendeur", con) == 0) {
						System.out.println("Il n'y a aucun vendeur");
					} else {
						Personnel.selectEmploye("vendeur", con);
						System.out.println("Taper l'id de vendeur que vous voulez modifier:");
						id = sc.nextInt();
						System.out.println("Taper le nouveau nom:");
						nom = sc.next();
						;
						System.out.println("Taper le nouveau prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper le nouveau age:");
						age = sc.nextInt();
						System.out.println("Taper la nouvelle date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le nouveau chiffre d'affaire:");
						chiffreAffaire = sc.nextDouble();
						Vendeur vendeur = new Vendeur(nom, prenom, age, dateEntree, chiffreAffaire);
						Personnel.modifierEmployee("vendeur", vendeur, con, id);
					}
					break;
				case 2:
					if (Personnel.ifIsSet("producteur", con) == 0) {
						System.out.println("Il n'y a aucun producteur");
					} else {
						Personnel.selectEmploye("producteur", con);
						System.out.println("Taper l'id de producteur que vous voulez modifier:");
						id = sc.nextInt();
						System.out.println("Taper le nouveau nom:");
						nom = sc.next();
						;
						System.out.println("Taper le nouveau prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper le nouveau age:");
						age = sc.nextInt();
						System.out.println("Taper la nouvelle date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le nouveau chiffre d'affaire:");
						nombreUnitesproduites = sc.nextDouble();
						Producteur producteur = new Producteur(nom, prenom, age, dateEntree, nombreUnitesproduites);
						Personnel.modifierEmployee("producteur", producteur, con, id);
					}
					break;
				case 3:
					if (Personnel.ifIsSet("presentateur", con) == 0) {
						System.out.println("Il n'y a aucun presentateur");
					} else {
						Personnel.selectEmploye("presentateur", con);
						System.out.println("Taper l'id de presentateur que vous voulez modifier:");
						id = sc.nextInt();
						System.out.println("Taper le nouveau nom:");
						nom = sc.next();
						;
						System.out.println("Taper le nouveau prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper le nouveau age:");
						age = sc.nextInt();
						System.out.println("Taper la nouvelle date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le nouveau chiffre d'affaire:");
						chiffreAffaire = sc.nextDouble();
						Presentateur presentateur = new Presentateur(nom, prenom, age, dateEntree, chiffreAffaire);
						Personnel.modifierEmployee("presentateur", presentateur, con, id);
					}
					break;
				case 4:
					if (Personnel.ifIsSet("manutentionnaire", con) == 0) {
						System.out.println("Il n'y a aucun manutentionnaire");
					} else {
						Personnel.selectEmploye("manutentionnaire", con);
						System.out.println("Taper l'id de manutentionnaire que vous voulez modifier:");
						id = sc.nextInt();
						System.out.println("Taper le nouveau nom:");
						nom = sc.next();
						;
						System.out.println("Taper le nouveau prenom:");
						prenom = sc.next();
						;
						System.out.println("Taper le nouveau age:");
						age = sc.nextInt();
						System.out.println("Taper la nouvelle date d'entree:");
						dateEntree = sc.next();
						;
						System.out.println("Taper le nouveau chiffre d'affaire:");
						nombreHeuresDeTravail = sc.nextInt();
						Manutentionnaire manutentionnaire = new Manutentionnaire(nom, prenom, age, dateEntree,
								nombreHeuresDeTravail);
						Personnel.modifierEmployee("manutentionnaire", manutentionnaire, con, id);
					}
					break;
				}
				break;
			case 4:
				System.out.println("Taper:" + "\n1 pour supprimer le vendeur" + "\n2 pour supprimer le producteur"
						+ "\n3 pour supprimer le presentateur" + "\n4 pour supprimer le manutentionnaire");
				choix2 = sc.nextInt();
				switch (choix2) {
				case 1:
					if (Personnel.ifIsSet("vendeur", con) == 0) {
						System.out.println("Il n'y a aucun vendeur");
					} else {
						Personnel.selectEmploye("vendeur", con);
						System.out.println("Taper l'id de vendeur que vous voulez modifier:");
						id = sc.nextInt();
						Personnel.supprimerEmployee("vendeur", id, con);
					}
					break;
				case 2:
					if (Personnel.ifIsSet("producteur", con) == 0) {
						System.out.println("Il n'y a aucun producteur");
					} else {
						Personnel.selectEmploye("producteur", con);
						System.out.println("Taper l'id de producteur que vous voulez modifier:");
						id = sc.nextInt();
						Personnel.supprimerEmployee("producteur", id, con);
					}
					break;
				case 3:
					if (Personnel.ifIsSet("presentateur", con) == 0) {
						System.out.println("Il n'y a aucun presentateur");
					} else {
						Personnel.selectEmploye("presentateur", con);
						System.out.println("Taper l'id de presentateur que vous voulez modifier:");
						id = sc.nextInt();
						Personnel.supprimerEmployee("presentateur", id, con);
					}
					break;
				case 4:
					if (Personnel.ifIsSet("manutentionnaire", con) == 0) {
						System.out.println("Il n'y a aucun manutentionnaire");
					} else {
						Personnel.selectEmploye("manutentionnaire", con);
						System.out.println("Taper l'id de manutentionnaire que vous voulez modifier:");
						id = sc.nextInt();
						Personnel.supprimerEmployee("manutentionnaire", id, con);
					}
					break;
				}
				break;
			case 0:
				System.out.println("A bientot");
				quit = true;
			}
		}

	}

}
