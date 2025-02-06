package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.DAO.AnnonceDAO;
import org.iut.montreuil.connection.ConnectionDB;

import java.io.IOException;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
            Boolean result = annonceDAO.delete(id);

            if(result) {
                response.sendRedirect("AnnonceList");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la supression");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
