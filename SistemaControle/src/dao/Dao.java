package dao;

import java.sql.Connection;
import java.sql.SQLException;
import util.ConnectionFactory;

public abstract class Dao<Entity>{
    
    protected Connection obterConexao() throws SQLException{
        return ConnectionFactory.getConexao();
    }
    
    public abstract boolean cadastrar(Entity pojo) throws SQLException;
    public abstract boolean atualizar(Entity pojo) throws SQLException;
    public abstract boolean remover(Entity pojo) throws SQLException;
    public abstract Integer getCodigo(Entity pojo) throws SQLException;
    
}
