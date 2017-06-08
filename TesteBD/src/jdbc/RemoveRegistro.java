package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.ConnectorFactory;

public class RemoveRegistro {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        
        conn = ConnectorFactory.getConexao();
        
        String sql = "DELETE FROM produtos WHERE prodId = ?";
        
         int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto para alteração: "));
        
        try {
            conn = ConnectorFactory.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.executeUpdate();
            
            System.out.println("Fechando a conexão...");
            
        } catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ConnectorFactory.closeConnection(conn,ps);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
}
