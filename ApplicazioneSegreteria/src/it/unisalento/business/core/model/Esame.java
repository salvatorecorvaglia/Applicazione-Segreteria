package it.unisalento.business.core.model;

import java.util.Date;

public class Esame {

	private int voto;
	private boolean lode;
	private String data;
	private Corso corso;
	
	public Esame(int voto, boolean lode, String data, Corso corso) {
		super();
		this.voto = voto;
		this.lode = lode;
		this.data = data;
		this.corso = corso;
	}

	public Esame() {
		super();
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public boolean isLode() {
		return lode;
	}

	public void setLode(boolean lode) {
		this.lode = lode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	
	

	
}
