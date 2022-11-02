package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Presidente;
import util.JPAUtil;

public class PresidenteDao {
	public static void salvar(Presidente p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Presidente> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select p from Presidente p order by p.id");
		List<Presidente> lista = q.getResultList();
		em.close();
		return lista;
	}

	public static void atualizar(Presidente p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Presidente p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		p = em.find(Presidente.class, p.getId());
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
}
