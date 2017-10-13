package dao;

import java.sql.SQLException;

public abstract class Dao<Entity>
{
  public Dao() {}
  
  protected java.sql.Connection obterConexao() throws SQLException {
    return util.ConnectionFactory.getConexao();
  }
  
  public abstract boolean cadastrar(Entity paramEntity)
    throws SQLException;
  
  public abstract boolean atualizar(Entity paramEntity)
    throws SQLException;
  
  public abstract boolean remover(Entity paramEntity)
    throws SQLException;
  
  public abstract Integer getCodigo(Entity paramEntity)
    throws SQLException;
}