package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Login;
import util.ConnectionFactory;


public class LoginDao
{
  public LoginDao() {}
  
  public static ArrayList<Login> buscarLogin()
    throws SQLException
  {
    ArrayList<Login> loginAux = new ArrayList();
    String sql = "SELECT logNome, logSenha FROM login";
    
    Connection conn = ConnectionFactory.getConexao();
    PreparedStatement ps = conn.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
      Login login = new Login();
      login.setLogNome(rs.getString("logNome"));
      login.setLogSenha(rs.getString("logSenha"));
      loginAux.add(login);
    }
    
    return loginAux;
  }
}