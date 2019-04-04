package com.bolsadeideas.springboot.datajpa.app.model.dao;

import com.bolsadeideas.springboot.datajpa.app.model.entity.Cliente;

import java.util.List;

/**
 * Created by hmartinez on 4/3/2019.
 */
public interface IClienteDao {

    public List<Cliente> findAll();
}
