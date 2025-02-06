package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.DAO.AnnonceDAO;
import org.iut.montreuil.connection.ConnectionDB;
import org.iut.montreuil.bean.Annonce;

import java.io.IOException;

@WebServlet("/AnnonceS")
public class AnnonceS extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Annonce annonce = new Annonce(
                request.getParameter("titre"),
                request.getParameter("description"),
                request .getParameter("adresse"),
                request.getParameter("mail")
        );

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
            Boolean bool = annonceDAO.create(annonce);

            if(bool) {
                response.sendRedirect("AnnonceList");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la mise à jour");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AnnonceAdd.jsp").forward(request, response);
    }
}