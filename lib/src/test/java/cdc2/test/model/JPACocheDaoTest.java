package cdc2.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cdc2.entities.Coche;
import cdc2.model.JPACocheDao;

import java.util.logging.Logger;

class JPACocheDaoTest {
	
	private static final Logger log = Logger.getLogger(JPACocheDaoTest.class.getName());
	
	static Coche coche1;
	static Coche coche2;
	static Coche coche3;
	static JPACocheDao undertest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		log.info("--------------------------Entro en setUpBeforeClass---------------");
		undertest = new JPACocheDao();
		log.info("JPACocheDao bajo test creado");
		coche1 = new Coche(1, "Skoda", "Octavia", 13500, 2020);
		log.info("Coche 1 creado: "+coche1);
		coche2 = new Coche(2, "Opel", "Insignia", 17000, 2021);
		log.info("Coche 2 creado: "+coche2);
		coche3 = new Coche(3, "Suzuki", "Vitara", 3300, 2010);
		log.info("Coche 3 creado: "+coche3);
		
		undertest.save(coche1);
		undertest.save(coche2);
		undertest.save(coche3);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@DisplayName("Verifica el método para encontrar un coche por Id")
	@Test
	final void testFindById() {
		Coche encontrado;
				
		encontrado = undertest.findById(coche3.getId());
		
		assertTrue(encontrado.getId() == coche3.getId(), "El coche buscado no es encontrado");
		
	}
	
	@DisplayName("Verifica el método para devolver todos los coches")
	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@DisplayName("Verifica el método la introducción de varios coches a la vez")
	@Test
	void testSaveAll() {
		Coche array [] = new Coche[3];
		array[0] = coche1;
		array[1] = coche2;
		array[2] = coche3;
		
		undertest.deleteAll();
		undertest.saveAll(array);
		
		assertTrue(undertest.getConcesionario().size() == array.length, "Error al almacenar varios coches a la vez");
				
	}

	@DisplayName("Verifica el método para actualizar el listado de coches")
	@Test
	void testUpdate() {
		
		int tamanio = undertest.getConcesionario().size();
		Coche coche4 = new Coche(1, "Mercedes", "Clase-A", 23000, 2019);
		
		undertest.update(coche4, 1);
		
		assertEquals(undertest.getConcesionario().size(), tamanio, "El tamaño ha variado, no se ha actualizado");
	}

	@DisplayName("Verifica el método para eliminar un coche")
	@Test
	void testDeleteCoche() {
		fail("Not yet implemented");
	}

}
