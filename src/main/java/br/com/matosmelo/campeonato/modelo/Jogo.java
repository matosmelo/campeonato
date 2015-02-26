package br.com.matosmelo.campeonato.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Usuario mandante;
	@ManyToOne
	private Usuario visitante;
	private Integer golsMandante;
	private Integer golsVisitante;
	private Integer tipoDeCompeticao;
	private String nomeDaCompeticao;

	public String getNomeDaCompeticao() {
		return this.nomeDaCompeticao;
	}

	public void setNomeDaCompeticao(String nomeDaCompeticao) {
		this.nomeDaCompeticao = nomeDaCompeticao;
	}

	public Integer getTipoDeCompeticao() {
		return this.tipoDeCompeticao;
	}

	public void setTipoDeCompeticao(Integer tipoDeCompeticao) {
		this.tipoDeCompeticao = tipoDeCompeticao;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getMandante() {
		return this.mandante;
	}

	public void setMandante(Usuario mandante) {
		this.mandante = mandante;
	}

	public Usuario getVisitante() {
		return this.visitante;
	}

	public void setVisitante(Usuario visitante) {
		this.visitante = visitante;
	}

	public Integer getGolsMandante() {
		return this.golsMandante;
	}

	public void setGolsMandante(Integer golsMandante) {
		this.golsMandante = golsMandante;
	}

	public Integer getGolsVisitante() {
		return this.golsVisitante;
	}

	public void setGolsVisitante(Integer golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

}
