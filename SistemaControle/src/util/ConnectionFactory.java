package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    
    private static final String usuario = "root";
    private static final String senha = "reis2009";
    private static final String url = "jdbc:mysql://localhost:3306/teste";
    
    public static Connection getConexao(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(url,usuario,senha);            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro de Conexão: "+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) throws StandartException{
        close(conn, ps, rs);
    }
    
    public static void closeConnection(Connection conn) throws StandartException{
        close(conn, null, null);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement ps) throws StandartException{
        close(conn, ps, null);
    }
    
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try{
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
            
        }
        
    }
}
