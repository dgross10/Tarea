package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mundo.Estudiante;

public class EstudianteTest {

    private Estudiante e1;
    private Estudiante e2;

    @BeforeEach
    public void setUp() {
        e1 = new Estudiante("Jorge Villalobos", "202111245", 4.0);
        e2 = new Estudiante("Mario Sanchez", "202213243", 4.5);
    }

    @Test
    public void testConstructor() {
        assertEquals("Jorge Villalobos", e1.getNombre(), "The name of the student is incorrect");
        assertEquals("202111245", e1.getCodigo(), "The codigo of the student is incorrect");
        assertEquals(4.0, e1.getNota(), 0.01, "The nota of the student is incorrect");

        assertEquals("Mario Sanchez", e2.getNombre(), "The name of the student is incorrect");
        assertEquals("202213243", e2.getCodigo(), "The codigo of the student is incorrect");
        assertEquals(4.5, e2.getNota(), 0.01, "The nota of the student is incorrect");
    }

    @Test
    public void testGettersAndSetters() {
        e1.setNombre("Laura Manzur");
        e1.setCodigo("202012333");
        e1.setNota(5.0);

        assertEquals("Laura Manzur", e1.getNombre(), "The name of the student is incorrect");
        assertEquals("202012333", e1.getCodigo(), "The codigo of the student is incorrect");
        assertEquals(5.0, e1.getNota(), 0.01, "The nota of the student is incorrect");

        e2.setNombre("Camila Ángel");
        e2.setCodigo("201415643");
        e2.setNota(5.0);

        assertEquals("Camila Ángel", e2.getNombre(), "The name of the student is incorrect");
        assertEquals("201415643", e2.getCodigo(), "The codigo of the student is incorrect");
        assertEquals(5.0, e2.getNota(), 0.01, "The nota of the student is incorrect");
    }

    @Test
    public void testCompararPorCodigo() {
        assertEquals(1, e1.compararPorCodigo(e2), "The students should be ordered by codigo");
        assertEquals(-1, e2.compararPorCodigo(e1), "The students should be ordered by codigo");
        assertEquals(0, e1.compararPorCodigo(e1), "The students should be ordered by codigo");
    }

    @Test
    public void testToString() {
        assertEquals("202111245", e1.toString(), "The toString method should return the codigo of the student");
        assertEquals("202213243", e2.toString(), "The toString method should return the codigo of the student");
    }

}