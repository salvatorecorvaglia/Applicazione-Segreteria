package it.unisalento.business.core;

import it.unisalento.business.core.model.*;
import it.unisalento.business.dbinterface.dao.ImpiegatoDAO;
import it.unisalento.business.dbinterface.dao.PersonaDAO;
import it.unisalento.business.dbinterface.dao.StudenteDAO;

public class Business {

	private static Business instance;
	
	public static Business getInstance() {
		if(instance == null)
			instance=new Business();
		return instance;
	}
	
	public Persona login(String username, String password) {
		
		if(PersonaDAO.getInstance().isValidate(username, password)) {
			if(PersonaDAO.getInstance().isStudente(username)) {
				Studente s=StudenteDAO.getInstance().getStudenteByUsername(username);
				return s;
			}
			else {//e' un impiegato
				Impiegato i=ImpiegatoDAO.getInstance().getImpiegatoByUsername(username);
				return i;
			}
		}
		else
			return null;
	}
	
}
