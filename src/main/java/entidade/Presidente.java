package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Presidente {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 5)
	private String partido;
	@Column(nullable = false)
	private Integer numero;
	@Column(name = "qtd_votos")
	private Integer qtdVotos;
	
	public Presidente() {
		qtdVotos = 0;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getQtdVotos() {
		return qtdVotos;
	}
	public void setQtdVotos(Integer qtdVotos) {
		this.qtdVotos = qtdVotos;
	}
}
