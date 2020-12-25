package employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Personnel {

	static Scanner sc = new Scanner(System.in);
	static String input, nom, prenom, dateEntree;
	static int age;

	public static void selectEmploye(String table, Connection con) {
		try {
			java.sql.Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT * FROM `" + table + "`";
			ResultSet rs = stmt.executeQuery(query);

			if (ifIsSet(table, con) > 0) {
				while (rs.next()) {
					StringBuilder sb = new StringBuilder();
					sb.append(rs.getString("nom") + " ");
					sb.append(rs.getString("prenom") + ", ");
					sb.append("id n°: " + rs.getInt("id") + ", ");
					sb.append("salaire: " + rs.getDouble("salaire") + ".");
					System.out.println("Liste de " + table + " :");
					System.out.println(sb.toString());
				}
			} else {
				System.out.println("La liste de " + table + " est vide");
			}

		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	public static int ifIsSet(String table, Connection con) throws SQLException {
		int comp = 0;
		try {
			java.sql.Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String query = "SELECT COUNT(*) FROM `" + table + "`";
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			rs.next();
			comp = rs.getInt(1);

		} catch (SQLException e) {
			System.err.println(e);
		}
		return comp;
	}

	public static void ajouterEmploye(String table, Employee employe, Connection con) throws SQLException {
		if (ifIsSet(table, con) == 1) {
			System.out.println("Il ya déjà un " + table);
		} else {
			System.out.println(ifIsSet(table, con));
			try {
				String query = "INSERT INTO `" + table
						+ "`(`nom`, `prenom`, `age`, `dateEntree`, `salaire`) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, employe.nom);
				ps.setString(2, employe.prenom);
				ps.setInt(3, employe.age);
				ps.setString(4, employe.dateEntree);
				ps.setDouble(5, employe.calculerSalaire());
				ps.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public static void modifierEmployee(String table, Employee employe, Connection con, int id) throws SQLException {
		if (ifIsSet(table, con) > 0) {
			try {
				String query = "UPDATE " + table + " SET nom=?, prenom=?, age=?, dateEntree=?, salaire=? WHERE id=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, employe.nom);
				ps.setString(2, employe.prenom);
				ps.setInt(3, employe.age);
				ps.setString(4, employe.dateEntree);
				ps.setDouble(5, employe.calculerSalaire());
				ps.setInt(6, id);

				ps.executeUpdate();
				System.out.println("Le " + table + " bien modifié!");
			} catch (SQLException e) {
				System.err.println(e);
			}
		} else {
			System.out.println("il ya aucun personnel dans la catégorie " + table);
		}
	}

	public static void supprimerEmployee(String table, int id, Connection con) {
		try {
			String query = "DELETE FROM assietteronde WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 1889);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Suprimé avec success!");
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
