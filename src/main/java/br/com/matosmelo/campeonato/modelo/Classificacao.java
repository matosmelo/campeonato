package br.com.matosmelo.campeonato.modelo;

public class Classificacao implements Comparable<Classificacao> {

	private Usuario usuario;
	private int pontos = 0;
	private int jogos = 0;
	private int vitorias = 0;
	private int empates = 0;
	private int derrotas = 0;
	private int golsPro = 0;
	private int golsContra = 0;
	private int saldoDeGols = 0;

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPontos() {
		return this.pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getJogos() {
		return this.jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}

	public int getVitorias() {
		return this.vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return this.empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return this.derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getGolsPro() {
		return this.golsPro;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public int getGolsContra() {
		return this.golsContra;
	}

	public void setGolsContra(int golsContra) {
		this.golsContra = golsContra;
	}

	public int getSaldoDeGols() {
		return this.saldoDeGols;
	}

	public void setSaldoDeGols(int saldoDeGols) {
		this.saldoDeGols = saldoDeGols;
	}

	// Compara numero de pontos
	public int compareTo(Classificacao outroTime) {

		if (this.pontos == outroTime.pontos)
			return compareToVitotorias(outroTime);

		if (outroTime.pontos > this.pontos)
			return 1;
		else
			return -1;
	}

	// Compra numero de vitorias
	public int compareToVitotorias(Classificacao outroTime) {

		if (this.vitorias == outroTime.vitorias)
			return compareToSaldoDeGols(outroTime);

		if (outroTime.vitorias > this.vitorias)
			return 1;
		else
			return -1;
	}

	// Compara saldo de gols
	public int compareToSaldoDeGols(Classificacao outroTime) {

		if (this.saldoDeGols == outroTime.saldoDeGols)
			return compareToGolsPro(outroTime);

		if (outroTime.saldoDeGols > this.saldoDeGols)
			return 1;
		else
			return -1;

	}

	// Compara Gols pro
	public int compareToGolsPro(Classificacao outroTime) {

		if (this.golsPro == outroTime.golsPro)
			return 0;

		if (outroTime.golsPro > this.golsPro)
			return 1;
		else
			return -1;
	}
}
