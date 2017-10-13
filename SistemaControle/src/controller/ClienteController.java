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
    public boolean atualizar(Cliente cliente) throws SQLException {
        
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.atualizar(cliente)){
            resultado =true;
        }
        return resultado;
    }

    @Override
    public boolean remover(Cliente cliente) throws SQLException {
        boolean resultado = false;
        ClienteDao clienteDao = new ClienteDao();
        if(clienteDao.remover(cliente)){
            resultado =true;
        }
        return resultado;
    }

    @Override
    public Integer getCodigo(Cliente cliente) throws SQLException {
        ClienteDao clienteDao = new ClienteDao();
        return clienteDao.getCodigo(cliente);
    }
    
}
