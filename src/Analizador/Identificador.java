package Analizador;


public class Identificador {
	String name;
	String valor;
	String tDato;
	String tipo;
	String uso;
	String modificador;
	int Posicion;

	public Identificador(String nombre, String valor, String tipoDato, String tipo, String uso, String modificador, int pos) {
		super();
		this.name = nombre;
		this.valor = valor;
		this.tDato = tipoDato;
		this.tipo = tipo;
		this.uso = uso;
		this.modificador = modificador;
		this.Posicion = pos;
	}


	public int getPosicion() {
		return Posicion;
	}

	public void setPosicion(int pos) {
		this.Posicion = pos;
	}

	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipoDato() {
		return tDato;
	}
	public void setTipoDato(String tipo) {
		this.tDato = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModificador() {
		return modificador;
	}
	public void setModificador(String modificador) {
		this.modificador = (modificador == null)?"":modificador;
	}
	public String getUso() {
		return uso;
	}
	public void setUso(String uso) {
		this.uso = uso;
	}

}
