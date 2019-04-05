package com.bolsadeideas.springboot.datajpa.app.model.dao;

import com.bolsadeideas.springboot.datajpa.app.model.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * Created by hmartinez on 4/3/2019.
 */
@Repository
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
	}
}
