package it.unisalento.business.dbinterface.dao;

import java.util.Vector;

import it.unisalento.business.dbinterface.DbConnection;

public class PersonaDAO {

	private static PersonaDAO instance;
	
	public static PersonaDAO getInstance() {
		
		if(instance == null) 
			instance =new PersonaDAO();
		return instance;
		
	}
	
	public boolean isValidate(String username, String password) {
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("SELECT * from db_segreteria.persona as P where P.username='"+ username +"' and P.password='"+password+"'");
		
		if(risultato.size()==0)
			return false;
		else
			return true;
		
	}

	public boolean isStudente(String username) {
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("SELECT * from db_segreteria.persona as P inner join db_segreteria.studente as S on P.idpersona=S.idpersona where P.username='"+ username +"'");
		
		if(risultato.size()==0)
			return false;
		else
			return true;
	}
	
}
