package com.bolsadeideas.springboot.datajpa.app.model.dao;

import com.bolsadeideas.springboot.datajpa.app.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by hmartinez on 4/3/2019.
 */
public interface IClienteDao extends CrudRepository<Cliente, Long>{

//    public List<Cliente> findAll();
//
//    public void save(Cliente cliente);
//
//    public Cliente findOne(Long id);
//
//    public void delete(Long id);
}
