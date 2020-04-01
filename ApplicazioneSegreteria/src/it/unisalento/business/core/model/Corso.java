package it.unisalento.business.core.model;

public class Corso {


	private int cfu;
	private String nome;
	private int id;
	
	public Corso(int cfu, String nome, int id) {
		super();
		this.cfu = cfu;
		this.nome = nome;
		this.id = id;
	}

	public Corso() {
		super();
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
