package model;

public class Telefone {

	private Long id;
	private String tipo;
	private String numero;
	private Long id_user;
	
	
	public Telefone() {
		
	}


	public Telefone(Long id, String tipo, String numero, Long id_user) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.numero = numero;
		this.id_user = id_user;
	}
	 

	public Telefone(String tipo, String numero, Long id_user) {
		super();
		this.tipo = tipo;
		this.numero = numero;
		this.id_user = id_user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Long getId_user() {
		return id_user;
	}


	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}


	@Override
	public String toString() {
		return "Telefone [id=" + id + ", tipo=" + tipo + ", numero=" + numero + ", id_user=" + id_user + "]";
	}
	
	
	
}
