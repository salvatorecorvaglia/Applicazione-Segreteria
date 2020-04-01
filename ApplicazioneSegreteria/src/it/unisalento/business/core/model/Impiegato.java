package it.unisalento.business.core.model;

public class Impiegato extends Persona {

	private int salario;
	
	
	public Impiegato() {
		super();
	}



	public Impiegato(String nome, String cognome, String username,
			String password, int salario) {
		super(nome, cognome, username, password);
		this.salario = salario;
	}



	public int getSalario() {
		return salario;
	}



	public void setSalario(int salario) {
		this.salario = salario;
	}



	public void stampaSommario() {
		System.out.println("L'impiegato " + this.getNome()+ " "+ this.getCognome()+ " ha uno stipendio di "+this.getSalario()+" euro");
	}
}
