package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author tiago
 */
public class DbConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbprojetopoo";
    private static final String USER = "root";
    private static final String PASS = "";
    

    private Connection conn;
    
    // ----------- MÉTODO CONSTRUTOR ----------- //
    
    
    // cria a conexão com o banco de dados, este é o construtor
    public DbConnection() {
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
            
        }
    }
    
    
    // ----------- INÍCIO DOS MÉTODOS ----------- //
    

    // método do tipo "PreparedStatement responsável por preparar o comando
    public PreparedStatement prepararComando(String sql) {
        
        PreparedStatement comando = null;
        
        try {
            comando = conn.prepareStatement(sql);
            
        } catch (SQLException e) {
            // bloco de retorno aqui
            JOptionPane.showMessageDialog(null, "Erro ao preparar comando: " + e);
        }
        
        return comando;
    } // fim do método que prepara a conexão

    
    // --------------------------------------------------------------------------------------//

    
    // método responsável por fechar a conexão com o banco de dados
    public void fecharConexao() {
        
        try {
            if (conn != null) {
                conn.close(); // fecha a conexão com o banco
            } 
            
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar a conexão: ", e);

        }    
    } // fim do método que fecha a CONEXÃO
    
    
    // --------------------------------------------------------------------------------------//
    
    
    // método responsável por fechar a CONEXÃO E O COMANDO
    public void fecharConexao(PreparedStatement comando) {
        fecharConexao(); // fecha a conexão com o banco
        
        try {
            if (comando != null) {
                comando.close(); //fecha o comando
            }
            
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar o comando: ", e);

        }
    } // fim do método que fecha a CONEXÃO E O COMANDO
    
    
    // --------------------------------------------------------------------------------------//
    
    
    // método responsável por fechar a CONEXÃO, O COMANDO E O RESULTADO
    public void fecharConexao(PreparedStatement comando, ResultSet resultado){
        
        fecharConexao(comando);
        
        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar o resultado: ", e);
        }
    } // fim do método que fecha a CONEXÃO, O COMANDO E O RESULTADO
    
    
    // ----------- FIM DOS MÉTODOS ----------- //
}