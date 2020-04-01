package it.unisalento.business.dbinterface.dao;

import it.unisalento.business.core.model.Corso;
import it.unisalento.business.core.model.Esame;
import it.unisalento.business.core.model.Studente;
import it.unisalento.business.dbinterface.DbConnection;

import java.util.ArrayList;
import java.util.Vector;

public class StudenteDAO {

	private static StudenteDAO instance;
	
	public static StudenteDAO getInstance() {
		if(instance == null)
			instance = new StudenteDAO();
		return instance;
	}
	
	public ArrayList<Studente> getStudenti() {
		
		ArrayList<Studente> lista=new ArrayList<Studente>();
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select P.nome, P.cognome, P.username, P.password, S.matricola from db_segreteria.studente as S inner join db_segreteria.persona as P on S.idpersona = P.idpersona");
		
		for(int i=0;i<risultato.size();i++) {
			String[] riga=risultato.get(i);
			Studente s=new Studente();
			
			s.setNome(riga[0]);
			s.setCognome(riga[1]);
			s.setUsername(riga[2]);
			s.setPassword(riga[3]);
			s.setMatricola(riga[4]);
			
			lista.add(s);
		}
		
		return lista;
	}
	
	public void getEsamiStudente(Studente s) {
		
		ArrayList<Esame> listaEsami=new ArrayList<Esame>();
		
		Vector<String[]> risultato = DbConnection.getInstance().eseguiQuery("select C.nome, SE.data, SE.voto from db_segreteria.studente as S inner join db_segreteria.sostiene_esame as SE on S.matricola = SE.studente_matricola inner join db_segreteria.corso as C on C.idcorso = SE.corso_idcorso where S.matricola='"+s.getMatricola()+"'");
		
		for(int i=0;i<risultato.size();i++) {
			String[] riga=risultato.get(i);
			Esame e=new Esame();
			Corso c=new Corso();
			c.setNome(riga[0]);
			e.setData(riga[1]);
			e.setVoto(Integer.parseInt(riga[2]));
			e.setCorso(c);
			listaEsami.add(e);
		}
		
		s.setEsamiSostenuti(listaEsami);
		
		
	}

	public Studente getStudenteByMatricola(String matricola) {
		Studente s=new Studente();
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select P.nome, P.cognome, P.username, P.password, S.matricola from db_segreteria.studente as S inner join db_segreteria.persona as P on S.idpersona = P.idpersona where S.matricola='"+matricola+"'");
		
		if(risultato.size() == 0) // studente non trovato
			return null;
		
		String[] riga = risultato.get(0);
		s.setNome(riga[0]);
		s.setCognome(riga[1]);
		s.setUsername(riga[2]);
		s.setPassword(riga[3]);
		s.setMatricola(riga[4]);
		
		return s;
	}

	public Studente getStudenteByUsername(String username) {
		Studente s=new Studente();
		
		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select P.nome, P.cognome, P.username, P.password, S.matricola from db_segreteria.studente as S inner join db_segreteria.persona as P on S.idpersona = P.idpersona where P.username='"+username+"'");
		
		if(risultato.size() == 0) // studente non trovato
			return null;
		
		String[] riga = risultato.get(0);
		s.setNome(riga[0]);
		s.setCognome(riga[1]);
		s.setUsername(riga[2]);
		s.setPassword(riga[3]);
		s.setMatricola(riga[4]);
		
		return s;
	}
}
