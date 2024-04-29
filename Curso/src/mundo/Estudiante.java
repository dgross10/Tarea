package mundo;

public class Estudiante {

	private String nombre;
	private String codigo;
	private double nota;
	
	public Estudiante(String nombre, String codigo, double nota) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.nota = nota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public int compararPorCodigo(Estudiante otro) {
		return (this.codigo.compareTo(otro.codigo)>=0)?1:0;
	}
	
	@Override
	public String toString() {
		return codigo;
	}
	
	
	
}









