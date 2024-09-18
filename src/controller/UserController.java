package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;

/**
 * @author tiago
 */
public class UserController {

    public UserController() {
    }
    //--------------------------------------------------------------------------------------//

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

    //--------------------------------------------------------------------------------------//
    //--------------------------------------------------------------------------------------//
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

    //--------------------------------------------------------------------------------------//
    //--------------------------------------------------------------------------------------//
    public List<User> listaUsuarios(int tipoFiltro, String filtro, int orderBy) {
        String sql = "SELECT * FROM tbl_usuarios";

        List<User> userlist = new ArrayList<>();
        DbConnection gerenciador = new DbConnection();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        // BUSCA
        if (!filtro.equals("")) {

            if (tipoFiltro == 0 || tipoFiltro == 1) { // BUSCA PELO NOME
                sql += " WHERE nome LIKE ? ";

            } else { // BUSCA PELO EMAIL
                sql += " WHERE email LIKE ? ";

            }

        }

        // ORDENA
        if (orderBy != 0) {

            switch (orderBy) {
                case 1: // ORDENA PELO CÓDIGO EM ASCENDENTE
                    sql += " ORDER BY id_usuario ";
                    break;

                case 2: // ORDENA PELO CÓDIGO EM DESCENDENTE
                    sql += " ORDER BY id_usuario DESC ";
                    break;

                case 3: // ORDENA PELO NOME EM ASCENDENTE
                    sql += " ORDER BY nome ";
                    break;

                case 4: // ORDENA PELO NOME EM DESCENDENTE
                    sql += " ORDER BY nome DESC ";
                    break;

                case 5: // ORDENA PELO EMAIL EM ASCENDENTE
                    sql += " ORDER BY email ";
                    break;

                case 6: // ORDENA PELO EM DESCENDENTE
                    sql += " ORDER BY email DESC ";
                    break;
            }
        }

        try {
            comando = gerenciador.prepararComando(sql); // prepara o comando

            // SETA A STRING CASO O USUÁRIO TENHA INSERIDO ALGO NA BUSCA
            if (!filtro.equals("")) {

                switch (tipoFiltro) {
                    case 0: // BUSCA PELO PRIMEIRO NOME
                        comando.setString(1, filtro + "%");
                        break;

                    case 1: // BUSCA PELO NOME INTEIRO
                        comando.setString(1, "%" + filtro + "%");
                        break;

                    case 2: // BUSCA PELO INÍCIO DO EMAIL
                        comando.setString(1, filtro + "%");
                        break;

                    case 3: // BUSCA PELO EMAIL INTEIRO
                        comando.setString(1, "%" + filtro + "%");
                        break;
                }
            }

            // executa a query construída
            resultado = comando.executeQuery();

            while (resultado.next()) {
                User usu = new User();
                usu.setId_usuario(resultado.getInt("id_usuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setEmail(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));
                usu.setDataNasc(resultado.getDate("datanasc"));
                usu.setAtivo(resultado.getBoolean("ativo"));

                userlist.add(usu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            gerenciador.fecharConexao(comando, resultado);

        }
        return userlist;
    }

    //--------------------------------------------------------------------------------------//
}
