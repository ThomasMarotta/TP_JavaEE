package org.iut.montreuil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iut.montreuil.DAO.AnnonceDAO;
import org.iut.montreuil.bean.Annonce;
import org.iut.montreuil.connection.ConnectionDB;

import java.io.IOException;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
            Annonce annonce = annonceDAO.find(id);

            request.setAttribute("annonce", annonce);
        } catch (Exception e) {
           e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AnnonceUpdate.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Annonce annonce = new Annonce(
                id,
                request.getParameter("titre"),
                request.getParameter("description"),
                request .getParameter("adresse"),
                request.getParameter("mail")
        );

        try {
            AnnonceDAO annonceDAO = new AnnonceDAO(ConnectionDB.getInstance());
            boolean result = annonceDAO.update(annonce);

            if(result) {
                response.sendRedirect("AnnonceList");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la mise à jour");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
