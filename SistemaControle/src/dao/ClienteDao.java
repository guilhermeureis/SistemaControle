package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import util.ConnectionFactory;

public class ClienteDao extends Dao<Cliente>
{
  public ClienteDao() {}
  
  @Override
  public boolean cadastrar(Cliente cliente) throws SQLException
  {
    PreparedStatement ps = null;
    String sql = "INSERT INTO cliente (nomeCliente,cpfCliente,sexoCliente,dtNascimentoCliente,foneCliente) VALUES (?,?,?,?,?)";
    try {
      Connection conn = obterConexao();
      try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setDate(4, cliente.getDataNascimento());
        ps.setString(5, cliente.getFone());
        ps.executeUpdate();
      } finally {
        try {
          ConnectionFactory.closeConnection(conn, ps);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }
  
  @Override
  public boolean atualizar(Cliente cliente) throws SQLException {
    PreparedStatement ps = null;
    String sql = "UPDATE cliente set nomeCliente=?,cpfCliente=?,sexoCliente=?,dtNascimentoCliente=?,FoneCliente=? WHERE idCliente=?";
    try {
      Connection conn = obterConexao();
      try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setDate(4, cliente.getDataNascimento());
        ps.setString(5, cliente.getFone());
        ps.setInt(6, cliente.getCodigo());
        ps.executeUpdate();
      } finally {
        try {
          ConnectionFactory.closeConnection(conn, ps);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }
  
  @Override
  public boolean remover(Cliente cliente) throws SQLException{
    PreparedStatement ps = null;
    String sql = "DELETE FROM cliente WHERE idCliente=?";
    try {
      Connection conn = this.obterConexao();
      ps = conn.prepareStatement(sql);
      ps.setInt(1, cliente.getCodigo());
      ps.executeUpdate();
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
  
  @Override
  public Integer getCodigo(Cliente cliente) throws SQLException
  {
    PreparedStatement ps = null;
    Integer codigo = null;
    String sql = "SELECT idCliente, nomeCliente FROM cliente WHERE cpfCliente = ?";
    try {
      Connection conn = obterConexao();
      ps = conn.prepareStatement(sql);
      ps.setString(1, cliente.getCpf());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        cliente.setCodigo(Integer.valueOf(rs.getInt("idCliente")));
        codigo = cliente.getCodigo();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return codigo;
  }
}