package it.unisalento.test;

import java.util.ArrayList;
import java.util.Vector;

import it.unisalento.business.core.model.Esame;
import it.unisalento.business.core.model.Studente;
import it.unisalento.business.dbinterface.DbConnection;
import it.unisalento.business.dbinterface.dao.*;

public class SegreteriaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Impiegato i=new Impiegato("Tizio", "Caio", 13000);
		//i.stampaSommario();
		
//		Studente s=new Studente("Tizio","Caio","user","pass","10064446", new ArrayList<Esame>());
//
//		Esame e=new Esame(28, false, 6, "Analisi I", 1);
//		s.addEsame(e);
//		
//		Esame e2=new Esame(18, false, 9, "Fisica I", 2);
//		s.addEsame(e2);
//		s.stampaEsami();
		
//		DbConnection.getInstance().connetti("db_segreteria", "root", "R1Ve0");
//		
//		Vector<String[]> risultato=DbConnection.getInstance().eseguiQuery("select * from db_segreteria.studente");
//		
//		for(int i=0;i<risultato.size();i++) {
//			String[] riga=risultato.get(i);
//			System.out.println(riga[0]+", "+riga[1]);
//		}
//		
//		DbConnection.getInstance().disconnetti();

		
		DbConnection.getInstance().connetti("db_segreteria", "root", "R1Ve0");
		
		ArrayList<Studente> listaStudenti=StudenteDAO.getInstance().getStudenti();
		
		for(int i=0;i<listaStudenti.size();i++) {
			Studente s=listaStudenti.get(i);
			System.out.println("Lo studente "+s.getNome()+" "+s.getCognome()+" ha la matricola "+s.getMatricola());
		}
		
		String username="user";
		String password="pass";
		
		boolean esiste=PersonaDAO.getInstance().isValidate(username, password);
		
		if(esiste)
			System.out.println("L'account e' corretto!");
		else
			System.out.println("Dati incorretti :( ");
		
		Studente s=StudenteDAO.getInstance().getStudenteByMatricola("10064446");
		StudenteDAO.getInstance().getEsamiStudente(s);
		
		ArrayList<Esame> listaEsami = s.getEsamiSostenuti();
		
		System.out.println("Lo studente con matricola 10064446 ha sostenuto i seguenti esami: ");
		for(int i=0;i<listaEsami.size();i++) {
			Esame e=listaEsami.get(i);
			System.out.println(e.getCorso().getNome()+" in data "+e.getData()+" con voto "+e.getVoto());
		}
		
		DbConnection.getInstance().disconnetti();
		
	}

}
