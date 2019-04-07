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
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

	@Override
	public void save(Cliente cliente) {
		if (cliente.getId() != null && cliente.getId()>0){
            em.merge(cliente);
		} else {
            em.persist(cliente);
        }
    }

    @Override
    public Cliente findOne(Long id) {
        return  em.find(Cliente.class,id);
    }

    @Override
    public void delete(Long id) {
        em.remove(findOne(id));
    }
}
