package RankingBLL;

import RankingBO.bo.Connexion;
import RankingDAO.dao.ConnexionDAO;
import RankingDAL.dal.DALException;
import RankingDAO.dal.DAOFactory;

public class ConnexionManager {

	private static ConnexionManager instance = null;
	private ConnexionDAO daoConnexion;
	private String currRole = null;

	private ConnexionManager() throws BLLException {
		// Instancier le Data Access Object
		daoConnexion = DAOFactory.getConnexionDAO();

		// Charger le catalogue
	}
	
	public static synchronized ConnexionManager getInstance() throws BLLException {
		if (instance == null) {
			instance = new ConnexionManager();
		}
		return instance;
	}

	public String getRole(Connexion c) throws BLLException{
		try {
			currRole= daoConnexion.checkConnexion(c);
			if (currRole.equals("noRole")){
				instance = null;
			}
		} catch (DALException e) {
			throw new BLLException("Echec de la connection - ", e);
		}
		return currRole;
	}
	
}

