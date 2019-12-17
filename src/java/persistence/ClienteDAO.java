/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author negro
 */
public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into cliente (nome,sexo,cidade,data)"
                    + " values ('" + cliente.getNome() + "','" + cliente.getSexo() + "','" + cliente.getCidade() + "','" + cliente.getData()+"')");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    public void update(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int codContato = cliente.getCodContato();
        String nome = cliente.getNome();
        String sexo = cliente.getSexo();
        String cidade = cliente.getCidade();
        String data = cliente.getData();

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("UPDATE cliente SET nome ='" + nome + "',  sexo='" + sexo + "', cidade='" + cidade + "',  data='" + data + "' WHERE codContato=" + codContato + " ");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

   

    public void delete(int codContato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE from cliente  WHERE codContato=" + codContato + " ");
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

        }
    }

    public ArrayList consultar() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        ArrayList clientes = new ArrayList<Cliente>();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("select * from cliente");            
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodContato(resultado.getInt("codContato"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setSexo(resultado.getString("sexo"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setData(resultado.getString("data"));

                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }
    

    public Cliente Buscar(int codContato) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ResultSet resultado = null;
        Cliente cliente = new Cliente();
        try {

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            resultado = st.executeQuery("SELECT * FROM `cliente` where codContato=" + codContato);
            while (resultado.next()) {
                cliente.setCodContato(resultado.getInt("codContato"));
                 cliente.setNome(resultado.getString("nome"));
                cliente.setSexo(resultado.getString("sexo"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setData(resultado.getString("data"));
            }
            return cliente;
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);//s
        }
    }

   

}
