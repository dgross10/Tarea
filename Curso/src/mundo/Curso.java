package mundo;

import java.util.ArrayList;

public class Curso {

	private ArrayList<Estudiante> estudiantes;

	public Curso() {
		estudiantes = new ArrayList<Estudiante>();
	}
	
	
	/**
	 * Ordena a los estudiantes DESCENDENTEMENTE por código
	 */
	public void ordenarEstudiantesPorCodigo() {
		for( int i = estudiantes.size( ); i > 0; i-- )
		{
			for( int j = 0; j < i - 1; j++ )
			{
				Estudiante e1 = estudiantes.get( j );
				Estudiante e2 = estudiantes.get( j + 1 );

				if( e1.compararPorCodigo( e2 ) <= 0 )
				{
					estudiantes.set( j, e2 );
					estudiantes.set( j + 1, e1 );
				}
			}
		}
	}

	public ArrayList<Estudiante> getEstudiantes(){
		return estudiantes;
	}

	public void agregarEstudiante(String nombre, String codigo, double nota) {
		Estudiante nuevo = new Estudiante(nombre, codigo, nota);
		estudiantes.add(nuevo);

	}

	public void imprimirEstudiantes() {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
	}
	
	public static void main(String[] args) {
		Curso c = new Curso();
		c.agregarEstudiante("Jorge Villalobos", "202111245", 4.0);
		c.agregarEstudiante("Mario Sanchez", "202213243", 4.5);
		c.agregarEstudiante("Laura Manzur", "202012333", 5.0);
		c.agregarEstudiante("Camila Ángel", "201415643", 5.0);
		c.agregarEstudiante("Paula Lago", "201029988", 5.0);
		c.agregarEstudiante("Rosalía Hidalgo", "201522121", 5.0);
		c.agregarEstudiante("Alejandro Osorio", "201121111", 5.0);
		
		c.ordenarEstudiantesPorCodigo();
		c.imprimirEstudiantes();
	}

}








