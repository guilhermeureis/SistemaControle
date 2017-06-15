package controller;

import dao.ClienteDao;
import dao.Dao;
import java.sql.SQLException;
import model.Cliente;

public class ClienteController extends Dao<Cliente>{

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException{
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.cadastrar(cliente)){
            resultado =true;
        }
        return resultado;
    }

    @Override
    public boolean atualizar(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCodigo(Cliente cliente) throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.getCodigo(cliente);
    }
    
}
