package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.ConnectorFactory;


public class AlteraRegistro {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE produtos SET  prodNome = ?, prodValor = ?, prodEstoque = ? WHERE prodId = ?";
        try{
            conn = ConnectorFactory.getConexao();
            
            
            
            String nome = JOptionPane.showInputDialog("Digite o novo nome do produto: ");
            Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor do produto: "));
            Integer estoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade do produto no estoque: "));

            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto para alteração: "));
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setDouble(2, valor);
            ps.setInt(3, estoque);
            ps.setInt(4, codigo);
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                ConnectorFactory.closeConnection(conn,ps);
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
}
