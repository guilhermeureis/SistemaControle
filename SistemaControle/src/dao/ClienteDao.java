package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;
import util.ConnectionFactory;


public class ClienteDao extends Dao<Cliente>{

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO clientes (nomeCliente,cpfCliente,sexoCliente,dtNascimentoCliente,FoneCliente) VALUES (?,?,?,?,?)";
        try{
            Connection conn = this.obterConexao();
            try{
                ps = conn.prepareStatement(sql);
                ps.setString(1,cliente.getNome());
                ps.setString(2,cliente.getCpf());
                ps.setString(3,cliente.getSexo());
                ps.setDate(4,cliente.getDataNascimento());
                ps.setString(5,cliente.getFone());
                ps.executeUpdate();
            }finally{
                try{
                    ConnectionFactory.closeConnection(conn, ps);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }   catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
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
    public Integer getCodigo(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
