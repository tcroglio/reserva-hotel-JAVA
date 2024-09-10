package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author tiago
 */
public class UserController {

    public UserController() {
    }

    //--------------------------------------------------------------------------------------//
    public boolean autenticar(String email, String senha) {
        String sql = "SELECT * FROM tbl_usuarios "
                + "WHERE email = ? "
                + "AND senha = ? "
                + "AND ativo = true";

        DbConnection gerenciador = new DbConnection();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, email);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao(comando, resultado);

        }

        return false;
    }

    public boolean cadastrar(String nome, String email, String senha, String datanasc, boolean ativo) {

        String sql = "INSERT INTO tbl_usuarios (nome, email, senha, datanasc, ativo)"
                + " VALUES (?, ?, ?, ?, ?)";

        DbConnection gerenciador = new DbConnection();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, nome);
            comando.setString(2, email);
            comando.setString(3, senha);
            comando.setString(4, datanasc);
            comando.setBoolean(5, ativo);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao(comando, null);
        }

        return false;
    }
}
