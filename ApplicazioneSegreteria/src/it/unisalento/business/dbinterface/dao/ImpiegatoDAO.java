package it.unisalento.business.dbinterface.dao;

import it.unisalento.business.core.model.Corso;
import it.unisalento.business.core.model.Esame;
import it.unisalento.business.core.model.Impiegato;
import it.unisalento.business.core.model.Studente;
import it.unisalento.business.dbinterface.DbConnection;

import java.util.ArrayList;
import java.util.Vector;

public class ImpiegatoDAO {

	private static ImpiegatoDAO instance;
	
	public static ImpiegatoDAO getInstance() {
		if(instance == null)
			instance = new ImpiegatoDAO();
		return instance;
	}

	public Impiegato getImpiegatoByUsername(String username) {
		Impiegato i=new Impiegato();
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select P.nome, P.cognome, P.username, P.password, I.salario from db_segreteria.impiegato as I inner join db_segreteria.persona as P on I.idpersona = P.idpersona where P.username='"+username+"'");
		
		if(risultato.size() == 0) // studente non trovato
			return null;
		
		String[] riga = risultato.get(0);
		i.setNome(riga[0]);
		i.setCognome(riga[1]);
		i.setUsername(riga[2]);
		i.setPassword(riga[3]);
		i.setSalario(Integer.parseInt(riga[4]));
		
		return i;
	}
}
