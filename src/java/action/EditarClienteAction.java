/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author negro
 */
public class EditarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int codContato = Integer.parseInt(request.getParameter("codContato"));
        String nome = request.getParameter("textNome");
         String sexo = request.getParameter("textSexo");
         String cidade = request.getParameter("textCidade");
         String data = request.getParameter("textData");
        try {
            Cliente cliente = new Cliente( nome, sexo,cidade,data);
            cliente.setCodContato(codContato);
            ClienteDAO.getInstance().update(cliente);
            response.sendRedirect("Sucess.jsp");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        }
    }
}
