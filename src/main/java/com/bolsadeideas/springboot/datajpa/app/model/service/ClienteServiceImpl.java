package com.bolsadeideas.springboot.datajpa.app.model.service;

import com.bolsadeideas.springboot.datajpa.app.model.dao.IClienteDao;
import com.bolsadeideas.springboot.datajpa.app.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return clienteDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.delete(id);
    }
}
