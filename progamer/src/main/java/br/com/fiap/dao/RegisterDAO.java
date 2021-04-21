package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Register;
import br.com.fiap.util.EntityManagerFacade;

public class RegisterDAO {
	
	private EntityManager manager = EntityManagerFacade.getEntityManager();

	public void save(Register register) {
		manager.getTransaction().begin();
		manager.persist(register);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}

	public List<Register> getAll() {
		String jpql = "SELECT r FROM Register r";
		TypedQuery<Register> query = manager.createQuery(jpql, Register.class);
		return query.getResultList();
		
	}

}
