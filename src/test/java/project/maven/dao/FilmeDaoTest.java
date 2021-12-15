package project.maven.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import projeto.maven.model.Filme;

class FilmeDaoTest {

	@Test
	void testCadastrarFilme() {
		Scanner input = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Filme filme = new Filme(null, "teste", "teste");
		em.getTransaction().commit();
		
		Assertions.assertNotNull(filme.getId());
		
		
	}

}
