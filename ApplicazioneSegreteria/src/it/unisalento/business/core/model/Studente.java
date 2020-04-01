package it.unisalento.business.core.model;

import java.util.ArrayList;
import java.util.List;

public class Studente extends Persona {

	private String matricola;
	private ArrayList<Esame> esamiSostenuti;
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


	public ArrayList<Esame> getEsamiSostenuti() {
		return esamiSostenuti;
	}

	public void setEsamiSostenuti(ArrayList<Esame> esamiSostenuti) {
		this.esamiSostenuti = esamiSostenuti;
	}

	public Studente(String nome, String cognome, String username,
			String password, String matricola, ArrayList<Esame> esamiSostenuti) {
		super(nome, cognome, username, password);
		this.matricola = matricola;
		this.esamiSostenuti = esamiSostenuti;
	}

	public Studente() {
		super();
	}
	
	public void addEsame(Esame e) {
		esamiSostenuti.add(e);
	}
	
	public void stampaEsami() {
		System.out.println("Lo studente "+getNome()+" "+getCognome()+" ha sostenuto i seguenti esami:");
		
		for(int i=0;i<esamiSostenuti.size();i++) {
			Esame tmp=esamiSostenuti.get(i);
			System.out.println(tmp.getCorso().getNome()+" da "+tmp.getCorso().getCfu()+" con voto "+tmp.getVoto());
		}
		
	}

}
