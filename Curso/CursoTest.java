package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mundo.Curso;
import mundo.Estudiante;

public class CursoTest {

    private Curso c;

    @BeforeEach
    public void setUp() {
        c = new Curso();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, c.getEstudiantes().size(), "The list of students should be empty");
    }

    @Test
    public void testAgregarEstudiante() {
        c.agregarEstudiante("Jorge Villalobos", "202111245", 4.0);
        assertEquals(1, c.getEstudiantes().size(), "The list of students should have one element");

        Estudiante e = c.getEstudiantes().get(0);
        assertEquals("Jorge Villalobos", e.getNombre(), "The name of the student is incorrect");
        assertEquals("202111245", e.getCodigo(), "The codigo of the student is incorrect");
        assertEquals(4.0, e.getNota(), 0.01, "The nota of the student is incorrect");
    }

    @Test
    public void testOrdenarEstudiantesPorCodigo() {
        c.agregarEstudiante("Jorge Villalobos", "202111245", 4.0);
        c.agregarEstudiante("Mario Sanchez", "202213243", 4.5);
        c.agregarEstudiante("Laura Manzur", "202012333", 5.0);
        c.agregarEstudiante("Camila Ángel", "201415643", 5.0);
        c.agregarEstudiante("Paula Lago", "201029988", 5.0);
        c.agregarEstudiante("Rosalía Hidalgo", "201522121", 5.0);
        c.agregarEstudiante("Alejandro Osorio", "201121111", 5.0);

        c.ordenarEstudiantesPorCodigo();

        List<Estudiante> expected = new ArrayList<>();
        expected.add(new Estudiante("Laura Manzur", "202012333", 5.0));
        expected.add(new Estudiante("Alejandro Osorio", "201121111", 5.0));
        expected.add(new Estudiante("Rosalía Hidalgo", "201522121", 5.0));
        expected.add(new Estudiante("Paula Lago", "201029988", 5.0));
        expected.add(new Estudiante("Camila Ángel", "201415643", 5.0));
        expected.add(new Estudiante("Mario Sanchez", "202213243", 4.5));
        expected.add(new Estudiante("Jorge Villalobos", "202111245", 4.0));

        assertEquals(expected, c.getEstudiantes(), "The students should be ordered by codigo");
    }

    @Test
    public void testImprimirEstudiantes() {
        c.agregarEstudiante("Jorge Villalobos", "202111245", 4.0);
        c.agregarEstudiante("Mario Sanchez", "202213243", 4.5);
        c.agregarEstudiante("Laura Manzur", "202012333", 5.0);

        c.ordenarEstudiantesPorCodigo();

        String expected = "Estudiante [nombre=Laura Manzur, codigo=202012333, nota=5.0]" + System.lineSeparator();
        expected += "Estudiante [nombre=Jorge Villalobos, codigo=202111245, nota=4.0]" + System.lineSeparator();
        expected += "Estudiante [nombre=Mario Sanchez, codigo=202213243, nota=4.5]" + System.lineSeparator();

        StringWriter sw = new StringWriter();
        c.imprimirEstudiantes();
        String actual = sw.toString();

        assertEquals(expected, actual, "The students should be printed in the correct order");
    }

    @Test
    public void testImprimirEstudiantesNull() {
        assertThrows(IllegalArgumentException.class, () -> c.imprimirEstudiantes());
    }

}