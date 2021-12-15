package project.maven.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import jakarta.persistence.Query;
import projeto.maven.model.Filme;

public class FilmeDao {

	final static Logger logger = Logger.getLogger(FilmeDao.class);

	public void CadastrarFilme(Filme filme) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(filme);
		em.getTransaction().commit();
		System.out.println("Filme Salvo com Sucesso!!!!");
	}

	public List<Filme> getFilme(int id) {
		List<Filme> filme = new ArrayList<Filme>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Filme f = em.find(Filme.class, id);
		System.out.println("ID: " + f.getId());
		System.out.println("Nome: " + f.getNome());
		System.out.println("Genero: " + f.getGenero());
		return filme;
	}
	
	public void AlterarFilme(int id, String nome, String genero) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Filme f1 = em.find(Filme.class, id);
		
		f1.setNome(nome);
		f1.setGenero(genero);
		
		em.merge(f1);
		em.getTransaction().commit();
		
		System.out.println("Dados Atualizados!!!");
	}
	
	public void ExcluirFilme(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Filme f2 = em.find(Filme.class, id);
		em.remove(f2);
		em.getTransaction().commit();
		
		System.out.println("Filme Excluido!!!!");
	}
	
	public List<Filme> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("filme3");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Filme> filme2 = null;
		try {
			filme2 = em.createQuery("from Filme").getResultList();
		}catch (Exception e) {
			System.out.println(e);
		}
		return filme2;

		
	}
}

