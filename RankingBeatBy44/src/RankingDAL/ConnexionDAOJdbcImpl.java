package RankingDAL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe_e.cliniqueveto.bo.Connexion;
import fr.eni.groupe_e.cliniqueveto.dal.ConnexionDAO;
import fr.eni.groupe_e.cliniqueveto.dal.DALException;

public class ConnexionDAOJdbcImpl implements RankingDAO.ConnexionDAO {

	private static final String sqlSelectCheck = "SELECT Role FROM Personnels "
			+ "WHERE Nom = ? AND MotPasse = ?";

	// private static final String sqlSelectByNom = "Select Nom, MotPasse, Role"
	// + "From Personnels"
	// + "Where Codepers = ?";
	// private static final String sqlSelectAll = "Select Nom, MotPasse, Role
	// from Personnels";

	// @Override
	public String checkConnexion(Connexion c) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		String result = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectCheck);
			rqt.setString(1, c.getNom());
			rqt.setString(2, c.getMotPasse());
			rs = rqt.executeQuery();
			if (rs.next()) {
				result = rs.getString("Role");
			}else{
				result = "noRole";
			}

		} catch (SQLException e) {
			throw new DALException("Check connexion failed " + c.getNom(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// private static final String sqlSelectByNom = "Select Nom, MotPasse, Role"
	// + "From Personnels"
	// + "Where Codepers = ?";
	// private static final String sqlSelectAll = "Select Nom, MotPasse, Role
	// from Personnels";

	// @Override
	// public Connexion selectByNom(String nom) throws DALException {
	// Connection cnx = null;
	// PreparedStatement rqt = null;
	// ResultSet rs = null;
	// Connexion result = null;
	// try {
	// cnx = JdbcTools.getConnection();
	// rqt = cnx.prepareStatement(sqlSelectByNom);
	// rqt.setString(1, nom);
	// rs = rqt.executeQuery();
	// if (rs.next()) {
	// result = new Connexion(rs.getString("Nom"), rs.getString("MotPasse"),
	// rs.getString("Role"));
	// }
	//
	// } catch (SQLException e) {
	// throw new DALException("Check connexion failed " + nom, e);
	// } finally {
	// try {
	// if (rs != null){
	// rs.close();
	// }
	// if (rqt != null){
	// rqt.close();
	// }
	// if(cnx!=null){
	// cnx.close();
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return result;
	// }

	// public List<Connexion> selectAll() throws DALException {
	// Connection cnx = null;
	// Statement rqt = null;
	// ResultSet rs = null;
	// List<Connexion> liste = new ArrayList<Connexion>();
	// try {
	// cnx = JdbcTools.getConnection();
	// rqt = cnx.createStatement();
	// rs = rqt.executeQuery(sqlSelectAll);
	// Connexion conn = null;
	//
	// while (rs.next()) {
	// conn = new Connexion(rs.getString("Nom"), rs.getString("MotPasse"),
	// rs.getString("Role"));
	// liste.add(conn);
	// }
	// } catch (SQLException e) {
	// throw new DALException("selectAll failed - " , e);
	// } finally {
	// try {
	// if (rs != null){
	// rs.close();
	// }
	// if (rqt != null){
	// rqt.close();
	// }
	// if(cnx!=null){
	// cnx.close();
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// return liste;
	//
	// }
	//
}