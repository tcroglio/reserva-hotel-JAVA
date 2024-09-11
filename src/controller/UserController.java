package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.User;

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

    public boolean cadastrar(User usuario) {

        String sql = "INSERT INTO tbl_usuarios (nome, email, senha, datanasc, ativo)"
                + " VALUES (?, ?, ?, ?, ?)";

        DbConnection gerenciador = new DbConnection();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getSenha());
            comando.setDate(4, new java.sql.Date(usuario.getDataNasc().getTime()));
            comando.setBoolean(5, usuario.isAtivo());
            
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
