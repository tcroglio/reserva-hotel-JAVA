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

    public DbConnection() {
        // cria a conexão com o banco de dados, este é o construtor

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());

        }
    }

    // --------------------------------------------------------------------------------------//
    public PreparedStatement prepararComando(String sql) {
        // método do tipo "PreparedStatement responsável por preparar o comando

        PreparedStatement comando = null;

        try {
            comando = conn.prepareStatement(sql);

        } catch (SQLException e) {
            // bloco de retorno aqui
            JOptionPane.showMessageDialog(null, "Erro ao preparar comando: " + e);
        }

        return comando;
    }

    // --------------------------------------------------------------------------------------//
    public void fecharConexao() {
        // método responsável por fechar a conexão com o banco de dados

        try {
            if (conn != null) {
                conn.close(); // fecha a conexão com o banco
            }

        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar a conexão: ", e);

        }
    }

    // --------------------------------------------------------------------------------------//
    public void fecharConexao(PreparedStatement comando) {
        // método responsável por fechar a CONEXÃO E O COMANDO
        fecharConexao(); // fecha a conexão com o banco

        try {
            if (comando != null) {
                comando.close(); //fecha o comando
            }
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar o comando: ", e);
        }
    }

    // --------------------------------------------------------------------------------------//
    public void fecharConexao(PreparedStatement comando, ResultSet resultado) {
        // método responsável por fechar a CONEXÃO, O COMANDO E O RESULTADO

        fecharConexao(comando);

        try {
            if (resultado != null) {
                resultado.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, "Erro ao fechar o resultado: ", e);
        }
    } // fim do método que fecha a CONEXÃO, O COMANDO E O RESULTADO
}
