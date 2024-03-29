/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDAO;

/**
 *
 * @author negro
 */
public class AnalisarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList clientes = new ArrayList<Cliente>();
        String analisarGeral = "";
        String analisarCEP = "";
        
        try {
            clientes = ClienteDAO.getInstance().consultar();
            analisarGeral = Cliente.analisarGeral(clientes);
        analisarCEP =  Cliente.analisarCEP(clientes);
            request.setAttribute("analise1", analisarGeral);
            request.setAttribute("analise2", analisarCEP);
            RequestDispatcher view = request.getRequestDispatcher("/analise.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(AnalisarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
