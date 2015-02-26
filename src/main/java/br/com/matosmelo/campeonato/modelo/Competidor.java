package br.com.matosmelo.campeonato.modelo;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class Competidor {

	private Usuario competidor;

	public Usuario getCompetidor() {
		return this.competidor;
	}

	public void setCompetidor(Usuario competidor) {
		this.competidor = competidor;
	}

}
